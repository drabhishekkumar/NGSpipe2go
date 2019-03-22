FastQC = {
	doc title: "FastQC",
		desc:  "Quality control of input file",
		constraints: "Only supports compressed FASTQ files",
		bpipe_version: "tested with bpipe 0.9.8.7",
		author: "Sergi Sayols"

	output.dir   = FASTQC_OUTDIR
	def FASTQC_FLAGS = "--extract --quiet"
	
	transform(".fastq.gz") to ("_fastqc.zip") {
		exec """
			${PREPARE_FASTQC} &&
			
			${RUN_FASTQC} $FASTQC_FLAGS -o $output.dir $input
		""","FastQC"
	}

	forward input
}
