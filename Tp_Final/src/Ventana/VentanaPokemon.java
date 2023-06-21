package Ventana;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import Enums.Naturaleza;
import Exepciones.ValorNoValidoExeption;
import Poderes.Habilidad;
import Pokemones.Pokemon;

public class VentanaPokemon extends JFrame {
	private ActionListener actionListener;
	private JLabel lblImagen;
	private JPanel editorpokemon;
	private JTextPane textPaneEspecie;
	private JTextField mote;
	private JSpinner nivel;
	private JEditorPane dtrpnIvsEvs;
	private JComboBox comboBox;
	private JComboBox naturaleza;
	private JButton btnEliminar;
	private JTextPane txtpnHpAtqDeff_2;
	private JButton btnMovimiento3;
	private JButton btnMovimiento4;
	private JButton btnMovimiento1;
	private JButton btnMovimiento2;
	private JButton btnVolver;
	private JButton btnGuardar;
	private JSpinner evsHp;
	private JSpinner evsAtq;
	private JSpinner evsDeff;
	private JSpinner evsEspAtq;
	private JSpinner evsEspDeff;
	private JSpinner evsVel;
	private JSpinner ivsHp;
	private JSpinner ivsAtq;
	private JSpinner ivsDeff;
	private JSpinner ivsEspAtq;
	private JSpinner ivsEspDeff;
	private JSpinner ivsVel;

	private ArrayList<JButton> btns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPokemon frame = new VentanaPokemon();
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
	public VentanaPokemon() {
		btns=new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 589);
		editorpokemon = new JPanel();
		editorpokemon.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(editorpokemon);
		editorpokemon.setLayout(null);

		lblImagen = new JLabel("New label");
		lblImagen.setBounds(10, 0, 108, 78);
		editorpokemon.add(lblImagen);

		mote = new JTextField();
		mote.setBounds(10, 88, 86, 20);
		editorpokemon.add(mote);
		mote.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(315, 28, 201, 22);
		editorpokemon.add(comboBox);

		naturaleza = new JComboBox();
		naturaleza.setModel(new DefaultComboBoxModel(Naturaleza.values()));
		naturaleza.setBounds(10, 443, 108, 22);
		editorpokemon.add(naturaleza);

		JTextPane txtpnHpAtqDeff = new JTextPane();
		txtpnHpAtqDeff.setEditable(false);
		txtpnHpAtqDeff.setText("Hp\r\n\r\n\r\nAtq\r\n\r\n\r\nDeff\r\n\r\n\r\nEspAtq\r\n\r\n\r\nEspDeff\r\n\r\n\r\nVel");
		txtpnHpAtqDeff.setBackground(new Color(240, 240, 240));
		txtpnHpAtqDeff.setBounds(10, 184, 45, 281);
		editorpokemon.add(txtpnHpAtqDeff);

		dtrpnIvsEvs = new JEditorPane();
		dtrpnIvsEvs.setBackground(new Color(240, 240, 240));
		dtrpnIvsEvs.setText("   IVs                EVs");
		dtrpnIvsEvs.setEditable(false);
		dtrpnIvsEvs.setBounds(65, 152, 138, 20);
		editorpokemon.add(dtrpnIvsEvs);

		txtpnHpAtqDeff_2 = new JTextPane();
		txtpnHpAtqDeff_2.setText("Hp\r\n\r\n\r\nAtq\r\n\r\n\r\nDeff\r\n\r\n\r\nEspAtq\r\n\r\n\r\nEspDeff\r\n\r\n\r\nVel");
		txtpnHpAtqDeff_2.setEditable(false);
		txtpnHpAtqDeff_2.setBackground(UIManager.getColor("Button.background"));
		txtpnHpAtqDeff_2.setBounds(199, 184, 45, 281);
		editorpokemon.add(txtpnHpAtqDeff_2);

