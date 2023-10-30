rem compilar
javac  -cp lib/jSerialComm-2.9.0.jar src/App.java

java -cp .;lib/jSerialComm-2.9.0.jar src.App

rem java  -cp src;lib/jSerialComm-2.9.0.jar App

rem crear jar

rem jar cfv App1.jar -C src App.class -C lib jSerialComm-2.9.0.jar
rem jar cfm App1.jar Manifest.txt -C src App.class -C lib jSerialComm-2.9.0.jar
rem cls

rem java -jar App1.jar
rem java -cp App1.jar App
rem java -cp lib/jSerialComm-2.9.0.jar:. src/App

pause