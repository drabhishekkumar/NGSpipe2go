InsertSize_vars=[
    outdir    :  QC + "/insertsize", //location of the OUTPUT Dir
    java_flags: "-Xmx5000m",         //set the java heap size
    extra     : "ASSUME_SORTED=true VALIDATION_STRINGENCY=LENIENT" //sometimes the sorted flag is not set and we should not care if we have reads which overhang chromosomes
]
