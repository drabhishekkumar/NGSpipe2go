//rule for task bam2bw from catalog NGS, version 1
//desc: Create scaled bigwig tracks from a bam file
bam2bw = {
	doc title: "bam2bw",
		desc:  "Convert BAM file to bigWig",
		constraints: "none.",
		bpipe_version: "tested with bpipe 0.9.8.7",
		author: "Sergi Sayols"

	output.dir=TRACKS
	
	transform(".bam") to ("_scaled.bw") {
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
                        ${RUN_BEDTOOLS} genomecov -bg -split -scale \${SCALE} -ibam ${input} | sortBed -i -  > ${output.prefix}.bedgraph &&
			${RUN_BEDGRAPHTOBIGWIG} ${output.prefix}.bedgraph \${CHRSIZES} $output &&
			rm \${CHRSIZES} ${output.prefix}.bedgraph
		""","bam2bw"
	}
}

