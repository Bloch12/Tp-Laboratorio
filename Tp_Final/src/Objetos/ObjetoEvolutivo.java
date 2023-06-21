package Objetos;

import Almacenamiento.Equipo;

public class ObjetoEvolutivo extends Objeto{
    public ObjetoEvolutivo(String nombre, int costo) {
        super(nombre, costo);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String usar(Equipo equipo, int pokemon) {
        return "No se puede usar en este momento";
    }

}
