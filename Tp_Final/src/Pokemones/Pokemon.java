package Pokemones;

public abstract class Pokemon {
    private String url;
    private String especie;

    public Pokemon(String url, String nombre) {
        this.url = url;
        this.especie = nombre;
    }

    public String getUrl() {
        return url;
    }

    public String getEspecie() {
        return especie;
    }


    @Override
    public String toString() {
        return "Nombre: " + especie;
    }


}