		btnMovimiento3 = new JButton("New button");
		btnMovimiento3.setBounds(315, 95, 89, 23);
		editorpokemon.add(btnMovimiento3);

		btnMovimiento4 = new JButton("New button");
		btnMovimiento4.setBounds(427, 95, 89, 23);
		editorpokemon.add(btnMovimiento4);

		btnMovimiento1 = new JButton("New button");
		btnMovimiento1.setBounds(314, 61, 89, 23);
		editorpokemon.add(btnMovimiento1);

		btnMovimiento2 = new JButton("New button");
		btnMovimiento2.setBounds(427, 61, 89, 23);
		editorpokemon.add(btnMovimiento2);

		btnVolver = new JButton("Volver");

		btnVolver.setBounds(438, 516, 89, 23);
		editorpokemon.add(btnVolver);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(199, 516, 127, 23);
		editorpokemon.add(btnGuardar);

		nivel = new JSpinner();
		nivel.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		nivel.setBounds(204, 88, 64, 20);
		editorpokemon.add(nivel);

		ivsHp = new JSpinner();
		ivsHp.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		ivsHp.setBounds(65, 184, 45, 20);
		editorpokemon.add(ivsHp);

		ivsAtq = new JSpinner();
		ivsAtq.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		ivsAtq.setBounds(65, 225, 45, 20);
		editorpokemon.add(ivsAtq);

		ivsDeff = new JSpinner();
		ivsDeff.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		ivsDeff.setBounds(65, 267, 45, 20);
		editorpokemon.add(ivsDeff);

		ivsEspAtq = new JSpinner();
		ivsEspAtq.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		ivsEspAtq.setBounds(65, 310, 45, 20);
		editorpokemon.add(ivsEspAtq);

		ivsEspDeff = new JSpinner();
		ivsEspDeff.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		ivsEspDeff.setBounds(65, 353, 45, 20);
		editorpokemon.add(ivsEspDeff);

		ivsVel = new JSpinner();
		ivsVel.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		ivsVel.setBounds(65, 396, 45, 20);
		editorpokemon.add(ivsVel);

		evsVel = new JSpinner();
		evsVel.setModel(new SpinnerNumberModel(0, 0, 252, 1));
		evsVel.setBounds(125, 396, 45, 20);
		editorpokemon.add(evsVel);

		evsEspDeff = new JSpinner();
		evsEspDeff.setModel(new SpinnerNumberModel(0, 0, 252, 1));
		evsEspDeff.setBounds(125, 353, 45, 20);
		editorpokemon.add(evsEspDeff);

		evsEspAtq = new JSpinner();
		evsEspAtq.setModel(new SpinnerNumberModel(0, 0, 252, 1));
		evsEspAtq.setBounds(125, 310, 45, 20);
		editorpokemon.add(evsEspAtq);

		evsDeff = new JSpinner();
		evsDeff.setModel(new SpinnerNumberModel(0, 0, 252, 1));
		evsDeff.setBounds(125, 267, 45, 20);
		editorpokemon.add(evsDeff);

		evsAtq = new JSpinner();
		evsAtq.setModel(new SpinnerNumberModel(0, 0, 252, 1));
		evsAtq.setBounds(125, 225, 45, 20);
		editorpokemon.add(evsAtq);

		evsHp = new JSpinner();
		evsHp.setModel(new SpinnerNumberModel(0, 0, 252, 1));
		evsHp.setBounds(125, 184, 45, 20);
		editorpokemon.add(evsHp);

		textPaneEspecie = new JTextPane();
		textPaneEspecie.setText("especie");
		textPaneEspecie.setBackground(new Color(240, 240, 240));
		textPaneEspecie.setBounds(106, 88, 88, 20);
		editorpokemon.add(textPaneEspecie);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(336, 516, 96, 23);
		editorpokemon.add(btnEliminar);

