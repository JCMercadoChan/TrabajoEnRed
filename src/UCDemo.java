// Ejemplo de URLConnection
import java.net.*;
import java.io.*;
import java.util.Date;

class UCDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URL("http://www.google.com");
        URLConnection hpCon = hp.openConnection();

        // Obtiene fecha
        long d = hpCon.getDate();
        if (d == 0)
            System.out.println("No hay información de la fecha");
        else
            System.out.println("Fecha: " + new Date(d));

        // Tipo de contenido
        System.out.println("Tipo del contenido: " + hpCon.getContentType());

        // Fecha de expiración
        d = hpCon.getExpiration();
        if (d == 0)
            System.out.println("No hay información de expiración disponible");
        else
            System.out.println("Expira: " + new Date(d));

        // Última modificación
        d = hpCon.getLastModified();
        if (d == 0)
            System.out.println("No hay información de última modificación disponible");
        else
            System.out.println("Última modificación: " + new Date(d));

        // Tamaño del contenido
        int len = hpCon.getContentLength();
        if (len == -1)
            System.out.println("Longitud del contenido no disponible");
        else
            System.out.println("Longitud del contenido: " + len);

        // Mostrar contenido (si lo hay)
        if (len != 0) {
            System.out.println("= = = Contenido = = =");
            InputStream input = hpCon.getInputStream();
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("No hay contenido disponible");
        }
    }
}
