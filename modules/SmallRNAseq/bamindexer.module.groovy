//rule for task BAMindexer from catalog NGS, version 1
//desc: Samtools index a bam file
BAMindexer = {
	doc title: "BAMindexer",
		desc:  "Call samtools to index a bam file",
		author: "Sergi Sayols"

	output.dir = MULTIMAP_OUT_DIR

	transform(".bam") to(".bam.bai") {
		exec """

			${PREPARE_SAMTOOLS} &&

			${RUN_SAMTOOLS} index $input
		""","BAMindexer"
	}

	forward input
}

