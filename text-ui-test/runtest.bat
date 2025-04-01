@echo off
setlocal enableextensions
pushd %~dp0

cd ..
call gradlew clean shadowJar

cd build\libs
for /f "tokens=*" %%a in (
    'dir /b *.jar'
) do (
    set jarloc=%%a
)

rem -- Force Java to run with UTF-8 encoding
cd ..\..\text-ui-test
chcp 65001 > nul
java -Dfile.encoding=UTF-8 -jar ..\build\libs\%jarloc% < input.txt > ACTUAL.TXT

FC ACTUAL.TXT EXPECTED.TXT >NUL && ECHO Test passed! || Echo Test failed!




