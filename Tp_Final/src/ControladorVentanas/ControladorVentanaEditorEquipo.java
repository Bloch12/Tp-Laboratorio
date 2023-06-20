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
		}
		if(comando.equalsIgnoreCase("Volver")) {
			ControladorVentanaEquipos aux = ControladorVentanaEquipos.getInstance();
			aux.setDatos();
			aux.setVentana(true);
			setVentana(false);
		}
		
	}
	
	public void setVentana(boolean b) {
		ventana.setVisible(b);
	}
	
	public void setDatos(){
		ventana.setDatos(equipo);
	}

}
