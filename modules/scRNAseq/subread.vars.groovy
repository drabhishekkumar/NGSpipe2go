subread_count_vars=[
    outdir  : RESULTS + "/subread-count",
    stranded: ESSENTIAL_STRANDED,           //whether the data is from a strand-specific assay (illumina SR: always reverse)
    paired  : (ESSENTIAL_PAIRED == "yes"),  //paired end design
    genesgtf: ESSENTIAL_GENESGTF,
    threads : Integer.toString(ESSENTIAL_THREADS),
    extra   : ""                            // extra parms to sent to the tool
]
