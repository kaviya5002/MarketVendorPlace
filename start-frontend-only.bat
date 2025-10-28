@echo off
echo ========================================
echo Campus Ecommerce - Frontend Preview
echo ========================================
echo.
echo Starting local web server for frontend preview...
echo This will show the website design only.
echo For full functionality, you need to run the Spring Boot backend.
echo.
echo Opening browser at: http://localhost:3000/index.html
echo Press Ctrl+C to stop the server
echo.

cd src\main\resources\static
start http://localhost:3000/index.html
python -m http.server 3000

pause

