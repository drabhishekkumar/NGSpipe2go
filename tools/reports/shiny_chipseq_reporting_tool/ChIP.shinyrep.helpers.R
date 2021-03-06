##################################
##
## helper functions to create the plots for the Shiny report
##
##################################
library("knitr")        # for markdown output
library("ChIPpeakAnno")	#for peak venn diagrams
library("RColorBrewer")
library("gridExtra")
library("dplyr")
library("tidyr")
library("reshape2")
library("ggplot2")
library("ngsReports")

##
## loadGlobalVars: read configuration from bpipe vars
##
loadGlobalVars <- function(f="shinyReports.txt") {

    # read in the conf file
    conf <- readLines(f)
    conf <- conf[grep("^SHINYREPS_", conf)]
    
    # create the vars
    sapply(conf, function(x) {
        x <- unlist(strsplit(x, "=", fixed=T))
        assign(x[1], x[2], envir=.GlobalEnv)
    })
    
    invisible(0)
}

##
## Some generic functions
##
# shorten: if a text string is longer than certain length, shorten by showing the first and last characters
shorten <- function(x, max.len=40, ini=20, end=15) {
    l <- nchar(x)
    if(l > max.len) paste(substr(x, 1, ini), substr(x, (l-end), l), sep="...") else x
}

##
## ChIPhelper.init: some time consuming tasks that can be done in advance
##
ChIPhelper.init <- function(task) {
    
    # read targets.txt
    readTargets <- function() {
        TARGETS <- paste0(SHINYREPS_PROJECT, "/", SHINYREPS_TARGETS)
        if(!file.exists(TARGETS)) {
            return("Targets file not available")
        }
    
        return(read.delim(TARGETS))
    }
    
    # read peaks from MACS2 output
    readPeaks <- function() {
    
        # check which macs output exist
        if(!file.exists(SHINYREPS_MACS2)) {
            return("MACS2 results not available")
        }
            if(file.exists(paste0(targets$IPname, ".vs.", targets$INPUTname,"_macs2_blacklist_filtered_peaks.xls"))[1]) {
                 comparisons <- paste0(targets$IPname, ".vs.", targets$INPUTname, "_macs2_blacklist_filtered_peaks.xls")  
            } else {
                 comparisons <- paste0(targets$IPname, ".vs.", targets$INPUTname, "_macs2_peaks.xls")
            }
        exist <- sapply(paste0(SHINYREPS_MACS2, "/", comparisons), file.exists)
        targets <- targets[exist, ]

        # and return the tables
            if(file.exists(paste0(SHINYREPS_MACS2, "/", targets$IPname, ".vs.", targets$INPUTname,"_macs2_blacklist_filtered_peaks.xls"))[1]) {
                 peaks <- lapply(paste0(SHINYREPS_MACS2, "/", targets$IPname, ".vs.", targets$INPUTname, "_macs2_blacklist_filtered_peaks.xls"), function(x) {
                     x <- tryCatch(read.delim(x, comment.char="#"), error=function(e) as.data.frame(matrix(ncol=10)))
                     colnames(x) <- c("chr", "start", "end", "length", "summit", "tags", "-log10 pval", "fold enrichment", "-log10 FDR", "name")
                     x[order(x$chr, x$start, x$end), c(-7, -10)]
                 })
            } else {
                 peaks <- lapply(paste0(SHINYREPS_MACS2, "/", targets$IPname, ".vs.", targets$INPUTname, "_macs2_peaks.xls"), function(x) {
                     x <- tryCatch(read.delim(x, comment.char="#"), error=function(e) as.data.frame(matrix(ncol=10)))
                     colnames(x) <- c("chr", "start", "end", "length", "summit", "tags", "-log10 pval", "fold enrichment", "-log10 FDR", "name")
                     x[order(x$chr, x$start, x$end), c(-7, -10)]
                 })
            }

        names(peaks) <- paste0(targets$IPname, " vs. ", targets$INPUTname)

        return(peaks)
    }
    
    # dispatch tasks
    switch(task, 
           readTargets=readTargets(), 
           readPeaks=readPeaks())
}


