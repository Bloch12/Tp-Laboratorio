package ControladorVentanas;

import Almacenamiento.Equipo;
import Exepciones.EquipoLlenoExeption;
import Exepciones.ValorNoValidoExeption;
import Pokemones.Pokemon;
import Ventana.VentanaCrearMovimiento;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVentanaCrearMovimiento implements ActionListener {

    private VentanaCrearMovimiento ventana;
    private static ControladorVentanaCrearPokemon instance = null;
    private static Equipo equipo;

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
        if(comando.equalsIgnoreCase("Crear")) {
            try {
                Pokemon p = new Pokemon(ventana.getTextField());
                equipo.agregarPokemon(p);
                ControladorVentanaEditorEquipo aux;
                aux = ControladorVentanaEditorEquipo.getInstance();
                aux.setDatos();
                aux.setVentana(true);
            }catch (EquipoLlenoExeption ex){
                JOptionPane.showMessageDialog(null, "Equipo LLeno");
            }catch (ValorNoValidoExeption ex){
                JOptionPane.showMessageDialog(null,"El pokemon no existe");
            }
        }
        if(comando.equalsIgnoreCase("Volver")) {
            ControladorVentanaEditorEquipo aux;
            aux = ControladorVentanaEditorEquipo.getInstance();
            aux.setDatos();
            aux.setVentana(true);
        }
    }



    public void setVentana(boolean b) {
        ventana.setVisible(b);
    }
}
