rMATS_vars=[
    outdir  : RESULTS + "/rMATS",
    suffix  : PREMATS_SUFFIX,
    sep     : ".vs.",
    paired  : (ESSENTIAL_PAIRED == "yes"),
    stranded: ESSENTIAL_STRANDED,
    gtf     : ESSENTIAL_GENESGTF,
    length  : ESSENTIAL_READLENGTH,
    threads : Integer.toString(ESSENTIAL_THREADS),
    extra   : " --cstat 0.0001"
]
