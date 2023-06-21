package ControladorVentanas;

import ClasesEstaticas.GestorDeEquipo;
import ClasesEstaticas.JsonUtiles;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Poderes.Movimiento;
import Ventana.VentanaCrearMovimiento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Ventana.VentanaMovimiento;

public class ControladorVentanaMovimiento implements ActionListener {
    private VentanaMovimiento ventana;
    private static Movimiento movimiento;
    private static ControladorVentanaMovimiento instance = null;
    private ControladorVentanaMovimiento() {
        this.ventana = new VentanaMovimiento();
        this.ventana.setActionListener(this);
    }

    public static ControladorVentanaMovimiento getInstance(Movimiento movimientoAux) {
        if(instance == null) {
            instance = new ControladorVentanaMovimiento();
        }
        movimiento = movimientoAux;
        return instance;
    }

    /**
     * el boton eliminar elimina el movimiento y te debuelve a la ventana pokemon y volver te debuelve a la ventana pokemon
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String comando = e.getActionCommand();
        if(comando.equalsIgnoreCase("Eliminar")) {
            ControladorVentanaPokemon aux;
            aux = ControladorVentanaPokemon.getInstance();
            aux.eliminarMovimiento();
            aux.setDatos();
            aux.setVentana(true);
            setVentana(false);
            GestorDeEquipo.subir();
        }
        if(comando.equalsIgnoreCase("Volver")) {
            ControladorVentanaPokemon aux;
            aux = ControladorVentanaPokemon.getInstance();
            aux.setVentana(true);
            setVentana(false);
        }
    }



    public void setVentana(boolean b) {
        ventana.setVisible(b);
    }
    public void setDatos(){
        ventana.setTextPane(movimiento.toString());
    }
}
