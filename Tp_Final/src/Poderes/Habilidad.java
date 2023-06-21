package Poderes;

import Interfaces.IToJson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Habilidad extends Poder {
    private boolean oculta;

    public Habilidad(String nombre, String url, boolean oculta) {
        super(nombre, url);
        this.oculta = oculta;
    }
    public Habilidad() {
        super();
        this.oculta = false;
    }

    @Override
    public String toString() {
        String rta = super.toString() + " ";
        if(oculta){
            rta = rta + " Es oculta";
        }
        return rta;
    }

    public boolean isOculta() {
        return oculta;
    }

    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }

    @Override
    public boolean equals(Object o) {
        boolean rta= false;
        if(o!=null && o instanceof Habilidad)
        {
            Habilidad aux = (Habilidad)o;
            rta=aux.getNombre().equals(getNombre());
        }
        return rta;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = super.toJson();
        try {
            jsonObject.put("oculta",oculta);
        }catch (JSONException e)
        {
        }
        return jsonObject;

    }

    @Override
    public void toObject(JSONObject jsonObject) {
        try {
            super.toObject(jsonObject);
            oculta = jsonObject.getBoolean("oculta");
        }catch (JSONException e)
        {
        }

    }
}
