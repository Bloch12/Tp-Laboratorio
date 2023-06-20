package ControladorVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ClasesEstaticas.Pokedex;
import Ventana.*;

public class ControladorVentanaPokedex implements ActionListener{
	private VentanaPokedex ventana;
	private static ControladorVentanaPokedex instance = null;
	
	private ControladorVentanaPokedex() {
		this.ventana = new VentanaPokedex();
		this.ventana.setActionListener(this);
	}	
	
	public static ControladorVentanaPokedex getInstance() {
		if(instance == null) {
			instance = new ControladorVentanaPokedex();
		}
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equalsIgnoreCase("Buscar")) {
			try {
			ControladorVentanaEspeciePokemon aux = ControladorVentanaEspeciePokemon.getInstance();
			aux.setTexto(Pokedex.buscarPokemon(ventana.getTextField()));
			aux.setVentana(true);
			setVentana(false);
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Pokemon No encontrado");
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
