////////////////////////////////////////////////////////////////
////  Set up tool commands for different installation types
////  Each tool has two tpes of commands:
////  - preparation command (e.g. module load)
////  - run command(s) (there can be several per tool)
////
//// INSTALLTYPE options: lmod, conda, singularity, system
////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////
// R
///////////////////////////////////////////////////////////////
if (R_INSTALLTYPE == "lmod") {
    PREPARE_R = "module load R/" + R_LMOD_VERSION
    RUN_R = "Rscript"
} else if (R_INSTALLTYPE == "conda") {
    PREPARE_R = "source activate " + CONDA_ENVS + "/R/" + R_CONDA_VERSION
    RUN_R = "Rscript"
} else if (R_INSTALLTYPE == "singularity") {
    PREPARE_R = ":"
    RUN_R = "singularity run --app Rscript " + SINGULARITY_IMAGES + "/R/" + R_SIMG_VERSION + "/R.simg"
} else {
    PREPARE_R = ":"
    RUN_R = "Rscript"
}

///////////////////////////////////////////////////////////////
// JAVA
///////////////////////////////////////////////////////////////
if (JAVA_INSTALLTYPE == "lmod") {
    PREPARE_JAVA = "module load jdk/" + JAVA_LMOD_VERSION
    RUN_JAVA = "java"
} else if (JAVA_INSTALLTYPE == "conda") {
    PREPARE_JAVA = "source activate " + CONDA_ENVS + "/jdk/" + JAVA_CONDA_VERSION
    RUN_JAVA = "java"
} else if (JAVA_INSTALLTYPE == "singularity") {
    PREPARE_JAVA = ":"
    RUN_JAVA = "singularity run --app java " + SINGULARITY_IMAGES + "/openjdk/" + JAVA_SIMG_VERSION + "/openjdk8.simg"
} else {
    PREPARE_JAVA = ":"
    RUN_JAVA = "java"
}

///////////////////////////////////////////////////////////////
// BAMQC
///////////////////////////////////////////////////////////////
if (BAMQC_INSTALLTYPE == "lmod") {
    PREPARE_BAMQC = "module load BamQC/" + BAMQC_LMOD_VERSION
    RUN_BAMQC = "bamqc"
////} else if (BAMQC_INSTALLTYPE == "conda") {
////    PREPARE_BAMQC = "source activate " + CONDA_ENVS + "/bamqc/" + BAMQC_CONDA_VERSION
////    RUN_BAMQC = "bamqc"
} else if (BAMQC_INSTALLTYPE == "singularity") {
    PREPARE_BAMQC = ":"
    RUN_BAMQC = "singularity run --app bamqc " + SINGULARITY_IMAGES + "/bamqc/" + BAMQC_SIMG_VERSION + "/bamqc.simg"
} else {
    PREPARE_BAMQC = ":"
    RUN_BAMQC = "bamqc"
}

///////////////////////////////////////////////////////////////
// BAMUTIL
///////////////////////////////////////////////////////////////
if (BAMUTIL_INSTALLTYPE == "lmod") {
    PREPARE_BAMUTIL = "module load bamUtil/" + BAMUTIL_LMOD_VERSION
    RUN_BAMUTIL = "bam"
} else if (BAMUTIL_INSTALLTYPE == "conda") {
    PREPARE_BAMUTIL = "source activate " + CONDA_ENVS + "/bamutil/" + BAMUTIL_CONDA_VERSION
    RUN_BAMUTIL = "bam"
} else if (BAMUTIL_INSTALLTYPE == "singularity") {
    PREPARE_BAMUTIL = ":"
    RUN_BAMUTIL = "singularity run --app bam " + SINGULARITY_IMAGES + "/bamutil/" + BAMUTIL_SIMG_VERSION + "/bamutil.simg"
} else {
    PREPARE_BAMUTIL = ":"
    RUN_BAMUTIL = "bam"
}

