//rule for task Bam2bw from catalog NGS, version 1
//desc: Create scaled bigwig tracks from a bam file
Bam2bw = {
	doc title: "Bam2bw",
		desc:  "Convert BAM file to bigWig",
		constraints: "none.",
		author: "Sergi Sayols, Antonio Domingues"

	output.dir=TRACKS
	
	def SAMPLE_NAME = input.split("/")[-1].split("\\.", 2)[0]

	transform(".bam") to (".scaled.bw") {
		exec """
			${PREPARE_BEDTOOLS} &&
			${PREPARE_SAMTOOLS} &&
			${PREPARE_KENTUTILS} &&

			if [ ! -d ${TMP} ]; then
				mkdir -p ${TMP};
			fi &&
			
			
			if [ "${NORMALIZATION_TO_NONSTRUCT}" == "yes" ];
			then
				TOTAL_MAPPED=\$(grep $SAMPLE_NAME ${output.dir}/normalization_factors.txt | cut -f 2);
			else
				TOTAL_MAPPED=\$( ${RUN_SAMTOOLS} flagstat $input | head -n1| cut -f1 -d" ");
			fi &&
			
			CHRSIZES=${TMP}/\$(basename ${input.prefix}).bam2bw.chrsizes &&
			${RUN_SAMTOOLS} idxstats ${input} | cut -f1-2 > \${CHRSIZES} &&

			SCALE=\$(echo "1000000/\$TOTAL_MAPPED" | bc -l) &&
			${RUN_BEDTOOLS} genomecov -bg -split -scale \${SCALE} -ibam ${input} -g \${CHRSIZES} > ${output.prefix}.bedgraph &&
			${RUN_BEDGRAPHTOBIGWIG} ${output.prefix}.bedgraph \${CHRSIZES} $output &&
			rm \${CHRSIZES} ${output.prefix}.bedgraph
		""","Bam2bw"
	}
}

