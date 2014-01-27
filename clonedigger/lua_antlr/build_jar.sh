export CLASSPATH=/home/peter/antlr/antlr-3.1.jar:/home/peter/antlr/antlr-3.0.1/lib/stringtemplate-3.1b1.jar:/home/peter/antlr/antlr-3.0.1/lib/antlr-2.7.7.jar:.
java org.antlr.Tool -debug Lua.g
javac *.java
jar -cf TreeProducer.jar *.class
rm *.class
