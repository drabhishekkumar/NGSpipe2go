strandBigWig = {
	doc title: "strandBigWig",
		desc:  "strandBigWig wrapper",
		constraints: "strandspecific bigwig for rnaseq",
		bpipe_version: "tested with bpipe 0.9.8.7",
		author: "Nastasja Kreim"

	output.dir = STRANDSPECIFICBIGWIG_OUTDIR
	//this might be confusing regarding the reverse and forward
	//setting but according to the deeptools manual it has to be like
	//that. 
    	if(ESSENTIAL_STRANDED == "yes") {
		FORWARD="reverse"
		REVERSE="forward"
	} else if(ESSENTIAL_STRANDED == "reverse") {
		FORWARD="forward"
		REVERSE="reverse"
	}

	transform(".bam") to(".fwd.bw", ".rev.bw") {
		exec """
			export TOOL_DEPENDENCIES=$TOOL_DEPENDENCIES  &&
			${PREPARE_DEEPTOOLS} &&
			${PREPARE_SAMTOOLS} &&
			${PREPARE_KENTUTILS} &&
			if [ -n "\$SLURM_JOBID" ]; then
				export TMPDIR=/jobdir/\${SLURM_JOBID};
			fi;
			base=\$(basename $input.prefix) &&
			echo \$base &&
			CHRSIZES=${TMPDIR}/\${base}.bam2bw.chrsizes &&
			${RUN_SAMTOOLS} idxstats ${input} | cut -f1-2 > \${CHRSIZES} &&
			${RUN_BAMCOVERAGE} --numberOfProcessors $STRANDSPECIFICBIGWIG_CORES --filterRNAstrand $FORWARD $STRANDSPECIFICBIGWIG_OTHER -b  $input -o \${TMPDIR}/\${base}.fwd.bedgraph &&
			${RUN_BAMCOVERAGE} --numberOfProcessors $STRANDSPECIFICBIGWIG_CORES --filterRNAstrand $REVERSE $STRANDSPECIFICBIGWIG_OTHER -b $input -o \${TMPDIR}/\${base}.rev.bedgraph&&
			
			awk 'BEGIN {OFS="\t"; FS="\t"}{print \$1,\$2, \$3,"-"\$4}' \${TMPDIR}/\${base}.rev.bedgraph > \${TMPDIR}/\${base}.rev.bedgraph_neg &&
			mv $TMPDIR/\${base}.rev.bedgraph_neg $TMPDIR/\${base}.rev.bedgraph &&
			${RUN_BEDGRAPHTOBIGWIG} \${TMPDIR}/\${base}.fwd.bedgraph $CHRSIZES $output1 &&
			${RUN_BEDGRAPHTOBIGWIG} \${TMPDIR}/\${base}.rev.bedgraph $CHRSIZES $output2
			
		""","strandBigWig"
	}
	forward input
}


