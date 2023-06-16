package Almacenamiento;

import Exepciones.HabilidadNoPermitidaExeption;
import Pokemones.Pokemon;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Pokemon> pokemones;
    private boolean estado;

    public Equipo(String nombre) {
        this.nombre = nombre;
        pokemones = new ArrayList<>();
        estado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void agregarPokemon(Pokemon pokemon)
    {
        if(pokemones.size() < 6)
        {
            pokemones.add(pokemon);
        }
        else {//lanzar excepcion de equipo lleno

        }
    }
    public void quitarPokemon(int posicion)
    {
        pokemones.remove(posicion);
    }

    public void modificarPokemon(int posicion,String nombre)
    {
        pokemones.get(posicion).setNombreParticular(nombre);
    }
    public void modificarPokemon(int posicion,int nivel)
    {
        pokemones.get(posicion).setNivel(nivel);
    }
    public void modificarPokemon(String habilidad,int posicion ) throws HabilidadNoPermitidaExeption
    {
                pokemones.get(posicion).setHabilidad(habilidad);
    }



}



