package Ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import java.awt.Color;

public class VentanaMochila extends JFrame {

	private JPanel contentPane;
	private ActionListener actionListener;
	private JTextField textField;
	private JTextPane txtpnBuscarObjeto;
	private JButton btnVolver;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMochila frame = new VentanaMochila();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setActionListener(ActionListener aux){
		actionListener = aux;
		btnBuscar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);

	}

	/**
	 * Create the frame.
	 */
	public VentanaMochila() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 41, 265, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 227, 89, 23);
		contentPane.add(btnVolver);

		btnBuscar = new JButton("Buscar");

		btnBuscar.setBounds(10, 72, 89, 23);
		contentPane.add(btnBuscar);

		txtpnBuscarObjeto = new JTextPane();
		txtpnBuscarObjeto.setBackground(new Color(240, 240, 240));
		txtpnBuscarObjeto.setText("Buscar Objeto");
		txtpnBuscarObjeto.setBounds(10, 10, 128, 20);
		contentPane.add(txtpnBuscarObjeto);
	}


	public String getTextField(){
		return textField.getText();
	}

}
