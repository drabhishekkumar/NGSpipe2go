shinyReports_vars=[
    project         : PROJECT,          //project directory
    org             : ESSENTIAL_ORG,    //UCSC organism
    db              : ESSENTIAL_DB,     //UCSC assembly version
    paired          : ESSENTIAL_PAIRED, // paired-end data [yes|no]
    log             : LOGS,             //where the logs lie
    qc              : QC,               //where the QC lie
    res             : RESULTS,          //where the results lie
    prefix          : ESSENTIAL_SAMPLE_PREFIX, //standard sample prefix
    star_log        : STAR_vars.logdir,        //where the STAR logs lie
    star_suffix     : "Log.final.out",         //extension given to the STAR log files
    starparms_suffix: "Log.out",               //extension given to the STAR log files
    fastqc_out      : FastQC_vars.outdir,      //where the Fastqc output lie
    fastqc_log      : LOGS + "/FastQC",        //where the Fastqc logs lie
    bamindex_log    : LOGS + "/BAMindexer",    //where the Samtools/BamIndexer logs lie
    dupradar_log    : dupRadar_vars.outdir,    //where dupRadar results lie
    rnatypes_log    : LOGS + "/RNAtypes",      //where the RNAtypes logs lie
    rnatypes        : subread2rnatypes_vars.outdir, //where the RNAtypes count results lie
    rnatypes_suffix : "counts.tsv",            //the extension of the subread results files
    genebodycov_log : geneBodyCov2_vars.outdir,
    bustard         : QC + "/DemultiplexedBustardSummary.xml",  //where the bustard xml file lies
    subread         : subread_count_vars.outdir,     // location of the subread counts
    subread_suffix  : ".raw_readcounts.tsv.summary", // the extension of the subread stats file
    subread_log     : LOGS + "/subread_count",       //where the Subread/FeatureCounts logs lie
    bam2bw_log      : LOGS + "/bam2bw",              //where the Bam2BW logs lie
    umicount        : (PIPELINE == "scRNAseq_marsseq" ? umicount_vars.outdir : ""), //location of the umitools counts 
    umicount_log    : (PIPELINE == "scRNAseq_marsseq" ? umicount_vars.logdir : ""), //where the umicount/FeatureCounts logs lie
    markdups_log    : LOGS + "/MarkDups",            //where the picard MarkDuplicates logs lie
    plots_column    : 3L,                            //number of columns to splits the plot grids (dupradar, genebodycov...). Min=2L. L=integer in R
    inferexperiment_logs: inferexperiment_vars.outdir, //where the inferexperiment logs lie
    qualimap_logs   : qualimap_vars.outdir,          //where the qualimap output files are
    trackhub_done   : PROJECT + "/trackhub.done",    //contains trackhub URL
    tool_versions   : PROJECT+ "/NGSpipe2go/modules/scRNAseq/tool.versions.groovy", //where the tool versions are listed
    cutadapt_logs   : Cutadapt_vars.logdir,          // cutadapt log files
    gtf             : ESSENTIAL_GENESGTF, 
    target          : PROJECT + "/NGSpipe2go/pipelines/scRNAseq/targets.txt"
]
