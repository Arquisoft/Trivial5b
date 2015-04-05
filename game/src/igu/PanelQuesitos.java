package igu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelQuesitos extends JPanel {
	private static final long serialVersionUID = 1L;
	// private JPanel quesitos;
	private JButton btAmarillo = new JButton();
	private JButton btAzul = new JButton();
	private JButton btVerde = new JButton();
	private JButton btRosa = new JButton();

	public PanelQuesitos() {
		setLayout(new GridLayout(2, 2, 0, 0));
		this.add(btAmarillo);
		this.add(btAzul);
		this.add(btVerde);
		this.add(btRosa);
		colorQuesitos();
	}

	private void colorQuesitos() {
		btAmarillo.setEnabled(false);
		btAzul.setEnabled(false);
		btVerde.setEnabled(false);
		btRosa.setEnabled(false);
		btAmarillo.setBackground(Color.yellow);
		btAzul.setBackground(Color.blue);
		btVerde.setBackground(Color.green);
		btRosa.setBackground(Color.magenta);
		btAmarillo.setVisible(true);
		btAzul.setVisible(true);
		btVerde.setVisible(true);
		btRosa.setVisible(true);
	}

	public void tickCategoria(int categoria) {
		System.out.println("VOY A PONER EL TICK EN LA CATEGORIA " + categoria);
		switch (categoria) {
		case 1:
			btAmarillo.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			btAmarillo.setIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			break;
		case 2:
			btAzul.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			btAzul.setIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			break;
		case 3:
			btVerde.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			btVerde.setIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			break;
		case 4:
			btRosa.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			btRosa.setIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			break;
		}
	}
}
