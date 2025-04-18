// Ejemplo de HttpURLConnection
import java.net.*;
import java.io.*;
import java.util.*;

class HttpURLDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        // Muestra el método solicitante
        System.out.println("El método solicitante es: " + hpCon.getRequestMethod());

        // Muestra el código de respuesta
        System.out.println("El código de respuesta es: " + hpCon.getResponseCode());

        // Muestra el mensaje de respuesta
        System.out.println("El mensaje de respuesta es: " + hpCon.getResponseMessage());

        // Obtiene encabezados
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();

        System.out.println("\nAquí está el encabezado:");
        for (String k : hdrField) {
            System.out.println("Clave: " + k + " Valor: " + hdrMap.get(k));
        }
    }
}
