package Ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class VentanaMovimiento extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver;
	private JButton btnEliminar;
	private ActionListener actionListener;
	JTextPane textPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMovimiento frame = new VentanaMovimiento();
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
	public VentanaMovimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 227, 89, 23);
		contentPane.add(btnVolver);
		setResizable(false);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(227, 227, 89, 23);
		contentPane.add(btnEliminar);

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 414, 205);
		contentPane.add(textPane);
	}

	public void setActionListener(ActionListener aux) {
		this.actionListener = aux;
		btnEliminar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}

	public void setTextPane(String movimiento){
		textPane.setText(movimiento);
	}
}

