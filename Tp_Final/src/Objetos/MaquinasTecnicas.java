package Objetos;

import Almacenamiento.Equipo;
import ClasesEstaticas.GestorDeEquipo;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Exepciones.ValorNoValidoExeption;

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

    /**
     * Agrega un movimiento al pokemon indicado
     * @param equipo
     * @param pokemon
     * @return
     */
    @Override
    public String usar(Equipo equipo, int pokemon) {
        try {
            equipo.getPokemon(pokemon).setMovimientos(movimiento);
            GestorDeEquipo.subir();
        }catch (MovimientoNoPermitidoExeption e){
            return e.getMessage();
        }catch (MaximaCantidadDeMovimientosSobrepasadaExeption e){
            return e.getMessage();
        }catch (ValorNoValidoExeption e){
            return e.getMessage();
        }
        return "el pokemon a aprendido el movimiento correctamente";
    }
}
