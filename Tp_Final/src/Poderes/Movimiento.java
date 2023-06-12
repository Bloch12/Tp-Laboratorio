package Poderes;

import ClasesEstaticas.ConsumeApi;
import Enums.Tipo;
import Enums.TipoDeDaño;
import Interfaces.ICargable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Movimiento extends Poder implements ICargable {
    private Tipo tipo;
    private TipoDeDaño tipoDeDaño;
    private String descripcion;
    private Integer pp;
    private Integer precision;


    public Movimiento(String nombre, String url, Tipo tipo, String descripcion, Integer pp) {
        super(nombre, url);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.pp = pp;
    }

    public Movimiento(String nombre, String url) {
        super(nombre, url);
        tipo= null;
        descripcion="";
        pp=0;
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
        return  "nomber" + getNombre() + "\n" +
                "tipo:" + tipo.getTipo() + "\n" +
                "tipoDeDaño: " + tipoDeDaño.getTipoDeDaño() + "\n" +
                "descripcion: " + descripcion + '\n' +
                "pp: " + pp + '\n' +
                "precision=" + precision + '\n';
    }
}