///////////////////////////////////////////////////////////////
// BEDTOOLS
///////////////////////////////////////////////////////////////
if (BEDTOOLS_INSTALLTYPE == "lmod") {
    PREPARE_BEDTOOLS = "module load bedtools/" + BEDTOOLS_LMOD_VERSION
    RUN_BEDTOOLS = "bedtools"
} else if (BEDTOOLS_INSTALLTYPE == "conda") {
    PREPARE_BEDTOOLS = "source activate " + CONDA_ENVS + "/bedtools/" + BEDTOOLS_CONDA_VERSION
    RUN_BEDTOOLS = "bedtools"
} else if (BEDTOOLS_INSTALLTYPE == "singularity") {
    PREPARE_BEDTOOLS = ":"
    RUN_BEDTOOLS = "singularity run --app bedtools " + SINGULARITY_IMAGES + "/bedtools/" + BEDTOOLS_SIMG_VERSION + "/bedtools.simg"
} else {
    PREPARE_BEDTOOLS = ":"
    RUN_BEDTOOLS = "bedtools"
}

///////////////////////////////////////////////////////////////
// BOWTIE
///////////////////////////////////////////////////////////////
if (BOWTIE_INSTALLTYPE == "lmod") {
    PREPARE_BOWTIE = "module load bowtie/" + BOWTIE_LMOD_VERSION
    RUN_BOWTIE = "bowtie"
} else if (BOWTIE_INSTALLTYPE == "conda") {
    PREPARE_BOWTIE = "source activate " + CONDA_ENVS + "/bowtie/" + BOWTIE_CONDA_VERSION
    RUN_BOWTIE = "bowtie"
} else if (BOWTIE_INSTALLTYPE == "singularity") {
    PREPARE_BOWTIE = ":"
    RUN_BOWTIE = "singularity run --app bowtie " + SINGULARITY_IMAGES + "/bowtie/" + BOWTIE_SIMG_VERSION + "/bowtie.simg"
} else {
    PREPARE_BOWTIE = ":"
    RUN_BOWTIE = "bowtie"
}

///////////////////////////////////////////////////////////////
// BOWTIE2
///////////////////////////////////////////////////////////////
if (BOWTIE2_INSTALLTYPE == "lmod") {
    PREPARE_BOWTIE2 = "module load bowtie2/" + BOWTIE2_LMOD_VERSION
    RUN_BOWTIE2 = "bowtie2"
} else if (BOWTIE2_INSTALLTYPE == "conda") {
    PREPARE_BOWTIE2 = "source activate " + CONDA_ENVS + "/bowtie2/" + BOWTIE2_CONDA_VERSION
    RUN_BOWTIE = "bowtie2"
} else if (BOWTIE2_INSTALLTYPE == "singularity") {
    PREPARE_BOWTIE2 = ":"
    RUN_BOWTIE2 = "singularity run --app bowtie2 " + SINGULARITY_IMAGES + "/bowtie2/" + BOWTIE2_SIMG_VERSION + "/bowtie2.simg"
} else {
    PREPARE_BOWTIE2 = ":"
    RUN_BOWTIE2 = "bowtie2"
}

///////////////////////////////////////////////////////////////
// BWA
///////////////////////////////////////////////////////////////
if (BWA_INSTALLTYPE == "lmod") {
    PREPARE_BWA = "module load bwa/" + BWA_LMOD_VERSION
    RUN_BWA = "bwa"
} else if (BWA_INSTALLTYPE == "conda") {
    PREPARE_BWA = "source activate " + CONDA_ENVS + "/bwa/" + BWA_CONDA_VERSION
    RUN_BWA = "bwa"
} else if (BWA_INSTALLTYPE == "singularity") {
    PREPARE_BWA = ":"
    RUN_BWA = "singularity run --app bwa " + SINGULARITY_IMAGES + "/bwa/" + BWA_SIMG_VERSION + "/bwa.simg"
} else {
    PREPARE_BWA = ":"
    RUN_BWA = "bwa"
}

///////////////////////////////////////////////////////////////
// CUTADAPT
///////////////////////////////////////////////////////////////
if (CUTADAPT_INSTALLTYPE == "lmod") {
    PREPARE_CUTADAPT = "module load cutadapt/" + CUTADAPT_LMOD_VERSION
    RUN_CUTADAPT = "cutadapt"
} else if (CUTADAPT_INSTALLTYPE == "conda") {
    PREPARE_CUTADAPT = "source activate " + CONDA_ENVS + "/cutadapt/" + CUTADAPT_CONDA_VERSION
    RUN_CUTADAPT = "cutadapt"
} else if (CUTADAPT_INSTALLTYPE == "singularity") {
    PREPARE_CUTADAPT = ":"
    RUN_CUTADAPT = "singularity run --app cutadapt " + SINGULARITY_IMAGES + "/cutadapt/" + CUTADAPT_SIMG_VERSION + "/cutadapt.simg"
} else {
    PREPARE_CUTADAPT = ":"
    RUN_CUTADAPT = "cutadapt"
}

