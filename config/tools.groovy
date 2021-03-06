// This file defines data structures with all tools + versions + running_environments
// available to all pipelines
//
// If you install a new tool to be used in a pipeline:
//   * add the corresponding entry in tools_envs for that tool + version + runenv
//   * add default version + runenv in tools_defaults
//   * if needed, override the defaults in ${PIPELINE_ROOT}/pipelines/<pipeline>/tools.groovy
//
// Tips:
//   * Indentation is important in this file. Please, use 4 spaces for indent. *NO TABS*.
//   * Help others finding the tools here:
//       * keep the keys *sorted*
//       * use always *lowercase* if possible
//   * One can use only major versions in the 2nd level, and the version_str will
//     take care to report the right version. This is specially useful for programs
//     that ship often new versions with irrelevant changes.
//     For example, java 1.8: we have installed v1.8.0_101 in the lmod, and v1.8.0_181
//     in singularity. The pipeline will run version_str to report the right version,
//     but to keep this Map simple we have both under java->"1.8".
//
def conda_tools       = "/fsimb/common/conda_tools"
def singularity_tools = "/fsimb/common/singularity_tools"

// default runenvs and versions for each tools.
// Names should match those of tools_envs
tools_defaults = [
    R          : [ runenv: "lmod", version: "3.6.0"        ],
    bamqc      : [ runenv: "lmod", version: "0.1.25_devel" ],
    bamutil    : [ runenv: "lmod", version: "1.0.13"       ],
    bedtools   : [ runenv: "lmod", version: "2.27"         ],
    bowtie     : [ runenv: "lmod", version: "1.2.2"        ],
    bowtie2    : [ runenv: "lmod", version: "2.3.4"        ],
    bwa        : [ runenv: "lmod", version: "0.7.15"       ],
    cutadapt   : [ runenv: "lmod", version: "1.18"         ],
    deeptools  : [ runenv: "lmod", version: "3.1"          ],
    fastqc     : [ runenv: "lmod", version: "0.11.8"       ],
    fastqscreen: [ runenv: "lmod", version: "0.13"         ],
    fastx      : [ runenv: "lmod", version: "0.0.14"       ],
    gatk       : [ runenv: "lmod", version: "3.4-46"       ],
    htseq      : [ runenv: "lmod", version: "0.6.1"        ],
    java       : [ runenv: "lmod", version: "1.8"          ],
    kentutils  : [ runenv: "lmod", version: "v365"         ],
    macs2      : [ runenv: "lmod", version: "2.1.2"        ],
    mirdeep2   : [ runenv: "lmod", version: "2.0.0.8"      ],
    multiqc    : [ runenv: "lmod", version: "1.7"          ],
    pear       : [ runenv: "lmod", version: "0.9.11"       ],
    picard     : [ runenv: "lmod", version: "2.20"         ],
    pingpongpro: [ runenv: "lmod", version: "1.0"          ],
    qualimap   : [ runenv: "lmod", version: "2.2.1"        ],
    repenrich  : [ runenv: "lmod", version: "1.2"          ],
    rmats      : [ runenv: "lmod", version: "4.0.2"        ],
    rseqc      : [ runenv: "lmod", version: "3.0.0"        ],
    samtools   : [ runenv: "lmod", version: "1.9"          ],
    seqtk      : [ runenv: "lmod", version: "1.3"          ], 
    starfusion : [ runenv: "lmod", version: "0.8.0"        ],
    star       : [ runenv: "lmod", version: "2.7"          ],
    stringtie  : [ runenv: "lmod", version: "1.3.5"        ],
    subread    : [ runenv: "lmod", version: "1.6"          ],
    trimgalore : [ runenv: "lmod", version: "0.5.0"        ],
    umitools   : [ runenv: "lmod", version: "1.0.0"        ]
]