##
## ChIPhelper.ComparisonsFromTargets: get te comparisons performed by MACS2 from the targets file
##
ChIPhelper.ComparisonsFromTargets <- function() {
    
    # check for targets.txt and macs2 results
    TARGETS <- paste0(SHINYREPS_PROJECT, "/", SHINYREPS_TARGETS)
    if(!file.exists(TARGETS)) {
        return("Targets file not available")
    }

    if(!file.exists(SHINYREPS_MACS2)) {
        return("MACS2 results not available")
    }
    
    # get the comparisons and clean the names
    x <- read.delim(TARGETS)

    if(file.exists(paste0(x$IPname, ".vs.", x$INPUTname,"_macs2_blacklist_filtered_peaks.xls"))[1]) {
         comparisons <- paste0(x$IPname, ".vs.", x$INPUTname, "_macs2_blacklist_filtered_peaks.xls")  
    } else {
         comparisons <- paste0(x$IPname, ".vs.", x$INPUTname, "_macs2_peaks.xls")
    }

    exist <- sapply(paste0(SHINYREPS_MACS2, "/", comparisons), file.exists)
    comparisons <- gsub(".vs.", " vs. ", comparisons)

    if(file.exists(paste0(x$IPname, ".vs.", x$INPUTname,"_macs2_blacklist_filtered_peaks.xls"))[1]) {
         comparisons <- gsub("_macs2_blacklist_filtered_peaks.xls", "", comparisons)  
    } else {
         comparisons <- gsub("_macs2_peaks.xls", "", comparisons)
    }
   
    return(comparisons[exist])
}

##
## ChIPhelper.Peaks: show the peaks called by MACS2
##
ChIPhelper.Peaks <- function(i=1) {
    ord  <- order(peaks[[i]][, "-log10 FDR"], 
                  peaks[[i]][, "fold enrichment"], 
                  decreasing=TRUE)
    peaks[[i]][ord, ]
}

##
## ChIPhelper.VennDiagram: shows a venn diagram per group of peaks called
##
ChIPhelper.VennDiagram <- function(){
	groups <- unique(targets$group)
	#create granges from the peaks
	peak.ranges <- lapply(peaks, function(x){
		  x <- GRanges(seqnames=x$chr,
			  IRanges(x$start,
				  end=x$end),
			  strand="*"
			   )
		  
		  })
	peak.groups <- targets$group
	for(group in groups){
		cat(paste0("#### ", group), fill=T)
		cat("\n", fill=T)
		peak <- peak.ranges[peak.groups==group]
    tryCatch({
		  peaks.ov <- findOverlapsOfPeaks(peak)
		  makeVennDiagram(peaks.ov,
				margin=0.25, cat.default.pos="outer", cat.dist=0.15,
				cat.fontface=rep("bold", length(peak)),
				fill=brewer.pal(length(peak), "Accent")[1:length(peak)]
      )
    }, error=function(e) cat("No replicates in", group, " or no peaks were called"))
		cat("\n", fill=T)
	}

}

