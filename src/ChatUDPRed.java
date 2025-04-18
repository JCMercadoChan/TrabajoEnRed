import java.net.*;
import java.util.Scanner;

public class ChatUDPRed {
    public static final int PORT_A = 998;
    public static final int PORT_B = 999;
    public static final int BUFFER_SIZE = 1024;
    public static byte[] buffer = new byte[BUFFER_SIZE];

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Eres el participante A? (s/n): ");
        boolean isA = scanner.nextLine().trim().equalsIgnoreCase("s");

        System.out.print("Ingresa la IP del otro participante: ");
        String otherIP = scanner.nextLine().trim();

        int ownPort = isA ? PORT_A : PORT_B;
        int otherPort = isA ? PORT_B : PORT_A;

        DatagramSocket socket = new DatagramSocket(ownPort);
        InetAddress otherAddress = InetAddress.getByName(otherIP);

        // Hilo para recibir mensajes
        Thread receiveThread = new ReceiverThread(socket);
        receiveThread.start();

        System.out.println("Chat iniciado. Escribe tu mensaje (escribe 'salir' para terminar):");
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("salir")) {
                socket.close();
                break;
            }
            byte[] data = line.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, otherAddress, otherPort);
            socket.send(packet);
        }
    }
}
