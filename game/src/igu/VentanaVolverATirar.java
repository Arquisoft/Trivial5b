package igu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import logica.Jugada;

public class VentanaVolverATirar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JDialog v = this;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblFondo;
	private JLabel lblDado;
	private JTextArea txtMensaje;
	private Button btAceptar;
	private Jugada jugada;
	private VentanaTablero tablero;

	public VentanaVolverATirar(Jugada jugada, VentanaTablero tablero) {
		this.jugada = jugada;
		this.tablero = tablero;
		this.setUndecorated(true);
		setBounds(100, 100, 470, 320);
		getContentPane().setLayout(null);
		contentPanel.setLayout(null);
		this.setResizable(false);
		setModal(true);
		getContentPane().add(getLblDado());
		getContentPane().add(getTxtMensaje());
		getContentPane().add(getBtAceptar());

		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/img/logo.jpg"));
		this.setIconImage(icon);
		lblFondo = new JLabel();
		lblFondo.setText(null);
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(new Dimension(482, 329));
		ImageIcon img = new ImageIcon(getClass().getResource("/img/f1.jpg"));
		Icon fondo = new ImageIcon(img.getImage().getScaledInstance(
				lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));

		lblFondo.setIcon(fondo);
		getContentPane().add(lblFondo, null);
	}

	private JTextArea getTxtMensaje() {
		txtMensaje = new JTextArea();
		txtMensaje.setText("Continúa tu turno,\ntirando de nuevo.");
		txtMensaje.setBounds(204, 85, 186, 62);
		txtMensaje.setEditable(false);
		txtMensaje.setLineWrap(true);
		txtMensaje.setFont(new java.awt.Font("Candara", 3, 20));
		txtMensaje.setVisible(true);
		txtMensaje.setOpaque(false);
		txtMensaje.setBorder(null);
		txtMensaje.setForeground(Color.WHITE);
		return txtMensaje;
	}

	private JLabel getLblDado() {
		lblDado = new JLabel();
		lblDado.setBounds(45, 56, 126, 120);
		ImageIcon img = new ImageIcon();
		img = new ImageIcon(getClass().getResource("/img/dado.png"));
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(
				lblDado.getWidth(), lblDado.getHeight(), Image.SCALE_DEFAULT));
		lblDado.setIcon(icono);
		return lblDado;
	}

	private Button getBtAceptar() {
		btAceptar = new Button("Aceptar");
		btAceptar.setFont(new java.awt.Font("Candara", 3, 20));
		btAceptar.setBounds(199, 250, 100, 30);
		btAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jugada.siguienteTurno(true, tablero);
				v.dispose();
			}
		});
		btAceptar.setVisible(true);
		return btAceptar;
	}
}
