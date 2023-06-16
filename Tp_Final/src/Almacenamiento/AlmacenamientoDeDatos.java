package Almacenamiento;

import ClasesEstaticas.ConsumeApi;
import Pokemones.EspeciePokemon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

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
