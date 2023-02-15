#!/bin/bash

# Download and extract json-simple and commons-io
#curl -O http://www.java2s.com/Code/JarDownload/json-simple/json-simple-1.1.1.jar.zip
#unzip json-simple-1.1.1.jar.zip

# Compile the Java files using json-simple and commons-io
#javac -cp json-simple-1.1.1.jar Lexer.java
#javac -cp json-simple-1.1.1.jar Parser.java
#javac -cp json-simple-1.1.1.jar ./*.java

# Create a jar file with compiled classes and dependencies
#jar cvf  Lexer.jar *.class json-simple-1.1.1.jar 
#jar cvf  Parser.jar *.class json-simple-1.1.1.jar 
#jar cfm Parser.jar manifest.txt *.class json-simple-1.1.1.jar 


# Clean up temporary files
#rm -rf json-simple-1.1.1.jar.zip json-simple-1.1.1

#!/bin/bash

# Add the path to the json-simple JAR file to the classpath
#export CLASSPATH="./json-simple-1.1.1.jar"

# Find all .java files in the current directory and its subdirectories
#find . -name "*.java" > sources.txt

# Compile all the .java files along with the json-simple library
#javac @sources.txt

#jar cfm lexer.jar ./Manifest.txt *.class

# Clean up the sources.txt file
#rm sources.txt

# Compile all Java source files in the current directory and its subdirectories
javac -cp ".:json-simple-1.1.1.jar" $(find . -name "*.java")

# Run the main Java file, assuming it has a `Main` class in the default package
#java -cp ".:json-simple-1.1.1.jar" Lexer