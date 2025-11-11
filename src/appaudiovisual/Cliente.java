package appaudiovisual;

import java.io.*;
import java.net.*;

public class Cliente {

    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 5000;

    public static String crearUsuario(String nombre, String email, String contrasena) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("CREAR;" + nombre + ";" + email + ";" + contrasena);
            return in.readLine();

        } catch (IOException e) {
            return "ERROR: No se puede conectar con el servidor";
        }
    }

    public static String iniciarSesion(String email, String contrasena) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("LOGIN;" + email + ";" + contrasena);
            return in.readLine();

        } catch (IOException e) {
            return "ERROR: No se puede conectar con el servidor";
        }
    }
}
