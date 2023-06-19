package Almacenamiento;

import Enums.IE;
import Enums.Naturaleza;
import Exepciones.*;
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

    public Equipo() {
        nombre="";
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

    public void agregarPokemon(Pokemon pokemon) throws EquipoLlenoExeption
    {
        if(pokemones.size() < 6)
        {
            pokemones.add(pokemon);
        }
        else {
            throw new EquipoLlenoExeption(nombre);
        }
    }
    public void quitarPokemon(int posicion) throws ValorNoValidoExeption
    {
        if(pokemones.size() > posicion)
            pokemones.remove(posicion);
        else
            throw new ValorNoValidoExeption("posicion invalida");
    }

    public Pokemon getPokemon(int posicion) throws ValorNoValidoExeption {
        if (pokemones.size() > posicion)
            return pokemones.get(posicion);
        else
            throw new ValorNoValidoExeption("posicion invalida");
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



