geneBodyCov2_vars=[
    gtf     : ESSENTIAL_GENESGTF,  // the gencode annotation GTF (can be compressed)
    paired  : ESSENTIAL_PAIRED,    // paired end yes|no
    stranded: ESSENTIAL_STRANDED,  // strandness yes|no|reverse
    outdir  : QC + "/geneBodyCov",
    threads : Integer.toString(ESSENTIAL_THREADS) // number of cores to use
]
