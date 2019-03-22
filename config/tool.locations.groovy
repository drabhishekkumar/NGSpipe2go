// variables containing the location of the used tools
TOOL_DEPENDENCIES="/fsimb/common/tools"              // your local tools folder
SINGULARITY_IMAGES="/fsimb/common/singularity_tools"  // your singularity images base folder
CONDA_ENVS="/fsimb/common/conda_tools"               // your conda virtual environments base folder
PROJECT_DEPENDENCIES=ESSENTIAL_PROJECT + "/NGSpipe2go/tools" // please copy the bpipe tools to the project folder and include the location here
TOOL_DUPRADAR=PROJECT_DEPENDENCIES + "/dupRadar"
TOOL_RNAtypes=TOOL_DEPENDENCIES + "/imb-forge/RNAtypes"
TOOL_GENEBODYCOV2=TOOL_DEPENDENCIES + "/imb-forge/geneBodyCov"
TOOL_EDGER=PROJECT_DEPENDENCIES + "/DE_edgeR"
TOOL_DESeq2=PROJECT_DEPENDENCIES + "/DE_DESeq2"
TOOL_COLLECT=PROJECT_DEPENDENCIES + "/collectBpipeLogs"
TOOL_GO=PROJECT_DEPENDENCIES+ "/GO_Enrichment"
TOOL_TRACKHUB=PROJECT_DEPENDENCIES+ "/trackhub"
TOOL_ENCODEqc=TOOL_DEPENDENCIES + "/imb-forge/chipqc"
TOOL_DIFFBIND=PROJECT_DEPENDENCIES + "/diffbind"
TOOL_PEAK_ANNOTATION=PROJECT_DEPENDENCIES + "/Peak_Annotation"
TOOL_BLACKLIST_FILTER=PROJECT_DEPENDENCIES + "/BlackList_Filter"
