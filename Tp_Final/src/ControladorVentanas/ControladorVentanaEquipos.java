package ControladorVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Almacenamiento.Equipo;
import ClasesEstaticas.GestorDeEquipo;
import Exepciones.ValorNoValidoExeption;
import Pokemones.Pokemon;
import Ventana.VentanaEquipos;

public class ControladorVentanaEquipos implements ActionListener{
		private VentanaEquipos ventana;
		private static ControladorVentanaEquipos instance = null;
		
		private ControladorVentanaEquipos() {
			this.ventana = new VentanaEquipos();
			this.ventana.setActionListener(this);
		}	
		
		public static ControladorVentanaEquipos getInstance() {
			if(instance == null) {
				instance = new ControladorVentanaEquipos();
			}
			return instance;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String comando = e.getActionCommand();
			if(comando.equalsIgnoreCase("Buscar")) {
				try{
						ControladorVentanaEditorEquipo aux;
						aux = ControladorVentanaEditorEquipo.getInstance(GestorDeEquipo.getEquipo((String) ventana.getSelectorDeEquipo().getSelectedItem() ));
						aux.setDatos();
						aux.setVentana(true);
						setVentana(false);
				}catch (ValorNoValidoExeption ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}if(comando.equalsIgnoreCase("Crear")) {
				  try {
                      GestorDeEquipo.crearEquipo(ventana.getTextField());
					  ControladorVentanaEditorEquipo aux = ControladorVentanaEditorEquipo.getInstance(GestorDeEquipo.getEquipo(ventana.getTextField()));
					  GestorDeEquipo.subir();
					  aux.setDatos();
					  aux.setVentana(true);
					  setVentana(false);
                  }catch (ValorNoValidoExeption ex) {
                      JOptionPane.showMessageDialog(null, ex.getMessage());
                  }
			}if(comando.equalsIgnoreCase("Volver")) {
				ControladorVentanaPrincipal aux = ControladorVentanaPrincipal.getInstance();
				aux.setVentana(true);
				setVentana(false);
			}
		}
		
		public void setVentana(boolean b) {
			ventana.setVisible(b);
		}
		
		public void setDatos(){
			ventana.getSelectorDeEquipo().setModel(new DefaultComboBoxModel(GestorDeEquipo.listarEquipo().toArray()));
		}


}
