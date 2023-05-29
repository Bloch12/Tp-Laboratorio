package Pokemones;

import ClasesEstaticas.ConsumeApi;
import Poderes.Habilidad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonDatos extends Pokemon{
    private int numPokedex;
    private ArrayList<Habilidad> habilidades;
    private String sprite;
    private ArrayList<String> tipos;
    private ArrayList<Integer> estadisticas;
    private Integer peso;
    private Integer felicidadBase;
    private Integer radioDeCaptura;
    private String color;
    private ArrayList<String> gruposHuevo;
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
        this.color = "";
        this.gruposHuevo = new ArrayList<>();
        this.descripcion = "";
        this.preevolucion = "";
        this.evolucion = "";
        this.metodoDeEvolucion = "";
    }

    private void Cargar(){
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
                    Habilidad hab = new Habilidad(jsonObject.getString("name"),jsonObject.getString("url"),jsonObject.getBoolean("is_hidden"));
                    habilidades.add(hab);
                }
                aux =  jsonObject.getJSONObject("sprites");
                sprite = aux.getString("front_default");
                jsonArray = jsonObject.getJSONArray("types");
                for (int i= 0; i<jsonArray.length();i++){
                    aux = jsonArray.getJSONObject(i);
                    aux = aux.getJSONObject("type");
                    tipos.add(aux.getString("name"));
                }
                peso = jsonObject.getInt("weight");
                aux = jsonObject.getJSONObject("species");
                cargarEspecie(aux.getString("url"));
            }catch (JSONException e){
            }
        }
    }

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
                color = aux.getString("name");
                jsonArray = jsonObject.getJSONArray("egg_groups");
                for (int i = 0; i < jsonArray.length();i++)
                {
                    aux = jsonArray.getJSONObject(i);
                    gruposHuevo.add(aux.getString("name"));
                }
                ///Hacer funcion que busque la primera descripcion en español y la guarde en descripcion
                ///Hacer funcion que consuma evolution_chain y saque su evolucion, su preevolucion y su metodo de evolucion
                /// cargar numero de pokedex
            }catch (JSONException e){
            }
        }
    }

    @Override
    public String toString() {
        if(peso == 0){
            Cargar();
        }
        return super.toString() + "\n" +
        "Sprite: " + sprite + "\n" + "Peso: " + peso;
    }

}
