FastxTrimmer = {
	doc title: "Read trimming",
		desc:  "Trims reads up to a given position. Useful when input files with the same read length are needed.",
		constraints: "Only supports compressed FASTQ files",
		author: "Antonio Domingues"

	output.dir = FASTQ_TRIMMER_OUTDIR
   FASTQ_TRIMMER_FLAGS= " -f "   + FIRST_BASE  +
                        " -l "   + LAST_BASE  +
                        FASTQ_TRIMMER_OTHER

   transform(".fastq.gz") to (".23bp.fastq.gz") {
      exec """
         ${PREPARE_FASTX} &&

         zcat $input | ${RUN_FASTX_TRIMMER} $FASTQ_TRIMMER_FLAGS -o $output
      ""","FastxTrimmer"
   }
}
