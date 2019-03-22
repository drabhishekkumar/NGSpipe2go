TrimUMIs = {
	doc title: "Trim UMIs",
		desc:  """Trims random barcodes that help in the identification of PCR duplicates and are in adapter-removed reads: NNNN-insert-NNNN.""",
      constraints: "Requires seqtk.",

		author: "Antonio Domingues"

	output.dir = TRIM_OUTDIR
   def SEQTK_FLAGS = " -l " + LEFT_TRIM +
                       " -b " + RIGHT_TRIM

	transform(".deduped_barcoded.fastq.gz") to (".deduped_barcoded.trimmed.fastq.gz") {


      exec """
         ${PREPARE_SEQTK} &&

         ${RUN_SEQTK} trimfq -b ${LEFT_TRIM} -e ${RIGHT_TRIM} $input | ${RUN_SEQTK} seq -L 15 - | gzip > $output

		""","TrimUMIs"
	}
}
