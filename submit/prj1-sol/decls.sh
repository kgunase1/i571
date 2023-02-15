#javac TokenEntity.java
#javac SyntaxError.java
#javac Parser.java


#javac -cp . Lexer.java

#!/bin/bash

# Set the classpath to include the required dependencies
#classpath="./*"

# Run the JAR file with the classpath and the main class name
#java Lexer
#java -jar lexer.jar

java -cp ".:json-simple-1.1.1.jar" Lexer