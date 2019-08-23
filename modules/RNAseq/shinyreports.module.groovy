// Notes:
//  * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.

load PIPELINE_ROOT + "/modules/RNAseq/shinyreports.vars.groovy"

shinyReports = {
    doc title: "shinyReports",
        desc:  "creates the source code to compile the shiny and markdown reports",
        constraints: "",
        bpipe_version: "tested with bpipe 0.9.8.7",
        author: "Sergi Sayols"

    output.dir = REPORTS

    def PREAMBLE = get_preamble("shinyReports")

    produce("shinyReports.txt") {
        exec """
            ${PREAMBLE} &&

            cp ${PIPELINE_ROOT}/tools/reports/shiny_rnaseq_reporting_tool/server.R ${REPORTS}                &&
            cp ${PIPELINE_ROOT}/tools/reports/shiny_rnaseq_reporting_tool/ui.R ${REPORTS}                    &&
            cp ${PIPELINE_ROOT}/tools/reports/shiny_rnaseq_reporting_tool/DE.shinyrep.helpers.R ${REPORTS}   &&
            cp ${PIPELINE_ROOT}/tools/reports/shiny_rnaseq_reporting_tool/bustard.pl ${REPORTS}              &&
            cp ${PIPELINE_ROOT}/tools/reports/shiny_rnaseq_reporting_tool/BustardSummary.toMD.xsl ${REPORTS} &&
            cp ${PIPELINE_ROOT}/tools/reports/shiny_rnaseq_reporting_tool/styles.css ${REPORTS}              &&

            if [ -e "${REPORTS}/DEreport.Rmd" ]; then
                echo 'DEreport.Rmd already exists. Older copy will be kept and not overwritten';
            else
                cp ${PIPELINE_ROOT}/tools/reports/shiny_rnaseq_reporting_tool/DEreport.Rmd ${REPORTS};
            fi &&

            PROJECT=\$(basename ${shinyReports_vars.project})                    &&
            sed -i "2,2s/SHINYREPS_PROJECT/\${PROJECT}/" ${REPORTS}/DEreport.Rmd &&

            echo "SHINYREPS_PROJECT=${shinyReports_vars.project}" >  $output &&
            echo "SHINYREPS_ORG=${shinyReports_vars.org}"         >> $output &&
            echo "SHINYREPS_DB=${shinyReports_vars.db}"           >> $output &&
            echo "SHINYREPS_LOG=${shinyReports_vars.log}"         >> $output &&
            echo "SHINYREPS_PAIRED=${shinyReports_vars.paired}"   >> $output &&
            echo "SHINYREPS_QC=${shinyReports_vars.qc}"           >> $output &&
            echo "SHINYREPS_RES=${shinyReports_vars.res}"         >> $output &&
            echo "SHINYREPS_PREFIX=${shinyReports_vars.prefix}"   >> $output &&
            echo "SHINYREPS_STAR_LOG=${shinyReports_vars.star_log}"       >> $output &&
            echo "SHINYREPS_STAR_SUFFIX=${shinyReports_vars.star_suffix}" >> $output &&
            echo "SHINYREPS_STARparms_SUFFIX=${shinyReports_vars.starparms_suffix}" >> $output &&
            echo "SHINYREPS_FASTQC_OUT=${shinyReports_vars.fastqc_out}"     >> $output &&
            echo "SHINYREPS_FASTQC_LOG=${shinyReports_vars.fastqc_log}"     >> $output &&
            echo "SHINYREPS_BAMINDEX_LOG=${shinyReports_vars.bamindex_log}"     >> $output &&
            echo "SHINYREPS_DUPRADAR_LOG=${shinyReports_vars.dupradar_log}" >> $output &&
            echo "SHINYREPS_RNATYPES_LOG=${shinyReports_vars.rnatypes_log}" >> $output &&
            echo "SHINYREPS_RNATYPES=${shinyReports_vars.rnatypes}" >> $output &&
            echo "SHINYREPS_RNATYPES_SUFFIX=${shinyReports_vars.rnatypes_suffix}" >> $output &&
            echo "SHINYREPS_GENEBODYCOV_LOG=${shinyReports_vars.genebodycov_log}" >> $output &&
            echo "SHINYREPS_BUSTARD=${shinyReports_vars.bustard}"         >> $output &&
            echo "SHINYREPS_DE_EDGER=${shinyReports_vars.de_edger}"       >> $output &&
            echo "SHINYREPS_DE_DESEQ=${shinyReports_vars.de_deseq}"       >> $output &&
            echo "SHINYREPS_DE_DESEQ_MM=${shinyReports_vars.de_deseq_mm}" >> $output &&
            echo "SHINYREPS_SUBREAD=${shinyReports_vars.subread}"         >> $output &&
            echo "SHINYREPS_SUBREAD_SUFFIX=${shinyReports_vars.subread_suffix}"  >> $output &&
            echo "SHINYREPS_SUBREAD_LOG=${shinyReports_vars.subread_log}"        >> $output &&
            echo "SHINYREPS_BAM2BW_LOG=${shinyReports_vars.bam2bw_log}"          >> $output &&
            echo "SHINYREPS_MARKDUPS_LOG=${shinyReports_vars.markdups_log}"      >> $output &&
            echo "SHINYREPS_EDGER_LOGS=${shinyReports_vars.edger_logs}"          >> $output &&
            echo "SHINYREPS_DESEQ_LOGS=${shinyReports_vars.deseq_logs}"          >> $output &&
            echo "SHINYREPS_PLOTS_COLUMN=${shinyReports_vars.plots_column}"      >> $output &&
            echo "SHINYREPS_INFEREXPERIMENT_LOGS=${shinyReports_vars.inferexperiment_logs}" >> $output &&
            echo "SHINYREPS_QUALIMAP_LOGS=${shinyReports_vars.qualimap_logs}" >> $output &&
            echo "SHINYREPS_INSERTSIZE=${shinyReports_vars.insertsize}" >> $output &&
            echo "SHINYREPS_GO_ENRICHMENT=${shinyReports_vars.go_enrichment}" >> $output &&
            echo "SHINYREPS_TRACKHUB_DONE=${shinyReports_vars.trackhub_done}" >> $output &&
            echo "SHINYREPS_TOOL_VERSIONS=${shinyReports_vars.tool_versions}" >> $output
        ""","shinyReports"
    }
}

