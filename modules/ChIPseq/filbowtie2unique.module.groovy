filbowtie2unique = {
    doc title: "filter out multimapping reads from bowtie2 out",
        desc:  "filter out multimapping reads from bowtie2 out. output bam file",
        constraints: "Only works with compressed input. Samtools multithreaded version expected (>=0.1.19).",
        bpipe_version: "tested with bpipe 0.9.8.7",
        author: "Nastasja Kreim"

	output.dir = FILBOWTIE2UNIQUE_MAPPED
	
	transform(".bam") to (".unique.bam") {
		exec """
			${PREPARE_SAMTOOLS} &&
            if [ -n "\$SLURM_JOBID" ]; then
				export TMPDIR=/jobdir/\${SLURM_JOBID};
			fi                                          &&
			
			${RUN_SAMTOOLS} view -f 2 $FILBOWTIE2UNIQUE_SAMTOOLS_MAPQ -bhu ${input} | ${RUN_SAMTOOLS} sort $FILBOWTIE2UNIQUE_SAMTOOLS_THREADS -T $TMPDIR/\$(basename $output.prefix) -o ${output} -;
		""","filbowtie2unique"
	}
}