##
## ChIPhelper.BOWTIE: parse bowtie log files and create a md table
##
ChIPhelper.Bowtie <- function() {
    
    # log file
    LOG <- SHINYREPS_BOWTIE_LOG
    if(!file.exists(LOG)) {
        return("Bowtie statistics not available")
    }
    
    # look for the lines containing the strings
    # and get the values associated with this strings
    x <- sapply(list.files(LOG), function(f) {
        
        x <- file(paste0(LOG, "/", f))
        l <- readLines(x)
        close(x)
        
        stats <- sapply(c("reads processed",                    #1
                 "reads with at least one reported alignment",  #2
                 "reads that failed to align",                  #3
                 "reads with alignments suppressed due to -m"), #4
                 function(x) { 
                     gsub("^.+: ", "", l[grep(x, l)])
                 })
    
        # and add the duplicates information
        f <- gsub(".bam.log", ".dupmarked.bam.log", f)
        dups <- if(file.exists(paste0(SHINYREPS_MARKDUPS_LOG, "/", f))) {
            x <- file(paste0(SHINYREPS_MARKDUPS_LOG, "/", f))
            l <- readLines(x)
            close(x)
            gsub(".+Marking (\\d+) records as duplicates.+", "\\1", l[grep("Marking \\d+ records as duplicates", l)])
        } else {
            "not available"
        }
        
        stats.return <- c(
            stats[1],                           # reads processed
            unlist(strsplit(stats[2], " "))[1], # reads with at least one reported alignment
            unlist(strsplit(stats[2], " "))[2], # (percentage)
            unlist(strsplit(stats[3], " "))[1], # reads that failed to align 
            unlist(strsplit(stats[3], " "))[2], # (percentage)
            unlist(strsplit(stats[4], " "))[1], # reads with alignments suppressed due to -m
            unlist(strsplit(stats[4], " "))[2]  # (percentage)
        )
        
        
        c(stats.return, dups)
    })

    # set row and column names, and output the md table
    colnames(x) <- gsub(paste0("^", SHINYREPS_PREFIX), "", colnames(x))
    colnames(x) <- gsub(".bam.log$", "", colnames(x))
    df <- data.frame(sample_names=sapply(colnames(x), shorten), 
                     input_reads=format( as.numeric(x[1, ]), big.mark=", "), 
                     mapped=paste( format( as.numeric(x[2, ]), big.mark=", "), x[3, ], sep=" "), 
                     failed=paste( format( as.numeric(x[4, ]), big.mark=", "), x[5, ], sep=" "), 
                     discarded=paste( format( as.numeric(x[6, ]), big.mark=", "), x[7, ], sep=" "), 
                     duplicates=paste0(format(as.numeric(x[8, ]), big.mark=", "), " (", round(100 * as.numeric(x[8, ]) / as.numeric(x[2, ]), 2), "%)")
                     )
    kable(df, align=c("l", "r", "r", "r", "r", "r"), output=F, format="markdown", row.names=FALSE,
          col.names=c("sample names", "all reads", "mapped (% of all)", "unmapped (% of all)", "too many map. pos. (% all)", "duplicates (% of mapped)"))
}


##
## ChIPhelper.BOWTIE2: parse bowtie2 paired end or single read mapping log files and create a md table
##
ChIPhelper.Bowtie2 <- function() {
  
  # log file
  LOG <- SHINYREPS_BOWTIE_LOG
  if(!file.exists(LOG)) {
    return("Bowtie statistics not available")
  }
  
  # look for the lines containing the strings
  # and get the values associated with this strings
  x <- sapply(list.files(LOG), function(f) {
    
    x <- file(paste0(LOG, "/", f))
    l <- readLines(x)
    close(x)
    
    stat.lines <- c("were (un)*paired",
                    "aligned concordantly exactly 1 time",
                    "aligned concordantly >1 times",
                    "aligned discordantly 1 time",
                    "aligned exactly 1 time",
                    "aligned >1 times",
                    "overall alignment rate")
    
    stat.names <- c("# read (pairs)",
                    "unique",
                    "multi",
                    "discordantly",
                    "single unique",
                    "single multi",
                    "overall align. rate")

    if(!isPaired) { # modify for single read design
      remove_lines <- grep("cordantly", stat.lines)
      stat.lines <- stat.lines[-remove_lines]
      stat.names <- stat.names[-remove_lines]
      stat.names <- gsub("single ", "", stat.names)
    }
     
    stats <- sapply(l[sapply(stat.lines, grep, x=l)], 
                    function(x) { 
                      sub("^\\s+", "", gsub(" \\(.*", "", x))
                    })	
    #recount the percentages for the stats
    stat.all <- stats[grep("overall alignment rate", names(stats))]
    stat.all <- gsub("overall alignment rate", "", stat.all)
    stats <- as.numeric(stats[!grepl("overall alignment rate", stats)])
    # and add the duplicates information
    stats.percent <- paste0("(", format((stats/stats[1])*100, digits=2), "%)")
    stats <- paste0(format(stats, big.mark=","), " ", stats.percent)
    stats <- c(stats, stat.all)
    stat.lines <- gsub("\\$", "", stat.lines)
    
    names(stats) <- stat.names
    return(stats)    
  })
  
  # set row and column names, and output the md table
  colnames(x) <- gsub(paste0("^", SHINYREPS_PREFIX), "", colnames(x))
  colnames(x) <- gsub(".bam.log$", "", colnames(x))
  rownames(x)[1] <- if(!isPaired) {"all reads"} else {"all pairs"}
  kable(t(x), align=c(rep("r",10)), output=F, format="markdown", row.names=T)
}


