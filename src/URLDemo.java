// Ejemplo de URL.
import java.net.*;

class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL hp = new URL("http://dev.java/download");

        System.out.println("Protocolo: " + hp.getProtocol());
        System.out.println("Puerto: " + hp.getPort());
        System.out.println("Nodo: " + hp.getHost());
        System.out.println("Archivo: " + hp.getFile());
        System.out.println("Extensión: " + hp.toExternalForm());
    }
}
