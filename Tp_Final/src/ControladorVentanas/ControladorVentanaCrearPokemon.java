package ControladorVentanas;

import Almacenamiento.Equipo;
import ClasesEstaticas.GestorDeEquipo;
import ClasesEstaticas.Pokedex;
import Exepciones.EquipoLlenoExeption;
import Exepciones.ValorNoValidoExeption;
import Pokemones.Pokemon;
import Ventana.VentanaCrearPokemon;
import Ventana.VentanaPokedex;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVentanaCrearPokemon implements ActionListener {

    private VentanaCrearPokemon ventana;
    private static ControladorVentanaCrearPokemon instance = null;
    private static Equipo equipo;

    private ControladorVentanaCrearPokemon() {
        this.ventana = new VentanaCrearPokemon();
        this.ventana.setActionListener(this);
    }

    public static ControladorVentanaCrearPokemon getInstance(Equipo equipoAux) {
        if(instance == null) {
            instance = new ControladorVentanaCrearPokemon();
        }
        equipo = equipoAux;
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
                GestorDeEquipo.subir();
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
