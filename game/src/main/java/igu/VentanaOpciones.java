package igu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class VentanaOpciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JSpinner spinner;
	private JLabel lblFondo;
	private JTextArea area;
	private Button btAceptar;
	private Button btAtras;
	private JLabel lblTipo;
	private JRadioButton rbtTipo1;
	private JRadioButton rbtTipo2;
	private VentanaOpciones ventana = this;
	private int tipo;
	private int numeroJugadores;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public VentanaOpciones() {
		this.setUndecorated(true);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setBounds(500, 350, 404, 246);
		getContentPane().add(getSpinner());
		getContentPane().add(getTxtArea());
		getContentPane().add(getBtAceptar());
		getContentPane().add(getBtAtras());
		getContentPane().add(getLblTipo());
		getContentPane().add(getRbtTipo1());
		getContentPane().add(getRbtTipo2());

		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/img/logo.jpg"));
		this.setIconImage(icon);

		lblFondo = new JLabel();
		lblFondo.setText(null);
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(new Dimension(409, 279));
		ImageIcon img = new ImageIcon(getClass().getResource("/img/f0.jpg"));
		Icon fondo = new ImageIcon(img.getImage().getScaledInstance(
				lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(fondo);
		getContentPane().add(lblFondo, null);
	}

	private JRadioButton getRbtTipo1() {
		rbtTipo1 = new JRadioButton("Tipo 1");
		buttonGroup.add(rbtTipo1);
		rbtTipo1.setBounds(93, 81, 109, 23);
		rbtTipo1.setSelected(true);
		rbtTipo1.setBorder(null);
		rbtTipo1.setOpaque(false);
		rbtTipo1.setForeground(Color.white);
		rbtTipo1.setFont(new java.awt.Font("Candara", 0, 17));
		return rbtTipo1;
	}

	private JRadioButton getRbtTipo2() {
		rbtTipo2 = new JRadioButton("Tipo 2");
		buttonGroup.add(rbtTipo2);
		rbtTipo2.setBounds(93, 115, 109, 23);
		rbtTipo2.setSelected(false);
		rbtTipo2.setOpaque(false);
		rbtTipo2.setBorder(null);
		rbtTipo2.setForeground(Color.white);
		rbtTipo2.setFont(new java.awt.Font("Candara", 0, 17));
		return rbtTipo2;
	}

	private JLabel getLblTipo() {
		lblTipo = new JLabel("lblTipo");
		lblTipo.setText("Tipo de tablero:");
		lblTipo.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 0, 18));
		lblTipo.setBounds(10, 52, 147, 29);
		return lblTipo;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			SpinnerNumberModel modelo = new SpinnerNumberModel(1, 1, 4, 1);
			spinner = new JSpinner(modelo);
			spinner.setBounds(273, 7, 40, 29);
		}
		return spinner;
	}

	private Component getTxtArea() {
		String texto = "Introduzca el número de jugadores (máx. 4): ";
		area = new JTextArea();
		area.setLineWrap(true);
		area.setText(texto);
		area.setEditable(false);
		area.setBounds(10, 11, 394, 58);
		area.setOpaque(false);
		area.setBorder(null);
		area.setForeground(Color.WHITE);
		setFont(new java.awt.Font("Candara", 0, 18));
		return area;
	}

	private Component getBtAceptar() {
		btAceptar = new Button("Aceptar");
		btAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setNumeroJugadores(Integer.parseInt(spinner.getValue()
						.toString()));
				if (rbtTipo1.isSelected())
					tipo = 1;
				else
					tipo = 2;
				VentanaTablero vt = new VentanaTablero(getNumeroJugadores(),
						tipo);
				vt.setVisible(true);
				ventana.dispose();
			}
		});
		btAceptar.setBounds(273, 186, 89, 23);
		return btAceptar;
	}

	private Component getBtAtras() {
		btAtras = new Button("Atras");
		btAtras.setBounds(143, 186, 89, 23);
		btAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInicio v = new VentanaInicio();
				v.setVisible(true);
				ventana.dispose();
			}
		});
		return btAtras;
	}

	public int getNumeroJugadores() {
		return numeroJugadores;
	}

	public void setNumeroJugadores(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}
}
