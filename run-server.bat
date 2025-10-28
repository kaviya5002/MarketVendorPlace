@echo off
echo ========================================
echo Campus Ecommerce Web - Starting Server
echo ========================================
echo.

echo Checking if Maven is available...
mvn --version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Maven is not installed or not in PATH
    echo Please install Maven or run from your IDE
    pause
    exit /b 1
)

echo Maven found! Starting Spring Boot application...
echo.
echo The server will start on http://localhost:8080
echo Press Ctrl+C to stop the server
echo.

mvn spring-boot:run

pause

