// Ejemplo con InetAddress.
import java.net.*;

class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        // Obtiene y muestra la dirección IP local
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        // Obtiene y muestra la dirección IP de "google.com"
        address = InetAddress.getByName("google.com");
        System.out.println(address);

        // Obtiene y muestra todas las direcciones IP asociadas con "google.com"
        InetAddress[] sw = InetAddress.getAllByName("www.google.com");
        for (int i = 0; i < sw.length; i++) {
            System.out.println(sw[i]);
        }
    }
}