##
## ChIPhelper.Fastqc: go through Fastqc output dir and create a md table with the duplication & read quals & sequence bias plots
##
ChIPhelper.Fastqc <- function(web=TRUE) {
    
    # logs folder
    if(!file.exists(SHINYREPS_FASTQC)) {
        return("Fastqc statistics not available")
    }
    
    # construct the folder name, which is different for web and noweb
    QC <- if(web) "/fastqc" else SHINYREPS_FASTQC
    
    # construct the image url from the folder ents (skip current dir .)
    samples <- list.dirs(SHINYREPS_FASTQC, recursive=F)
    df <- sapply(samples, function(f) {
        c(paste0("![fastq dup img](", QC, "/", basename(f), "/Images/duplication_levels.png)"), 
          paste0("![fastq qual img](", QC, "/", basename(f), "/Images/per_base_quality.png)"), 
          paste0("![fastq sequ img](", QC, "/", basename(f), "/Images/per_base_sequence_content.png)"))
    })

    # set row and column names, and output the md table
    df <- as.data.frame(t(df))
    x <- gsub(paste0("^", SHINYREPS_PREFIX), "", basename(samples))
    x <- gsub("_fastqc$", "", x)
    rownames(df) <- sapply(x, shorten)
    colnames(df) <- c("Duplication levels", "Read qualities", "Sequence bias")
    kable(df, output=F, align="c", format="markdown")
}

##
## ChIPhelper.ngsReports.Fastqc: joint FastQC report of all samples in the experiment
##
ChIPhelper.ngsReports.Fastqc <- function() {
	
	# output folder
	if(!file.exists(SHINYREPS_FASTQC)) {
		return("Fastqc statistics not available")
	}

    # Loading FastQC Data 
    f <- list.files(SHINYREPS_FASTQC, pattern="fastqc.zip$", full.names=TRUE)
    x <- ngsReports::FastqcDataList(f)
	lbls <- gsub(paste0("(^", SHINYREPS_PREFIX, "|.fastqc.zip$)"), "", names(x))
    names(lbls) <- gsub(".fastqc.zip", ".fastq.gz", names(x))

    print(ngsReports::plotDupLevels(x, labels=lbls))
    print(ngsReports::plotBaseQuals(x, labels=lbls))
    print(ngsReports::plotSeqContent(x, labels=lbls) +
            theme(legend.position="right") +
            guides(fill=FALSE, color="legend") +
            geom_point(mapping=aes(x=Inf, y=Inf, color=base),
                       data=data.frame(base=c("T", "A", "C", "G")),
                       inherit.aes=FALSE, show.legend=TRUE) +
            scale_color_manual("", values=c("red", "green", "blue", "black"))
    )
}


##
## ChIPhelper.IPstrength: go through IPstrength output dir and create a md table with
##     the plots
##
ChIPhelper.IPstrength<- function(web=TRUE) {
    
    # logs folder
    if(!file.exists(SHINYREPS_IPSTRENGTH)) {
        return("IPstrength statistics not available")
    }
    
    if(!is.integer(SHINYREPS_PLOTS_COLUMN) | SHINYREPS_PLOTS_COLUMN < 2) {
        SHINYREPS_PLOTS_COLUMN <- 4L    # default to 4 columns
    }
    
    # construct the folder name, which is different for web and noweb
    QC <- if(web) "/ipstrength" else SHINYREPS_IPSTRENGTH
    
    # construct the image url from the folder contents (skip current dir .)
    samples <- list.files(SHINYREPS_IPSTRENGTH, pattern=".png$")
    COLUMNS <- min(length(samples), SHINYREPS_PLOTS_COLUMN)
    df <- sapply(samples, function(f) {
        paste0("![IPstrength img](", QC, "/", basename(f), ")")
    })
    
    # put sample names and output an md table of COLUMNS columns
    while(length(df) %% COLUMNS != 0) df <- c(df, "")
    samples <- sapply(df, function(x) {
        x <- sapply(x, function(x) gsub(paste0("^", SHINYREPS_PREFIX), "", basename(x)))
        sapply(gsub("_ipstrength.png)$", "", x), shorten)
    })
    df      <- matrix(df     , ncol=COLUMNS, byrow=T)
    samples <- matrix(samples, ncol=COLUMNS, byrow=T)
    
    # add a row with the sample names
    df.names <- matrix(sapply(1:nrow(df), function(i) { c(df[i, ], samples[i, ]) }), 
                       ncol=COLUMNS, byrow=T)
    colnames(df.names) <- rep(" ", COLUMNS)
    
    kable(as.data.frame(df.names), output=F, align="c", format="markdown")
}

