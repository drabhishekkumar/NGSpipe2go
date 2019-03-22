DedupStats = {
	doc title: "Statistics of unique reads",
		desc:  "Counts the number of reads in the original reads file, and after PCR duplicate removal, and plots results",
		author: "Antonio Domingues"


	produce(REMOVE_DUP_OUTDIR + "/figure/PCRDuplicates.pdf",
           REMOVE_DUP_OUTDIR + "/figure/PCRDuplicates.png") {

      exec """
         ${PREPARE_R} &&

         cd ${REMOVE_DUP_OUTDIR} &&
         ${RUN_R} ${DEDUP_PLOT_TOOL}

		""","DedupStats"
	}
}
