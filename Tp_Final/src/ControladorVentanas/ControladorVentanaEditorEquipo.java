package ControladorVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Almacenamiento.Equipo;
import ClasesEstaticas.GestorDeEquipo;
import Exepciones.ValorNoValidoExeption;
import Ventana.VentanaEditorEquipo;

public class ControladorVentanaEditorEquipo implements ActionListener {
	
	private VentanaEditorEquipo ventana;
	private static ControladorVentanaEditorEquipo instance = null;
	private static Equipo equipo;
	private int pos;
	
	private ControladorVentanaEditorEquipo(){
		this.ventana = new VentanaEditorEquipo();
		this.ventana.setActionListener(this);
	}	
	
	public static ControladorVentanaEditorEquipo getInstance(Equipo equipoAux) {
		if(instance == null) {
			instance = new ControladorVentanaEditorEquipo();
		}
		equipo = equipoAux;
		return instance;
	}

	public static ControladorVentanaEditorEquipo getInstance() {
		if(instance == null) {
			instance = new ControladorVentanaEditorEquipo();
		}
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equalsIgnoreCase("Guardar Cambios")) {
			try {
				if(!equipo.getNombre().equals(ventana.getTextField()))
					GestorDeEquipo.modificarEquipo(ventana.getTextField(),equipo);
				equipo.setEstado(ventana.getrtbdHabilitado());
				JOptionPane.showMessageDialog(null,"Cambios Guardados");
			} catch (ValorNoValidoExeption ex) {
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}catch (ClassCastException ex){
				JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		} else if(comando.equalsIgnoreCase("Volver")) {
			ControladorVentanaEquipos aux = ControladorVentanaEquipos.getInstance();
			aux.setDatos();
			aux.setVentana(true);
			setVentana(false);
		}else if(comando.equalsIgnoreCase("Agregar")){
			ControladorVentanaCrearPokemon aux = ControladorVentanaCrearPokemon.getInstance(equipo);
			aux.setVentana(true);
			setVentana(false);
		}else{
			int i = 0;
			while(i<6 && !comando.equalsIgnoreCase("pokemon " + i)) {
				i++;
			}
			try {
				pos = i;
				ControladorVentanaPokemon aux = ControladorVentanaPokemon.getInstance(equipo.getPokemon(i));
				aux.setDatos();
				aux.setVentana(true);
				setVentana(false);
			}catch (ValorNoValidoExeption ex) {
			}

		}

		
	}
	
	public void setVentana(boolean b) {
		ventana.setVisible(b);
	}
	
	public void setDatos(){
		ventana.setDatos(equipo);
	}

	public void eliminarPokemon(){
		try {
			equipo.quitarPokemon(pos);
		}catch (ValorNoValidoExeption ex){
		}
	}

}
