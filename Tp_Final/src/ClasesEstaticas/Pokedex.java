package ClasesEstaticas;

import Almacenamiento.AlmacenamientoDeDatos;
import Pokemones.EspeciePokemon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;



public class Pokedex{
    private static AlmacenamientoDeDatos<EspeciePokemon> pokemones = new AlmacenamientoDeDatos();

    /**
     * Carga el mapa pokemones con todos los pokemones de la API pokeapi , su clave es el mismo nombre del pokemon.
     * @see <a href="https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0"> https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0
     * @see ConsumeApi#getInfo(String)
     */
    public static void cargar(){
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
                    EspeciePokemon pokemonAux = new EspeciePokemon(aux.getString("url"),aux.getString("name"));
                    pokemones.agregar(pokemonAux.getEspecie(),pokemonAux);
                }
            }catch(JSONException e){
            }
        }
    }

    /**
     * busca un pokemon por su nombre y te retorna su informacion
     * @param nombre pokemon a buscar
     * @return Si lo encuentra String con toda la informacion del pokemon, Si no lo encentra "Pokemon No Encontrado"
     * @see EspeciePokemon#toString
     * @throws NullPointerException
     */
    public static EspeciePokemon buscarPokemon(String nombre){
        EspeciePokemon aux = pokemones.buscar(nombre);
        if(aux.getNumPokedex()==0)
            aux.cargar();
        return pokemones.buscar(nombre);
    }

    public static boolean existePokemon(String nombre){
       return pokemones.contienteClave(nombre);
    }
}
