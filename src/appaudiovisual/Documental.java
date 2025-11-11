package appaudiovisual;

public class Documental extends Audiovisual implements Comparable<Documental> {
    private String tema;

    public Documental(String titulo, String genero, int duracion, String clasificacion, String tema) {
        super(titulo, genero, duracion, clasificacion);
        this.tema = tema;
    }

    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }

    @Override
    public int compareTo(Documental otro) {
        return this.getTitulo().compareTo(otro.getTitulo());
    }
}
