package ControladorVentanas;

import Almacenamiento.Equipo;
import Exepciones.EquipoLlenoExeption;
import Exepciones.MaximaCantidadDeMovimientosSobrepasadaExeption;
import Exepciones.MovimientoNoPermitidoExeption;
import Exepciones.ValorNoValidoExeption;
import Pokemones.EspeciePokemon;
import Pokemones.Pokemon;
import Ventana.VentanaCrearMovimiento;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVentanaCrearMovimiento implements ActionListener {

    private VentanaCrearMovimiento ventana;
    private static ControladorVentanaCrearMovimiento instance = null;
    private ControladorVentanaCrearMovimiento() {
        this.ventana = new VentanaCrearMovimiento();
        this.ventana.setActionListener(this);
    }

    public static ControladorVentanaCrearMovimiento getInstance() {
        if(instance == null) {
            instance = new ControladorVentanaCrearMovimiento();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String comando = e.getActionCommand();
        if(comando.equalsIgnoreCase("Buscar")) {
            ControladorVentanaPokemon aux= ControladorVentanaPokemon.getInstance();
            try {
                aux.getPokemon().setMovimientos(ventana.getTextField());
                aux.setDatos();
                aux.setVentana(true);
                setVentana(false);
            }catch (MovimientoNoPermitidoExeption ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }catch (MaximaCantidadDeMovimientosSobrepasadaExeption ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }

        }
        if(comando.equalsIgnoreCase("Volver")) {
            ControladorVentanaPokemon aux;
            aux = ControladorVentanaPokemon.getInstance();
            aux.setDatos();
            aux.setVentana(true);
        }
    }



    public void setVentana(boolean b) {
        ventana.setVisible(b);
    }
}
