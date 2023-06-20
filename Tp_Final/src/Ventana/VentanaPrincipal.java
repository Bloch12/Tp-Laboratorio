package Ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.Box;
import java.awt.FlowLayout;

public class VentanaPrincipal extends JFrame{

	private JPanel contentPane;
	private ActionListener actionListener;
	private JButton btnPokedex;
	private JButton btnEquipos;
	private JButton btnMochila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    public void setActionListener(ActionListener aux){
    	this.actionListener = aux;
    	this.btnPokedex.addActionListener(actionListener);
    	this.btnEquipos.addActionListener(actionListener);
    	this.btnMochila.addActionListener(actionListener);
    }

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setTitle("Pokedex ");
		setBackground(new Color(255, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPokedex = new JButton("Pokedex");
		btnPokedex.setBounds(174, 39, 89, 29);
		btnPokedex.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(btnPokedex);
		
		btnEquipos = new JButton("Equipos");
		btnEquipos.setBackground(UIManager.getColor("Button.background"));
		btnEquipos.setBounds(174, 103, 89, 29);
		contentPane.add(btnEquipos);
		
		btnMochila = new JButton("Mochila");
		btnMochila.setBackground(UIManager.getColor("Button.background"));
		btnMochila.setBounds(174, 169, 89, 29);
		contentPane.add(btnMochila);
	}
}
