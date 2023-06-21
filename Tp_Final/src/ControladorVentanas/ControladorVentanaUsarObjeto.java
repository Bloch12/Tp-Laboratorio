package ControladorVentanas;

import Almacenamiento.Equipo;
import ClasesEstaticas.Mochila;
import Exepciones.ValorNoValidoExeption;
import Objetos.Objeto;
import Ventana.VentanaUsarObjeto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVentanaUsarObjeto implements ActionListener {
    private VentanaUsarObjeto ventana;
    private static Objeto objeto;
    private Equipo equipo;
    private static ControladorVentanaUsarObjeto instance = null;

    private ControladorVentanaUsarObjeto() {
        this.ventana = new VentanaUsarObjeto();
        this.ventana.setActionListener(this);
    }

    public static ControladorVentanaUsarObjeto getInstance(Objeto objetoAux) {
        if(instance == null) {
            instance = new ControladorVentanaUsarObjeto();
        }
        objeto = objetoAux;
        return instance;
    }

    /**
     * Seleccionar seleciona un equipo y te muestra sus pokemons, usar usa el objeto en el pokemon elegido, volver vuelve al menu principal
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String comando = e.getActionCommand();
        if(comando.equalsIgnoreCase("Seleccionar")) {
            try {
                equipo = ventana.getComboBox();
                ventana.setComboBox_1(equipo);
            }catch (ValorNoValidoExeption ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
        if(comando.equalsIgnoreCase("Usar")) {
            JOptionPane.showMessageDialog(null,objeto.usar(equipo,ventana.getComboBox_1()));
            ControladorVentanaPrincipal aux = ControladorVentanaPrincipal.getInstance();
            aux.setVentana(true);
            setVentana(false);
        }
        if(comando.equalsIgnoreCase("Volver")) {
            ControladorVentanaPrincipal aux = ControladorVentanaPrincipal.getInstance();
            aux.setVentana(true);
            setVentana(false);
        }
    }

    public void setDatos(){
        ventana.setComboBox();
    }

    public void setVentana(boolean b) {
        ventana.setVisible(b);
    }
}
