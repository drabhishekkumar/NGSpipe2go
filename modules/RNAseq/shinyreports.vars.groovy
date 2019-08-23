shinyReports_vars=[
    project             : PROJECT,                        //project directory
    org                 : ESSENTIAL_ORG,                  //UCSC organism
    db                  : ESSENTIAL_DB,                   //UCSC assembly version
    paired              : ESSENTIAL_PAIRED,               //paired-end data [yes|no]
    log                 : LOGS,                           //where the logs lie
    qc                  : QC,                             //where the QC lie
    res                 : RESULTS,                        //where the results lie
    prefix              : ESSENTIAL_SAMPLE_PREFIX,        //standard sample prefix
    star_log            : LOGS + "/STAR",                 //where the STAR logs lie
    star_suffix         : "Log.final.out",                //extension given to the STAR log files
    starparms_suffix    : "Log.out",                      //extension given to the STAR log files
    fastqc_out          : FastQC_vars.outdir,             //where the Fastqc output lie
    fastqc_log          : LOGS + "/FastQC",               //where the Fastqc logs lie
    bamindex_log        : LOGS + "/BAMindexer",           //where the Samtools/BamIndexer logs lie
    dupradar_log        : dupRadar_vars.outdir,           //where the dupRadar logs lie
    rnatypes_log        : QC + "/RNAtypes",               //where the RNAtypes logs lie
    rnatypes            : QC + "/RNAtypes",               //where the RNAtypes count results lie
    rnatypes_suffix     : ".readcounts.tsv",              //the extension of the subread results files
    genebodycov_log     : geneBodyCov2_vars.outdir,
    bustard             : QC + "/DemultiplexedBustardSummary.xml",      //where the bustard xml file lies
    de_edger            : "",                             //where the DE_edgeR output lies
    de_deseq            : DE_DESeq2_vars.outdir + "/DE_DESeq2.RData",   //where the DE_DESeq2 output lies
    de_deseq_mm         : DE_DESeq2_MM_vars.outdir + "/DE_DESeq2.RData",//where the DE_DESeq2_MM output lies
    subread             : subread_count_vars.outdir + "/subread-count", // location of the subread counts
    subread_suffix      : ".raw_readcounts.tsv.summary",  // the extension of the subread stats file
    subread_log         : LOGS + "/subread_count",        //where the Subread/FeatureCounts logs lie
    bam2bw_log          : LOGS + "/bam2bw",               //where the Bam2BW logs lie
    markdups_log        : LOGS + "/MarkDups",             //where the picard MarkDuplicates logs lie
    edger_logs          : "",                             //where the DE_edgeR logs lie
    deseq_logs          : LOGS + "/DE_DESeq2",            //where the DE_DESeq2 logs lie
    plots_column        : "3",                            //number of columns to splits the plot grids (dupradar, genebodycov...). Min=2L. L=integer in R
    inferexperiment_logs: inferexperiment_vars.outdir,    //where the inferexperiment logs lie
    qualimap_logs       : qualimap_vars.outdir,           //where the qualimap output files are
    go_enrichment       : GO_Enrichment_vars.outdir,      //where the GO enrichment results lie
    insertsize          : InsertSize_vars.outdir,         //where the insertsize statistics are found
    trackhub_done       : PROJECT + "/trackhub.done",     //contains trackhub URL
    tool_versions       : PIPELINE_ROOT + "/pipelines/RNAseq/tools.groovy" //where the tool versions are listed
]
