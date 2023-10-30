// See https://aka.ms/new-console-template for more information
using System.IO.Ports;

string asterisk = new string('*',50);

Console.WriteLine(asterisk);
Console.WriteLine("*            App .Net Listener                   *");
Console.WriteLine(asterisk);

int baudrate = 9600; // Configura la velocidad de transmisión según tu caso

string[] portNames = SerialPort.GetPortNames();

int index = 0;
foreach (string portname in portNames)
{
    Console.WriteLine($"({index + 1}) {portname}");
    index++;
}


SerialPort selectedPort = new SerialPort();

bool isNumber = false;
string selectedPortName = string.Empty;
while (!isNumber)
{

    Console.Write("Seleccione puerto COM : ");
    string port = Console.ReadLine();

    int numberport;
    if (int.TryParse(port, out numberport) && numberport > 0 && numberport <= portNames.Length)
    {
        try
        {
            selectedPortName = portNames[numberport - 1];
            selectedPort = new SerialPort(selectedPortName, baudrate);
            selectedPort.Open();
            Console.WriteLine($"Puerto {selectedPortName} abierto con éxito.");
            isNumber = true;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }
    else
    {
        Console.WriteLine("Ingrese un valor correcto.");
    }
}

//selectedPort.WriteLine("Hola Com1");
// while (true)
// {
    selectedPort.DataReceived += (sender, e) =>
    {
        string mensaje = selectedPort.ReadExisting();
        Console.WriteLine($"Mensaje recibido en {selectedPortName} : {mensaje}");
    };
// }

Console.WriteLine("Presiona Enter para finalizar");
Console.ReadLine();

