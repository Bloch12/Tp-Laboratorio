package Ventana;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;


public class VentanaCrearPokemon extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver;
	private JButton btnCrear;
	private JTextField textField;
	private ActionListener actionListener;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearPokemon frame = new VentanaCrearPokemon();
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
	public VentanaCrearPokemon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		textField = new JTextField();
		textField.setBounds(10, 39, 306, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 227, 89, 23);
		contentPane.add(btnVolver);

		JTextPane txtpnIngreseLaEspecie = new JTextPane();
		txtpnIngreseLaEspecie.setBackground(new Color(240, 240, 240));
		txtpnIngreseLaEspecie.setText("Ingrese la especie del nuevo Pokemon");
		txtpnIngreseLaEspecie.setBounds(10, 11, 190, 20);
		contentPane.add(txtpnIngreseLaEspecie);

		btnCrear = new JButton("Crear");
		btnCrear.setBounds(10, 70, 89, 23);
		contentPane.add(btnCrear);

		setContentPane(contentPane);
	}

	public void setActionListener(ActionListener aux){
		actionListener = aux;
		btnCrear.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}

	public String getTextField(){
		return textField.getText();
	}

}
