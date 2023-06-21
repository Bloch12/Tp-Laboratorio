package Ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class VentanaEquipos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox selectorDeEquipo;
	private JButton btnBuscar;
	private JButton btnCrear;
	private JButton btnVolver;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipos frame = new VentanaEquipos();
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
	public VentanaEquipos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		selectorDeEquipo = new JComboBox();
		selectorDeEquipo.setEditable(true);
		//SelectorDeEquipo.setModel(new DefaultComboBoxModel(new String[] {"Equipo 1", "Equipo 2", "Equipo 3", "Equipo 4"}));
		selectorDeEquipo.setBounds(10, 31, 141, 22);
		contentPane.add(selectorDeEquipo);
		
		JTextPane txtpnBuscarEquipo = new JTextPane();
		txtpnBuscarEquipo.setBackground(new Color(240, 240, 240));
		txtpnBuscarEquipo.setText("Buscar Equipo");
		txtpnBuscarEquipo.setBounds(10, 11, 141, 20);
		contentPane.add(txtpnBuscarEquipo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 58, 89, 23);
		contentPane.add(btnBuscar);
		
		JTextPane txtpnCrearEquipo = new JTextPane();
		txtpnCrearEquipo.setText("Crear Equipo");
		txtpnCrearEquipo.setBackground(UIManager.getColor("Button.background"));
		txtpnCrearEquipo.setBounds(10, 107, 141, 20);
		contentPane.add(txtpnCrearEquipo);
		
		textField = new JTextField();
		textField.setBounds(130, 135, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		setResizable(false);
		JTextPane txtpnNombreDelEquipo = new JTextPane();
		txtpnNombreDelEquipo.setText("Nombre Del Equipo:");
		txtpnNombreDelEquipo.setBackground(UIManager.getColor("Button.background"));
		txtpnNombreDelEquipo.setBounds(10, 132, 141, 20);
		contentPane.add(txtpnNombreDelEquipo);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(10, 161, 89, 23);
		contentPane.add(btnCrear);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 227, 89, 23);
		contentPane.add(btnVolver);
	}
	
	public void setActionListener(ActionListener aux){
    	this.actionListener = aux;
    	this.btnBuscar.addActionListener(actionListener);
    	this.btnCrear.addActionListener(actionListener);
    	this.btnVolver.addActionListener(actionListener);
	}
	
	public String getTextField() {
		return textField.getText();
	}

	public JComboBox getSelectorDeEquipo(){
		return selectorDeEquipo;
	}

	
	
}
