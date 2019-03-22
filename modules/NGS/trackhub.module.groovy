trackhub = {
    doc title: "Trackhub",
        desc:  "Generate UCSC track hub to display project tracks",
        constraints: "Uses configuration file, which should have been generated earlier",
        bpipe_version: "tested with bpipe 0.9.9.3",
        author: "Martin Oti"

    def trackhub_FLAGS = "TRACKHUB_CONFIG=" + TRACKHUB_CONFIG

    transform(".yaml") to (".done") {
        exec """
           ${PREPARE_KENTUTILS} &&
           ${PREPARE_R} &&
           ${RUN_R} ${TOOL_TRACKHUB}/Make_Trackhub.R $trackhub_FLAGS
        ""","trackhub"
    }
}

