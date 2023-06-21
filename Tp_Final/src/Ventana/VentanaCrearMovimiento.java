package Ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class VentanaCrearMovimiento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private JButton btnBuscar;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearMovimiento frame = new VentanaCrearMovimiento();
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
	public VentanaCrearMovimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 77, 89, 23);
		contentPane.add(btnBuscar);

		textField = new JTextField();
		textField.setBounds(10, 46, 204, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JTextPane txtpnIngreseMovimientoA = new JTextPane();
		txtpnIngreseMovimientoA.setText("Ingrese Movimiento a Aprender (En ingles por favor)");
		txtpnIngreseMovimientoA.setBackground(new Color(240, 240, 240));
		txtpnIngreseMovimientoA.setEditable(false);
		txtpnIngreseMovimientoA.setBounds(10, 15, 296, 20);
		contentPane.add(txtpnIngreseMovimientoA);
	}

	public void setActionListener(ActionListener aux){
		actionListener = aux;
		btnBuscar.addActionListener(actionListener);
	}

	public String getTextField(){
		return textField.getText();
	}


}
