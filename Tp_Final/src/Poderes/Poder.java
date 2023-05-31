package Poderes;

public abstract class Poder {
    private String nombre;
    private String url;

    public Poder(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
