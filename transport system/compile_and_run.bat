@echo off
cls
echo ========================================
echo Transport System - Compile and Run
echo ========================================
echo.

echo [1/3] Creating output directory...
if not exist "bin" mkdir bin

echo [2/3] Compiling Java files...
javac -d bin src/transport/IVehicle.java src/transport/Vehicle.java src/transport/Bus.java src/transport/Train.java src/transport/Taxi.java src/transport/TransportSystem.java src/transport/Main.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)

echo [3/3] Running the program...
echo.
echo ========================================
java -cp bin transport.Main
echo ========================================
echo.
echo Program execution completed.
pause
