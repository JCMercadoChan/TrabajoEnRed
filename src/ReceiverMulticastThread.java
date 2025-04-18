import java.net.*;

public class ReceiverMulticastThread implements Runnable {
    private DatagramSocket socket;
    private InetAddress multicastAddress;
    private int port;

    public ReceiverMulticastThread(DatagramSocket socket, InetAddress multicastAddress, int port) {
        this.socket = socket;
        this.multicastAddress = multicastAddress;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            // Crear un MulticastSocket para recibir mensajes
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(multicastAddress); // Unirse al grupo multicast

            while (true) {
                DatagramPacket packet = new DatagramPacket(ChatUDPMulticast.buffer, ChatUDPMulticast.buffer.length);
                multicastSocket.receive(packet); // Recibir el mensaje
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Recibido: " + msg); // Imprimir el mensaje recibido
            }
        } catch (Exception e) {
            System.out.println("Receptor finalizado.");
        }
    }
}