// This map defines how to prepare the environment in order to have in PATH all
// tools + versions + running_environments available. Structure:
//   * 1st level: tool name
//   * 2nd level: version --> version *string*
//   * 3rd level: runenv  --> one of [lmod|singularity|conda]
tools_envs = [
    R: [
        "3.5.1": [
            lmod: "module load R/3.5.1_debian9"
        ],
        "3.6.0": [
            lmod: "module load R/3.6.0",
            singularity: "alias Rscript=\"singularity run --app Rscript ${singularity_tools}/R/3.6.0r0/R.simg\""
        ]
    ],
    bamqc: [
        "0.1.25_devel": [
            lmod: "module load BamQC/0.1.25_devel"
        ]
    ],
    bamutil: [
        "1.0.13": [
            lmod: "module load bamUtil/1.0.13"
        ],
        "1.0.14": [
            conda: "source activate ${conda_tools}/bamutil/1.0.14"
        ]
    ],
    bedtools: [
        "2.27": [
            lmod: "module load bedtools/2.27.1_debian9",
            conda: "source activate ${conda_tools}/bedtools/2.27.1",
            singularity: "alias bedtools=\"singularity run --app bedtools ${singularity_tools}/bedtools/2.27.1r0/bedtools.simg\""
        ]
    ],
    bowtie: [
        "1.2.2": [
            lmod: "module load bowtie/1.2.2",
            conda: "source activate ${conda_tools}/bowtie/1.2.2"
        ]
    ],
    bowtie2: [
        "2.3.4": [
            lmod: "module load bowtie2/2.3.4.3",
            conda: "source activate ${conda_tools}/bowtie2/2.3.4",
            singularity: "alias bowtie2=\"singularity run --app bowtie2 ${singularity_tools}/bowtie2/2.3.4.3r0/bowtie2.simg\""
        ]
    ],
    bwa: [
        "0.7.15": [
            lmod: "module load bwa/0.7.15"
        ]
    ],
    cutadapt: [
        "1.18": [
            lmod: "module load cutadapt/1.18",
            conda: "source activate ${conda_tools}/cutadapt/1.18",
            singularity :"alias cutadapt=\"singularity run --app cutadapt ${singularity_tools}/cutadapt/1.18r0/cutadapt.simg\""
        ]
    ],
    deeptools: [
        "3.1": [
            lmod: "module load deepTools/3.1.0_debian9",
            singularity: """
                alias bamCoverage=\"singularity run --app bamCoverage $singularity_tools deeptools/3.1.2r0/deeptools.simg\";
                alias bamCompare=\"singularity run --app bamCompare $singularity_tools deeptools/3.1.2r0/deeptools.simg\"
            """
        ],
        "3.2": [
            conda: "source activate ${conda_tools}/deeptools/3.2.0"
        ]
    ],
    fastqc: [
        "0.11.8": [
            lmod: "module load fastqc/0.11.8",
            conda: "source activate ${conda_tools}/fastqc/0.11.8",
            singularity: "alias fastqc=\"singularity run --app fastqc ${singularity_tools}/fastqc/0.11.8r0/fastqc.simg\""
        ]
    ],
    fastqscreen: [
        "0.13": [
            lmod: "module load fastq_screen/0.13",
            conda: "source activate ${conda_tools}/fastq_screen/0.13"
        ]
    ],
    fastx: [
        "0.0.14": [
            lmod: "module load fastx_toolkit/0.0.14",
            conda: "source activate ${conda_tools}/fastx_toolkit/0.0.14"
        ]
    ],
    gatk: [
        "3.4-46": [
            lmod: "module load GATK/3.4-46"
        ]
    ],
    htseq: [
        "0.6.1": [
            lmod: "module load htseq/0.6.1"
        ]
    ],
    java: [
        "1.8": [
            lmod: "module load jdk/1.8.0_101",
            singularity: "alias java=\"singularity run --app java ${singularity_tools}/openjdk/8u181r0/openjdk8.simg\""
        ]
    ],
    kentutils: [
        "v302": [
            lmod: "module load kentUtils/v302"
        ],
        "v365": [
            lmod: "module load kentUtils/v365"
        ]
    ],
    macs2: [
        "2.1.2": [
            lmod: "module load macs2/2.1.2_debian9",
            conda: "source activate ${conda_tools}/macs2/2.1.2",
            singularity: "alias macs2=\"singularity run --app macs2 ${singularity_tools}/macs2/2.1.2.1r0/macs.simg\""
        ]
    ],
    mirdeep2: [
        "2.0.0.8": [
            lmod: "module load mirdeep2/2.0.0.8",
            conda: "source activate ${conda_tools}/mirdeep2/2.0.0.8"
        ]
    ],
    multiqc: [
        "1.7": [
            lmod: "module load MultiQC/1.7",
            conda: "source activate ${conda_tools}/MultiQC/1.7",
            singularity: "alias multiqc=\"singularity run --app multiqc ${singularity_tools}/MultiQC/1.7/multiqc.simg\""
        ]
    ],
    pear: [
        "0.9.11": [
            lmod: "module load pear/0.9.11"
        ]
    ],
    picard: [
        "2.7": [
            lmod: "module load picard/2.7.0"
        ],
        "2.18": [
            conda: "source activate ${conda_tools}/picard/2.18.26",
            singularity: "alias picard=\"singularity run --app picard ${singularity_tools}/picard/2.18.17r0/picard.simg\""
        ],
        "2.20": [
            lmod: "module load picard/2.20.3"
        ]
    ],
    pingpongpro: [
        "1.0": [
            lmod: "module load pingpongpro/1.0"
        ]
    ],
    qualimap: [
        "2.2.1": [
            lmod: "module load qualimap/2.2.1"
        ]
    ],
    repenrich: [
        "1.2": [
            conda: "source activate ${conda_tools}/repenrich/1.2"
        ]
    ],
    rmats: [
        "4.0.2": [
            lmod: "module load rmats/4.0.2_recompile_debian9",
            conda: "source activate ${conda_tools}/rmats/4.0.2",
            singularity: "alias rmats.py=\"singularity run --app rmats.py ${singularity_tools}/rmats/4.0.2r0/rmats.simg\""
        ]
    ],
    rseqc: [
        "3.0.0": [
            lmod: "module load RSeQC/3.0.0_debian9",
            conda: "source activate ${conda_tools}/rseqc/3.0.0",
            singularity: """
                alias bam2fq.py=\"singularity run --app bam2fq.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias bam2wig.py=\"singularity run --app bam2wig.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias bam_stat.py=\"singularity run --app bam_stat.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias clipping_profile.py=\"singularity run --app clipping_profile.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias deletion_profile.py=\"singularity run --app deletion_profile.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias divide_bam.py=\"singularity run --app divide_bam.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias FPKM_count.py=\"singularity run --app FPKM_count.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias geneBody_coverage.py=\"singularity run --app geneBody_coverage.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias geneBody_coverage2.py=\"singularity run --app geneBody_coverage2.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias infer_experiment.py=\"singularity run --app infer_experiment.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias inner_distance.py=\"singularity run --app inner_distance.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias insertion_profile.py=\"singularity run --app insertion_profile.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias junction_annotation.pyc=\"singularity run --app junction_annotation.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias junction_saturation.pyc=\"singularity run --app junction_saturation.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias mismatch_profile.py=\"singularity run --app mismatch_profile.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias normalize_bigwig.py=\"singularity run --app normalize_bigwig.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias overlay_bigwig.py=\"singularity run --app overlay_bigwig.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias read_distribution.py=\"singularity run --app read_distribution.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias read_duplication.py=\"singularity run --app read_duplication.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias read_GC.py=\"singularity run --app read_GC.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias read_hexamer.py=\"singularity run --app read_hexamer.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias read_NVC.py=\"singularity run --app read_NVC.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias read_quality.py=\"singularity run --app read_quality.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias RNA_fragment_size.py=\"singularity run --app RNA_fragment_size.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias RPKM_saturation.py=\"singularity run --app RPKM_saturation.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias spilt_bam.py=\"singularity run --app spilt_bam.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias split_paired_bam.py=\"singularity run --app split_paired_bam.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\";
                alias tin.py=\"singularity run --app tin.py ${singularity_tools}/rseqc/3.0.0r0/rseqc.simg\"
            """
        ]
    ],
    samtools: [
        "1.9": [
            lmod: "module load samtools/1.9",
            conda: "source activate ${conda_tools}/samtools/1.9",
            singularity: "alias samtools=\"singularity run --app samtools ${singularity_tools}/samtools/1.9r1/samtools.simg\""
        ]
    ],
    seqtk: [
        "1.3": [
            lmod: "module load seqtk/1.3",
            conda: "source activate ${conda_tools}/seqtk/1.3"
        ]
    ],
    starfusion: [
        "0.8.0": [
            lmod: "module load STAR-Fusion/0.8.0"
        ]
    ],
    star: [
        "2.6": [
            lmod: "module load star/2.6.1b_debian9",
            singularity: "alias STAR=\"singularity run --app STAR ${singularity_tools}/star/2.6.1br0/STAR.simg\""
        ],
        "2.7": [
            lmod: "module load star/2.7.3a",
            conda: "source activate ${conda_tools}/star/2.7.0d",
            singularity: "alias STAR=\"singularity run --app STAR ${singularity_tools}/star/2.7.0fr0/STAR.simg\""
        ]
    ],
    stringtie: [
        "1.3.5": [
            lmod: "module load stringtie/1.3.5"
        ]
    ],
    subread: [
        "1.6": [
            lmod: "module load subread/1.6.5_debian9",
            conda: "source activate ${conda_tools}/subread/1.6.3",
            singularity: """
                alias exactSNP=\"singularity run --app exactSNP ${singularity_tools}/subread/1.6.3r0/subread.simg\";
                alias featureCounts=\"singularity run --app featureCounts ${singularity_tools}/subread/1.6.3r0/subread.simg\";
                alias subindel=\"singularity run --app subindel ${singularity_tools}/subread/1.6.3r0/subread.simg\";
                alias subjunc=\"singularity run --app subjunc ${singularity_tools}/subread/1.6.3r0/subread.simg\";
                alias sublong=\"singularity run --app sublong ${singularity_tools}/subread/1.6.3r0/subread.simg\";
                alias subread-align=\"singularity run --app subread-align ${singularity_tools}/subread/1.6.3r0/subread.simg\";
                alias subread-buildindex=\"singularity run --app subread-buildindex${singularity_tools}/subread/1.6.3r0/subread.simg\"
            """
        ],
        "2.0": [
            lmod: "module load subread/2.0.0_debian9"
        ]
    ],
    trimgalore: [
        "0.5.0": [
            singularity: "alias trim_galore=\"singularity run --app trim_galore ${singularity_tools}/trimgalore/0.5.0r0/trimgalore.simg\""
        ]
    ],
    umitools: [
        "0.5.5": [
            lmod: "module load umitools/0.5.5",
            conda: "source activate ${conda_tools}/umitools/0.5.5"
        ],
        "1.0.0": [
            lmod: "module load umitools/1.0.0",
            conda: "source activate ${conda_tools}/umitools/1.0.0"
        ]
    ]
]

//
// prepare_tool_env
// 
// Given a tool, version and run env, return its tools_envs string.
// If any of the keys doesn't exist, returns the POSIX shell null command.
//
String prepare_tool_env (String tool, String version, String runenv) {

    if(tools_envs.containsKey(tool) &&
       tools_envs[tool].containsKey(version) &&
       tools_envs[tool][version].containsKey(runenv)) {
        return tools_envs[tool][version][runenv]
    } else {
        return ":"   // return the POSIX shell null command
    }
}

