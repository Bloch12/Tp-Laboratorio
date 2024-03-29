package Poderes;

import ClasesEstaticas.ConsumeApi;
import Enums.Tipo;
import Enums.TipoDeDaño;
import Interfaces.ICargable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Movimiento extends Poder implements ICargable {
    private Tipo tipo;
    private TipoDeDaño tipoDeDaño;
    private String descripcion;
    private Integer pp;
    private Integer precision;


    public Movimiento(String nombre, String url, Tipo tipo, String descripcion, Integer pp,Integer precision) {
        super(nombre, url);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.pp = pp;
        this.precision = precision;
    }
    public Movimiento() {
        super();
        this.tipo = null;
        this.descripcion = "";
        this.pp = 0;
        this.precision = 0;
    }

    public Movimiento(String nombre, String url) {
        super(nombre, url);
        tipo= null;
        descripcion="";
        pp=0;
        precision = 0;
    }

    @Override
    public void cargar() {
        try {
            JSONObject jsonObject= new JSONObject(ConsumeApi.getInfo(getUrl()));
            JSONObject aux = jsonObject.getJSONObject("damage_class");
            JSONArray jsonArray = jsonObject.getJSONArray("flavor_text_entries");
            tipoDeDaño = TipoDeDaño.valueOf(aux.getString("name"));
            for(int i=0; i <jsonArray.length() && descripcion.equals("");i++){
                aux = jsonArray.getJSONObject(i);
                if(aux.getJSONObject("language").getString("name").equals("es")){
                    descripcion = aux.getString("flavor_text");
                }
            }
            if(jsonObject.get("accuracy").equals(null)){
                precision = -1;
            }else{
                precision = jsonObject.getInt("accuracy");
            }
            pp = jsonObject.getInt("pp");
            aux = jsonObject.getJSONObject("type");
            tipo = Tipo.valueOf(aux.getString("name"));
        }

        catch (JSONException e){
            System.out.println(e.toString());
        }

    }

    @Override
    public String toString() {
        return  getNombre() + " | " + pp + "\n " + tipo.getTipo() + " | " + tipoDeDaño.getTipoDeDaño() + "\n " + descripcion;

    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = super.toJson();
        try {
            jsonObject.put("tipo",tipo.name());
            jsonObject.put("tipoDeDaño",tipoDeDaño.name());
            jsonObject.put("descripcion",descripcion);
            jsonObject.put("pp",pp);
            jsonObject.put("precision",precision);
        }
        catch (JSONException e)
        {
        }
        return jsonObject;
    }

    @Override
    public void toObject(JSONObject jsonObject) {
        super.toObject(jsonObject);
        try {
            tipo = Tipo.valueOf(jsonObject.getString("tipo"));
            tipoDeDaño = TipoDeDaño.valueOf(jsonObject.getString("tipoDeDaño"));
            descripcion = jsonObject.getString("descripcion");
            pp = jsonObject.getInt("pp");
            precision = jsonObject.getInt("precision");
        } catch (JSONException e) {
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Movimiento){
            Movimiento aux = (Movimiento) o;
            return getNombre().equals(aux.getNombre());
        }else{
            return false;
        }

    }

    @Override
    public int hashCode() {
        return 1;
    }

}


