FilterRNAClasses = {
   doc title: "Filter small RNA classes",
         desc:  "Filter alignments to select C. elegans small RNA classes: 21U, 22G, 26G",
         constraints: "",
         author: "Antonio Domingues"

   output.dir = FILTER_CLASSES_OUTDIR

   transform(".bam") to (".21U.bam", ".22G.bam", ".26G.bam"){

      exec """
         ${PREPARE_BEDTOOLS} &&
         ${PREPARE_HTSEQ} &&

         python $FILTER_CLASSES_TOOL_PATH -i $input -m 21 -M 21 -o stdout | ${RUN_BEDTOOLS} intersect -a stdin -b $FILTER_CLASSES_21U_REF -s > $output1 &&
         python $FILTER_CLASSES_TOOL_PATH -i $input -m 20 -M 23 -o stdout | ${RUN_BEDTOOLS} intersect -a stdin -b $FILTER_CLASSES_22G_REF -S > $output2 &&
         python $FILTER_CLASSES_TOOL_PATH -i $input -m 26 -M 26 -o stdout | ${RUN_BEDTOOLS} intersect -a stdin -b $FILTER_CLASSES_26G_REF -S > $output3 &&

         ${RUN_SAMTOOLS} index $output1 &&
         ${RUN_SAMTOOLS} index $output2 &&
         ${RUN_SAMTOOLS} index $output3

      ""","FilterRNAClasses"
   }
   forward input, output1, output2, output3
}