##
## ChIPhelper.peakAnnotation: go through Peak_Annotation output dir and create a md table with 
##      the coverage plots
##
ChIPhelper.peakAnnotationCoverage <- function(web=TRUE) {
  # check if peak annotation results are available
  if(!file.exists(SHINYREPS_PEAK_ANNOTATION)){
    return("Peak annotation results not available")  
  }
  
  if(!is.integer(SHINYREPS_PLOTS_COLUMN) | SHINYREPS_PLOTS_COLUMN < 2) {
    SHINYREPS_PLOTS_COLUMN <- 3L    # default to 3 columns
  }
  
  # construct the image url from the folder contents (skip current dir .)
  samples <- list.files(SHINYREPS_PEAK_ANNOTATION, pattern="_ChIPseq_Peaks_Coverageplot.png$")
  COLUMNS <- min(length(samples), SHINYREPS_PLOTS_COLUMN)
  df <- sapply(samples, function(f) {
    paste0("![Peak_Annotation img](", SHINYREPS_PEAK_ANNOTATION, "/", basename(f), ")")
  })
  
  # put sample names and output an md table of COLUMN columns
  while(length(df) %% COLUMNS != 0) df <- c(df, "")
  samples <- sapply(df, function(x) {
    x <- sapply(x, function(x) gsub(paste0("^", SHINYREPS_PREFIX), "", basename(x)))
    sapply(gsub("_ChIPseq_Peaks_Coverageplot.png)$", "", x), shorten)
  })
  df      <- matrix(df     , ncol=COLUMNS, byrow=T)
  samples <- matrix(samples, ncol=COLUMNS, byrow=T)
  
  # add a row with the sample names
  df.names <- matrix(sapply(1:nrow(df), function(i) { c(df[i, ], samples[i, ]) }), 
                     ncol=COLUMNS, byrow=T)
  colnames(df.names) <- rep(" ", COLUMNS)
  
  kable(as.data.frame(df.names), output=F, align="c", format="markdown")
}

##
## ChIPhelper.peakAnnotationUpSet: go through Peak_Annotation output dir and create a md table with 
##      the UpSet plots
##
ChIPhelper.peakAnnotationUpSet <- function(web=TRUE) {
  # check if peak annotation results are available
  if(!file.exists(SHINYREPS_PEAK_ANNOTATION)){
    return("Peak annotation results not available")  
  }
  
  if(!is.integer(SHINYREPS_PLOTS_COLUMN) | SHINYREPS_PLOTS_COLUMN < 2) {
    SHINYREPS_PLOTS_COLUMN <- 3L    # default to 3 columns
  }
  
  # construct the image url from the folder contents (skip current dir .)
  samples <- list.files(SHINYREPS_PEAK_ANNOTATION, pattern="_ChIPseq_UpSetplot.png$")
  COLUMNS <- min(length(samples), SHINYREPS_PLOTS_COLUMN)
  df <- sapply(samples, function(f) {
    paste0("![Peak_Annotation img](", SHINYREPS_PEAK_ANNOTATION, "/", basename(f), ")")
  })
  
  # put sample names and output an md table of COLUMN columns
  while(length(df) %% COLUMNS != 0) df <- c(df, "")
  samples <- sapply(df, function(x) {
    x <- sapply(x, function(x) gsub(paste0("^", SHINYREPS_PREFIX), "", basename(x)))
    sapply(gsub("_ChIPseq_UpSetplot.png)$", "", x), shorten)
  })
  df      <- matrix(df     , ncol=COLUMNS, byrow=T)
  samples <- matrix(samples, ncol=COLUMNS, byrow=T)
  
  # add a row with the sample names
  df.names <- matrix(sapply(1:nrow(df), function(i) { c(df[i, ], samples[i, ]) }), 
                     ncol=COLUMNS, byrow=T)
  colnames(df.names) <- rep(" ", COLUMNS)
  
  kable(as.data.frame(df.names), output=F, align="c", format="markdown")
}

