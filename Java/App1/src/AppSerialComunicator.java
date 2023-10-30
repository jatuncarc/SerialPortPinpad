import java.io.IOException;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class AppSerialComunicator {
    public static void main(String[] args) throws IOException {

        // List ports available
        SerialPort[] serialPorts = SerialPort.getCommPorts();

        // Validate existing ports
        if (serialPorts.length == 0) {
            System.out.println("No ports available");
            System.exit(0);
        }

        String asterisk = "*";
        System.out.println(asterisk.repeat(50));
        System.out.println("*               App Java Sender           *");
        System.out.println(asterisk.repeat(50));

        int index = 0;
        for (SerialPort port : serialPorts) {
            System.out.println(String.format("(%s) %s", index + 1, port.getSystemPortName()));
            index++;
        }

        // Validate input port number selected
        Scanner scanner = new Scanner(System.in);

        int indexPort;
        while (true) {
            System.out.print("Digite el número de puerto COM a comunicar: ");

            if (scanner.hasNextInt()) {
                indexPort = scanner.nextInt();
                if (indexPort > 0) {
                    if (indexPort > serialPorts.length)
                        System.out.println("Número inválido. Ingrese nuevamente");
                    else
                        break;
                } else {
                    System.out.println("Número inválido. Ingrese nuevamente");
                }
            } else {
                System.out.println("Entrada no válida. Debes ingresar un número entero.");
                scanner.next();
            }
        }

        String selectPortName = serialPorts[indexPort - 1].getSystemPortName();
        SerialPort selectedPort = SerialPort.getCommPort(selectPortName);

        // Open selected port
        if (selectedPort.openPort()) {
            System.out.printf("Puerto %s abierto con éxito\n", selectPortName);

            selectedPort.setComPortParameters(9600, 8, 1, 0);

            scanner.nextLine();
            while (true) {
                System.out.print(String.format("Ingrese el mensaje a enviar desde puerto %s:", selectPortName));
                String message = scanner.nextLine();
                selectedPort.getOutputStream().write(message.getBytes());
            }

        } else {
            System.err.printf("Ocurrió un error al abrir el puerto %s", selectPortName);
            System.exit(0);
        }

        scanner.close();
    }
}
