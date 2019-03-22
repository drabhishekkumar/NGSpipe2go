//rule for task BWA mem from DNAseq pipeline
//desc: Align single and paired end reads
BWA_pe = {
	doc title: "BWA PE alignment",
	desc:  "Align paired end reads",
	constraints: "Only works with compressed input. Set all global vars. Samtools version >= 1.2.",
	bpipe_version: "tested with bpipe 0.9.8.7",
	author: "Oliver Drechsel, Anke Busch"

	output.dir = MAPPED
	
	def OUTPUTFILE = input1
	int path_index = OUTPUTFILE.lastIndexOf("/")
	OUTPUTFILE = OUTPUTFILE.substring(path_index+1)
	OUTPUTFILE = (OUTPUTFILE =~ /_R1.fastq.gz/).replaceFirst("")
	
	def BWA_FLAGS = "-M " +
        	        BWA_THREADS + " " +
                        BWA_EXTRA
    
	def SAMTOOLS_VIEW_FLAGS = "-bhSu"
	def SAMTOOLS_SORT_FLAGS = SAMTOOLS_THREADS	
		
    	produce(OUTPUTFILE + ".bam") {
            exec """
            	${PREPARE_BWA} &&
            	${PREPARE_SAMTOOLS} && 
			
            	if [ -n "\$SLURM_JOBID" ]; then
                	export TMPDIR=/jobdir/\${SLURM_JOBID};
            	fi 

		SAMPLE_NAME=\$(basename $output.prefix) &&
		PLATFORM="genomics" &&
			
		${RUN_BWA} mem $BWA_FLAGS -R \"@RG\\tID:\${SAMPLE_NAME}\\tSM:\${SAMPLE_NAME}\\tPL:illumina\\tLB:\${SAMPLE_NAME}\\tPU:\${PLATFORM}\" $BWA_REF $input1 $input2 | ${RUN_SAMTOOLS} view ${SAMTOOLS_VIEW_FLAGS} - | ${RUN_SAMTOOLS} sort ${SAMTOOLS_SORT_FLAGS} -T \${TMPDIR}/\${SAMPLE_NAME} -  > ${output} &&
			
		${RUN_SAMTOOLS} flagstat ${output} 1>&2
            ""","BWA_pe"
    }
}


BWA_se = {
	doc title: "BWA SE alignment",
	desc:  "Align paired end reads",
	constraints: "Only works with compressed input. Set all global vars. Samtools version >= 1.2",
	bpipe_version: "tested with bpipe 0.9.8.7",
	author: "Oliver Drechsel"

	output.dir = MAPPED
    def BWA_FLAGS = "-M " +
                    BWA_THREADS + " " +
                    BWA_EXTRA
    
	def SAMTOOLS_VIEW_FLAGS = "-bhSu"
	def SAMTOOLS_SORT_FLAGS = SAMTOOLS_THREADS	
		
    
	transform(".fastq.gz") to(".bam") {
        exec """
            
            ${PREPARE_BWA} &&
            ${PREPARE_SAMTOOLS} &&

			SAMPLE_NAME=\$(basename $output.prefix.prefix) &&

			PLATFORM="genomics" &&
			
			${RUN_BWA} mem $BWA_FLAGS -R \"@RG\\tID:\${SAMPLE_NAME}\\tSM:\${SAMPLE_NAME}\\tPL:illumina\\tLB:\${SAMPLE_NAME}\\tPU:\${PLATFORM}\" $BWA_REF $input | ${RUN_SAMTOOLS} view ${SAMTOOLS_VIEW_FLAGS} - | ${RUN_SAMTOOLS} sort ${SAMTOOLS_SORT_FLAGS} -T \${TMP}/\${SAMPLE_NAME} -  > ${output} &&
			
			${RUN_SAMTOOLS} flagstat ${output} 1>&2
        ""","BWA_se"
    }
}
