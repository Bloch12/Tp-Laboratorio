package Poderes;

import ClasesEstaticas.ConsumeApi;
import Enums.Tipo;
import Interfaces.ICargable;
import org.json.JSONException;
import org.json.JSONObject;

public class Movimiento extends Poder implements ICargable {
    private Tipo tipo;
    private String descripcion;
    private Integer pp;

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

        }

        catch (JSONException e){

        }

    }
}
