@echo off
echo ========================================
echo Campus Ecommerce - Starting Backend Server
echo ========================================
echo.
echo Checking Java installation...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    pause
    exit /b 1
)

echo.
echo Starting Spring Boot application...
echo This will start the backend server on http://localhost:8080
echo.
echo Please wait... (this may take 30-60 seconds)
echo.

cd /d "%~dp0"

REM Try using Maven wrapper
if exist mvnw.cmd (
    echo Using Maven wrapper...
    call mvnw.cmd spring-boot:run
) else (
    echo Maven wrapper not found. Please run from IntelliJ IDEA.
    echo.
    echo Instructions:
    echo 1. Open IntelliJ IDEA
    echo 2. Open: src/main/java/com/campus/ecommerce/CampusEcommerceWebApplication.java
    echo 3. Right-click and select "Run"
    echo.
    pause
)

