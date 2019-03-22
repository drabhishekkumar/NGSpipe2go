//rule for task extend from catalog NGS, version 1
//desc: Extend read length to the average fragment size
extend = {
	doc title: "extend",
		desc:  "Extend read length to the average fragment size",
		constraints: "",
		bpipe_version: "tested with bpipe 0.9.8.7",
		author: "Sergi Sayols"

	output.dir=MAPPED
	
	def SAMTOOLS_SORT_FLAGS = "-O bam " + EXTEND_SAMTOOLS_THREADS

	transform(".bam") to ("_ext.bam") {
		exec """
            ${PREPARE_BEDTOOLS} &&
            ${PREPARE_SAMTOOLS} &&

			if [ ! -d $TMP ]; then
				mkdir -p $TMP;
			fi &&
			
			CHRSIZES=${TMP}/\$(basename ${input.prefix}).extend.chrsizes  &&
			${RUN_SAMTOOLS} idxstats ${input} | cut -f1-2 > \${CHRSIZES} &&
			${RUN_BEDTOOLS} bamtobed -split -i $input |
			${RUN_BEDTOOLS} slop -g \$CHRSIZES -l 0 -r $EXTEND_FRAGLEN -s |
			${RUN_BEDTOOLS} bedtobam -ubam -g \$CHRSIZES |
			${RUN_SAMTOOLS} sort $SAMTOOLS_SORT_FLAGS -T $TMP/\$(basename $output.prefix) - > $output &&
			${RUN_SAMTOOLS} index $output
		""","extend"
	}
}