///////////////////////////////////////////////////////////////
// DEEPTOOLS
///////////////////////////////////////////////////////////////
if (DEEPTOOLS_INSTALLTYPE == "lmod") {
    PREPARE_DEEPTOOLS = "module load deepTools/" + DEEPTOOLS_LMOD_VERSION
    RUN_BAMCOVERAGE = "bamCoverage"
    RUN_BAMCOMPARE = "bamCompare"
} else if (DEEPTOOLS_INSTALLTYPE == "conda") {
    PREPARE_DEEPTOOLS = "source activate " + CONDA_ENVS + "/deeptools/" + DEEPTOOLS_CONDA_VERSION
    RUN_BAMCOVERAGE = "bamCoverage"
    RUN_BAMCOMPARE = "bamCompare"
} else if (DEEPTOOLS_INSTALLTYPE == "singularity") {
    PREPARE_DEEPTOOLS = ":"
    RUN_BAMCOVERAGE = "singularity run --app bamCoverage " + SINGULARITY_IMAGES + "/deeptools/" + DEEPTOOLS_SIMG_VERSION + "/deeptools.simg"
    RUN_BAMCOMPARE = "singularity run --app bamCompare " + SINGULARITY_IMAGES + "/deeptools/" + DEEPTOOLS_SIMG_VERSION + "/deeptools.simg"
} else {
    PREPARE_DEEPTOOLS = ":"
    RUN_BAMCOVERAGE = "bamCoverage"
    RUN_BAMCOMPARE = "bamCompare"
}

///////////////////////////////////////////////////////////////
// FASTQC
///////////////////////////////////////////////////////////////
if (FASTQC_INSTALLTYPE == "lmod") {
    PREPARE_FASTQC = "module load fastqc/" + FASTQC_LMOD_VERSION
    RUN_FASTQC = "fastqc"
} else if (FASTQC_INSTALLTYPE == "conda") {
    PREPARE_FASTQC = "source activate " + CONDA_ENVS + "/fastqc/" + FASTQC_CONDA_VERSION
    RUN_FASTQC = "fastqc"
} else if (FASTQC_INSTALLTYPE == "singularity") {
    PREPARE_FASTQC = ":"
    RUN_FASTQC = "singularity run --app fastqc " + SINGULARITY_IMAGES + "/fastqc/" + FASTQC_SIMG_VERSION + "/fastqc.simg"
} else {
    PREPARE_FASTQC = ":"
    RUN_FASTQC = "fastqc"
}

///////////////////////////////////////////////////////////////
// FASTQSCREEN
///////////////////////////////////////////////////////////////
if (FASTQSCREEN_INSTALLTYPE == "lmod") {
    PREPARE_FASTQSCREEN = "module load fastq_screen/" + FASTQSCREEN_LMOD_VERSION
    RUN_FASTQSCREEN = "fastq_screen"
} else if (FASTQSCREEN_INSTALLTYPE == "conda") {
    PREPARE_FASTQSCREEN = "source activate " + CONDA_ENVS + "/fastq_screen/" + FASTQSCREEN_CONDA_VERSION
    RUN_FASTQSCREEN = "fastq_screen"
} else if (FASTQSCREEN_INSTALLTYPE == "singularity") {
    PREPARE_FASTQSCREEN = ":"
    RUN_FASTQSCREEN = "singularity run --app fastq_screen " + SINGULARITY_IMAGES + "/fastq_screen/" + FASTQSCREEN_SIMG_VERSION + "/fastq_screen.simg"
} else {
    PREPARE_FASTQSCREEN = ":"
    RUN_FASTQSCREEN = "fastq_screen"
}

