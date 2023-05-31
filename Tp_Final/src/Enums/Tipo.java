package Enums;

public enum Tipo {
    normal("Normal","https://pokeapi.co/api/v2/type/1/"),fighting("Lucha","https://pokeapi.co/api/v2/type/2/"), flying("Volador","https://pokeapi.co/api/v2/type/3/"),poison("Veneno","https://pokeapi.co/api/v2/type/4/"),ground("Tierra","https://pokeapi.co/api/v2/type/5/"),rock("Roca","https://pokeapi.co/api/v2/type/6/"),bug("Bicho","https://pokeapi.co/api/v2/type/7/"),ghost("Fantasma","https://pokeapi.co/api/v2/type/8/"),steel("Acero","https://pokeapi.co/api/v2/type/9/"),fire("Fuego","https://pokeapi.co/api/v2/type/10/"),water("Agua","https://pokeapi.co/api/v2/type/11/"),grass("Planta","https://pokeapi.co/api/v2/type/12/"),electric("Electrico","https://pokeapi.co/api/v2/type/13/"),psychic("Psiquico","https://pokeapi.co/api/v2/type/14/"),ice("Hielo","https://pokeapi.co/api/v2/type/15/"),dragon("Dragon","https://pokeapi.co/api/v2/type/16/"),dark("Siniestro","https://pokeapi.co/api/v2/type/17/"),fairy("Hada","https://pokeapi.co/api/v2/type/18/"),unknown("Desconocido","https://pokeapi.co/api/v2/type/19/"),shadow("Sombrio","https://pokeapi.co/api/v2/type/20/");
    private String tipo;
    private String url;
    private Tipo(String tipo,String url) {
        this.tipo = tipo;
        this.url = url;
    }

    @Override
    public String toString() {
        return tipo;
    }

    public String getUrl() {
        return url;
    }


}
