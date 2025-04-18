// Ejemplo con Sockets
import java.net.*;
import java.io.*;

class Whois {
    public static void main(String[] args) throws Exception {
        int c;

        // Crea un socket y lo conecta a whois.markmonitor.com, puerto 43
        Socket s = new Socket("whois.markmonitor.com", 43);
        // Obtiene flujos de entrada y salida
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        // Construye una cadena para la solicitud
        String str = (args.length == 0 ? "google.com" : args[0]) + "\n";
        // Convierte la cadena a bytes
        byte[] buf = str.getBytes();
        // Envía la solicitud
        out.write(buf);
        // Lee y muestra la respuesta
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
        // Cierra el socket
        s.close();
    }
}
