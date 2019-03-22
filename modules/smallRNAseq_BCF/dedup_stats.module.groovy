DedupStats = {
		doc title: "Statistics of unique reads",
		desc:  "Counts the number of reads in the original reads file, and after PCR duplicate removal, and plots results",
		author: "Antonio Domingues, Anke Busch"

		output.dir = REMOVE_DUP_PLOTDIR

		produce(REMOVE_DUP_PLOTDIR + "/dedupReads.pdf", REMOVE_DUP_PLOTDIR + "/dedupReads.png") {

			exec """

                    ${PREPARE_R} &&

			        ${RUN_R} ${DEDUP_PLOT_TOOL} ${REMOVE_DUP_DATADIR} ${REMOVE_DUP_PLOTDIR} ${ESSENTIAL_SAMPLE_PREFIX}

			""","DedupStats"
		}
}
