strandBigWig_vars=[
    outdir               : TRACKS + "/strandspecific",
    threads              : Integer.toString(ESSENTIAL_THREADS),
    stranded             : ESSENTIAL_STRANDED,
    smoothLength         : "60",
    binSize              : "20",
    normalizeUsingRPKM   : true,
    skipNonCoveredRegions: true,
    extra                : ""
]
