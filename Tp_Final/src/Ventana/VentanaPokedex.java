package Ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class VentanaPokedex extends JFrame{
	
	private ActionListener actionListener;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBuscar;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPokedex frame = new VentanaPokedex();
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
	public VentanaPokedex(){
		setTitle("Busca tus pokemones favoritos :)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(10, 37, 282, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnBuscarPokemon = new JTextPane();
		txtpnBuscarPokemon.setText("Buscar Pokemon: ");
		txtpnBuscarPokemon.setBackground(new Color(240, 240, 240));
		txtpnBuscarPokemon.setBounds(10, 11, 104, 20);
		contentPane.add(txtpnBuscarPokemon);
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 67, 89, 23);
		contentPane.add(btnBuscar);
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 227, 89, 23);
		contentPane.add(btnVolver);
	}
	
	public void setActionListener(ActionListener aux){
	    	this.actionListener = aux;
	    	this.btnBuscar.addActionListener(actionListener);
	    	this.btnVolver.addActionListener(actionListener);
	}
	
	public String getTextField() {
		return textField.getText();
	}
	
	
	

}
