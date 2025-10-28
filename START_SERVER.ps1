# Campus Ecommerce - Start Backend Server
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Campus Ecommerce - Starting Backend Server" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Check Java
Write-Host "Checking Java installation..." -ForegroundColor Yellow
try {
    $javaVersion = java -version 2>&1
    Write-Host "Java found: $($javaVersion[0])" -ForegroundColor Green
} catch {
    Write-Host "ERROR: Java is not installed or not in PATH" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "Starting Spring Boot application..." -ForegroundColor Yellow
Write-Host "Backend will be available at: http://localhost:8080" -ForegroundColor Green
Write-Host "Press Ctrl+C to stop the server" -ForegroundColor Yellow
Write-Host ""

# Set location to script directory
Set-Location $PSScriptRoot

# Run Maven wrapper
if (Test-Path ".\mvnw.cmd") {
    Write-Host "Using Maven wrapper to start server..." -ForegroundColor Green
    & cmd /c "mvnw.cmd spring-boot:run"
} else {
    Write-Host "Maven wrapper not found!" -ForegroundColor Red
    Write-Host ""
    Write-Host "Please run from IntelliJ IDEA instead:" -ForegroundColor Yellow
    Write-Host "1. Open IntelliJ IDEA" -ForegroundColor White
    Write-Host "2. Open: src/main/java/com/campus/ecommerce/CampusEcommerceWebApplication.java" -ForegroundColor White
    Write-Host "3. Right-click and select 'Run'" -ForegroundColor White
    Write-Host ""
    Read-Host "Press Enter to exit"
}

