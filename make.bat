@echo off

set DIR="%~dp1"
set FIlE="%~nx1"
set OUT="%~n1.exe"

echo compiling
call "C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\VC\Auxiliary\Build\vcvars64" > nul
cd %DIR%
cl %FILE%
echo finished with exit code %ERRORLEVEL%



echo running
%OUT%
echo finished with exit code %ERRORLEVEL%
