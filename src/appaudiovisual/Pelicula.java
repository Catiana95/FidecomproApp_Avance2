package appaudiovisual;

public class Pelicula extends Audiovisual implements Comparable<Pelicula> {
    private String director;

    public Pelicula(String titulo, String genero, int duracion, String clasificacion, String director) {
        super(titulo, genero, duracion, clasificacion);
        this.director = director;
    }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    @Override
    public int compareTo(Pelicula otra) {
        return this.getTitulo().compareTo(otra.getTitulo());
    }
}
