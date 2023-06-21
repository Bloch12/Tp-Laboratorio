package Ventana;

import Almacenamiento.Equipo;
import ClasesEstaticas.GestorDeEquipo;
import Exepciones.ValorNoValidoExeption;

import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaUsarObjeto extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnSeleccionar;
	private JButton btnUsar;
	private JButton btnVolver;
	private JTextPane txtpnBuscarPokemon;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsarObjeto frame = new VentanaUsarObjeto();
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
	public VentanaUsarObjeto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 227, 89, 23);
		contentPane.add(btnVolver);

		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(10, 47, 89, 22);
		contentPane.add(comboBox);

		JTextPane txtpnBuscarEquipo = new JTextPane();
		txtpnBuscarEquipo.setBackground(new Color(240, 240, 240));
		txtpnBuscarEquipo.setText("Buscar Equipo\r\n");
		txtpnBuscarEquipo.setEditable(false);
		txtpnBuscarEquipo.setBounds(10, 23, 89, 20);
		contentPane.add(txtpnBuscarEquipo);

		comboBox_1 = new JComboBox();
		comboBox_1.setEditable(false);
		comboBox_1.setVisible(false);
		comboBox_1.setBounds(109, 47, 89, 22);
		contentPane.add(comboBox_1);

		txtpnBuscarPokemon = new JTextPane();
		txtpnBuscarPokemon.setText("Buscar Pokemon");
		txtpnBuscarPokemon.setEditable(false);
		txtpnBuscarPokemon.setVisible(false);
		txtpnBuscarPokemon.setBackground(UIManager.getColor("Button.background"));
		txtpnBuscarPokemon.setBounds(109, 23, 89, 20);
		contentPane.add(txtpnBuscarPokemon);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(10, 80, 89, 23);
		contentPane.add(btnSeleccionar);

		btnUsar = new JButton("Usar");
		btnUsar.setBounds(109, 80, 89, 23);
		contentPane.add(btnUsar);
	}

	public void setActionListener(ActionListener aux){
		actionListener = aux;
		btnSeleccionar.addActionListener(actionListener);
		btnUsar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}

	public void setComboBox(){
		comboBox.setModel(new DefaultComboBoxModel(GestorDeEquipo.listarEquipo().toArray()));
		comboBox_1.setVisible(false);
		txtpnBuscarPokemon.setVisible(false);
		btnUsar.setVisible(false);
	}

	public void setComboBox_1(Equipo equipo){
		comboBox_1.setModel(new DefaultComboBoxModel(equipo.listarPokemones().toArray()));
		comboBox_1.setVisible(true);
		txtpnBuscarPokemon.setVisible(true);
		btnUsar.setVisible(true);
	}

	public Equipo getComboBox() throws ValorNoValidoExeption{
			return GestorDeEquipo.getEquipo((String) comboBox.getSelectedItem());
	}

	public int getComboBox_1(){
		return (Integer) comboBox_1.getSelectedItem();
	}
}
