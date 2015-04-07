package igu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import logica.Jugada;
import logica.Question;

public class VentanaPregunta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JDialog v = this;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblFondo;
	private JLabel lblIcono;
	private JTextArea txtPregunta;
	private JButton btRespuesta1;
	private JButton btRespuesta2;
	private JButton btRespuesta3;
	private Button btAtras;
	private VentanaTablero tablero;
	private Jugada jugada;
	private int categoria;
	private Question pregunta = new Question();
	private boolean acertada = false;

	public VentanaPregunta(int categoria, boolean especial,
			VentanaTablero tablero, Jugada jugada) {
		this.setUndecorated(true);
		tablero.pintarJugadores();
		this.categoria = categoria;
		this.jugada = jugada;
		setBounds(100, 100, 470, 320);
		getContentPane().setLayout(null);
		contentPanel.setLayout(null);
		this.setResizable(false);
		setModal(true);
		this.tablero = tablero;

		pregunta = pregunta.getPregunta(categoria);

		getContentPane().add(getLblIcono(categoria));
		getContentPane().add(getTxtAreaPregunta());
		getContentPane().add(getBtRespuesta1());
		getContentPane().add(getBtRespuesta2());
		getContentPane().add(getBtRespuesta3());
		getContentPane().add(getBtAtras());

		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/img/logo.jpg"));
		this.setIconImage(icon);
		lblFondo = new JLabel();
		lblFondo.setText(null);
		lblFondo.setLocation(0, 0);
		lblFondo.setSize(new Dimension(482, 329));
		ImageIcon img = new ImageIcon(getClass()
				.getResource("/img/tarjeta.jpg"));
		Icon fondo = new ImageIcon(img.getImage().getScaledInstance(
				lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(fondo);
		getContentPane().add(lblFondo, null);
	}

	private Button getBtAtras() {
		btAtras = new Button("Atrás");
		btAtras.setBounds(199, 281, 89, 23);
		btAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jugada.getJugadorActivo().setPregunta(
						jugada.getJugadorActivo().getPreguntas() + 1);
				if (jugada.getJugadorActivo().getPreguntas() % 4 == 0) {
					jugada.getJugadorActivo().setCategoria(categoria);
				}
				if (jugada.getJugadorActivo().comprobarGanador()) {
					VentanaGanador ganador = new VentanaGanador(jugada
							.getJugadorActivo());
					tablero.dispose();
					v.dispose();
					ganador.setVisible(true);
				}
				jugada.siguienteTurno(acertada, tablero);
				v.dispose();
			}
		});
		btAtras.setVisible(false);
		return btAtras;
	}

	private JButton getBtRespuesta1() {
		btRespuesta1 = new JButton();
		btRespuesta1.setBounds(52, 159, 379, 35);
		btRespuesta1.setVisible(true);
		btRespuesta1.setText(pregunta.getCorrectAnswer());
		btRespuesta1.setFont(new java.awt.Font("Candara", 0, 11));
		btRespuesta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btRespuesta1.setBackground(Color.green);
				btRespuesta2.setBackground(Color.red);
				btRespuesta3.setBackground(Color.red);
				acertada = true;
				btAtras.setVisible(true);
			}
		});
		return btRespuesta1;
	}

	private JButton getBtRespuesta2() {
		btRespuesta2 = new JButton();
		btRespuesta2.setBounds(52, 197, 379, 35);
		btRespuesta2.setVisible(true);
		btRespuesta2.setText(pregunta.getWrongAnswers().get(0));
		btRespuesta2.setFont(new java.awt.Font("Candara", 0, 11));
		btRespuesta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btRespuesta1.setBackground(Color.green);
				btRespuesta2.setBackground(Color.red);
				btRespuesta3.setBackground(Color.red);
				acertada = false;
				btAtras.setVisible(true);
			}
		});
		return btRespuesta2;
	}

	private JButton getBtRespuesta3() {
		btRespuesta3 = new JButton();
		btRespuesta3.setBounds(52, 235, 379, 35);
		btRespuesta3.setVisible(true);
		btRespuesta3.setText(pregunta.getWrongAnswers().get(1));
		btRespuesta3.setFont(new java.awt.Font("Candara", 0, 11));
		btRespuesta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btRespuesta1.setBackground(Color.green);
				btRespuesta2.setBackground(Color.red);
				btRespuesta3.setBackground(Color.red);
				acertada = false;
				btAtras.setVisible(true);
			}
		});
		return btRespuesta3;
	}

	private JTextArea getTxtAreaPregunta() {
		txtPregunta = new JTextArea();
		txtPregunta.setText(pregunta.getText());
		txtPregunta.setEditable(false);
		txtPregunta.setLineWrap(true);
		txtPregunta.setBounds(184, 68, 234, 57);
		txtPregunta.setFont(new java.awt.Font("Candara", 2, 14));
		txtPregunta.setVisible(true);
		return txtPregunta;
	}

	private JLabel getLblIcono(int categoria) {
		lblIcono = new JLabel();
		lblIcono.setBounds(52, 47, 112, 106);
		lblIcono.setText(null);
		ImageIcon img = new ImageIcon();
		switch (categoria) {
		case 1:
			img = new ImageIcon(getClass().getResource("/img/cat1.jpg"));
			break;
		case 2:
			img = new ImageIcon(getClass().getResource("/img/cat2.jpg"));
			break;
		case 3:
			img = new ImageIcon(getClass().getResource("/img/cat3.jpg"));
			break;
		case 4:
			img = new ImageIcon(getClass().getResource("/img/cat4.jpg"));
			break;
		}
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(
				lblIcono.getWidth(), lblIcono.getHeight(), Image.SCALE_DEFAULT));
		lblIcono.setIcon(icono);
		return lblIcono;
	}
}
