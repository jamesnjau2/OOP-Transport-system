@echo off
echo Compiling Java files...
javac -d bin src/transport/*.java

echo.
echo Running the program...
java -cp bin transport.Main

pause
