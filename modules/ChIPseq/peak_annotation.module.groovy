// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/ChIPseq/peak_annotation.vars.groovy"

peak_annotation = {
    doc title: "peak_annotation",
        desc: "ChIP peak annotation, comparison and visualization using ChIPSeeker package",
        constraints: "",
        bpipe_version:"",
        author:"Sri Dewi"

    output.dir=peak_annotation_vars.outdir

    def PEAK_ANNOTATION_FLAGS =
        (peak_annotation_vars.files           ? " peakData="       + peak_annotation_vars.files           : "") +
        (peak_annotation_vars.transcript_type ? " transcriptType=" + peak_annotation_vars.transcript_type : "") +
        (peak_annotation_vars.transcript_db   ? " transcriptDb="   + peak_annotation_vars.transcript_db   : "") +
        (peak_annotation_vars.orgdb           ? " orgDb="          + peak_annotation_vars.orgdb           : "") +
        (peak_annotation_vars.regiontss       ? " regionTSS="      + peak_annotation_vars.regiontss       : "") +
        (peak_annotation_vars.outdir          ? " out="            + peak_annotation_vars.outdir          : "") +
        (peak_annotation_vars.extra           ? " "                + peak_annotation_vars.extra           : "")

    def TOOL_ENV = prepare_tool_env("R", tools["R"]["version"], tools["R"]["runenv"])
    def PREAMBLE = get_preamble("peak_annotation")

    produce("Peak_Annotation.RData") {
        exec """
            ${TOOL_ENV} &&
            ${PREAMBLE} &&

            Rscript ${PIPELINE_ROOT}/tools/Peak_Annotation/Peak_Annotation.R $PEAK_ANNOTATION_FLAGS;
        ""","peak_annotation"
    }
}
