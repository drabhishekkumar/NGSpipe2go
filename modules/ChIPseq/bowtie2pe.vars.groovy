bowtie2_pe_vars=[
    mapped          : MAPPED,                // output directory
    threads         : Integer.toString(ESSENTIAL_THREADS), // threads to use
    samtools_threads: Integer.toString(ESSENTIAL_THREADS), // threads to use
    ref             : ESSENTIAL_BOWTIE_REF,  // prefix of the bowtie reference genome
    insert          : "",                    // seed size. Match with fragment size, the default 20 is set by --very-sensitive
    mm_seed         : "--very-sensitive",    // for very polymorphic samples one can try the "super-sensitive" but >2x slower parameter combination "-D 20 -R 3 -N 1 -L 20 -i S,1,0.50"
    quals           : "--phred33",           // phred33-quals. Use --phred64-quals for old sequencing runs
    extra           : "--fr --end-to-end --maxins 1000 --minins 0"  // mates align fw/rev, entire, read must align, maximum and minimum fragmnet length
]
