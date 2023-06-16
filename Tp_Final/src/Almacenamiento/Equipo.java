package Almacenamiento;

import Enums.IE;
import Enums.Naturaleza;
import Exepciones.HabilidadNoPermitidaExeption;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Exepciones.ValorNoValidoExeption;
import Interfaces.IToJson;
import Poderes.Movimiento;
import Pokemones.Pokemon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Equipo implements IToJson {
    private String nombre;
    private ArrayList<Pokemon> pokemones;
    private boolean estado;

    public Equipo(String nombre) {
        this.nombre = nombre;
        pokemones = new ArrayList<>();
        estado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void agregarPokemon(Pokemon pokemon)
    {
        if(pokemones.size() < 6)
        {
            pokemones.add(pokemon);
        }
        else {//lanzar excepcion de equipo lleno

        }
    }
    public void quitarPokemon(int posicion)
    {
        pokemones.remove(posicion);
    }

    public void modificarPokemon(int posicion,String nombre)
    {
        pokemones.get(posicion).setNombreParticular(nombre);
    }
    public void modificarPokemon(int posicion,int nivel)
    {
        pokemones.get(posicion).setNivel(nivel);
    }
    public void modificarPokemon(String habilidad,int posicion ) throws HabilidadNoPermitidaExeption
    {
        pokemones.get(posicion).setHabilidad(habilidad);
    }

    public void modificarIvs(int posicion, int ivs, IE estadistica)throws ValorNoValidoExeption
    {
        pokemones.get(posicion).setIvs(ivs,estadistica);
    }
    public void modificarEvs(int posicion, int evs,IE estadistica)throws ValorNoValidoExeption
    {
        pokemones.get(posicion).setEvs(evs,estadistica);
    }
    public void modificarPokemon(int posicion, Naturaleza naturaleza)
    {
        pokemones.get(posicion).setNaturaleza(naturaleza);
    }
    public void agregarMovimiento(int posicion, String movimiento)throws MovimientoNoPermitidoExeption, MaximaCantidadDeMovimientosSobrepasadaExeption
    {
        pokemones.get(posicion).setMovimientos(movimiento);
    }
    public void quitarMovimiento(int posicion,int posMovimiento) throws ValorNoValidoExeption {
        pokemones.get(posicion).eliminarMovimiento(posMovimiento);
    }

    @Override
    public JSONObject toJson()  {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonObject.put("nombre",nombre);
            jsonObject.put("estado",estado);
            for (int i = 0; i < pokemones.size();i++)
            {
                jsonArray.put(pokemones.get(i).toJson());
            }
            jsonObject.put("pokemones",jsonArray);
        }
        catch (JSONException e)
        {
        }
        return jsonObject;

    }

    @Override
    public void toObject(JSONObject jsonObject) {
        try {
            nombre = jsonObject.getString("nombre");
            estado = jsonObject.getBoolean("estado");
            JSONArray jsonArray = jsonObject.getJSONArray("pokemones");
            for (int i = 0;i < jsonArray.length();i++)
            {
                Pokemon aux = new Pokemon();
                aux.toObject(jsonArray.getJSONObject(i));
                pokemones.add(aux);
            }
        }catch (JSONException e){
        }
    }


}



