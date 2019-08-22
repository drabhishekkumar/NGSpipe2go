bamCoverage_vars=[
    outdir   : TRACKS,
    cores    : Integer.toString(ESSENTIAL_THREADS),
    fragments: (ESSENTIAL_FRAGMENT_USAGE == "yes"),
    // If you want to exclude chromsomes for normalisation e.g. rDNA or mitochondrion add
    // the following parameter --ignoreForNormalization \"chrM, rDNA\".
    // If you like to use offsets, blacklist regions, center reads or anything like it please
    // refer to the deepTools manual, there is even a special modus for Nucleosome detection in Mnase data
    // for deeptools versions >v3 you have to use --normalizeUsing RPKM since the API changed
    extra    : "--outFileFormat bigwig" + " " + ESSENTIAL_BAMCOVERAGE
]
