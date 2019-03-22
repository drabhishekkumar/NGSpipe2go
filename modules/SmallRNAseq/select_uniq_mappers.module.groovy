//rule for task SelectUniqMappers from catalog SmallRNAseq, version 0.1
SelectUniqMappers = {
   doc title: "SelectUniqMappers",
      desc:  "Call samtools to Select uniquely mapped reads.",
      author: "Antonio Domingues"

   output.dir = UNIQUEMAP_OUT_DIR

   transform(".bam") to(".unique.bam") {
      exec """
         ${PREPARE_SAMTOOLS} &&

         ${RUN_SAMTOOLS} view -hb -q 255 $input | ${RUN_SAMTOOLS} sort -@ $BOWTIE_THREADS - -o $output &&
         ${RUN_SAMTOOLS} index $output
      ""","SelectUniqMappers"
   }
}
