// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/NGS/multiqc.vars.groovy"

MultiQC = {
    doc title: "MultiQC",
        desc:  "MultiQC is a reporting tool that parses summary statistics from results and log files generated by other bioinformatics tools",
        constraints: "",
        bpipe_version: "tested with bpipe 0.9.9.7",
        author: "Giuseppe Petrosino"

    output.dir = MultiQC_vars.outdir
    def MULTIQC_FLAGS =
        (MultiQC_vars.extra ? " " + MultiQC_vars.extra : "")

    def TOOL_ENV = prepare_tool_env("multiqc", tools["multiqc"]["version"], tools["multiqc"]["runenv"])
    def PREAMBLE = get_preamble("MULTIQC")

        exec """
            ${TOOL_ENV} &&
            ${PREAMBLE} &&

            multiqc $ESSENTIAL_PROJECT $MultiQC_FLAGS -o $output.dir
        ""","MULTIQC"

}