##
## ChIPhelper.PhantomPeak: go through PhantomPeak output dir and create a md table with
##     the plots
##
ChIPhelper.PhantomPeak <- function(web=TRUE) {
    
    # logs folder
    if(!file.exists(SHINYREPS_PHANTOMPEAK)) {
        return("PhantomPeak statistics not available")
    }
    
    if(!is.integer(SHINYREPS_PLOTS_COLUMN) | SHINYREPS_PLOTS_COLUMN < 2) {
        SHINYREPS_PLOTS_COLUMN <- 3L    # default to 4 columns
    }
    
    # construct the folder name, which is different for web and noweb
    QC <- if(web) "/phantompeak" else SHINYREPS_PHANTOMPEAK
    
    # construct the image url from the folder contents (skip current dir .)
    samples <- list.files(SHINYREPS_PHANTOMPEAK, pattern=".png$")
    COLUMNS <- min(length(samples), SHINYREPS_PLOTS_COLUMN)
    df <- sapply(samples, function(f) {
        paste0("![PhantomPeak img](", QC, "/", basename(f), ")")
    })
    
    # put sample names and output an md table of COLUMN columns
    while(length(df) %% COLUMNS != 0) df <- c(df, "")
    samples <- sapply(df, function(x) {
        x <- sapply(x, function(x) gsub(paste0("^", SHINYREPS_PREFIX), "", basename(x)))
        sapply(gsub("_phantompeak.png)$", "", x), shorten)
    })
    df      <- matrix(df     , ncol=COLUMNS, byrow=T)
    samples <- matrix(samples, ncol=COLUMNS, byrow=T)
    
    # add a row with the sample names
    df.names <- matrix(sapply(1:nrow(df), function(i) { c(df[i, ], samples[i, ]) }), 
                       ncol=COLUMNS, byrow=T)
    colnames(df.names) <- rep(" ", COLUMNS)
    
    kable(as.data.frame(df.names), output=F, align="c", format="markdown")
}

##
## ChIPhelper.PBC: go through PBC output dir and create a md table with
##     the PBC stats
##
ChIPhelper.PBC <- function() {
    
    # logs folder
    if(!file.exists(SHINYREPS_PBC)) {
        return("PCR bottleneck coefficient statistics not available")
    }
    
    # construct the image url from the folder contents (skip current dir .)
    samples <- list.files(SHINYREPS_PBC, pattern="*.csv")
    df <- sapply(samples, function(f) {
        read.csv(paste0(SHINYREPS_PBC, "/", f))$PBC
    })
    
    # output md table
    df <- as.data.frame(df)
    colnames(df) <- "PBC"
    rownames(df) <- gsub("_PBC.csv", "", rownames(df))
    kable(as.data.frame(df), output=F, format="markdown")
}



##
##ChIPhelper.insertsize: get the insertsize from the qc and display mean and sd 
##
ChIPhelper.insertsize <- function(){
  
  if (SHINYREPS_PAIRED == "yes") {
    filelist <- list.files(path=SHINYREPS_INSERTSIZE,full.names=TRUE, pattern="insertsizemetrics.tsv$")
    insertsizes <- lapply(filelist, read.table, sep="\t", header=TRUE, nrow=1)
    insertsizes <- do.call(rbind, insertsizes)
    samplenames <- basename(filelist)
    samplenames <- gsub(SHINYREPS_PREFIX, "", samplenames)
    samplenames <- gsub("_insertsizemetrics.tsv","", samplenames)
    rownames(insertsizes) <- samplenames 
    insertsizes <- insertsizes[,c("MEDIAN_INSERT_SIZE","MEAN_INSERT_SIZE", "STANDARD_DEVIATION")]
    colnames(insertsizes) <- c("Median", "Mean", "SD")
    kable(insertsizes, output=F, align=c("l"), format="markdown")
  }
}