///////////////////////////////////////////////////////////////
// FASTX TOOLKIT
///////////////////////////////////////////////////////////////
if (FASTX_INSTALLTYPE == "lmod") {
    PREPARE_FASTX = "module load fastx_toolkit/" + FASTX_LMOD_VERSION
    RUN_FASTQ_QUALITY_FILTER = "fastq_quality_filter"
    RUN_FASTX_TRIMMER = "fastx_trimmer"
} else if (FASTX_INSTALLTYPE == "conda") {
    PREPARE_FASTX = "source activate " + CONDA_ENVS + "/fastx_toolkit/" + FASTX_CONDA_VERSION
    RUN_FASTQ_QUALITY_FILTER = "fastq_quality_filter"
    RUN_FASTX_TRIMMER = "fastx_trimmer"
} else if (FASTX_INSTALLTYPE == "singularity") {
    PREPARE_FASTX = ":"
    RUN_FASTQ_QUALITY_FILTER = "singularity run --app fastq_quality_filter " + SINGULARITY_IMAGES + "/fastx_toolkit/" + FASTX_SIMG_VERSION + "/fastx_toolkit.simg"
    RUN_FASTX_TRIMMER = "singularity run --app fastx_trimmer " + SINGULARITY_IMAGES + "/fastx_toolkit/" + FASTX_SIMG_VERSION + "/fastx_toolkit.simg"
} else {
    PREPARE_FASTX = ":"
    RUN_FASTQ_QUALITY_FILTER = "fastq_quality_filter"
    RUN_FASTX_TRIMMER = "fastx_trimmer"
}

///////////////////////////////////////////////////////////////
// HTSEQ
///////////////////////////////////////////////////////////////
if (HTSEQ_INSTALLTYPE == "lmod") {
    PREPARE_HTSEQ = "module load htseq/" + HTSEQ_LMOD_VERSION
    RUN_HTSEQCOUNT = "htseq-count"
} else if (HTSEQ_INSTALLTYPE == "conda") {
    PREPARE_HTSEQ = "source activate " + CONDA_ENVS + "/htseq/" + HTSEQ_CONDA_VERSION
    RUN_HTSEQCOUNT = "htseq-count"
} else if (HTSEQ_INSTALLTYPE == "singularity") {
    PREPARE_HTSEQ = ":"
    RUN_HTSEQCOUNT = "singularity run --app htseq-count " + SINGULARITY_IMAGES + "/htseq/" + HTSEQ_SIMG_VERSION + "/htseq.simg"
} else {
    PREPARE_HTSEQ = ":"
    RUN_HTSEQCOUNT = "htseq-count"
}

///////////////////////////////////////////////////////////////
// KENTUTILS
///////////////////////////////////////////////////////////////
if (KENTUTILS_INSTALLTYPE == "lmod") {
    PREPARE_KENTUTILS = "module load kentUtils/" + KENTUTILS_LMOD_VERSION
    RUN_BEDGRAPHTOBIGWIG = "bedGraphToBigWig"
    RUN_BEDTOBIGBED = "bedToBigBed"
} else if (KENTUTILS_INSTALLTYPE == "conda") {
    PREPARE_KENTUTILS = "source activate " + CONDA_ENVS + "/kentUtils/" + KENTUTILS_CONDA_VERSION
    RUN_BEDGRAPHTOBIGWIG = "bedGraphToBigWig"
    RUN_BEDTOBIGBED = "bedToBigBed"
} else if (KENTUTILS_INSTALLTYPE == "singularity") {
    PREPARE_KENTUTILS = ":"
    RUN_BEDGRAPHTOBIGWIG = "singularity run --app bedGraphToBigWig " + SINGULARITY_IMAGES + "/kentUtils/" + KENTUTILS_SIMG_VERSION + "/kentUtils.simg"
    RUN_BEDTOBIGBED = "singularity run --app bedToBigBed " + SINGULARITY_IMAGES + "/kentUtils/" + KENTUTILS_SIMG_VERSION + "/kentUtils.simg"
} else {
    PREPARE_KENTUTILS = ":"
    RUN_BEDGRAPHTOBIGWIG = "bedGraphToBigWig"
    RUN_BEDTOBIGBED = "bedToBigBed"
}

