inferexperiment_vars=[
    outdir: QC + "/inferexperiment",
    bed   : ESSENTIAL_GENESBED, //this variable is essential for the module to run do not set it to the empty string! 
    extra : "-s 4000000"        //add other options here in this case it is the samples size (how many reads should be samples from the bam file) 
]
