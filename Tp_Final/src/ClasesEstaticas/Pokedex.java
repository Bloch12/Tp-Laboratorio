package ClasesEstaticas;

import Pokemones.PokemonDatos;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;



public class Pokedex {
    private static HashMap<String, PokemonDatos> pokemones = new HashMap<>();

    /**
     * Carga el mapa pokemones con todos los pokemones de la API pokeapi , su clave es el mismo nombre del pokemon.
     * @see <a href="https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0"> https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0
     * @see ConsumeApi#getInfo(String)
     */
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
                }
            }catch(JSONException e){
            }
        }
    }

    /**
     * busca un pokemon por su nombre y te retorna su informacion
     * @param nombre pokemon a buscar
     * @return Si lo encuentra String con toda la informacion del pokemon, Si no lo encentra "Pokemon No Encontrado"
     * @see PokemonDatos#toString
     * @throws NullPointerException
     */
    public static String buscarPokemon(String nombre){
        try {
            return pokemones.get(nombre).toString();
        }catch (NullPointerException e){
            return "Pokemon No Encontrado";
        }

    }
}
