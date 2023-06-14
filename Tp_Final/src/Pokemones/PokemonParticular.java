package Pokemones;

import Exepciones.HabilidadNoPermitidaExeption;
import Poderes.Habilidad;
import Poderes.Movimiento;

import java.util.ArrayList;

public class PokemonParticular extends Pokemon{
    private String nombreParticular;
    private Integer nivel;
    private Habilidad habilidad;
    private ArrayList<Movimiento> movimientos;
    private PokemonDatos datos;



    public PokemonParticular(String url, String nombre, String nombreParticular, Integer nivel, Habilidad habilidad,PokemonDatos datos) {
        super(url, nombre);
        this.nombreParticular = nombreParticular;
        this.nivel = nivel;
        this.habilidad = habilidad;
        movimientos = new ArrayList<>();
        this.datos=datos;
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

    public void setHabilidad(String habilidad) throws HabilidadNoPermitidaExeption{
        boolean flag = false;
        int i = 0;
        Habilidad aux;

        if(!flag)
            throw new HabilidadNoPermitidaExeption();
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {

        boolean
    }

    

}
