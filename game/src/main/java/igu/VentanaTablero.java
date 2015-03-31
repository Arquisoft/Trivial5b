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

import Logica.Juego;

public class VentanaTablero extends JFrame {

	private static final long serialVersionUID = 1L;

	private Juego juego;
	private JLabel lbFondo = null;
	private JPanel contentPane;
	private JPanel pnTablero;
	private JButton[][] tablero = null;
	private JButton[][] quesitos = null;
	private JButton btDado;
	private JTextField tfDado;
	private JPanel pnQuesito1;
	private JPanel pnQuesito2;
	private JPanel pnQuesito3;
	private JPanel pnQuesito4;
	private JLabel lbJugador1;
	private JLabel lbJugador2;
	private JLabel lbJugador3;
	private JLabel lbJugador4;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// VentanaTablero frame = new VentanaTablero();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public VentanaTablero(int numeroQueso) {
		
		// this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTablero.class.getResource("/img/logo.jpg")));
		juego = new Juego();
		juego.setNumeroJugadores(numeroQueso);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 693);
		contentPane = new JPanel();
		lbFondo = new JLabel();
		lbFondo.setLocation(0, 0);
		lbFondo.setSize(this.getSize());
		ImageIcon img = new ImageIcon(getClass().getResource("/img/f1.jpg"));
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
			tablero = new JButton[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					tablero[i][j] = new JButton();
					tablero[i][j].setActionCommand(i + "");
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
			btDado = new JButton("");
			btDado.setToolTipText("Click para lanzar el dado");
			btDado.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/dado.png")));
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					juego.tirarDado();
					tfDado.setText(String.valueOf(juego.getNumeroDado()));
				}
			});
			btDado.setIcon(new ImageIcon(getClass()
					.getResource("/img/dado.png")));
			btDado.setBounds(25, 11, 101, 114);
			btDado.setOpaque(false);
			btDado.setContentAreaFilled(false);
			btDado.setBorderPainted(false);
		}
		return btDado;
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

	private JPanel getPnQuesito1() {
		if (pnQuesito1 == null) {
			GridLayout gl_pnQuesito1 = new GridLayout();
			gl_pnQuesito1.setRows(2);
			gl_pnQuesito1.setColumns(2);
			pnQuesito1 = new JPanel();
			quesitos = new JButton[2][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					quesitos[i][j] = new JButton();
					quesitos[i][j].setActionCommand(i + "");
					pnQuesito1.add(quesitos[i][j]);
				}
			}
			colorQuesitos();
			pnQuesito1.setBounds(834, 54, 108, 108);
			pnQuesito1.setLayout(gl_pnQuesito1);
			pnQuesito1.setOpaque(false);
		}
		return pnQuesito1;
	}

	private JPanel getPnQuesito2() {
		if (pnQuesito2 == null) {
			GridLayout gl_pnQuesito2 = new GridLayout();
			gl_pnQuesito2.setColumns(2);
			gl_pnQuesito2.setRows(2);
			pnQuesito2 = new JPanel();
			quesitos = new JButton[2][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					quesitos[i][j] = new JButton();
					quesitos[i][j].setActionCommand(i + "");
					pnQuesito2.add(quesitos[i][j]);
				}
			}
			colorQuesitos();
			pnQuesito2.setOpaque(false);
			pnQuesito2.setBounds(834, 220, 108, 108);
			pnQuesito2.setLayout(gl_pnQuesito2);
		}
		return pnQuesito2;
	}

	private JPanel getPnQuesito3() {
		if (pnQuesito3 == null) {
			GridLayout gl_pnQuesito3 = new GridLayout();
			gl_pnQuesito3.setColumns(2);
			gl_pnQuesito3.setRows(2);
			pnQuesito3 = new JPanel();
			quesitos = new JButton[2][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					quesitos[i][j] = new JButton();
					quesitos[i][j].setActionCommand(i + "");
					pnQuesito3.add(quesitos[i][j]);
				}
			}
			colorQuesitos();
			pnQuesito3.setOpaque(false);
			pnQuesito3.setBounds(834, 385, 108, 108);
			pnQuesito3.setLayout(gl_pnQuesito3);
		}
		return pnQuesito3;
	}

	private JPanel getPnQuesito4() {
		if (pnQuesito4 == null) {
			GridLayout gl_pnQuesito4 = new GridLayout();
			gl_pnQuesito4.setColumns(2);
			gl_pnQuesito4.setRows(2);
			pnQuesito4 = new JPanel();
			quesitos = new JButton[2][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					quesitos[i][j] = new JButton();
					quesitos[i][j].setActionCommand(i + "");
					pnQuesito4.add(quesitos[i][j]);
				}
			}
			colorQuesitos();
			pnQuesito4.setOpaque(false);
			pnQuesito4.setBounds(834, 531, 108, 108);
			pnQuesito4.setLayout(gl_pnQuesito4);
		}
		return pnQuesito4;
	}

	private void colorQuesitos() {
		quesitos[0][0].setEnabled(false);
		quesitos[0][1].setEnabled(false);
		quesitos[1][0].setEnabled(false);
		quesitos[1][1].setEnabled(false);
		quesitos[0][0].setBackground(Color.blue);
		quesitos[0][1].setBackground(Color.green);
		quesitos[1][0].setBackground(Color.magenta);
		quesitos[1][1].setBackground(Color.yellow);
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
	
	public void deshabilitarBotones() {
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
	
		tablero[0][0].setBackground(Color.magenta);
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
		tablero[0][4].setIcon(new ImageIcon(getClass().getResource(
				"/img/dado1.png")));
		tablero[0][4].setOpaque(false);
		tablero[0][4].setContentAreaFilled(false);
		tablero[0][6].setBackground(Color.blue);
		tablero[0][8].setBackground(Color.blue);
		tablero[4][0].setIcon(new ImageIcon(getClass().getResource(
				"/img/dado1.png")));
		tablero[4][0].setOpaque(false);
		tablero[4][0].setContentAreaFilled(false);
		tablero[4][6].setBackground(Color.blue);
		tablero[4][8].setIcon(new ImageIcon(getClass().getResource(
				"/img/dado1.png")));
		tablero[4][8].setOpaque(false);
		tablero[4][8].setContentAreaFilled(false);
		tablero[5][4].setBackground(Color.blue);
		tablero[7][0].setBackground(Color.blue);
		tablero[7][8].setBackground(Color.blue);
		tablero[8][4].setIcon(new ImageIcon(getClass().getResource(
				"/img/dado1.png")));
		tablero[8][4].setOpaque(false);
		tablero[8][4].setContentAreaFilled(false);
		tablero[4][2].setBackground(Color.blue);
	
		tablero[4][4].setIcon(new ImageIcon(getClass().getResource(
				"/img/queso.PNG")));
		tablero[4][4].setOpaque(false);
		tablero[4][4].setContentAreaFilled(false);
		tablero[4][4].setBorderPainted(false);
	}

	public void mostrarQuesitos() {
		List<JPanel> paneles = new ArrayList<JPanel>();
		List<JLabel> labels = new ArrayList<JLabel>();
		
		paneles.add(getPnQuesito1());
		paneles.add(getPnQuesito2());
		paneles.add(getPnQuesito3());
		paneles.add(getPnQuesito4());
		
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
}
