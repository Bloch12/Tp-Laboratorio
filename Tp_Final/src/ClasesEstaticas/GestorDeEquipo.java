package ClasesEstaticas;

import Almacenamiento.Equipo;
import Exepciones.ValorNoValidoExeption;
import Interfaces.IToJson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class GestorDeEquipo{

    private static LinkedHashSet<Equipo> listaDeEquipos= new LinkedHashSet<>();

    /**
     * Crea un equipo, si este ya existe lanza una exeption
     * @param nombreEquipo
     * @throws ValorNoValidoExeption
     */

    public static void crearEquipo(String nombreEquipo) throws ValorNoValidoExeption
    {
        Equipo aux= new Equipo(nombreEquipo);
        if(!listaDeEquipos.add(aux))
            throw new ValorNoValidoExeption("El equipo " + nombreEquipo + " ya existe");
    }

    /**
     * Cambia el estado de un equipo
     * @param equipo
     */

    public static void cambiarEstadoEquipo(Equipo equipo)
    {
        if(!equipo.isEstado())
            equipo.setEstado(true);
        else
            equipo.setEstado(false);
    }

    /**
     * Modifica el nombre de un equipo, lanza una exeption si el nombre ya existe.
     * @param nombre
     * @param equipo
     * @throws ValorNoValidoExeption
     */
    public static void modificarEquipo(String nombre, Equipo equipo) throws ValorNoValidoExeption
    {
        Iterator it= listaDeEquipos.iterator();
        while (it.hasNext()) {
            Equipo aux = (Equipo) it.next();
            if (aux.getNombre().equalsIgnoreCase(nombre))
                throw new ValorNoValidoExeption("Ya existe un equipo con este nombre");
        }
        equipo.setNombre(nombre);
    }

    /**
     * Devuelve un equipo en la posicion pos
     * @param pos
     * @return
     * @throws ValorNoValidoExeption
     */

    public static Equipo getEquipo(int pos) throws ValorNoValidoExeption{
       if(listaDeEquipos.size()>pos){
            Equipo[] a = new Equipo[listaDeEquipos.size()];
            a =listaDeEquipos.toArray(a);
            return a[pos];
        }
        else
            throw new ValorNoValidoExeption("Posicion no valida");
    }

    /**
     * Devuelve un equipo con el nombre pasado
     * @param nombre
     * @return
     * @throws ValorNoValidoExeption
     */

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

    /**
     * Devuelve un Arraylist con el nombre de cada equipo en sus posciciones
     * @return Arraylist
     */

    public static ArrayList listarEquipo(){
        Iterator it = listaDeEquipos.iterator();
        ArrayList<String> aux = new ArrayList<>();
        while (it.hasNext()){
            Equipo eqAux = (Equipo) it.next();
            if(eqAux.isEstado())
                aux.add(eqAux.getNombre());
        }
        return aux;
    }

    /**
     * Sube todos los equipos a un archivo Json
     */

    public static void subir() {
        JSONObject jsonObject= new JSONObject();
        JSONArray jsonArray= new JSONArray();
        try {
            Iterator it = listaDeEquipos.iterator();
            while (it.hasNext()) {
                Equipo aux = (Equipo) it.next();
                JSONObject jsonObject1=aux.toJson();
                jsonArray.put(jsonObject1);
            }
            jsonObject.put("equipos",jsonArray);
        }
        catch (JSONException e)
        {
        }
        JsonUtiles.grabar(jsonObject,"equipos");

    }

    /**
     * Baja todos los equipos de un archivo Json
     */

    public static void bajar() {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(JsonUtiles.leer("equipos"));
            JSONArray jsonArray= jsonObject.getJSONArray("equipos");
            for (int i = 0; i < jsonArray.length() ; i++) {
                Equipo aux= new Equipo();
                aux.toObject(jsonArray.getJSONObject(i));
                listaDeEquipos.add(aux);
            }
        } catch (JSONException e) {

        }

    }

}
