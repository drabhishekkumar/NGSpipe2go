#!/bin/bash

###############################################################################
## Script to install several conda tools.
## Assumes conda itself has already been installed,
## but it adds the necessary channels itself.
## Run as:
##   bash install_conda_tools.sh "/path/to/environments/base/folder" "/path/to/condarc/file"
##
## NOTE: Fragile; currently no error checking implemented.
###############################################################################

# Base location for conda tool environments
# Each tool will be put into a separate conda environment
CONDA_ENVS="$1"
CONDARC_PATH="$2"

# Add conda channels and set their order to check in bioconda first
# Needs full path to ".condarc" conda configuration file
# Comment these out if existing conda channels setup should not be modified
conda config --file CONDARC_PATH --add channels defaults &&
conda config --file CONDARC_PATH --add channels conda-forge &&
conda config --file CONDARC_PATH --add channels r &&
conda config --file CONDARC_PATH --add channels bioconda

R_CONDA_VERSION="3.5.1"
JAVA_CONDA_VERSION="8.0.192"
SAMTOOLS_CONDA_VERSION="1.9"
BEDTOOLS_CONDA_VERSION="2.27.1"
FASTQC_CONDA_VERSION="0.11.8"
CUTADAPT_CONDA_VERSION="1.18"
FASTX_CONDA_VERSION="0.0.14"
FASTQSCREEN_CONDA_VERSION="0.13.0"
BOWTIE_CONDA_VERSION="1.2.2"
BOWTIE2_CONDA_VERSION="2.3.4"
STAR_CONDA_VERSION="2.7.0d"
SUBREAD_CONDA_VERSION="1.6.3"
HTSEQ_CONDA_VERSION="0.11.2"
PICARD_CONDA_VERSION="2.18.26"
BAMUTIL_CONDA_VERSION="1.0.14"
RSEQC_CONDA_VERSION="3.0.0"
QUALIMAP_CONDA_VERSION="2.2.2b"
RMATS_CONDA_VERSION="4.0.2" 
DEEPTOOLS_CONDA_VERSION="3.2.0"
STARFUSION_CONDA_VERSION="1.5.0"
MACS2_CONDA_VERSION="2.1.2"
SEQTK_CONDA_VERSION="1.3"
MIRDEEP2_CONDA_VERSION="2.0.0.8"
REPENRICH_CONDA_VERSION="1.2"
EMBOSS_CONDA_VERSION="6.6.0"
UMITOOLS_CONDA_VERSION="0.5.5"


# Install conda tools, each in their own environment
# Can probably be automated with a for-loop,
# but conda packages are not always just lowercase versions of NGSpipe2go tool names
# (see e.g. fastx-toolkit & star-fusion)

conda create -y -p "$CONDA_ENVS/samtools/$SAMTOOLS_CONDA_VERSION" samtools=$SAMTOOLS_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/bedtools/$BEDTOOLS_CONDA_VERSION" bedtools=$BEDTOOLS_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/fastqc/$FASTQC_CONDA_VERSION" fastqc=$FASTQC_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/cutadapt/$CUTADAPT_CONDA_VERSION" cutadapt=$CUTADAPT_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/fastx_toolkit/$FASTX_CONDA_VERSION" fastx_toolkit=$FASTX_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/fastq_screen/$FASTQSCREEN_CONDA_VERSION" fastq-screen=$FASTQSCREEN_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/bowtie/$BOWTIE_CONDA_VERSION" bowtie=$BOWTIE_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/bowtie2/$BOWTIE2_CONDA_VERSION" bowtie2=$BOWTIE2_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/star/$STAR_CONDA_VERSION" star=$STAR_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/subread/$SUBREAD_CONDA_VERSION" subread=$SUBREAD_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/htseq/$HTSEQ_CONDA_VERSION" htseq=$HTSEQ_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/picard/$PICARD_CONDA_VERSION" picard=$PICARD_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/bamutil/$BAMUTIL_CONDA_VERSION" bamutil=$BAMUTIL_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/rseqc/$RSEQC_CONDA_VERSION" rseqc=$RSEQC_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/rmats/$RMATS_CONDA_VERSION" rmats=$RMATS_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/deeptools/$DEEPTOOLS_CONDA_VERSION" deeptools=$DEEPTOOLS_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/macs2/$MACS2_CONDA_VERSION" macs2=$MACS2_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/seqtk/$SEQTK_CONDA_VERSION" seqtk=$SEQTK_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/mirdeep2/$MIRDEEP2_CONDA_VERSION" mirdeep2=$MIRDEEP2_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/repenrich/$REPENRICH_CONDA_VERSION" repenrich=$REPENRICH_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/emboss/$EMBOSS_CONDA_VERSION" emboss=$EMBOSS_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/umitools/$UMITOOLS_CONDA_VERSION" umi_tools=$UMITOOLS_CONDA_VERSION
##conda create -y -p "$CONDA_ENVS/qualimap/$QUALIMAP_CONDA_VERSION" qualimap=$QUALIMAP_CONDA_VERSION
conda create -y -p "$CONDA_ENVS/star-fusion/$STARFUSION_CONDA_VERSION" star-fusion=$STARFUSION_CONDA_VERSION


