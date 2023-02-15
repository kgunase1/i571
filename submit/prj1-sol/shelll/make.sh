#!/bin/bash

# Download and extract json-simple and commons-io
curl -O http://www.java2s.com/Code/JarDownload/json-simple/json-simple-1.1.1.jar.zip
unzip json-simple-1.1.1.jar.zip

# Compile the Java files using json-simple and commons-io
#javac -cp json-simple-1.1.1.jar Lexer.java
#javac -cp json-simple-1.1.1.jar Parser.java
javac -cp json-simple-1.1.1.jar ./*.java

# Create a jar file with compiled classes and dependencies
jar cvf  Lexer.jar *.class json-simple-1.1.1.jar 
#jar cvf  Parser.jar *.class json-simple-1.1.1.jar 
#jar cfm Parser.jar manifest.txt *.class json-simple-1.1.1.jar 


# Clean up temporary files
#rm -rf json-simple-1.1.1.jar.zip json-simple-1.1.1