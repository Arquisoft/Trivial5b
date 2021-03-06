package igu;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblFondo;
	private Button btNuevaPartida;
	private Button btInstrucciones;
	private Button btSalir;
	private JFrame anterior = this;
	private JLabel lblIcono;
	private JLabel lblTexto;
	private JLabel lblLogo;

	public VentanaInicio() {

		getContentPane().setLayout(null);
		this.setTitle("Inicio");
		this.setBounds(40, 40, 500, 400);

		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/img/logo.jpg"));
		this.setIconImage(icon);
		getContentPane().add(getBtNuevaPartida());
		getContentPane().add(getBtInstrucciones());
		getContentPane().add(getBtSalir());
		getContentPane().add(getLblIcono());
		getContentPane().add(getLblTexto());
		getContentPane().add(getLblLogo());

		lblFondo = new JLabel();
		lblFondo.setText(null);
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(this.getSize());
		ImageIcon img = new ImageIcon(getClass().getResource("/img/f0.jpg"));
		Icon fondo = new ImageIcon(img.getImage().getScaledInstance(
				lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(fondo);
		getContentPane().add(lblFondo, null);

	}

	private JLabel getLblLogo() {
		lblLogo = new JLabel();
		lblLogo.setBounds(50, 90, 100, 100);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/logo.jpg"));
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(
				lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono);
		return lblLogo;
	}

	private JLabel getLblTexto() {
		lblTexto = new JLabel("Trivial 5b");
		lblTexto.setForeground(Color.white);
		lblTexto.setBounds(210, -30, 200, 300);
		lblTexto.setFont(new java.awt.Font("Candara", 1, 40));
		return lblTexto;
	}

	private JLabel getLblIcono() {
		lblIcono = new JLabel();
		Icon icono = new ImageIcon("/img/logo.jpg");
		lblIcono.setText(null);
		lblIcono.setIcon(icono);
		lblIcono.setBounds(57, 91, 46, 14);
		return lblIcono;
	}

	private Button getBtNuevaPartida() {
		btNuevaPartida = new Button();
		btNuevaPartida.setText("Nueva Partida");
		btNuevaPartida.setBounds(30, 300, 120, 35);
		btNuevaPartida.setVisible(true);
		btNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anterior.dispose();
				VentanaOpciones vo = new VentanaOpciones();
				vo.setVisible(true);
			}
		});
		return btNuevaPartida;
	}

	private Button getBtInstrucciones() {
		btInstrucciones = new Button();
		btInstrucciones.setText("Instrucciones");
		btInstrucciones.setBounds(180, 300, 120, 35);
		btInstrucciones.setVisible(true);
		btInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInstrucciones instrucciones = new VentanaInstrucciones(
						anterior);
				instrucciones.setVisible(true);
			}
		});
		return btInstrucciones;
	}

	private Button getBtSalir() {
		btSalir = new Button();
		btSalir.setText("Salir");
		btSalir.setBounds(330, 300, 120, 35);
		btSalir.setVisible(true);
		btSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anterior.dispose();
			}
		});
		return btSalir;
	}

	public static void close() {
		System.exit(0);
	}
}
