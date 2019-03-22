//rule for task bowtie_se from catalog ChIPseq, version 1
//desc: Align single end reads
Bowtie_se = {
   doc title: "Bowtie SE alignment",
      desc:  "Align single end reads",
      constraints: "Only works with compressed input. Samtools multithreaded version expected (>=0.1.19).",
      bpipe_version: "tested with bpipe 0.9.8.7",
      author: "Sergi Sayols"

   output.dir = MULTIMAP_OUT_DIR

   def BOWTIE_FLAGS = " -q --sam"  +
                       " "   + BOWTIE_QUALS    +
                       " "   + BOWTIE_BEST     +
                       " -p " + Integer.toString(BOWTIE_THREADS) +
                       " -v " + Integer.toString(BOWTIE_MM)       +
                       " -M " + Integer.toString(BOWTIE_MULTIREPORT) +
                       " --trim5 " + Integer.toString(BOWTIE_TRIMM5)  +
                       " --trim3 " + Integer.toString(BOWTIE_TRIMM3)

   transform(".deduped_barcoded.trimmed.fastq.gz") to (".bam") {
   branch.totalBams = output

      def SAMPLE_NAME = input.prefix.prefix

      exec """
         ${PREPARE_BOWTIE}     &&
         ${PREPARE_SAMTOOLS} &&

         zcat $input | ${RUN_BOWTIE} $BOWTIE_FLAGS $BOWTIE_REF - 2> ${SAMPLE_NAME}.bt.log | ${RUN_SAMTOOLS} view -bhSu - | ${RUN_SAMTOOLS} sort -@ $BOWTIE_THREADS - -o $output
      ""","Bowtie_se"
   }
}
