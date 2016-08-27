---
# GENERATED - DO NOT EDIT
title: Building
category: Development
nav_order: 17
---
{% include get_url.liquid %}
## Getting the source
To use [Arden2ByteCode](https://github.com/PLRI/arden2bytecode), first download or clone the source.

- **Using [Eclipse](https://eclipse.org/)**:
  1. Copy the following URL into your clipboard (`ctrl + c`): https://github.com/PLRI/arden2bytecode.git  
  1. In Eclipse go to *File* &rArr; *Import&hellip;* &rArr; *Projects from Git* &rArr; *Clone URI*. The fields should automatically contain the URL you copied, so click *Next*.
  1. Select the master branch and click *Next* again.
  1. On this page enter a location for the repository and check *Clone submodules* if you also want to download the examples submodule. Then Click *Next*.
  1. Choose *Import existing Eclipse projects* and click *Next*.
  1. Select the *arden2bytecode* project and click *Finish*.
  1. The project should now be imported and opened on the left side of your Eclipse IDE window (Package Explorer).

- **Using the command line**  
You can clone the source and the submodule with the examples, with Git as follows:  
`git clone --recursive https://github.com/PLRI/arden2bytecode.git`

- **Downloading the files**  
Alternatively, you can download a zipball or tarball from the following URLs:  
Zipball: [https://github.com/PLRI/arden2bytecode/zipball/master](https://github.com/PLRI/arden2bytecode/zipball/master)  
Tarball: [https://github.com/PLRI/arden2bytecode/tarball/master](https://github.com/PLRI/arden2bytecode/tarball/master)  
Extract the files to a directory of your choice.  
You can also import these files in Eclipse via *File* &rArr; *Import&hellip;* &rArr; *Existing Projects into Workspace*.


## Building the source
Now that you got the source, you can build (compile) it. You first need to generate the parser using the SableCC parser generator. There are 2 different ways to build it:

- **Using [Eclipse](https://eclipse.org/) (recommended)**  
   1. Build the project by selecting it in the Package Explorer and then choosing *Project* &rArr; *Build project* from the Eclipse menu.
   1. On the first build you need to refresh the Project (`F5`), so Eclipse finds the downloaded dependencies. 
- **Using [Apache Ant](http://ant.apache.org/)**  
   Ant is a command-line utility mainly used to compile Java programs like Arden2ByteCode.  
   1. First of all, you need to have [ant](http://ant.apache.org/) installed and the binary being in the path of your environment.
   1. Further, you need a [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html) of at least version 7 to be able to compile the Java Sources.
   1. Using the command line, switch to the directory containing the source code (build.xml should be located in that directory).
   1. Type `ant`, to start the compile procedure. 
   1. The compiled Java program should now reside in subdirectory `bin/` of the source tree.  

Both will automatically call the "sableCC" target in the build.xml and generate the .java files for the parser in the packages `analysis`, `lexer`, `node`, `parser`. This can take some time, but will only happen if the .java files do not exist or are out-of-date.

When the input grammar is changed, you will need to regenerate the parser. Before regenerating the parser, you should call the "clean" target (*Project* &rArr; *Clean&hellip;* in the Eclipse menu or `ant clean` using the command line) to ensure there aren't any old files left behind.


## Creating distributable files

To create a JAR package file and helper scripts to launch it, call the `jar` target in the build.xml:

- **Using Eclipse**  
  1. Open the build.xml.
  1. Look for the Outline view on the right. If it is not there, open it with *Window* &rArr; *Show View* &rArr; *Outline*.
  1. Right-click on the `jar` target in the outline and select *Run As* &rArr; *Ant Build*.
- **Using the command line**  
  1. Switch to the directory containing the source code (build.xml should be located in that directory).
  1. Type `ant jar`.

The distributable files will be built in the in the `dist/` subdirectory.

To create distributable .tar.gz and .zip files which contain MLM examples, the JAR file and launch scripts, call the `dist` target. 


## Launching Arden2ByteCode
Having built the source or a JAR file you can now launch the Arden2ByteCode compiler.

- **Launching the class-files**  
  1. On the command line switch into the `bin/` subdirectory of the source tree.
  1. Enter `java -cp .:../lib/* arden.MainClass -r <Path to an MLM-File>` on the command prompt.  
   E.g. `java -cp .:../lib/* arden.MainClass -r ../test/arden/tests/implementation/x3.1.mlm`
- **Launching the JAR file**  
You can also launch the .jar binary package as explained in [Installation]({{ baseurl }}/docs/installation/).
  1. Switch to `dist/` subdirectory.
  1. Type `arden2bytecode -r <Path to an MLM-File>` (Windows) or `./arden2bytecode -r <Path to an MLM-File>` (Linux, MacOS) on the command line to run it.  

More information about using the compiler is given in the [command line options]({{ baseurl }}/docs/command-line-options/) wiki page.