//CONFIG_FOLDER="./NGSpipe2go/config/"

load CONFIG_FOLDER + "tool.locations.groovy"
load CONFIG_FOLDER + "tool.lmod_versions.groovy"
load CONFIG_FOLDER + "tool.conda_versions.groovy"
load CONFIG_FOLDER + "tool.simg_versions.groovy"
load CONFIG_FOLDER + "tool.installtypes.groovy"
load CONFIG_FOLDER + "tool.commands.groovy"


//////////////////////////////////////////////////////////////////////////////
////
//// Get tool versions and write to output file for reporting tools
////

def TOOLVERSIONSFILE=CONFIG_FOLDER + "tool.versions.groovy"
def INSTALLTYPESFILE=CONFIG_FOLDER + "tool.installtypes.groovy"

import java.io.File

// Read in install type per tool, to determine which version to use
def INSTALLTYPES = [:]
new File(INSTALLTYPESFILE).eachLine { line -> 
  if( line.trim() ) {
    String[] fields = line.split( '=' )
    if ( fields.length > 1 ) {
      INSTALLTYPES[ fields.getAt(0) ] = fields.getAt(1).replaceAll('"', '')
    }
  }
}

// Determine version per tool based on its install type
def TOOLVERSIONS = [:]
INSTALLTYPES.each { key, value ->
  versionstring = key.replace("_INSTALLTYPE", "_VERSION")
  switch (value ) {
    case "lmod":
      TOOLVERSIONS[versionstring] = getProperty( versionstring.replace("_VERSION", "_LMOD_VERSION") )
      break
    case "conda":
      TOOLVERSIONS[versionstring] = getProperty( versionstring.replace("_VERSION", "_CONDA_VERSION") )
      break
    case "singularity":
      TOOLVERSIONS[versionstring] = getProperty( versionstring.replace("_VERSION", "_SIMG_VERSION") )
      break
    default:
      TOOLVERSIONS[versionstring] = "N.A."
  }
}

// Write out tool versions for all tools
new File(TOOLVERSIONSFILE).delete()
def versionsfile = new File(TOOLVERSIONSFILE)
TOOLVERSIONS.each { key, value ->
  versionsfile.append("$key=\"$value\"\n")
}

////
//////////////////////////////////////////////////////////////////////////////

