package ControladorVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Pokemones.EspeciePokemon;
import Ventana.VentanaEspeciePokemon;

public class ControladorVentanaEspeciePokemon implements ActionListener {
	private VentanaEspeciePokemon ventana;
	private static ControladorVentanaEspeciePokemon instance = null;
	
	private ControladorVentanaEspeciePokemon() {
		this.ventana = new VentanaEspeciePokemon();
		this.ventana.setActionListener(this);
	}	
	
	public static ControladorVentanaEspeciePokemon getInstance() {
		if(instance == null) {
			instance = new ControladorVentanaEspeciePokemon();
		}
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equalsIgnoreCase("Volver")) {
			ControladorVentanaPokedex aux = ControladorVentanaPokedex.getInstance();
			aux.setVentana(true);
			setVentana(false);
			
		}
	}
	
	public void setVentana(boolean b) {
		ventana.setVisible(b);
	}
	
	public void setTexto(EspeciePokemon p) {
		ventana.setDatos(p);
	}


}
