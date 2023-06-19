package Objetos;

import Almacenamiento.Equipo;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;

public class MaquinasTecnicas extends Objeto{
    private String movimiento;
    public MaquinasTecnicas(String nombre, int costo,String movimiento) {
        super(nombre, costo);
        this.movimiento = movimiento;
    }

    @Override
    public String toString() {
        return super.toString() + " " + movimiento;
    }

    @Override
    public String usar(Equipo equipo, int pokemon) {
        try {
            equipo.agregarMovimiento(pokemon,movimiento);
        }catch (MovimientoNoPermitidoExeption e){
            return e.getMessage();
        }catch (MaximaCantidadDeMovimientosSobrepasadaExeption e){
            return e.getMessage();
        }
        return "el pokemon a aprendido el movimiento correctamente";
    }
}
