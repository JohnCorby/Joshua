@echo off


echo compiling
call "C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\VC\Auxiliary\Build\vcvars64" > nul

set DIR="%~dp1"
set FIlE="%~nx1"

cd %DIR%
cl %FILE%



echo running
set OUT="%~n1.exe"
%OUT%
