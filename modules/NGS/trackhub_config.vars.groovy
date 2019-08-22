trackhub_config_vars=[
    ftpurlbase: "https://hpc1.imb.uni-mainz.de/public",// public FTP base URL
    ftpbase   : "/fsimb/services/ftp/public/",         // public FTP root folder
    ucsccfg   : "/fsimb/common/tools/ucsc/config/",    // folder with UCSC tools configuration files (e.g. narrowPeak.as/broadPeak.as)
    targets   : PROJECT + "/targets.txt",              // targets file describing the samples for ChIP-seq
    peaksdir  : RESULTS + "/macs2",                    // location of peak files for ChIP-seq (comment out if no peak files)
    tracksdir : TRACKS,                                // location of track files for putting into trackhub
    config    : PROJECT + "/trackhub.yaml",            // trackhub configuration file
    project   : PROJECT,
    db        : ESSENTIAL_DB,                          // UCSC genome assembly, e.g. "hg19
    chromsizes: ESSENTIAL_CHROMSIZES,                  // chromosome sizes file
    stranded  : ESSENTIAL_STRANDED,                    // stranded sequencing or not, for strans-specific bigwig creation
    tracks    : TRACKS                                 // full path of project subdirectory containing tracks
]
