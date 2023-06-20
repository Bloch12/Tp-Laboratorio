package Ventana;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Almacenamiento.Equipo;
import ClasesEstaticas.Pokedex;
import Exepciones.ValorNoValidoExeption;
import Pokemones.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class VentanaEditorEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ActionListener actionListener;
	private JRadioButton rdbtnHabilitado;
	private JLabel lblPkemon1;
	private JLabel lblPkemon2;
	private JLabel lblPkemon3;
	private JLabel lblPkemon4;
	private JLabel lblPkemon5;
	private JLabel lblPkemon6;
	private ArrayList<JLabel> lbls;
	private JButton btnPokemo1;
	private JButton btnPokemo2;
	private JButton btnPokemo3;
	private JButton btnPokemo4;
	private JButton btnPokemo5;
	private JButton btnPokemo6;
	private ArrayList<JButton> btns;
	private JButton btnVolver;
	private JButton btnGuardarCambios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEditorEquipo frame = new VentanaEditorEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEditorEquipo() {
		lbls = new ArrayList();
		btns = new ArrayList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Volver");
		
		btnVolver.setBounds(471, 417, 89, 23);
		contentPane.add(btnVolver);
		btnGuardarCambios = new JButton("Guardar Cambios");
	
		btnGuardarCambios.setBounds(346, 417, 115, 23);
		contentPane.add(btnGuardarCambios);
		
		JTextPane txtpnNombreDelEquipo = new JTextPane();
		txtpnNombreDelEquipo.setEditable(false);
		txtpnNombreDelEquipo.setText("NOMBRE DEL EQUIPO");
		txtpnNombreDelEquipo.setBackground(new Color(240, 240, 240));
		txtpnNombreDelEquipo.setBounds(10, 11, 162, 20);
		contentPane.add(txtpnNombreDelEquipo);
		
		textField = new JTextField();
		textField.setBounds(10, 33, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		rdbtnHabilitado = new JRadioButton("Habilitado");
		rdbtnHabilitado.setSelected(true);
		rdbtnHabilitado.setBounds(10, 60, 109, 23);
		contentPane.add(rdbtnHabilitado);
		
		lblPkemon1 = new JLabel("New label");
		lblPkemon1.setBounds(10, 103, 89, 87);
		contentPane.add(lblPkemon1);
		lbls.add(lblPkemon1);
		
		lblPkemon2 = new JLabel("New label");
		lblPkemon2.setBounds(132, 103, 89, 87);
		contentPane.add(lblPkemon2);
		lbls.add(lblPkemon2);
		lblPkemon3 = new JLabel("New label");
		lblPkemon3.setBounds(252, 103, 89, 87);
		contentPane.add(lblPkemon3);
		lbls.add(lblPkemon3);
		lblPkemon4 = new JLabel("New label");
		lblPkemon4.setBounds(10, 225, 89, 87);
		contentPane.add(lblPkemon4);
		lbls.add(lblPkemon4);
		lblPkemon5 = new JLabel("New label");
		lblPkemon5.setBounds(132, 225, 89, 87);
		contentPane.add(lblPkemon5);
		lbls.add(lblPkemon5);
		lblPkemon6 = new JLabel("New label");
		lblPkemon6.setBounds(252, 225, 89, 87);
		contentPane.add(lblPkemon6);
		lbls.add(lblPkemon6);
		btnPokemo1 = new JButton("Pokemon 1");
		btnPokemo1.setBounds(0, 190, 89, 23);
		contentPane.add(btnPokemo1);
		btns.add(btnPokemo1);
		btnPokemo2= new JButton("Pokemon 2");
		btnPokemo2.setBounds(132, 190, 89, 23);
		contentPane.add(btnPokemo2);
		btns.add(btnPokemo2);
		btnPokemo3 = new JButton("Pokemon 3");
		btnPokemo3.setBounds(252, 190, 89, 23);
		contentPane.add(btnPokemo3);
		btns.add(btnPokemo3);
		btnPokemo4 = new JButton("Pokemon 4");
		btnPokemo4.setBounds(0, 317, 89, 23);
		contentPane.add(btnPokemo4);
		btns.add(btnPokemo4);
		btnPokemo5 = new JButton("Pokemon 5");
		btnPokemo5.setBounds(132, 317, 89, 23);
		contentPane.add(btnPokemo5);
		btns.add(btnPokemo5);
		btnPokemo6 = new JButton("Pokemon 6");
		btnPokemo6.setBounds(252, 317, 89, 23);
		contentPane.add(btnPokemo6);
		btns.add(btnPokemo6);
	}
	
	public void setActionListener(ActionListener aux){
    	this.actionListener = aux;
    	this.btnGuardarCambios.addActionListener(actionListener);
    	this.btnVolver.addActionListener(actionListener);
    	this.btnPokemo1.addActionListener(actionListener);
    	this.btnPokemo2.addActionListener(actionListener);
    	this.btnPokemo3.addActionListener(actionListener);
    	this.btnPokemo4.addActionListener(actionListener);
    	this.btnPokemo5.addActionListener(actionListener);
    	this.btnPokemo6.addActionListener(actionListener);
	}
	
	public String getTextField() {
		return textField.getText();
	}
	
	public Boolean getrtbdHabilitado() {
		return rdbtnHabilitado.isSelected();
	}
	
	public void setDatos(Equipo equipo){
		textField.setText(equipo.getNombre());
		rdbtnHabilitado.setSelected(equipo.isEstado());
		int i = 0;
		try {
			while(true) {
				Pokemon p = equipo.getPokemon(i);
				btns.get(i).setText(p.getNombreParticular());;
				Image imagen = null;
				URL url;
				try {
					url = new URL(Pokedex.buscarPokemon(p.getEspecie()).getSprite());
					imagen = ImageIO.read(url);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lbls.get(i).removeAll();
				lbls.get(i).setIcon(new ImageIcon(imagen));
				i++;
			}
		} catch (ValorNoValidoExeption e) {
			btns.get(i).setText("Agregar");
			lbls.get(i).setVisible(false);
			for(i++;i<6;i++) {
				btns.get(i).setVisible(false);
				lbls.get(i).setVisible(false);
			}
		}
	}
}
