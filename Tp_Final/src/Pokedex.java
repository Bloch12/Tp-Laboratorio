import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class Pokedex {
    private static HashMap<String, PokemonDatos> pokemones = new HashMap<>();
    public static void cargarPokemones(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(ConsumeApi.getInfo("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0"));
        }catch (JSONException e){
            jsonObject = null;
        }
        if(jsonObject != null){
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                JSONObject aux;
                for (int i=0; i < jsonArray.length(); i++){
                    aux = jsonArray.getJSONObject(i);
                    PokemonDatos pokemonAux = new PokemonDatos(aux.getString("url"),aux.getString("name"));
                    pokemones.put(pokemonAux.getNombre(),pokemonAux);
                    pokemones.put(((Integer)(i+1)).toString(),pokemonAux);
                }
            }catch(JSONException e){
            }
        }
    }

    public static String buscarPokeom(String nombre){
            if(pokemones.isEmpty()){
                return "null";
            }else{
                return pokemones.get(nombre).toString();
            }
    }
}
