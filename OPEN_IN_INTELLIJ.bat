@echo off
echo ========================================
echo Opening Project in IntelliJ IDEA
echo ========================================
echo.

REM Try to find and open IntelliJ IDEA
set "PROJECT_DIR=%~dp0"

echo Looking for IntelliJ IDEA...

REM Common IntelliJ installation paths
set "IDEA_PATHS=C:\Program Files\JetBrains\IntelliJ IDEA*\bin\idea64.exe"
set "IDEA_PATHS=%IDEA_PATHS%;C:\Program Files (x86)\JetBrains\IntelliJ IDEA*\bin\idea64.exe"
set "IDEA_PATHS=%IDEA_PATHS%;%LOCALAPPDATA%\JetBrains\Toolbox\apps\IDEA-U\*\bin\idea64.exe"

for %%p in (%IDEA_PATHS%) do (
    if exist "%%p" (
        echo Found IntelliJ IDEA at: %%p
        echo Opening project...
        start "" "%%p" "%PROJECT_DIR%"
        echo.
        echo ========================================
        echo IntelliJ IDEA should open shortly!
        echo ========================================
        echo.
        echo NEXT STEPS:
        echo 1. Wait for IntelliJ to load the project
        echo 2. Navigate to: src/main/java/com/campus/ecommerce/CampusEcommerceWebApplication.java
        echo 3. Right-click on the file
        echo 4. Select "Run 'CampusEcommerceWebApplication.main()'"
        echo 5. Wait for server to start (you'll see "Started CampusEcommerceWebApplication")
        echo 6. Open browser: http://localhost:8080/index.html
        echo.
        pause
        exit /b 0
    )
)

echo.
echo Could not find IntelliJ IDEA installation.
echo.
echo Please manually:
echo 1. Open IntelliJ IDEA
echo 2. Open this folder: %PROJECT_DIR%
echo 3. Run: src/main/java/com/campus/ecommerce/CampusEcommerceWebApplication.java
echo.
pause

