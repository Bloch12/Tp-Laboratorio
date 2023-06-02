package Pokemones;

import Poderes.Habilidad;
import Poderes.Movimiento;

import java.util.ArrayList;

public class PokemonParticular extends Pokemon{
    private String nombreParticular;
    private Integer nivel;
    private Habilidad habilidad;
    private ArrayList<Movimiento> movimientos;

    public PokemonParticular(String url, String nombre, String nombreParticular, Integer nivel, Habilidad habilidad) {
        super(url, nombre);
        this.nombreParticular = nombreParticular;
        this.nivel = nivel;
        this.habilidad = habilidad;
        movimientos = new ArrayList<>();
    }

    public String getNombreParticular() {
        return nombreParticular;
    }

    public void setNombreParticular(String nombreParticular) {
        this.nombreParticular = nombreParticular;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