///////////////////////////////////////////////////////////////
// MACS2
///////////////////////////////////////////////////////////////
if (MACS2_INSTALLTYPE == "lmod") {
    PREPARE_MACS2 = "module load macs2/" + MACS2_LMOD_VERSION
    RUN_MACS2 = "macs2"
} else if (MACS2_INSTALLTYPE == "conda") {
    PREPARE_MACS2 = "source activate " + CONDA_ENVS + "/macs2/" + MACS2_CONDA_VERSION
    RUN_MACS2 = "macs2"
} else if (MACS2_INSTALLTYPE == "singularity") {
    PREPARE_MACS2 = ":"
    RUN_MACS2 = "singularity run --app macs2 " + SINGULARITY_IMAGES + "/macs2/" + MACS2_SIMG_VERSION + "/macs.simg"
} else {
    PREPARE_MACS2 = ":"
    RUN_MACS2 = "macs2"
}

///////////////////////////////////////////////////////////////
// MIRDEEP2
///////////////////////////////////////////////////////////////
if (MIRDEEP2_INSTALLTYPE == "lmod") {
    PREPARE_MIRDEEP2 = "module load mirdeep2/" + MIRDEEP2_LMOD_VERSION
    RUN_MIRDEEP2 = "miRDeep2.pl"
    RUN_MIRDEEP2MAPPER = "mapper.pl"
} else if (MIRDEEP2_INSTALLTYPE == "conda") {
    PREPARE_MIRDEEP2 = "source activate " + CONDA_ENVS + "/mirdeep2/" + MIRDEEP2_CONDA_VERSION
    RUN_MIRDEEP2 = "miRDeep2.pl"
    RUN_MIRDEEP2MAPPER = "mapper.pl"
} else if (MIRDEEP2_INSTALLTYPE == "singularity") {
    PREPARE_MIRDEEP2 = ":"
    RUN_MIRDEEP2 = "singularity run --app miRDeep2.pl " + SINGULARITY_IMAGES + "/mirdeep2/" + MIRDEEP2_SIMG_VERSION + "/mirdeep2.simg"
    RUN_MIRDEEP2MAPPER = "singularity run --app mapper.pl " + SINGULARITY_IMAGES + "/mirdeep2/" + MIRDEEP2_SIMG_VERSION + "/mirdeep2.simg"
} else {
    PREPARE_MIRDEEP2 = ":"
    RUN_MIRDEEP2 = "miRDeep2.pl"
    RUN_MIRDEEP2MAPPER = "mapper.pl"
}

///////////////////////////////////////////////////////////////
// PICARD
///////////////////////////////////////////////////////////////
if (PICARD_INSTALLTYPE == "lmod") {
    PREPARE_PICARD = "module load picard/" + PICARD_LMOD_VERSION
    RUN_PICARD = "picard"
} else if (PICARD_INSTALLTYPE == "conda") {
    PREPARE_PICARD = "source activate " + CONDA_ENVS + "/picard/" + PICARD_CONDA_VERSION
    RUN_PICARD = "picard"
} else if (PICARD_INSTALLTYPE == "singularity") {
    PREPARE_PICARD = ":"
    RUN_PICARD = "singularity run --app picard " + SINGULARITY_IMAGES + "/picard/" + PICARD_SIMG_VERSION + "/picard.simg"
} else {
    PREPARE_PICARD = ":"
    RUN_PICARD = "picard"
}

///////////////////////////////////////////////////////////////
// PINGPONGPRO
///////////////////////////////////////////////////////////////
if (PINGPONGPRO_INSTALLTYPE == "lmod") {
    PREPARE_PINGPONGPRO = "module load pingpongpro/" + PINGPONGPRO_LMOD_VERSION
    RUN_PINGPONGPRO = "pingpongpro"
} else if (PINGPONGPRO_INSTALLTYPE == "conda") {
    PREPARE_PINGPONGPRO = "source activate " + CONDA_ENVS + "/pingpongpro/" + PINGPONGPRO_CONDA_VERSION
    RUN_PINGPONGPRO = "pingpongpro"
} else if (PINGPONGPRO_INSTALLTYPE == "singularity") {
    PREPARE_PINGPONGPRO = ":"
    RUN_PINGPONGPRO = "singularity run --app pingpongpro " + SINGULARITY_IMAGES + "/pingpongpro/" + PINGPONGPRO_SIMG_VERSION + "/pingpongpro.simg"
} else {
    PREPARE_PINGPONGPRO = ":"
    RUN_PINGPONGPRO = "pingpongpro"
}