		btns.add(btnMovimiento1);
		btns.add(btnMovimiento2);
		btns.add(btnMovimiento3);
		btns.add(btnMovimiento4);
	}

	public void setActionListener(ActionListener aux){
		this.actionListener = aux;
		this.btnGuardar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.btnEliminar.addActionListener(actionListener);
		this.btnMovimiento1.addActionListener(actionListener);
		this.btnMovimiento2.addActionListener(actionListener);
		this.btnMovimiento3.addActionListener(actionListener);
		this.btnMovimiento4.addActionListener(actionListener);
	}

	public ArrayList<Integer> getEvs(){
		ArrayList<Integer> aux = new ArrayList();
		aux.add((Integer)evsHp.getValue());
		aux.add((Integer)evsAtq.getValue());
		aux.add((Integer)evsDeff.getValue());
		aux.add((Integer)evsEspAtq.getValue());
		aux.add((Integer)evsEspDeff.getValue());
		aux.add((Integer)evsVel.getValue());
		return aux;
	}

	public ArrayList<Integer> getIvs(){
		ArrayList<Integer> aux = new ArrayList();
		aux.add((Integer)ivsHp.getValue());
		aux.add((Integer)ivsAtq.getValue());
		aux.add((Integer)ivsDeff.getValue());
		aux.add((Integer)ivsEspAtq.getValue());
		aux.add((Integer)ivsEspDeff.getValue());
		aux.add((Integer)ivsVel.getValue());
		return aux;
	}

	public int getNivel() {
		return (Integer) nivel.getValue();
	}

	public String getMote() {
		return mote.getText();
	}

	public Naturaleza getNaturaleza() {
		return (Naturaleza) naturaleza.getSelectedItem();
	}

	public String getHabilidad() {
		return (String) comboBox.getSelectedItem();
	}


	public void setNivel(int nivel){
		this.nivel.setValue(nivel);
	}

	public void setMote(String mote){
		this.mote.setText(mote);
	}

	public void setEspecie(String especie){
		textPaneEspecie.setText(especie);
	}

	public void setHabilidad(Habilidad habilidad,ArrayList<Habilidad> habilidades){
		comboBox.removeAllItems();
		for (Habilidad h: habilidades) {
			comboBox.addItem(h.getNombre());
		}
		if(habilidad != null){
			comboBox.setSelectedItem(habilidad.getNombre());
		}
	}

	public void setEvs(ArrayList<Integer> evs){
		evsHp.setValue(evs.get(0));
		evsAtq.setValue(evs.get(1));
		evsDeff.setValue(evs.get(2));
		evsEspAtq.setValue(evs.get(3));
		evsEspDeff.setValue(evs.get(4));
		evsVel.setValue(evs.get(5));
	}

	public void setIvs(ArrayList<Integer> ivs){
		ivsHp.setValue(ivs.get(0));
		ivsAtq.setValue(ivs.get(1));
		ivsDeff.setValue(ivs.get(2));
		ivsEspAtq.setValue(ivs.get(3));
		ivsEspDeff.setValue(ivs.get(4));
		ivsVel.setValue(ivs.get(5));
	}

	public void setNaturaleza(Naturaleza naturaleza){
		this.naturaleza.setSelectedItem(naturaleza);
	}

	public void setLblImagen(String sprite){
		Image imagen = null;
		URL url;
		try {
			url = new URL(sprite);
			imagen = ImageIO.read(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblImagen.removeAll();
		lblImagen.setIcon(new ImageIcon(imagen));


	}

	public void setMovimientos(Pokemon p){
		int i=0;
		for (JButton btn: btns)
			btn.setVisible(true);
		try{
			while(true) {
				btns.get(i).setText(p.getMovimiento(i).getNombre());
				i++;
			}
		}catch (ValorNoValidoExeption ex){
			if(i<4)
				btns.get(i).setText("Crear");
			for (i++; i <4 ; i++) {
				btns.get(i).setVisible(false);
			}
		}
	}



}
