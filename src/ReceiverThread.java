import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiverThread extends Thread {
    private static final int BUFFER_SIZE = 1024;
    private final DatagramSocket socket;
    private final byte[] buffer = new byte[BUFFER_SIZE];

    public ReceiverThread(DatagramSocket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Recibido: " + msg);
            }
        } catch (Exception e) {
            System.out.println("Receptor finalizado.");
        }
    }
}