///////////////////////////////////////////////////////////////
// QUALIMAP
///////////////////////////////////////////////////////////////
if (QUALIMAP_INSTALLTYPE == "lmod") {
    PREPARE_QUALIMAP = "module load qualimap/" + QUALIMAP_LMOD_VERSION
    RUN_QUALIMAP = "qualimap"
} else if (QUALIMAP_INSTALLTYPE == "conda") {
    PREPARE_QUALIMAP = "source activate " + CONDA_ENVS + "/qualimap/" + QUALIMAP_CONDA_VERSION
    RUN_QUALIMAP = "qualimap"
} else if (QUALIMAP_INSTALLTYPE == "singularity") {
    PREPARE_QUALIMAP = ":"
    RUN_QUALIMAP = "singularity run --app qualimap " + SINGULARITY_IMAGES + "/qualimap/" + QUALIMAP_SIMG_VERSION + "/qualimap.simg"
} else {
    PREPARE_QUALIMAP = ":"
    RUN_QUALIMAP = "qualimap"
}

///////////////////////////////////////////////////////////////
// REPENRICH
///////////////////////////////////////////////////////////////
if (REPENRICH_INSTALLTYPE == "lmod") {
    PREPARE_REPENRICH = "module load RepEnrich/" + REPENRICH_LMOD_VERSION
    RUN_REPENRICH = "RepEnrich.py"
} else if (REPENRICH_INSTALLTYPE == "conda") {
    PREPARE_REPENRICH = "source activate " + CONDA_ENVS + "/repenrich/" + REPENRICH_CONDA_VERSION
    RUN_REPENRICH = "RepEnrich.py"
} else if (REPENRICH_INSTALLTYPE == "singularity") {
    PREPARE_REPENRICH = ":"
    RUN_REPENRICH = "singularity run --app RepEnrich.py " + SINGULARITY_IMAGES + "/repenrich/" + REPENRICH_SIMG_VERSION + "/repenrich.simg"
} else {
    PREPARE_REPENRICH = ":"
    RUN_REPENRICH = "RepEnrich.py"
}

///////////////////////////////////////////////////////////////
// RMATS
///////////////////////////////////////////////////////////////
if (RMATS_INSTALLTYPE == "lmod") {
    PREPARE_RMATS = "module load rmats/" + RMATS_LMOD_VERSION
    RUN_RMATS = "rmats.py"
} else if (RMATS_INSTALLTYPE == "conda") {
    PREPARE_RMATS = "source activate " + CONDA_ENVS + "/rmats/" + RMATS_CONDA_VERSION
    RUN_RMATS = "rmats.py"
} else if (RMATS_INSTALLTYPE == "singularity") {
    PREPARE_RMATS = ":"
    RUN_RMATS = "singularity run --app rmats.py " + SINGULARITY_IMAGES + "/rmats/" + RMATS_SIMG_VERSION + "/rmats.simg"
} else {
    PREPARE_RMATS = ":"
    RUN_RMATS = "rmats.py"
}

///////////////////////////////////////////////////////////////
// RSEQC
///////////////////////////////////////////////////////////////
if (RSEQC_INSTALLTYPE == "lmod") {
    PREPARE_RSEQC = "module load RSeQC/" + RSEQC_LMOD_VERSION
    RUN_GENEBODYCOV = "geneBody_coverage.py"
    RUN_INFEREXPERIMENT = "infer_experiment.py"
} else if (RSEQC_INSTALLTYPE == "conda") {
    PREPARE_RSEQC = "source activate " + CONDA_ENVS + "/rseqc/" + RSEQC_CONDA_VERSION
    RUN_GENEBODYCOV = "geneBody_coverage.py"
    RUN_INFEREXPERIMENT = "infer_experiment.py"
} else if (RSEQC_INSTALLTYPE == "singularity") {
    PREPARE_RSEQC = ":"
    RUN_GENEBODYCOV = "singularity run --app geneBody_coverage.py " + SINGULARITY_IMAGES + "/rseqc/" + RSEQC_SIMG_VERSION + "/rseqc.simg"
    RUN_INFEREXPERIMENT = "singularity run --app infer_experiment.py " + SINGULARITY_IMAGES + "/rseqc/" + RSEQC_SIMG_VERSION + "/rseqc.simg"
} else {
    PREPARE_RSEQC = ":"
    RUN_GENEBODYCOV = "geneBody_coverage.py"
    RUN_INFEREXPERIMENT = "infer_experiment.py"
}

