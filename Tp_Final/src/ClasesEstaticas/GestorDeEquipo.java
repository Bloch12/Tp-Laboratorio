package ClasesEstaticas;

import Almacenamiento.Equipo;
import Exepciones.ValorNoValidoExeption;
import Interfaces.IToJson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class GestorDeEquipo implements IToJson {

    private static LinkedHashSet<Equipo> listaDeEquipos= new LinkedHashSet<>();

    public static void crearEquipo(String nombreEquipo) throws ValorNoValidoExeption
    {
        Equipo aux= new Equipo(nombreEquipo);
        if(!listaDeEquipos.add(aux))
            throw new ValorNoValidoExeption("El equipo " + nombreEquipo + " ya existe");
    }

    public static void cambiarEstadoEquipo(Equipo equipo)
    {
        if(!equipo.isEstado())
            equipo.setEstado(true);
        else
            equipo.setEstado(false);
    }


    public static void modificarEquipo(String nombre, Equipo equipo) throws ValorNoValidoExeption
    {
        Iterator it=listaDeEquipos.iterator();
        while (it.hasNext()) {
            Equipo aux= (Equipo) it;
            if (aux.getNombre().equalsIgnoreCase(nombre))
                throw new ValorNoValidoExeption("Ya existe un equipo con este nombre");
        }
        equipo.setNombre(nombre);
    }

    public static Equipo getEquipo(int pos) throws ValorNoValidoExeption{
       if(listaDeEquipos.size()>pos){
            Equipo[] a = new Equipo[listaDeEquipos.size()];
            a =listaDeEquipos.toArray(a);
            return a[pos];
        }
        else
            throw new ValorNoValidoExeption("Posicion no valida");
    }
    public static Equipo getEquipo(String nombre) throws ValorNoValidoExeption{

            Equipo[] a = new Equipo[listaDeEquipos.size()];
            a = listaDeEquipos.toArray(a);
            for(int i =0; i<listaDeEquipos.size();i++){
                if(a[i].getNombre().equalsIgnoreCase(nombre)){
                    return a[i];
                }
            }
            throw new ValorNoValidoExeption("Nombre no Encontrado");

    }

    public static String listarEquipo(){
        return GestorDeColecciones.CollecionAString(listaDeEquipos);
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject= new JSONObject();
        JSONArray jsonArray= new JSONArray();
        try {
            Iterator it = listaDeEquipos.iterator();
            while (it.hasNext()) {
                Equipo aux = (Equipo) it;
                JSONObject jsonObject1=aux.toJson();
                jsonArray.put(jsonObject1);
                it.next();
            }
            jsonObject.put("equipos",jsonArray);
        }
        catch (JSONException e)
        {

        }
        return jsonObject;
    }

    @Override
    public void toObject(JSONObject jsonObject) {
        try {

            JSONArray jsonArray=jsonObject.getJSONArray("equipos");
            for (int i = 0; i < jsonArray.length() ; i++) {
                Equipo aux= new Equipo();
                aux.toObject(jsonArray.getJSONObject(i));
                listaDeEquipos.add(aux);
            }
        } catch (JSONException e) {

        }

    }

}
