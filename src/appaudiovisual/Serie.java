package appaudiovisual;

public class Serie extends Audiovisual implements Comparable<Serie> {
    private int temporadas;

    public Serie(String titulo, String genero, int duracion, String clasificacion, int temporadas) {
        super(titulo, genero, duracion, clasificacion);
        this.temporadas = temporadas;
    }

    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    @Override
    public int compareTo(Serie otra) {
        return this.getTitulo().compareTo(otra.getTitulo());
    }
}
