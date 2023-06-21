package ControladorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Ventana.VentanaPrincipal;

public class ControladorVentanaPrincipal implements ActionListener {
	private VentanaPrincipal ventana;
	private static ControladorVentanaPrincipal instance = null;
	
	private ControladorVentanaPrincipal() {
		this.ventana = new VentanaPrincipal();
		this.ventana.setActionListener(this);
	}	
	
	public static ControladorVentanaPrincipal getInstance() {
		if(instance == null) {
			instance = new ControladorVentanaPrincipal();
		}
		return instance;
	}

	/**
	 * el boton pokedex te lleva el menu de la pokedex, el de equipos al de equipos y el de mochila al de mochila.
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equalsIgnoreCase("Pokedex")) {
			ControladorVentanaPokedex aux = ControladorVentanaPokedex.getInstance();
			aux.setVentana(true);
			setVentana(false);
			
		}if(comando.equalsIgnoreCase("Equipos")) {
			ControladorVentanaEquipos aux = ControladorVentanaEquipos.getInstance();
			aux.setDatos();
			aux.setVentana(true);
			setVentana(false);
			
		}if(comando.equalsIgnoreCase("Mochila")) {
			ControladorVentanaMochila aux = ControladorVentanaMochila.getInstance();
			aux.setVentana(true);
			setVentana(false);
		}
	}
	
	public void setVentana(boolean b) {
		ventana.setVisible(b);
	}
}
