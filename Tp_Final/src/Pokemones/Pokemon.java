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
    private EspeciePokemon datos;
    private ArrayList<Integer> ivs;
    private ArrayList<Integer> evs;
    private Naturaleza naturaleza;




    public Pokemon(EspeciePokemon datos) {
        this.nombreParticular = datos.getEspecie();
        this.nivel = 100;
        this.datos= datos;
        this.habilidad = datos.getHabilidades().get(0);
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
        this.datos= null;
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

    public void setNombreParticular(String nombreParticular) {
        this.nombreParticular = nombreParticular;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) throws HabilidadNoPermitidaExeption{
        boolean flag = false;
        int i = 0;
        Habilidad aux;
        while(i < datos.getHabilidades().size() && !flag){
            aux = datos.getHabilidades().get(i);
            if(aux.getNombre().equals(habilidad)){
                this.habilidad = aux;
                flag = true;
            }
        }
        if(!flag)
            throw new HabilidadNoPermitidaExeption(datos.getEspecie(),habilidad);
    }

    public void setMovimientos(String movimiento) throws MaximaCantidadDeMovimientosSobrepasadaExeption,MovimientoNoPermitidoExeption {
        if(datos.getMovimientos().containsKey(movimiento)){
            if(datos.getMovimientos().size() < 4){
                movimientos.add(datos.getMovimientos().get(movimiento));
            }else{
                throw new MaximaCantidadDeMovimientosSobrepasadaExeption();
            }
        }else{
            throw new MovimientoNoPermitidoExeption(datos.getEspecie(),movimiento);
        }
    }

    public void setIvs(int iv,IE estadistica) throws ValorNoValidoExeption {
        if(estadistica.getI() > 5 || estadistica.getI() < 0){
            throw new ValorNoValidoExeption("el valor de Estadistica tiene que estar entre 0 & 5");
        }else if(iv > 31 || iv < 0){
            throw new ValorNoValidoExeption("el valor del iv tiene que estar entre 0 & 31");
        }else{
            ivs.set(estadistica.getI(),iv);
        }
    }

    public void setEvs(int ev,IE estadistica) throws ValorNoValidoExeption {
        if(estadistica.getI() > 5 || estadistica.getI() < 0){
            throw new ValorNoValidoExeption("el valor de Estadistica tiene que estar entre 0 & 5");
        }else if(ev > 252 || ev < 0){
            throw new ValorNoValidoExeption("el valor del ev tiene que estar entre 0 & 252");
        }else if(GestorDeColecciones.sumarDatosColeccion(evs) <= 508){
            throw new ValorNoValidoExeption("la suma de todos los evs no pueden superar 508, Valor sin el cambio: " + GestorDeColecciones.sumarDatosColeccion(evs));
        }
        else{
            evs.set(estadistica.getI(),ev);
        }
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

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonObject.put("nombrePokemon",nombreParticular);
            jsonObject.put("especie",datos.getEspecie());
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
            //cargar los datos
            /*datos =
            jsonObject.put("especie",datos.getEspecie());*/
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
