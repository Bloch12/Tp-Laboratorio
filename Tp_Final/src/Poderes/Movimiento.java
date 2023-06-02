package Poderes;

import Enums.Tipo;

public class Movimiento extends Poder{
    private Tipo tipo;
    private String descripcion;
    private Integer pp;

    public Movimiento(String nombre, String url, Tipo tipo, String descripcion, Integer pp) {
        super(nombre, url);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.pp = pp;
    }
}
