package Pokemones;

public abstract class Pokemon {
    private String url;
    private String nombre;

    public Pokemon(String url, String nombre) {
        this.url = url;
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }


}
