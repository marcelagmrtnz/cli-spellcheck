#!/bin/sh

cd src/

echo Removing old binaries...;
rm -f *.class;
echo Done;

echo Removing old jar file...;
rm -f ../Spellcheck.jar;
echo Done;

echo Compiling binaries...;
javac *.java
echo Done;

echo Creating jar file...;
jar cfe ../Spellcheck.jar Main *.class
echo Done;

cd ../
