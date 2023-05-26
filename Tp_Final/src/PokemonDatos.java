import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonDatos extends Pokemon{
    private int numPokedex;
    private ArrayList<String> habilidades;
    private String sprite;
    private ArrayList<String> tipos;

    public PokemonDatos(String url, String nombre) {
        super(url, nombre);
        numPokedex = 0;
    }

    public void Cargar(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(ConsumeApi.getInfo(getUrl()));
        }catch(JSONException e){
            jsonObject = null;
        }

    }


}