///////////////////////////////////////////////////////////////
// SAMTOOLS
///////////////////////////////////////////////////////////////
if (SAMTOOLS_INSTALLTYPE == "lmod") {
    PREPARE_SAMTOOLS = "module load samtools/" + SAMTOOLS_LMOD_VERSION
    RUN_SAMTOOLS = "samtools"
} else if (SAMTOOLS_INSTALLTYPE == "conda") {
    PREPARE_SAMTOOLS = "source activate " + CONDA_ENVS + "/samtools/" + SAMTOOLS_CONDA_VERSION
    RUN_SAMTOOLS = "samtools"
} else if (SAMTOOLS_INSTALLTYPE == "singularity") {
    PREPARE_SAMTOOLS = ":"
    RUN_SAMTOOLS = "singularity run --app samtools " + SINGULARITY_IMAGES + "/samtools/" + SAMTOOLS_SIMG_VERSION + "/samtools.simg"
} else {
    PREPARE_SAMTOOLS = ":"
    RUN_SAMTOOLS = "samtools"
}

///////////////////////////////////////////////////////////////
// SEQTK
///////////////////////////////////////////////////////////////
if (SEQTK_INSTALLTYPE == "lmod") {
    PREPARE_SEQTK = "module load seqtk/" + SEQTK_LMOD_VERSION
    RUN_SEQTK = "seqtk"
} else if (SEQTK_INSTALLTYPE == "conda")  {
    PREPARE_SEQTK = "source activate " + CONDA_ENVS + "/seqtk/" + SEQTK_CONDA_VERSION
    RUN_SEQTK = "seqtk"
} else if (SEQTK_INSTALLTYPE == "singularity")  {
    PREPARE_SEQTK = ":"
    RUN_SEQTK = "singularity run --app seqtk " + SINGULARITY_IMAGES + "/seqtk/" + SEQTK_SIMG_VERSION + "/seqtk.simg"
} else {
    PREPARE_SEQTK = ":"
    RUN_SEQTK = "seqtk"
}

///////////////////////////////////////////////////////////////
// STAR
///////////////////////////////////////////////////////////////
if (STAR_INSTALLTYPE == "lmod") {
    PREPARE_STAR = "module load star/" + STAR_LMOD_VERSION
    RUN_STAR = "STAR"
} else if (STAR_INSTALLTYPE == "conda")  {
    PREPARE_STAR = "source activate " + CONDA_ENVS + "/star/" + STAR_CONDA_VERSION
    RUN_STAR = "STAR"
} else if (STAR_INSTALLTYPE == "singularity")  {
    PREPARE_STAR = ":"
    RUN_STAR = "singularity run --app STAR " + SINGULARITY_IMAGES + "/star/" + STAR_SIMG_VERSION + "/STAR.simg"
} else {
    PREPARE_STAR = ":"
    RUN_STAR = "STAR"
}

///////////////////////////////////////////////////////////////
// STAR-FUSION
///////////////////////////////////////////////////////////////
if (STARFUSION_INSTALLTYPE == "lmod") {
    PREPARE_STARFUSION = "module load STAR-Fusion/" + STARFUSION_LMOD_VERSION
    RUN_STARFUSION = "STAR-Fusion"
} else if (STARFUSION_INSTALLTYPE == "conda")  {
    PREPARE_STARFUSION = "source activate " + CONDA_ENVS + "/star-fusion/" + STARFUSION_CONDA_VERSION
    RUN_STARFUSION = "STAR-Fusion"
} else if (STARFUSION_INSTALLTYPE == "singularity")  {
    PREPARE_STARFUSION = ":"
    RUN_STARFUSION = "singularity run --app STAR-Fusion " + SINGULARITY_IMAGES + "/star-fusion/" + STARFUSION_SIMG_VERSION + "/star-fusion.simg"
} else {
    PREPARE_STARFUSION = ":"
    RUN_STARFUSION = "STAR-Fusion"
}

