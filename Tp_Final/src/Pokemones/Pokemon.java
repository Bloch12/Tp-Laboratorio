package Pokemones;

import ClasesEstaticas.GestorDeColecciones;
import ClasesEstaticas.Pokedex;
import Enums.Naturaleza;
import Exepciones.HabilidadNoPermitidaExeption;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Exepciones.ValorNoValidoExeption;
import Interfaces.IToJson;
import Poderes.Habilidad;
import Poderes.Movimiento;
import Enums.IE;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Pokemon implements IToJson {
    private String nombreParticular;
    private Integer nivel;
    private Habilidad habilidad;
    private ArrayList<Movimiento> movimientos;
    private String especie;
    private ArrayList<Integer> ivs;
    private ArrayList<Integer> evs;
    private Naturaleza naturaleza;


    public Pokemon(String especie) {
        this.nombreParticular = especie;
        this.nivel = 100;
        this.especie = especie;
        this.habilidad = null;
        movimientos = new ArrayList<>();
        this.evs = new ArrayList<>();
        for(int i=0; i<6;i++){
            evs.add(0);
        }
        this.ivs = new ArrayList<>();
        for(int i=0; i<6;i++){
            ivs.add(31);
        }
        this.naturaleza = Naturaleza.Docil;
    }

    public Pokemon() {
        this.nombreParticular = "";
        this.nivel = 100;
        this.especie = null;
        this.habilidad = null;
        movimientos = new ArrayList<>();
        this.evs = new ArrayList<>();
        for(int i=0; i<6;i++){
            evs.add(0);
        }
        this.ivs = new ArrayList<>();
        for(int i=0; i<6;i++){
            ivs.add(31);
        }
        this.naturaleza = Naturaleza.Docil;
    }

    public String getNombreParticular() {
        return nombreParticular;
    }
    public String getEspecie(){return especie;}

    public String listarMovimientos(){return GestorDeColecciones.CollecionAString(movimientos);}

    public void setNombreParticular(String nombreParticular) {
        this.nombreParticular = nombreParticular;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) throws ValorNoValidoExeption {
        if(nivel > 0 && nivel <= 100){
            this.nivel = nivel;
        }else{
            throw new ValorNoValidoExeption("El nivel debe estar entre 1 & 100");
        }

    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) throws HabilidadNoPermitidaExeption{
       this.habilidad = getDatosEspecie().buscarHabilidad(habilidad);
    }

    private EspeciePokemon getDatosEspecie(){
        return Pokedex.buscarPokemon(especie);
    }

    public void setMovimientos(String movimiento) throws MaximaCantidadDeMovimientosSobrepasadaExeption,MovimientoNoPermitidoExeption {
          Movimiento aux = getDatosEspecie().buscarMovimiento(movimiento);
          if(movimientos.size() < 4){
              if(!movimientos.contains(aux)){
                  movimientos.add(aux);
              }else{
                throw new MovimientoNoPermitidoExeption(nombreParticular,movimiento + " porque ya lo conoce");
              }
          }else{
              throw new MaximaCantidadDeMovimientosSobrepasadaExeption();
          }
    }

    public void setIvs(ArrayList<Integer> ivs){
            this.ivs = ivs;
    }

    public void setEvs(ArrayList<Integer> evs) throws ValorNoValidoExeption {
        if(GestorDeColecciones.sumarDatosColeccion(evs) > 508){
            throw new ValorNoValidoExeption("la suma de todos los evs no pueden superar 508, Valor sin el cambio: " + GestorDeColecciones.sumarDatosColeccion(evs));
        }
        else{
            this.evs = evs;
        }
    }

    public Naturaleza getNaturaleza(){
        return naturaleza;
    }

    public ArrayList<Integer> getEvs(){
        return this.evs;
    }

    public ArrayList<Integer> getIvs(){
        return this.ivs;
    }




    public void setNaturaleza(Naturaleza naturaleza) {
        this.naturaleza = naturaleza;
    }

    public void eliminarMovimiento(int pos) throws ValorNoValidoExeption {
        if(pos < movimientos.size())
        {
            movimientos.remove(pos);
        }
        else {
            throw new ValorNoValidoExeption("El valor debe estar entre 0 y "+(movimientos.size()-1));
        }
    }

    public void evolucionar(){
        //a implementar
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombreParticular='" + nombreParticular + '\'' +
                ", nivel=" + nivel +
                ", habilidad=" + habilidad +
                ", movimientos=" + movimientos +
                ", especie='" + especie + '\'' +
                ", ivs=" + ivs +
                ", evs=" + evs +
                ", naturaleza=" + naturaleza +
                '}';
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonObject.put("nombrePokemon",nombreParticular);
            jsonObject.put("especie",especie);
            jsonObject.put("nivel",nivel);
            for (int i = 0; i < movimientos.size(); i++)
            {
                jsonArray.put(movimientos.get(i).toJson());
            }
            jsonObject.put("movimientos",jsonArray);
            for (int i = 0; i < ivs.size(); i++)
            {
                jsonArray.put(ivs.get(i));
            }
            jsonObject.put("ivs",jsonArray);
            for (int i = 0; i < evs.size(); i++)
            {
                jsonArray.put(evs.get(i));
            }
            jsonObject.put("evs",jsonArray);
            jsonObject.put("habilidad",habilidad.toJson());
            jsonObject.put("naturaleza",naturaleza.name());
        }
        catch (JSONException e)
        {
        }
        return jsonObject;
    }

    @Override
    public void toObject(JSONObject jsonObject) {
        JSONArray jsonArray = new JSONArray();
        try {
            nombreParticular = jsonObject.getString("nombrePokemon");
            especie = jsonObject.getString("especie");
            nivel = jsonObject.getInt("nivel");
            jsonArray = jsonObject.getJSONArray("movimientos");
            for (int i = 0; i < jsonArray.length(); i++)
            {
                Movimiento aux = new Movimiento();
                aux.toObject(jsonArray.getJSONObject(i));
                movimientos.add(aux);
            }
            jsonArray = jsonObject.getJSONArray("ivs");
            for (int i = 0; i < jsonArray.length(); i++)
            {
                ivs.add(jsonArray.getInt(i));
            }
            jsonArray = jsonObject.getJSONArray("evs");
            for (int i = 0; i < jsonArray.length(); i++)
            {
                evs.add(jsonArray.getInt(i));
            }
            Habilidad aux = new Habilidad();
            aux.toObject(jsonObject.getJSONObject("habilidad"));
            habilidad = aux;
            naturaleza = Naturaleza.valueOf(jsonObject.getString("naturaleza"));
        }
        catch (JSONException e)
        {
        }
    }
}
