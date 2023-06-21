package Ventana;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pokemones.EspeciePokemon;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;

public class VentanaEspeciePokemon extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver;
	private JTextArea txtrDatos; 
	private ActionListener actionListener;
	private JLabel lblImagen;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEspeciePokemon frame = new VentanaEspeciePokemon();
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
	public VentanaEspeciePokemon() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 863);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 790, 89, 23);
		contentPane.add(btnVolver);
		txtrDatos = new JTextArea();
		txtrDatos.setBackground(new Color(240, 240, 240));
		txtrDatos.setEditable(false);
		txtrDatos.setBounds(10, 11, 749, 764);
		contentPane.add(txtrDatos);
		lblImagen = new JLabel();
		lblImagen.setBounds(769, 11, 250, 250);
		contentPane.add(lblImagen);
		
	}
	
	public void setDatos(EspeciePokemon p) {
		txtrDatos.setText(p.toString());
		Image imagen = null;
		URL url;
		try {
			url = new URL(p.getSprite());
			imagen = ImageIO.read(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblImagen.removeAll();
		lblImagen.setIcon(new ImageIcon(imagen.getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		
		
	}
	
	public void setActionListener(ActionListener aux){
	    this.actionListener = aux;
	    this.btnVolver.addActionListener(actionListener);
	}
}	
