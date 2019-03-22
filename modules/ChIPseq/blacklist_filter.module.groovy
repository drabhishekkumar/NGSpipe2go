blacklist_filter = {

    doc title: "blacklist_filter",
        desc: "Remove peaks overlapping blacklisted genomic regions",
        constraints: "",
        bpipe_version:"",
        author:"Giuseppe Petrosino"

    output.dir=blacklist_filter_OUTDIR.replaceFirst("out=","")
    def blacklist_filter_FLAGS = blacklist_filter_FILES + " " +
        blacklist_filter_BED_FILE + " " + 
        blacklist_filter_OUTDIR + " " +
        blacklist_filter_EXTRA


    produce("BlackList_Filter.RData") {
        exec """
           ${PREPARE_BEDTOOLS} &&
           ${PREPARE_R} &&
            ${RUN_R} ${TOOL_BLACKLIST_FILTER}/BlackList_Filter.R $blacklist_filter_FLAGS;
        ""","blacklist_filter"
    }
}