# Helper to plot the insertsize histogram equivalent to the one from picard
# Input is the Picard generated metrics file
ChIPhelper.insertsize.helper <- function(metricsFile){
  #find the start of our metrics informatioun 
  startFinder <- scan(metricsFile, what="character", sep="\n", quiet=TRUE, blank.lines.skip=FALSE)
  
  firstBlankLine=0
  
  for (i in 1:length(startFinder)) {
    if (startFinder[i] == "") {
      if (firstBlankLine == 0) {
        firstBlankLine = i+1
      } else {
        secondBlankLine = i+1
        break
      }
    }
  }
  
  histogram <- read.table(metricsFile, header=TRUE, sep="\t", skip=secondBlankLine, comment.char="", quote='', check.names=FALSE)
  
  ## The histogram has a fr_count/rf_count/tandem_count for each metric "level"
  ## This code parses out the distinct levels so we can output one graph per level
  headers <- sapply(sub(".fr_count","",names(histogram),fixed=TRUE), "[[" ,1)
  headers <- sapply(sub(".rf_count","",headers,fixed=TRUE), "[[" ,1)
  headers <- sapply(sub(".tandem_count","",headers,fixed=TRUE), "[[" ,1)
  
  ## Duplicate header names could cause this to barf.  But it really shouldn't when we have "All_reads.fr_count" and 
  ## "All_reads.rf_count" for example.  Not sure why this would fail, but I care.
  if (any(duplicated(headers))) {
    levels = unique(headers[2:length(headers)]);
  } else {
    levels <- c()
    for (i in 2:length(headers)) {
      if (!(headers[i] %in% levels)) {
        levels[length(levels)+1] <- headers[i]
      }
    }
  }
  
  title_info <- gsub("_insertsizemetrics.tsv$", "", gsub(SHINYREPS_PREFIX, "", basename(metricsFile)))
  
  #we get the histogram which ahs the names of the leves e.g. all_reads and readgroups/sample groups depending on
  #accumulation level which was used.
  #the colnames of histogram are something like all.read.fr_count, all.read.rf_count etc.
  #to get the whole shebang into a wider format we have to add the information
  hist_long <- melt(histogram, id.var = "insert_size") %>% 
    separate( variable, 
              sep = "\\.",
              into = c("group", "counttype" )) %>%
    rename( amount = value)
  #we also have to add the comulative sum per group to the whole shebang
  hist_long <- hist_long %>% group_by(group) %>% 
    arrange( desc(insert_size)) %>% 
    mutate( cumulative = (cumsum(amount)/sum(amount))*max(amount))
  #1. Create one plot per group (all_reads etc)
  #2. save the plots in a list
  #3. use arrangeGrob to arrange
  hist_long <- split(hist_long, hist_long$group)
  hist_plots <- lapply(hist_long, function(hist_data){
    p <- ggplot(hist_data, aes(x    = insert_size,
                               y    = amount,
                               fill = counttype)) +
      geom_bar( stat = "identity", 
                position = "identity",
                alpha=0.7) +
      scale_fill_hue( c=50, l=40) +
      geom_line(aes(x = insert_size,
                    y = cumulative),
                linetype = "dashed",
                color    = "grey") +
      scale_y_continuous( name="# reads",
                          sec.axis = sec_axis(~./max(hist_data$amount),
                                              name = "Cumulative fraction of reads > insert size")) +
      xlab("insert size in bp") +
      theme_bw() +
      facet_grid(~group)
    return(p)
  })
  
  hist_plot <- arrangeGrob(grobs = hist_plots,
                           top = textGrob(title_info)) 
  return(hist_plot)
  
}

## 
## ChIPhelper.subchunkify: small function stolen from here 
##http://michaeljw.com/blog/post/subchunkify/
## to dynamically create chunks and adjust their size accordingly.
##
ChIPhelper.subchunkify <- function(g, fig_height=7, fig_width=5) {
  g_deparsed <- paste0(deparse(
    function() {grid.draw(g)}
  ), collapse = '')
  
  sub_chunk <- paste0("`","``{r sub_chunk_", floor(runif(1) * 10000),
                      ", fig.height=", fig_height,
                      ", fig.width=", fig_width,
                      ", echo=FALSE}","\n(", 
                      g_deparsed, ")()",
                      "\n`","``")
  
  cat(knitr::knit(text = knitr::knit_expand(text = sub_chunk), quiet = TRUE))
}


##
##ChIPhelper.insertsize.plot: get the insertsize histograms and display them 
##
ChIPhelper.insertsize.plot <- function(){
  # logs folder
  SHINYREPS_PLOTS_COLUMN <- tryCatch(as.integer(SHINYREPS_PLOTS_COLUMN),
                                     error=function(e){3})
  if(SHINYREPS_PLOTS_COLUMN < 2) {
    SHINYREPS_PLOTS_COLUMN <- 3L    # default to 3 columns
  }
  if (SHINYREPS_PAIRED == "yes" &
      length(list.files(path = SHINYREPS_INSERTSIZE,
                        pattern = "insertsizemetrics.tsv$")) > 0) {
    samples <- list.files(path = SHINYREPS_INSERTSIZE,
                          full.names = TRUE,
                          pattern = "insertsizemetrics.tsv$")
    #we generate the plots
    insert_plots <- lapply(samples, 
                           ChIPhelper.insertsize.helper)
    return(arrangeGrob(grobs = insert_plots,
                       ncol = SHINYREPS_PLOTS_COLUMN))
  }else{
    return("No insertsize histograms available.")
  }
}



