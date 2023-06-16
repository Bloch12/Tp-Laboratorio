package Poderes;

import Interfaces.IToJson;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Poder implements IToJson {
    private String nombre;
    private String url;

    public Poder(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }
    public Poder() {
        this.nombre = "";
        this.url = "";
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("url",url);
            jsonObject.put("nombre",nombre);
        }
        catch (JSONException e)
        {
        }
        return jsonObject;
    }

    @Override
    public void toObject(JSONObject jsonObject) {
        try {
            url = jsonObject.getString("url");
            nombre = jsonObject.getString("nombre");
        }catch (JSONException e)
        {
        }

    }
}
