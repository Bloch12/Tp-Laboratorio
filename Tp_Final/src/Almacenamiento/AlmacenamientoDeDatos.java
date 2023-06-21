package Almacenamiento;

import java.util.LinkedHashMap;

public class AlmacenamientoDeDatos <T> {
    private LinkedHashMap<String,T> datos;

    public AlmacenamientoDeDatos() {
        this.datos = new LinkedHashMap<>();
    }

    public void agregar(String key, T dato){
        datos.put(key,dato);
    }

    public T buscar(String key){
        return datos.get(key);
    }

    public boolean contienteClave(String clave){
        return datos.containsKey(clave);
    }
}
