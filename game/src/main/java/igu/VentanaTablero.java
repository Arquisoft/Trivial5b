package igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.Juego;
import logica.Jugada;
import logica.Jugador;
import logica.Par;

public class VentanaTablero extends JFrame {

	private static final long serialVersionUID = 1L;

	private VentanaTablero v = this;
	private Juego juego = new Juego();
	private JLabel lbFondo = null;
	private JPanel contentPane;
	private JPanel pnTablero;
	private Casilla[][] tablero = null;
	private JButton btDado;
	private JTextField tfDado;
	private PanelQuesitos quesitos1 = new PanelQuesitos();
	private PanelQuesitos quesitos2 = new PanelQuesitos();
	private PanelQuesitos quesitos3 = new PanelQuesitos();
	private PanelQuesitos quesitos4 = new PanelQuesitos();
	private JLabel lbJugador1;
	private JLabel lbJugador2;
	private JLabel lbJugador3;
	private JLabel lbJugador4;
	private Jugada jugada = new Jugada();
	private JLabel lblTurno;
	private JTextField txtJugador;
	private VentanaTablero ventana = this;
	private List<JPanel> paneles;
	private int opcion;

	public VentanaTablero(int numeroQueso, int opcion) {
		this.opcion = opcion;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaTablero.class.getResource("/img/logo.jpg")));
		juego.setNumeroJugadores(numeroQueso);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 693);
		contentPane = new JPanel();
		lbFondo = new JLabel();
		lbFondo.setLocation(0, 0);
		lbFondo.setSize(this.getSize());
		ImageIcon img = new ImageIcon();
		if (opcion == 1)
			img = new ImageIcon(getClass().getResource("/img/f1.jpg"));
		if (opcion == 2)
			img = new ImageIcon(getClass().getResource("/img/f2.jpg"));
		Icon icono = new ImageIcon(img.getImage().getScaledInstance(
				lbFondo.getWidth(), lbFondo.getHeight(), Image.SCALE_DEFAULT));
		lbFondo.setIcon(icono);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnTablero());
		contentPane.add(getBtDado());
		contentPane.add(getTfDado());
		mostrarQuesitos();
		contentPane.add(getLblTurno());
		colocarJugadores();
		contentPane.add(lbFondo, null);
		this.setLocationRelativeTo(null);
	}

	private JPanel getPnTablero() {
		if (pnTablero == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(9);
			gridLayout.setColumns(9);
			pnTablero = new JPanel();
			pnTablero.setOpaque(false);
			tablero = new Casilla[9][9];
			jugada.addJugador(new Jugador("Jugador 1", quesitos1));
			jugada.setJugadorActivo(jugada.getJugadores().get(0));
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					tablero[i][j] = new Casilla();
					tablero[i][j].setActionCommand(i + "");
					tablero[i][j].action(v, i, j, jugada, opcion);
					tablero[i][j].setEnabled(false);
					pnTablero.add(tablero[i][j]);
				}
			}
			deshabilitarBotones();
			pnTablero.setVisible(true);
			pnTablero.setLayout(gridLayout);
			pnTablero.setBounds(new Rectangle(247, 54, 551, 551));
		}
		return pnTablero;
	}

	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setToolTipText("Click para lanzar el dado");
			if (opcion == 1)
				btDado.setDisabledIcon(new ImageIcon(getClass().getResource(
						"/img/azul.gif")));
			else if (opcion == 2)
				btDado.setDisabledIcon(new ImageIcon(getClass().getResource(
						"/img/rojo.gif")));
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pintarJugadores();
					juego.tirarDado();
					tfDado.setText(String.valueOf(juego.getNumeroDado()));
					activarCasillas(juego.getNumeroDado());
					btDado.setEnabled(false);
					tablero[jugada.getJugadorActivo().getI()][jugada
							.getJugadorActivo().getJ()].setEnabled(true);
				}
			});
			if (opcion == 1)
				btDado.setIcon(new ImageIcon(getClass().getResource(
						"/img/azul.gif")));
			else if (opcion == 2)
				btDado.setIcon(new ImageIcon(getClass().getResource(
						"/img/rojo.gif")));
			btDado.setBounds(25, 11, 101, 114);
			btDado.setOpaque(false);
			btDado.setContentAreaFilled(false);
			btDado.setBorderPainted(false);
		}
		return btDado;
	}

	private void activarCasillas(int dado) {
		ArrayList<Par> lista = jugada.activar(dado);
		for (Par par : lista) {
			tablero[par.getI()][par.getJ()].setEnabled(true);
		}
		tablero[jugada.getJugadorActivo().getI()][jugada.getJugadorActivo()
				.getJ()].setEnabled(false);
	}

	private JTextField getTfDado() {
		if (tfDado == null) {
			tfDado = new JTextField();
			tfDado.setForeground(Color.WHITE);
			tfDado.setEditable(false);
			tfDado.setHorizontalAlignment(SwingConstants.CENTER);
			tfDado.setFont(new Font("Forte", Font.PLAIN, 70));
			tfDado.setText(String.valueOf(juego.getNumeroDado()));
			tfDado.setBounds(136, 11, 101, 114);
			tfDado.setColumns(10);
			tfDado.setOpaque(false);
			tfDado.setBorder(null);
		}
		return tfDado;
	}

	private PanelQuesitos getQuesitos1() {
		quesitos1.setOpcion(opcion);
		quesitos1.setBounds(834, 54, 108, 108);
		quesitos1.setVisible(true);
		return quesitos1;
	}

	private PanelQuesitos getQuesitos2() {
		quesitos2.setOpcion(opcion);
		quesitos2.setBounds(834, 220, 108, 108);
		quesitos2.setVisible(true);
		return quesitos2;
	}

	private PanelQuesitos getQuesitos3() {
		quesitos3.setOpcion(opcion);
		quesitos3.setBounds(834, 385, 108, 108);
		quesitos3.setVisible(true);
		return quesitos3;
	}

	private PanelQuesitos getQuesitos4() {
		quesitos4.setOpcion(opcion);
		quesitos4.setBounds(834, 531, 108, 108);
		quesitos4.setVisible(true);
		return quesitos4;
	}

	private JLabel getLbJugador1() {
		if (lbJugador1 == null) {
			lbJugador1 = new JLabel("     Jugador 1");
			lbJugador1.setFont(new Font("Candara", Font.BOLD, 16));
			lbJugador1.setForeground(Color.WHITE);
			lbJugador1.setBounds(834, 26, 109, 20);
		}
		return lbJugador1;
	}

	private JLabel getLbJugador2() {
		if (lbJugador2 == null) {
			lbJugador2 = new JLabel("     Jugador 2");
			lbJugador2.setFont(new Font("Candara", Font.BOLD, 16));
			lbJugador2.setForeground(Color.WHITE);
			lbJugador2.setBounds(834, 189, 108, 20);
		}
		return lbJugador2;
	}

	private JLabel getLbJugador3() {
		if (lbJugador3 == null) {
			lbJugador3 = new JLabel("     Jugador 3");
			lbJugador3.setForeground(Color.WHITE);
			lbJugador3.setFont(new Font("Candara", Font.BOLD, 16));
			lbJugador3.setBounds(834, 354, 112, 20);
		}
		return lbJugador3;
	}

	private JLabel getLbJugador4() {
		if (lbJugador4 == null) {
			lbJugador4 = new JLabel("     Jugador 4");
			lbJugador4.setFont(new Font("Candara", Font.BOLD, 16));
			lbJugador4.setForeground(Color.WHITE);
			lbJugador4.setBounds(834, 506, 108, 20);
		}
		return lbJugador4;
	}

	private void deshabilitarBotones() {
		hacerInvisibles();
		categorizar();
		colorear();

		tablero[0][4].setIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[0][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaVolverATirar(jugada, ventana);
			}
		});
		tablero[0][4].setDisabledIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[0][4].setOpaque(false);
		tablero[0][4].setContentAreaFilled(false);

		tablero[4][0].setIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[4][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaVolverATirar(jugada, ventana);
			}
		});
		tablero[4][0].setDisabledIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[4][0].setOpaque(false);
		tablero[4][0].setContentAreaFilled(false);

		tablero[4][8].setIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[4][8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaVolverATirar(jugada, ventana);
				
			}
		});
		tablero[4][8].setDisabledIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[4][8].setOpaque(false);
		tablero[4][8].setContentAreaFilled(false);

		tablero[8][4].setIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[8][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaVolverATirar(jugada, ventana);
			}
		});
		tablero[8][4].setDisabledIcon(new ImageIcon(getClass().getResource(
				"/img/girando.gif")));
		tablero[8][4].setOpaque(false);
		tablero[8][4].setContentAreaFilled(false);

		tablero[4][4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaVolverATirar(jugada, ventana);
			}
		});
		if (opcion == 1) {
			tablero[4][4].setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/queso.png")));
			tablero[4][4].setIcon(new ImageIcon(getClass().getResource(
					"/img/queso.PNG")));
		} else if (opcion == 2) {
			tablero[4][4].setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/queso1.png")));
			tablero[4][4].setIcon(new ImageIcon(getClass().getResource(
					"/img/queso1.PNG")));
		}
		tablero[4][4].setOpaque(false);
		tablero[4][4].setContentAreaFilled(false);
		tablero[4][4].setEnabled(false);
	}

	private void colorear() {
		if (opcion == 1) {
			tablero[0][0].setBackground(Color.magenta);
			tablero[0][6].setBackground(Color.magenta);
			tablero[1][4].setBackground(Color.magenta);
			tablero[3][0].setBackground(Color.magenta);
			tablero[4][1].setBackground(Color.magenta);
			tablero[4][5].setBackground(Color.magenta);
			tablero[5][8].setBackground(Color.magenta);
			tablero[6][0].setBackground(Color.magenta);
			tablero[7][4].setBackground(Color.magenta);
			tablero[8][2].setBackground(Color.magenta);
			tablero[8][7].setBackground(Color.magenta);
			tablero[0][2].setBackground(Color.YELLOW);
			tablero[0][5].setBackground(Color.YELLOW);
			tablero[1][8].setBackground(Color.YELLOW);
			tablero[2][0].setBackground(Color.YELLOW);
			tablero[4][7].setBackground(Color.YELLOW);
			tablero[5][0].setBackground(Color.YELLOW);
			tablero[6][8].setBackground(Color.YELLOW);
			tablero[8][0].setBackground(Color.YELLOW);
			tablero[8][3].setBackground(Color.YELLOW);
			tablero[8][6].setBackground(Color.YELLOW);
			tablero[0][3].setBackground(Color.green);
			tablero[0][7].setBackground(Color.green);
			tablero[1][0].setBackground(Color.green);
			tablero[2][4].setBackground(Color.green);
			tablero[3][8].setBackground(Color.green);
			tablero[4][3].setBackground(Color.green);
			tablero[4][6].setBackground(Color.green);
			tablero[6][4].setBackground(Color.green);
			tablero[8][5].setBackground(Color.green);
			tablero[8][8].setBackground(Color.green);
			tablero[3][4].setBackground(Color.blue);
			tablero[8][1].setBackground(Color.blue);
			tablero[2][8].setBackground(Color.blue);
			tablero[0][1].setBackground(Color.blue);
			tablero[0][8].setBackground(Color.blue);
			tablero[4][2].setBackground(Color.blue);
			tablero[4][6].setBackground(Color.blue);
			tablero[5][4].setBackground(Color.blue);
			tablero[7][0].setBackground(Color.blue);
			tablero[7][8].setBackground(Color.blue);
		} else if (opcion == 2) {
			tablero[0][0].setBackground(Color.red);
			tablero[0][6].setBackground(Color.red);
			tablero[1][4].setBackground(Color.red);
			tablero[3][0].setBackground(Color.red);
			tablero[4][1].setBackground(Color.red);
			tablero[4][5].setBackground(Color.red);
			tablero[5][8].setBackground(Color.red);
			tablero[6][0].setBackground(Color.red);
			tablero[7][4].setBackground(Color.red);
			tablero[8][2].setBackground(Color.red);
			tablero[8][7].setBackground(Color.red);
			tablero[0][2].setBackground(Color.white);
			tablero[0][5].setBackground(Color.white);
			tablero[1][8].setBackground(Color.white);
			tablero[2][0].setBackground(Color.white);
			tablero[4][7].setBackground(Color.white);
			tablero[5][0].setBackground(Color.white);
			tablero[6][8].setBackground(Color.white);
			tablero[8][0].setBackground(Color.white);
			tablero[8][3].setBackground(Color.white);
			tablero[8][6].setBackground(Color.white);
			tablero[0][3].setBackground(Color.cyan);
			tablero[0][7].setBackground(Color.cyan);
			tablero[1][0].setBackground(Color.cyan);
			tablero[2][4].setBackground(Color.cyan);
			tablero[3][8].setBackground(Color.cyan);
			tablero[4][3].setBackground(Color.cyan);
			tablero[4][6].setBackground(Color.cyan);
			tablero[6][4].setBackground(Color.cyan);
			tablero[8][5].setBackground(Color.cyan);
			tablero[8][8].setBackground(Color.cyan);
			tablero[3][4].setBackground(Color.orange);
			tablero[8][1].setBackground(Color.orange);
			tablero[2][8].setBackground(Color.orange);
			tablero[0][1].setBackground(Color.orange);
			tablero[0][8].setBackground(Color.orange);
			tablero[4][2].setBackground(Color.orange);
			tablero[4][6].setBackground(Color.orange);
			tablero[5][4].setBackground(Color.orange);
			tablero[7][0].setBackground(Color.orange);
			tablero[7][8].setBackground(Color.orange);
		}
	}

	private void categorizar() {
		tablero[8][6].setCategoria(1);
		tablero[8][3].setCategoria(1);
		tablero[8][0].setCategoria(1);
		tablero[6][8].setCategoria(1);
		tablero[5][0].setCategoria(1);
		tablero[4][7].setCategoria(1);
		tablero[2][0].setCategoria(1);
		tablero[1][8].setCategoria(1);
		tablero[0][5].setCategoria(1);
		tablero[0][2].setCategoria(1);

		tablero[4][2].setCategoria(2);
		tablero[5][4].setCategoria(2);
		tablero[4][6].setCategoria(2);
		tablero[0][8].setCategoria(2);
		tablero[0][1].setCategoria(2);
		tablero[2][8].setCategoria(2);
		tablero[8][1].setCategoria(2);
		tablero[3][4].setCategoria(2);
		tablero[7][0].setCategoria(2);
		tablero[7][8].setCategoria(2);

		tablero[8][8].setCategoria(3);
		tablero[8][5].setCategoria(3);
		tablero[6][4].setCategoria(3);
		tablero[4][6].setCategoria(3);
		tablero[4][3].setCategoria(3);
		tablero[3][8].setCategoria(3);
		tablero[2][4].setCategoria(3);
		tablero[1][0].setCategoria(3);
		tablero[0][7].setCategoria(3);
		tablero[0][3].setCategoria(3);

		tablero[8][7].setCategoria(4);
		tablero[8][2].setCategoria(4);
		tablero[7][4].setCategoria(4);
		tablero[6][0].setCategoria(4);
		tablero[5][8].setCategoria(4);
		tablero[4][5].setCategoria(4);
		tablero[4][1].setCategoria(4);
		tablero[3][0].setCategoria(4);
		tablero[1][4].setCategoria(4);
		tablero[0][6].setCategoria(4);
		tablero[0][0].setCategoria(4);
	}

	private void hacerInvisibles() {
		tablero[1][1].setVisible(false);
		tablero[2][1].setVisible(false);
		tablero[3][1].setVisible(false);
		tablero[1][2].setVisible(false);
		tablero[2][2].setVisible(false);
		tablero[3][2].setVisible(false);
		tablero[1][3].setVisible(false);
		tablero[2][3].setVisible(false);
		tablero[3][3].setVisible(false);
		tablero[1][5].setVisible(false);
		tablero[2][5].setVisible(false);
		tablero[3][5].setVisible(false);
		tablero[1][6].setVisible(false);
		tablero[2][6].setVisible(false);
		tablero[3][6].setVisible(false);
		tablero[1][7].setVisible(false);
		tablero[2][7].setVisible(false);
		tablero[3][7].setVisible(false);

		tablero[5][1].setVisible(false);
		tablero[6][1].setVisible(false);
		tablero[7][1].setVisible(false);
		tablero[5][2].setVisible(false);
		tablero[6][2].setVisible(false);
		tablero[7][2].setVisible(false);
		tablero[5][3].setVisible(false);
		tablero[6][3].setVisible(false);
		tablero[7][3].setVisible(false);
		tablero[5][5].setVisible(false);
		tablero[6][5].setVisible(false);
		tablero[7][5].setVisible(false);
		tablero[5][6].setVisible(false);
		tablero[6][6].setVisible(false);
		tablero[7][6].setVisible(false);
		tablero[5][7].setVisible(false);
		tablero[6][7].setVisible(false);
		tablero[7][7].setVisible(false);
	}

	private void mostrarQuesitos() {
		paneles = new ArrayList<>();
		List<JLabel> labels = new ArrayList<>();
		paneles.add(getQuesitos1());
		paneles.add(getQuesitos2());
		paneles.add(getQuesitos3());
		paneles.add(getQuesitos4());
		labels.add(getLbJugador1());
		labels.add(getLbJugador2());
		labels.add(getLbJugador3());
		labels.add(getLbJugador4());
		for (int i = 0; i < juego.getNumeroJugadores(); i++) {
			contentPane.add(paneles.get(i));
			contentPane.add(labels.get(i));
			paneles.get(i).setVisible(true);
			labels.get(i).setVisible(true);
		}
	}

	private void colocarJugadores() {
		tablero[0][4].setIcon(new ImageIcon(getClass().getResource(
				"/img/jugador1.png")));
		tablero[0][4].setEnabled(true);
		jugada.getJugadores().get(0).setI(0);
		jugada.getJugadores().get(0).setJ(4);
		if (juego.getNumeroJugadores() > 1) {
			tablero[8][4].setIcon(new ImageIcon(getClass().getResource(
					"/img/jugador2.png")));
			tablero[8][4].setEnabled(true);
			jugada.addJugador(new Jugador("Jugador 2", quesitos2));
			jugada.getJugadores().get(1).setI(8);
			jugada.getJugadores().get(1).setJ(4);
		}
		if (juego.getNumeroJugadores() > 2) {
			tablero[4][0].setIcon(new ImageIcon(getClass().getResource(
					"/img/jugador3.png")));
			tablero[4][0].setEnabled(true);
			jugada.getJugadores().add(new Jugador("Jugador 3", quesitos3));
			jugada.getJugadores().get(2).setI(4);
			jugada.getJugadores().get(2).setJ(0);
		}
		if (juego.getNumeroJugadores() > 3) {
			tablero[4][8].setIcon(new ImageIcon(getClass().getResource(
					"/img/jugador4.png")));
			tablero[4][8].setEnabled(true);
			jugada.addJugador(new Jugador("Jugador 4", quesitos4));
			jugada.getJugadores().get(3).setI(4);
			jugada.getJugadores().get(3).setJ(8);
		}
		contentPane.add(getTxtJugador());
	}

	public void siguienteTurno() {
		deshabilitarBotones();
		ventana.pintarJugadores();
		txtJugador.setText(jugada.getJugadorActivo().getNombre());
		btDado.setEnabled(true);

	}

	private JLabel getLblTurno() {
		if (lblTurno == null) {
			lblTurno = new JLabel("Turno de:");
			lblTurno.setBounds(25, 136, 94, 56);
			lblTurno.setForeground(Color.WHITE);
			lblTurno.setFont(new Font("Candara", Font.BOLD, 20));
		}
		return lblTurno;
	}

	private JTextField getTxtJugador() {
		txtJugador = new JTextField();
		txtJugador.setText(jugada.getJugadorActivo().getNombre());
		txtJugador.setBounds(129, 155, 86, 20);
		txtJugador.setColumns(10);
		txtJugador.setEditable(false);
		txtJugador.setFont(new Font("Candara", Font.BOLD, 20));
		txtJugador.setOpaque(false);
		txtJugador.setVisible(true);
		txtJugador.setForeground(Color.white);
		txtJugador.setBorder(null);
		return txtJugador;
	}

	public void moverJugador(Jugador activo) {
		switch (activo.getNombre()) {
		case "Jugador 1":
			tablero[activo.getI()][activo.getJ()].setIcon(new ImageIcon(
					getClass().getResource("/img/jugador1.png")));
			break;
		case "Jugador 2":
			tablero[activo.getI()][activo.getJ()].setIcon(new ImageIcon(
					getClass().getResource("/img/jugador2.png")));
			break;
		case "Jugador 3":
			tablero[activo.getI()][activo.getJ()].setIcon(new ImageIcon(
					getClass().getResource("/img/jugador3.png")));
			break;
		case "Jugador 4":
			tablero[activo.getI()][activo.getJ()].setIcon(new ImageIcon(
					getClass().getResource("/img/jugador4.png")));
			break;
		}
		inhabilitar();
	}

	private void inhabilitar() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tablero[i][j].setEnabled(false);
			}
		}
		tablero[jugada.getJugadorActivo().getI()][jugada.getJugadorActivo()
				.getJ()].setEnabled(true);
	}

	public void quitarFicha(int i, int j) {
		tablero[i][j].setIcon(null);
	}

	public void pintarJugadores() {
		if (jugada.getJugadores().size() < 0) {
			if (jugada.getJugadores().get(0) != null) {
				tablero[jugada.getJugadores().get(0).getI()][jugada
						.getJugadores().get(0).getJ()].setIcon(new ImageIcon(
						getClass().getResource("/img/jugador1.png")));
				tablero[jugada.getJugadores().get(0).getI()][jugada
						.getJugadores().get(0).getJ()]
						.setDisabledIcon(new ImageIcon(getClass().getResource(
								"/img/jugador1.png")));
			}
		}
		if (jugada.getJugadores().size() > 1) {
			if (jugada.getJugadores().get(1) != null) {
				tablero[jugada.getJugadores().get(1).getI()][jugada
						.getJugadores().get(1).getJ()].setIcon(new ImageIcon(
						getClass().getResource("/img/jugador2.png")));
				tablero[jugada.getJugadores().get(1).getI()][jugada
						.getJugadores().get(1).getJ()]
						.setDisabledIcon(new ImageIcon(getClass().getResource(
								"/img/jugador2.png")));
			}
		}
		if (jugada.getJugadores().size() > 2) {
			if (jugada.getJugadores().get(2) != null) {
				tablero[jugada.getJugadores().get(2).getI()][jugada
						.getJugadores().get(2).getJ()].setIcon(new ImageIcon(
						getClass().getResource("/img/jugador3.png")));
				tablero[jugada.getJugadores().get(2).getI()][jugada
						.getJugadores().get(2).getJ()]
						.setDisabledIcon(new ImageIcon(getClass().getResource(
								"/img/jugador3.png")));
			}
		}
		if (jugada.getJugadores().size() > 3) {
			if (jugada.getJugadores().get(3) != null) {
				tablero[jugada.getJugadores().get(3).getI()][jugada
						.getJugadores().get(3).getJ()].setIcon(new ImageIcon(
						getClass().getResource("/img/jugador4.png")));
				tablero[jugada.getJugadores().get(3).getI()][jugada
						.getJugadores().get(3).getJ()]
						.setDisabledIcon(new ImageIcon(getClass().getResource(
								"/img/jugador4.png")));
			}
		}
	}
}
