Bam2bwStrand = {
	doc title: "Bam2bw",
		desc:  "Convert BAM file to bigWig for each strand. Normalization factor is the total number of reads.",
		constraints: "none.",
		author: "Antonio Domingues"

	output.dir=BAMCOVSTRANDS_OUTDIR

	transform(".bam") to (".scaled.fwd.bw", ".scaled.rev.bw")  {
		exec """
			${PREPARE_BEDTOOLS} &&
			${PREPARE_SAMTOOLS} &&
			${PREPARE_KENTUTILS} &&

			if [ ! -d ${TMP} ]; then
				mkdir -p ${TMP};
			fi &&
			
			CHRSIZES=${TMP}/\$(basename ${input.prefix}).bam2bw.chrsizes &&
			${RUN_SAMTOOLS} idxstats ${input} | cut -f1-2 > \${CHRSIZES} &&
			TOTAL_MAPPED=\$( ${RUN_SAMTOOLS} flagstat $input | head -n1| cut -f1 -d" ") &&
			SCALE=\$(echo "1000000/\$TOTAL_MAPPED" | bc -l) &&

			${RUN_BEDTOOLS} genomecov -bg -split -scale \${SCALE} -strand "+" -ibam ${input} -g ${CHRSIZES} > ${output1.prefix}.bedgraph &&
			${RUN_BEDGRAPHTOBIGWIG} ${output1.prefix}.bedgraph ${CHRSIZES} $output1 &&
			
			${RUN_BEDTOOLS} genomecov -bg -split -scale ${SCALE} -strand "-" -ibam ${input} -g ${CHRSIZES} > ${output2.prefix}.bedgraph &&
			${RUN_BEDGRAPHTOBIGWIG} ${output2.prefix}.bedgraph ${CHRSIZES} $output2 &&
			
			rm ${CHRSIZES} ${output1.prefix}.bedgraph ${output2.prefix}.bedgraph

		""","Bam2bwStrand"
	}
}

