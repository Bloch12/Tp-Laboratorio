package Objetos;
import Almacenamiento.Equipo;

import java.io.Serializable;

public abstract class Objeto implements Serializable {
    private String nombre;
    private int costo;
    public Objeto(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return nombre + " " + costo + " ";
    }

    public abstract String usar(Equipo equipo, int pokemon);


}
