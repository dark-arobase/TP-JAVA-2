# Script de compilation et création du JAR - TP-JAVA-2
# Usage: .\build.ps1

Write-Host "=== COMPILATION DU PROJET TP-JAVA-2 ===" -ForegroundColor Green

# Créer le dossier bin s'il n'existe pas
if (!(Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin"
    Write-Host "Dossier 'bin' créé." -ForegroundColor Yellow
}

# Nettoyer le dossier bin
Remove-Item -Path "bin\*" -Recurse -Force -ErrorAction SilentlyContinue
Write-Host "Dossier 'bin' nettoyé." -ForegroundColor Yellow

# Compiler tous les fichiers Java
Write-Host "Compilation des fichiers Java..." -ForegroundColor Yellow
$javaFiles = Get-ChildItem -Path "src" -Filter "*.java" -Recurse
$javaFilePaths = $javaFiles | ForEach-Object { $_.FullName }

try {
    javac -d bin $javaFilePaths
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Compilation réussie!" -ForegroundColor Green
    } else {
        Write-Host "Erreur de compilation!" -ForegroundColor Red
        exit 1
    }
} catch {
    Write-Host "Erreur lors de la compilation: $_" -ForegroundColor Red
    exit 1
}

# Créer le fichier JAR
Write-Host "Création du fichier JAR..." -ForegroundColor Yellow
try {
    jar cf TP-JAVA-2.jar -C bin .
    if ($LASTEXITCODE -eq 0) {
        Write-Host "JAR créé avec succès: TP-JAVA-2.jar" -ForegroundColor Green
    } else {
        Write-Host "Erreur lors de la création du JAR!" -ForegroundColor Red
        exit 1
    }
} catch {
    Write-Host "Erreur lors de la création du JAR: $_" -ForegroundColor Red
    exit 1
}

# Tester l'exécution
Write-Host "Test d'exécution..." -ForegroundColor Yellow
try {
    java -cp bin App
    Write-Host "Exécution réussie!" -ForegroundColor Green
} catch {
    Write-Host "Attention: erreur lors du test d'exécution" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "=== BUILD TERMINE ===" -ForegroundColor Green
Write-Host "Fichiers générés:" -ForegroundColor Cyan
Write-Host "  - bin/ (classes compilées)" -ForegroundColor White
Write-Host "  - TP-JAVA-2.jar (livrable)" -ForegroundColor White