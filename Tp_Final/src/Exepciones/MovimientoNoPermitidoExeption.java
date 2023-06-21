package Exepciones;

public class MovimientoNoPermitidoExeption extends Exception {
    public MovimientoNoPermitidoExeption(String pokemon,String movimiento) {
        super("El pokemon " + pokemon + " no puede tener el movimiento " + movimiento);
    }
}
