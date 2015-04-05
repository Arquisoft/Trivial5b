package igu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private VentanaOpciones ventana = this;
	private int numeroJugadores;

	public VentanaOpciones() {
		this.setUndecorated(true);
		this.setResizable(false);
		this.setBounds(500, 350, 300, 200);
		getContentPane().add(getSpinner());
		getContentPane().add(getTxtArea());
		getContentPane().add(getBtAceptar());
		getContentPane().add(getBtAtras());

		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/img/logo.jpg"));
		this.setIconImage(icon);

		lblFondo = new JLabel();
		lblFondo.setText(null);
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(this.getSize());
		ImageIcon img = new ImageIcon(getClass().getResource("/img/f1.jpg"));
		Icon fondo = new ImageIcon(img.getImage().getScaledInstance(
				lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(fondo);
		getContentPane().add(lblFondo, null);
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 4, 1);
			spinner.setModel(model);
			spinner.setBounds(195, 42, 40, 29);
		}
		return spinner;
	}

	private Component getTxtArea() {
		String texto = "Introduzca el número\nde jugadores (máx. 4): ";
		area = new JTextArea();
		area.setLineWrap(true);
		area.setText(texto);
		area.setEditable(false);
		area.setBounds(18, 45, 161, 58);
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
				setNumeroJugadores(Integer.parseInt(spinner.getValue().toString()));
				VentanaTablero vt = new VentanaTablero(getNumeroJugadores());
				vt.setVisible(true);
				ventana.dispose();
			}
		});
		btAceptar.setBounds(201, 138, 89, 23);
		return btAceptar;
	}

	private Component getBtAtras() {
		btAtras = new Button("Atras");
		btAtras.setBounds(101, 138, 89, 23);
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
