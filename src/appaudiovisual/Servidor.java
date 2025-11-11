package appaudiovisual;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        cargarUsuarios();

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("✅ Servidor iniciado en el puerto 5000. Esperando clientes...");

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> manejarCliente(socket)).start();
            }

        } catch (IOException e) {
            System.out.println("❌ Error al iniciar el servidor: " + e.getMessage());
        }
    }

    private static void manejarCliente(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String mensaje = in.readLine();
            if (mensaje == null) return;

            String[] partes = mensaje.split(";");
            String comando = partes[0];

            switch (comando) {
                case "LOGIN":
                    String email = partes[1];
                    String contrasena = partes[2];
                    boolean valido = usuarios.stream().anyMatch(u ->
                            u.getEmail().equalsIgnoreCase(email) && u.getContrasena().equals(contrasena));

                    if (valido)
                        out.println("BIENVENIDO " + email);
                    else
                        out.println("ERROR: Usuario o contraseña incorrectos");
                    break;

                case "CREAR":
                    String nombre = partes[1];
                    String nuevoEmail = partes[2];
                    String nuevaContrasena = partes[3];

                    boolean existe = usuarios.stream().anyMatch(u ->
                            u.getEmail().equalsIgnoreCase(nuevoEmail));

                    if (existe) {
                        out.println("ERROR: Ya existe un usuario con ese correo");
                    } else {
                        usuarios.add(new Usuario(nombre, nuevoEmail, nuevaContrasena));
                        guardarUsuarios();
                        out.println("USUARIO CREADO EXITOSAMENTE");
                    }
                    break;

                default:
                    out.println("ERROR: Comando no reconocido");
            }

        } catch (IOException e) {
            System.out.println("⚠ Error manejando cliente: " + e.getMessage());
        }
    }

    private static void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
            usuarios = (ArrayList<Usuario>) ois.readObject();
            System.out.println("Usuarios cargados correctamente (" + usuarios.size() + ")");
        } catch (Exception e) {
            usuarios = new ArrayList<>();
        }
    }

    private static void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            oos.writeObject(usuarios);
            System.out.println("✅ Usuarios guardados en archivo.");
        } catch (IOException e) {
            System.out.println("❌ Error guardando usuarios: " + e.getMessage());
        }
    }
}
