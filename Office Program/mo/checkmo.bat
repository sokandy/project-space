@echo off
cd %1
ren *.txt *.
cd ..
java Checkmo %1
@echo on
