package Pokemones;

import Almacenamiento.AlmacenamientoDeDatos;
import ClasesEstaticas.ConsumeApi;
import ClasesEstaticas.GestorDeColecciones;
import Enums.Color;
import Enums.Tipo;
import Enums.TipoHuevo;
import Exepciones.HabilidadNoPermitidaExeption;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Interfaces.ICargable;
import Interfaces.IToJson;
import Poderes.Habilidad;
import Poderes.Movimiento;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class EspeciePokemon implements ICargable {
    private String url;
    private String especie;
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

    private ArrayList<Evolucion> cadenaEvolutiva;
    private AlmacenamientoDeDatos<Movimiento> movimientos;



    public EspeciePokemon(String url, String especie) {
        this.url = url;
        this.especie = especie;
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
        this.cadenaEvolutiva = new ArrayList<>();
        this.movimientos= new AlmacenamientoDeDatos<>();
    }

    public String getUrl() {
        return url;
    }

    public String getEspecie() {
        return especie;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public String getSprite() {
        return sprite;
    }

    public Integer getPeso() {
        return peso;
    }

    public Integer getFelicidadBase() {
        return felicidadBase;
    }

    public Integer getRadioDeCaptura() {
        return radioDeCaptura;
    }

    public Color getColor() {
        return color;
    }

    public String getDescripcion() {
        return descripcion;
    }




    /**
     * Carga todos los datos de un pokemon sacados de la API pokeAPI
     * @see <a href="https://pokeapi.co/api/v2/pokemon/1/"> https://pokeapi.co/api/v2/pokemon/1/ El 1 se remplaza por el numero donde se encuentra el pokemon el el jsonArray
     * @see ConsumeApi#getInfo(String)
     * @see EspeciePokemon#cargar(String)
     */
    public void cargar(){
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
                jsonArray = jsonObject.getJSONArray("stats");
                for(int i = 0; i<jsonArray.length();i++){
                    aux = jsonArray.getJSONObject(i);
                    estadisticas.add(aux.getInt("base_stat"));
                }
                jsonArray= jsonObject.getJSONArray("moves");
                for (int i = 0; i <jsonArray.length() ; i++) {
                    aux = jsonArray.getJSONObject(i).getJSONObject("move");
                    movimientos.agregar(aux.getString("name"),new Movimiento(aux.getString("name"),aux.getString("url")));
                }
                aux = jsonObject.getJSONObject("species");
                cargar(aux.getString("url"));

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
    private void cargar(String url){
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
                aux = jsonObject.getJSONObject("evolution_chain");
                jsonObject = new JSONObject(ConsumeApi.getInfo(aux.getString("url")));
                aux = jsonObject.getJSONObject("chain");
                cargar(aux,0);
                ///Hacer funcion que consuma evolution_chain y saque su evolucion, su preevolucion y su metodo de evolucio
            }catch (JSONException e){
                System.out.println(e.toString());
            }
        }
    }

    private void cargar(JSONObject chain, int etapa){
        JSONObject jsonObject;
        JSONObject aux;
        JSONArray jsonArray;
        Evolucion evolucion = new Evolucion(etapa);
        try {
            aux = chain.getJSONObject("species");
            evolucion.setEspecie(aux.getString("name"));
            jsonArray = chain.getJSONArray("evolution_details");
            if(jsonArray.length() > 0){
                jsonObject = jsonArray.getJSONObject(0);
                aux = jsonObject.getJSONObject("trigger");
                evolucion.setTrigger(aux.getString("name"));
                if(!Objects.equals(jsonObject.get("min_happiness"),null)){
                    evolucion.setMinFel(jsonObject.getInt("min_happiness"));
                }
                if(!Objects.equals(jsonObject.get("held_item"),null)){
                    aux = jsonObject.getJSONObject("held_item");
                    evolucion.setObjeto(aux.getString("name"));
                }
                if(!Objects.equals(jsonObject.get("item"),null)){
                    aux = jsonObject.getJSONObject("item");
                    evolucion.setObjeto(aux.getString("name"));
                }
                if(!Objects.equals(jsonObject.get("min_level"),null)){
                    evolucion.setMinNivel(jsonObject.getInt("min_level"));
                }
                if(!Objects.equals(jsonObject.get("min_beauty"),null)){
                    evolucion.setBellezaMinima(jsonObject.getInt("min_beauty"));
                }
                evolucion.setHorario(jsonObject.getString("time_of_day"));
            }
            cadenaEvolutiva.add(evolucion);
            jsonArray = chain.getJSONArray("evolves_to");
            for(int i=0; i < jsonArray.length();i++){
                cargar(jsonArray.getJSONObject(i),(etapa + 1));
            }
        }catch (JSONException e){
            System.out.println(e.toString());
        }

    }

    @Override
    public String toString() {
        if(numPokedex==0){
            cargar();
        }
        return
                "Numero en la Pokedex:" + numPokedex + "\n" +
                "Especie: " + especie + "\n" +
                "Habilidades:\n" + GestorDeColecciones.CollecionAString(habilidades)  + "\n" +
                "Tipos:\n" + GestorDeColecciones.CollecionAString(tipos) + "\n" +
                "Estadisticas:\n" + GestorDeColecciones.CollecionAString(estadisticas) + "\n" +
                "Peso: " + peso + "\n" +
                "Felicidad Base:" + felicidadBase + "\n" +
                "Radio De Captura:" + radioDeCaptura + "\n" +
                "Color:" + color + "\n" +
                "Grupos Huevo:\n" + GestorDeColecciones.CollecionAString(gruposHuevo) + "\n" +
                "Descripcion:" + descripcion + "\n\n\n" +
                "Cadena:" + GestorDeColecciones.CollecionAString(cadenaEvolutiva);
    }

    public Habilidad buscarHabilidad(String habilidad) throws HabilidadNoPermitidaExeption{
        int i = 0;
        Habilidad aux;
        while(i < habilidades.size()){
            aux = habilidades.get(i);
            if(aux.getNombre().equals(habilidad)){
                return aux;
            }
            i++;
        }
        throw new HabilidadNoPermitidaExeption(especie,habilidad);
    }

    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }
    public Habilidad getHabilidad(int pos){return habilidades.get(pos);}

    public Movimiento buscarMovimiento(String movimiento) throws MovimientoNoPermitidoExeption{
        if(movimientos.contienteClave(movimiento)){
                return movimientos.buscar(movimiento);
        }else{
            throw new MovimientoNoPermitidoExeption(especie,movimiento);
        }
    }


}
