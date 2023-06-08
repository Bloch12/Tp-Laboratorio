package Exepciones;

public class HabilidadNoPermitidaExeption extends Exception{

    public HabilidadNoPermitidaExeption() {
        super("El pokemon no puede tener esta habilidad");
    }
}
