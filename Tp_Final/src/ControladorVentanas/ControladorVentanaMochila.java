package ControladorVentanas;

import ClasesEstaticas.Mochila;

import Exepciones.ValorNoValidoExeption;
import Ventana.VentanaMochila;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVentanaMochila implements ActionListener {
    private VentanaMochila ventana;
    private static ControladorVentanaMochila instance = null;

    private ControladorVentanaMochila() {
        this.ventana = new VentanaMochila();
        this.ventana.setActionListener(this);
    }

    public static ControladorVentanaMochila getInstance() {
        if(instance == null) {
            instance = new ControladorVentanaMochila();
        }
        return instance;
    }

    /**
     * Buscar intenta buscar el objeto y te manda a la ventana para usarlo y volver te debuelve al menu principal
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String comando = e.getActionCommand();
        if(comando.equalsIgnoreCase("Buscar")) {
            try{
                ControladorVentanaUsarObjeto aux = ControladorVentanaUsarObjeto.getInstance(Mochila.getObjeto(ventana.getTextField()));
                aux.setDatos();
                aux.setVentana(true);
                setVentana(false);

            }catch (ValorNoValidoExeption ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }

        }
        if(comando.equalsIgnoreCase("Volver")) {
            ControladorVentanaPrincipal aux = ControladorVentanaPrincipal.getInstance();
            aux.setVentana(true);
            setVentana(false);
        }
    }

    public void setVentana(boolean b) {
        ventana.setVisible(b);
    }
}
