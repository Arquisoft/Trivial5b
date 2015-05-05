package igu;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import logica.Jugador;

public class VentanaGanador extends JDialog {

	private static final long serialVersionUID = 1L;
	private JDialog anterior = this;
	private JLabel lblFondo;
	private JLabel lblFoto;
	private Jugador ganador;
	private JLabel lblGanador;
	private JLabel lblNombre;
	private Button btSalir;
	private Button btNuevaPartida;

	public VentanaGanador(Jugador jugador) {
		ganador = jugador;
		getContentPane().setLayout(null);
		this.setTitle("Ganador");
		this.setBounds(40, 40, 600, 600);
		this.setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/img/logo.jpg"));
		this.setIconImage(icon);

		getContentPane().add(getLblFoto());

		lblFondo = new JLabel();
		lblFondo.setText(null);
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(this.getSize());
		ImageIcon img = new ImageIcon(getClass().getResource("/img/f1.jpg"));
		Icon fondo = new ImageIcon(img.getImage().getScaledInstance(
				lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));

		getContentPane().add(getLblGanador());
		getContentPane().add(getLblNombre());
		getContentPane().add(getBtNuevaPartida());
		getContentPane().add(getBtSalir());

		lblFondo.setIcon(fondo);
		getContentPane().add(lblFondo, null);

	}

	private Button getBtNuevaPartida() {
		btNuevaPartida = new Button("Nueva Partida");
		btNuevaPartida.setBounds(71, 495, 130, 40);
		btNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anterior.dispose();
				VentanaOpciones vo = new VentanaOpciones();
				vo.setVisible(true);
			}
		});
		return btNuevaPartida;
	}
	
	private Button getBtSalir() {
		btSalir = new Button("Salir");
		btSalir.setBounds(400, 495, 130, 40);
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anterior.dispose();
			}
		});
		return btSalir;
	}

	private JLabel getLblNombre() {
		lblNombre = new JLabel();
		lblNombre.setBounds(310, 397, 252, 65);
		lblNombre.setText(ganador.getNombre());
		lblNombre.setFont(new java.awt.Font("Candara", 1, 32));
		lblNombre.setForeground(Color.white);
		return lblNombre;
	}

	private JLabel getLblFoto() {
		lblFoto = new JLabel();
		lblFoto.setBounds(100, 50, 400, 300);
		ImageIcon img = new ImageIcon(getClass()
				.getResource("/img/ganador.png"));
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		lblFoto.setIcon(icono);
		return lblFoto;
	}

	private JLabel getLblGanador() {
		lblGanador = new JLabel();
		lblGanador.setText("El ganador es el: ");
		lblGanador.setBounds(100, 397, 200, 65);
		lblGanador.setFont(new java.awt.Font("Candara", 1, 28));
		lblGanador.setForeground(Color.white);
		return lblGanador;
	}
}
