package appaudiovisual;

import java.io.Serializable;

public class Usuario implements Comparable<Usuario>, Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String email;
    private String contrasena;

    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public static void iniciarSesion(Usuario u) {
        System.out.println("¡Bienvenido " + u.getNombre() + "!");
    }

    @Override
    public int compareTo(Usuario otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + email + ")";
    }
}
