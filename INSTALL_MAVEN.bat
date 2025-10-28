@echo off
echo ========================================
echo Installing Maven Wrapper
echo ========================================
echo.
echo This will download Maven wrapper for your project
echo so you can run the application without installing Maven globally.
echo.

cd /d "%~dp0"

echo Downloading Maven Wrapper...
powershell -Command "& {Invoke-WebRequest -Uri 'https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar' -OutFile 'maven-wrapper.jar'}"

if exist maven-wrapper.jar (
    echo.
    echo ✓ Maven wrapper downloaded successfully!
    echo.
    echo Creating wrapper files...
    
    mkdir .mvn\wrapper 2>nul
    move maven-wrapper.jar .mvn\wrapper\ >nul
    
    echo @echo off > mvnw.cmd
    echo set MAVEN_PROJECTBASEDIR=%%~dp0 >> mvnw.cmd
    echo java -jar "%%MAVEN_PROJECTBASEDIR%%.mvn\wrapper\maven-wrapper.jar" %%* >> mvnw.cmd
    
    echo.
    echo ✓ Maven wrapper installed!
    echo.
    echo You can now run: mvnw.cmd spring-boot:run
    echo.
) else (
    echo.
    echo ✗ Failed to download Maven wrapper.
    echo.
    echo Please use IntelliJ IDEA to run the application instead.
    echo See: START_BACKEND_GUIDE.md
    echo.
)

pause