///////////////////////////////////////////////////////////////
// STRINGTIE
///////////////////////////////////////////////////////////////
if (STRINGTIE_INSTALLTYPE == "lmod") {
    PREPARE_STRINGTIE = "module load stringtie/" + STRINGTIE_LMOD_VERSION
    RUN_STRINGTIE = "stringtie"
} else if (STRINGTIE_INSTALLTYPE == "conda") {
    PREPARE_STRINGTIE = "source activate " + CONDA_ENVS + "/stringtie/" + STRINGTIE_CONDA_VERSION
    RUN_STRINGTIE = "stringtie"
} else if (STRINGTIE_INSTALLTYPE == "singularity") {
    PREPARE_STRINGTIE = ":"
    RUN_STRINGTIE = "singularity run --app stringtie " + SINGULARITY_IMAGES + "/stringtie/" + STRINGTIE_SIMG_VERSION + "/stringtie.simg"
} else {
    PREPARE_STRINGTIE = ":"
    RUN_STRINGTIE = "stringtie"
}

///////////////////////////////////////////////////////////////
// SUBREAD
///////////////////////////////////////////////////////////////
if (SUBREAD_INSTALLTYPE == "lmod") {
    PREPARE_SUBREAD = "module load subread/" + SUBREAD_LMOD_VERSION
    RUN_FEATURECOUNTS = "featureCounts"
    RUN_REPAIR = "repair"
} else if (SUBREAD_INSTALLTYPE == "conda") {
    PREPARE_SUBREAD = "source activate " + CONDA_ENVS + "/subread/" + SUBREAD_CONDA_VERSION
    RUN_FEATURECOUNTS = "featureCounts"
    RUN_REPAIR = "repair"
} else if (SUBREAD_INSTALLTYPE == "singularity") {
    PREPARE_SUBREAD = ":"
    RUN_FEATURECOUNTS = "singularity run --app featureCounts " + SINGULARITY_IMAGES + "/subread/" + SUBREAD_SIMG_VERSION + "/subread.simg"
    RUN_REPAIR = "singularity run --app repair " + SINGULARITY_IMAGES + "/subread/" + SUBREAD_SIMG_VERSION + "/subread.simg"
} else {
    PREPARE_SUBREAD = ":"
    RUN_FEATURECOUNTS = "featureCounts"
    RUN_REPAIR = "repair"
}

///////////////////////////////////////////////////////////////
// UMITOOLS
///////////////////////////////////////////////////////////////
if (UMITOOLS_INSTALLTYPE == "lmod") {
    PREPARE_UMITOOLS = "module load umitools/" + UMITOOLS_LMOD_VERSION
    RUN_UMITOOLS = "umi_tools"
} else if (UMITOOLS_INSTALLTYPE == "conda")  {
    PREPARE_UMITOOLS = "source activate " + CONDA_ENVS + "/umitools/" + UMITOOLS_CONDA_VERSION
    RUN_UMITOOLS = "umi_tools"
} else if (UMITOOLS_INSTALLTYPE == "singularity")  {
    PREPARE_UMITOOLS = ":"
    RUN_UMITOOLS = "singularity run --app umi_tools " + SINGULARITY_IMAGES + "/umitools/" + UMITOOLS_SIMG_VERSION + "/umi_tools.simg"
} else {
    PREPARE_UMITOOLS = ":"
    RUN_UMITOOLS = "umi_tools"
}

///////////////////////////////////////////////////////////////
// PYBEDTOOLS (Python library, so no run command)
///////////////////////////////////////////////////////////////
if (PYBEDTOOLS_INSTALLTYPE == "lmod") {
    PREPARE_PYBEDTOOLS = "module load pybedtools/" + PYBEDTOOLS_LMOD_VERSION
    RUN_PYBEDTOOLS = ":"
} else if (PYBEDTOOLS_INSTALLTYPE == "conda")  {
    PREPARE_PYBEDTOOLS = "source activate " + CONDA_ENVS + "/pybedtools/" + PYBEDTOOLS_CONDA_VERSION
    RUN_PYBEDTOOLS = ":"
} else if (PYBEDTOOLS_INSTALLTYPE == "singularity")  {
    PREPARE_PYBEDTOOLS = ":"
    RUN_PYBEDTOOLS = "singularity run " + SINGULARITY_IMAGES + "/pybedtools/" + PYBEDTOOLS_SIMG_VERSION + "/pybedtools.simg"
} else {
    PREPARE_PYBEDTOOLS = ":"
    RUN_PYBEDTOOLS = ":"
}

