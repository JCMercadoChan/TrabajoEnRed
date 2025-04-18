import java.net.*;
import java.util.Scanner;

public class ChatUDPMulticast {
    public static final int PORT = 8888; // Puerto para todos los participantes
    public static final int BUFFER_SIZE = 1024;
    public static byte[] buffer = new byte[BUFFER_SIZE];
    public static final String MULTICAST_IP = "230.0.0.1"; // Dirección IP multicast

    public static void main(String[] args) throws Exception {
        // Crear un DatagramSocket para la comunicación
        DatagramSocket socket = new DatagramSocket(PORT);
        InetAddress multicastAddress = InetAddress.getByName(MULTICAST_IP);

        // Hilo para recibir mensajes
        Thread receiveThread = new Thread(new ReceiverMulticastThread(socket, multicastAddress, PORT));
        receiveThread.start();

        // Enviar mensajes desde la consola
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("salir")) {
                socket.close();
                break;
            }

            byte[] data = line.getBytes(); // Convertir mensaje a bytes
            DatagramPacket packet = new DatagramPacket(data, data.length, multicastAddress, PORT);
            socket.send(packet); // Enviar el mensaje al grupo multicast
        }
    }
}
