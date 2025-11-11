package appaudiovisual;

import java.util.ArrayList;

public abstract class Audiovisual {
    private String titulo;
    private String genero;
    private int duracion;
    private String clasificacion;
    protected static ArrayList<String> comentarios = new ArrayList<>();

    public Audiovisual(String titulo, String genero, int duracion, String clasificacion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracion() { return duracion; }
    public String getClasificacion() { return clasificacion; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    // Método estático para agregar comentarios
    public static void agregarComentario(String comentario) {
        comentarios.add(comentario);
    }

    // Mostrar comentarios
    public static void mostrarComentarios() {
        System.out.println("\n📢 Comentarios de usuarios:");
        for (String c : comentarios) {
            System.out.println("- " + c);
        }
    }
}
