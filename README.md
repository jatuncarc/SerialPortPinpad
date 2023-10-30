# Serial Port Comunications

Esta prueba de concepto pretende realizar una comunicación por puerto serial desde una aplicación de consola Java que actua con sender, hacia una aplicación de consola .Net que actua como listener.

## :bulb: Requisitos

1. Instalar el emulador de puerto serial que se encuentra en :link: [Emulador](https://github.com/jatuncarc/SerialPortPinpad/blob/master/EmulatorSerialPort/vspd.exe)
   
     >Dado que las computadoras actuales ya no traen el puerto serial. Este emulador crear puertos virtuales para la comunicacion serial con las mismas características que los puertos reales.

2. Crear un par de puertos serial
     ![alt](https://github.com/jatuncarc/SerialPortPinpad/blob/master/images/vspd1.png?raw=true)

     ![alt](https://github.com/jatuncarc/SerialPortPinpad/blob/master/images/vspd2.png?raw=true)

     ![alt](https://github.com/jatuncarc/SerialPortPinpad/blob/master/images/vspd3.png?raw=true)

3. Tener instalado el runtime para .net 6
4. Tener instalador el Java Runtime environment (jre) 

## :bulb: Pasos para ejecutar los programas

1. Descargar el repositorio a una ruta local
2. Desde una ventana de linea de comandos (cmd) y desde la ruta local **SerialPortPinpad\Java\App1** ejecutar el jar App1.jar

  ```
  java -jar App1.jar
  ```
![alt](https://github.com/jatuncarc/SerialPortPinpad/blob/master/images/executejar.png?raw=true)

3. Desde una ventana de linea de comandos (cmd) y desde la ruta local **SerialPortPinpad\Net\App2** ejecutar el comando:

  ```
  dotnet run
  ```
![alt](https://github.com/jatuncarc/SerialPortPinpad/blob/master/images/executenet.png?raw=true)

4. Desde la app Java , seleccionar el puerto por el que se enviará el mensaje y desde la app Net, seleccionar el puerto por el que se escuchará el mensaje.

![alt](https://github.com/jatuncarc/SerialPortPinpad/blob/master/images/done.png?raw=true)