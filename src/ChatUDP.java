import java.net.*;
import java.util.Scanner;

public class ChatUDP {
    public static final int PORT_A = 998; // Puerto del primer participante
    public static final int PORT_B = 999; // Puerto del segundo participante
    public static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        boolean isA = args.length == 1; // Si hay argumento, es A (por ejemplo, "servidor")

        int ownPort = isA ? PORT_A : PORT_B;
        int otherPort = isA ? PORT_B : PORT_A;

        DatagramSocket socket = new DatagramSocket(ownPort);
        InetAddress localhost = InetAddress.getLocalHost();

        // Inicia el hilo receptor
        Thread receiver = new ReceiverThread(socket);
        receiver.start();

        // Enviar mensajes desde la consola
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("salir")) {
                socket.close();
                break;
            }
            byte[] data = line.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, localhost, otherPort);
            socket.send(packet);
        }
    }
}
