package Exepciones;

public class HabilidadNoPermitidaExeption extends Exception{

    public HabilidadNoPermitidaExeption(String pokemon,String habilidad) {
        super("El pokemon" + pokemon + " no puede tener la habilidad" + habilidad);
    }
}
