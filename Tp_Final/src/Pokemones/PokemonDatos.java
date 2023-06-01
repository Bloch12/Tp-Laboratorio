package Pokemones;

import ClasesEstaticas.ConsumeApi;
import Enums.Color;
import Enums.Tipo;
import Enums.TipoHuevo;
import Poderes.Habilidad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonDatos extends Pokemon{
    private int numPokedex;
    private ArrayList<Habilidad> habilidades;
    private String sprite;
    private ArrayList<Tipo> tipos;
    private ArrayList<Integer> estadisticas;
    private Integer peso;
    private Integer felicidadBase;
    private Integer radioDeCaptura;
    private Color color;
    private ArrayList<TipoHuevo> gruposHuevo;
    private String descripcion;
    private String preevolucion;
    private String evolucion;
    private String metodoDeEvolucion;


    public PokemonDatos(String url, String nombre) {
        super(url, nombre);
        this.numPokedex = 0;
        this.habilidades = new ArrayList<>();
        this.sprite = "";
        this.tipos = new ArrayList<>();
        this.estadisticas = new ArrayList<>();
        this.peso = 0;
        this.felicidadBase = 0;
        this.radioDeCaptura = 0;
        this.color = null;
        this.gruposHuevo = new ArrayList<>();
        this.descripcion = "";
        this.preevolucion = "";
        this.evolucion = "";
        this.metodoDeEvolucion = "";
    }

    /**
     * Carga todos los datos de un pokemon sacados de la API pokeAPI
     * @see <a href="https://pokeapi.co/api/v2/pokemon/1/"> https://pokeapi.co/api/v2/pokemon/1/ El 1 se remplaza por el numero donde se encuentra el pokemon el el jsonArray
     * @see ConsumeApi#getInfo(String)
     * @see PokemonDatos#cargarEspecie(String)
     */
    public void cargarPokemon(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(ConsumeApi.getInfo(getUrl()));
        }catch(JSONException e){
            jsonObject = null;
        }
        if(jsonObject != null){
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("abilities");
                JSONObject aux;
                for (int i= 0; i<jsonArray.length();i++) {
                    aux = jsonArray.getJSONObject(i);
                    Habilidad hab = new Habilidad(aux.getJSONObject("ability").getString("name"), aux.getJSONObject("ability").getString("url"),aux.getBoolean("is_hidden"));
                    habilidades.add(hab);
                }
                aux =  jsonObject.getJSONObject("sprites");
                sprite = aux.getString("front_default");
                jsonArray = jsonObject.getJSONArray("types");
                for (int i= 0; i<jsonArray.length();i++){
                    aux = jsonArray.getJSONObject(i);
                    aux = aux.getJSONObject("type");
                    tipos.add(Tipo.valueOf(aux.getString("name")));
                }
                peso = jsonObject.getInt("weight");
                aux = jsonObject.getJSONObject("species");
                cargarEspecie(aux.getString("url"));
                jsonArray = jsonObject.getJSONArray("stats");
                for(int i = 0; i<jsonArray.length();i++){
                    aux = jsonArray.getJSONObject(i);
                    estadisticas.add(aux.getInt("base_stat"));
                }

            }catch (JSONException e){
                System.out.println(e.toString());
            }
        }
    }

    /**
     * Carga todos los datos de la especie de un pokemon sacados de la API pokeAPI
     * @param url la url donde se encuentran el json
     * @see <a href="https://pokeapi.co/api/v2/pokemon-species/1/"> https://pokeapi.co/api/v2/pokemon-species/1/ El 1 se remplaza por el numero donde se encuentra el pokemon el el jsonArray
     * @see ConsumeApi#getInfo(String)
     */
    private void cargarEspecie(String url){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(ConsumeApi.getInfo(url));
        }catch(JSONException e){
            jsonObject = null;
        }
        if(jsonObject != null){
            try {
                JSONObject aux;
                JSONArray jsonArray;
                felicidadBase = jsonObject.getInt("base_happiness");
                radioDeCaptura = jsonObject.getInt("capture_rate");
                aux = jsonObject.getJSONObject("color");
                color =Color.valueOf(aux.getString("name"));
                jsonArray = jsonObject.getJSONArray("egg_groups");
                for (int i = 0; i < jsonArray.length();i++)
                {
                    aux = jsonArray.getJSONObject(i);
                    gruposHuevo.add(TipoHuevo.valueOf(aux.getString("name").replaceAll("-","")));
                }
                jsonArray = jsonObject.getJSONArray("pokedex_numbers");
                aux = jsonArray.getJSONObject(0);
                numPokedex = aux.getInt("entry_number");
                jsonArray = jsonObject.getJSONArray("flavor_text_entries");
                for (int i = 0; i<jsonArray.length() && descripcion.equals("");i++){
                    aux = jsonArray.getJSONObject(i);
                    if(aux.getJSONObject("language").getString("name").equals("es")){
                        descripcion = aux.getString("flavor_text");
                    }
                }
                ///Hacer funcion que consuma evolution_chain y saque su evolucion, su preevolucion y su metodo de evolucio
            }catch (JSONException e){
                System.out.println(e.toString());
            }
        }
    }

    @Override
    public String toString() {
        if(numPokedex==0){
            cargarPokemon();
        }
        return
                "Numero en la Pokedex:" + numPokedex + "\n" +
                super.toString() + "\n" +
                "Habilidades:\n" + arregloAString(habilidades)  + "\n" +
                "Sprite:" + sprite +  "\n" +
                "Tipos:\n" + arregloAString(tipos) + "\n" +
                "Estadisticas:\n" + arregloAString(estadisticas) + "\n" +
                "Peso: " + peso + "\n" +
                "Felicidad Base:" + felicidadBase + "\n" +
                "Radio De Captura:" + radioDeCaptura + "\n" +
                "Color:" + color + "\n" +
                "Grupos Huevo:\n" + arregloAString(gruposHuevo) + "\n" +
                "descripcion:" + descripcion + "\n";
                        /*
                "preevolucion='" + preevolucion + '\'' +
                "evolucion='" + evolucion + '\'' +
                "metodoDeEvolucion='" + metodoDeEvolucion + '\'';
                         */
    }

    /**
     * se le pasa un arreglo y lo lista
     * @param a el arreglo a listar
     * @return el listado del arreglo
     */
    private String arregloAString(ArrayList a){
        String rta = "";
        for (int i = 0; i<a.size();i++) {
            rta += a.get(i).toString() + "\n";
        }
        return rta;
    }
}
