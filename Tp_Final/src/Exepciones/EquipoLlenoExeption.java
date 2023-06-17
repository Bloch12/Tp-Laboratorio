package Exepciones;

public class EquipoLlenoExeption extends Exception{

    public EquipoLlenoExeption(String equipo) {
        super("Equipo; "+equipo+" esta lleno, debe quitar un pokemon para poder seguir agregando");
    }
}