##
## ChIPhelper.Bustard: call the perl XML interpreter and get the MD output
##
ChIPhelper.Bustard <- function() {
    f  <- SHINYREPS_BUSTARD
    
    if(!file.exists(f)) {
        return("Bustard statistics not available")
    }
    
    # call the perl XSL inetrpreter
    cmd <- paste(" bustard.pl", f)
    try(ret <- system2("perl", cmd, stdout=TRUE, stderr=FALSE))
    
    # check RC
    if(!is.null(attributes(ret))) {
        return(paste("Error parsing bustard statistics. RC:", attributes(ret)$status, "in command: perl", cmd))
    }
    
    ret     # ret contains already MD code
}

##
## extract tool versions
##
## report version of used tools
Toolhelper.ToolVersions <- function() {
    tryCatch({
        ver <- read.delim(file=SHINYREPS_TOOL_VERSIONS)
        colnames(ver) <- c("Tool name","Environment", "Version")
        kable(as.data.frame(ver),output=F)
    }, error=function(e) cat("tool versions not available.\n", fill=TRUE))
}

##
## ChIPhelper.BLACKLISTFILTER: go through MACS2 output dir and show BlackList 
##     Filter module file
##
ChIPhelper.BLACKLISTFILTER <- function() {
    
    # logs folder
    if(!file.exists(SHINYREPS_BLACKLIST_FILTER)) {
        return("Peaks overlapping blacklist regions not available")
    }
    
    # construct the image url from the folder contents (skip current dir .)
    samples <- read.csv(SHINYREPS_BLACKLIST_FILTER, row.names=1)
    colnames(samples) <- c("# peaks with MACS2", "# peaks wo overlapping with BRs", "% peaks overlapping BRs")
    kable(samples, output=F, format="markdown")
}


##
## ChIPhelper.GREAT: get the GO enrichment results and display them
##
ChIPhelper.GREAT <- function(){

    #csv file
    if(!file.exists(SHINYREPS_GREAT)){
        return("GREAT analysis not available")
    }
}


##
## ChIPhelper.Trackhub: display the UCSC trackhub URL
##
ChIPhelper.Trackhub <- function() {
    
    # output file with trackhub URL
    if(!file.exists(SHINYREPS_TRACKHUB_DONE)) {
        return("UCSC GB Trackhub URL file not available")
    }
    
    # Trackhub URL is second line of file
    url <- scan(SHINYREPS_TRACKHUB_DONE, skip=0, nlines=1, what='character')
    if (grepl("hub.txt", url)) {
        return(url)
    } else {
        return("UCSC GB Trackhub URL not available")
    }
}

##
## ChIPhelper.diffbind
##
ChIPhelper.diffbind <- function() {
  
  tryCatch({
      # read the results (if available
      res <- readRDS(file.path(SHINYREPS_DIFFBIND, "diffbind.rds"))
      
      # for each contrast
      Map(x=res, x.name=names(res), f=function(x, x.name) {
          cat("### ", x.name, "\n",
              nrow(x), "differential peaks at FDR 5%.\n", fill=TRUE)#,
          layout(matrix(c(1, 2, 3, 3), nrow=2, ncol=2, byrow=TRUE))
          freq <- table(x$seqnames)
          opar <- par(mfrow=c(1, 3))
          barplot(freq[rev(order(gsub("chr", "", names(freq))))], , horiz=TRUE, las=1, xlab="number of peaks")
          hist(x$Fold, main="", xlab="fold change", ylab="number of peaks", col="grey")#,
          abline(v=0, lty=2, col="blue")
          plot(x$Conc, x$Fold, main="", xlab="concentration", ylab="fold change")#,
          abline(h=0, lty=2, col="blue")
          par(opar)
          invisible(NULL)
      })
  }, error=function(e) cat("Differential binding analysis not available.\n", fill=TRUE))
}

