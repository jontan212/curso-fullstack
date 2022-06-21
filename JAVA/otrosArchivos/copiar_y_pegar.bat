@echo off
REM apagar tomcat
cd C:\xampp\tomcat
call catalina_stop.bat

REM Copiar y pegar archivos
xcopy C:\xampp\htdocs\ejemplos.com\JAVA\Servlets\build\classes C:\xampp\tomcat\webapps\examples\WEB-INF\classes /S /C /K /Y
echo Copia completada!

REM Encender tomcat
call catalina_start.bat

REM @pause