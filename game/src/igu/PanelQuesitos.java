package igu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelQuesitos extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton boton1 = new JButton();
	private JButton boton2 = new JButton();
	private JButton boton3 = new JButton();
	private JButton boton4 = new JButton();

	public PanelQuesitos(int opcion) {
		setLayout(new GridLayout(2, 2, 0, 0));
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		visibles();
		colorQuesitos(opcion);
	}

	private void visibles() {
		boton1.setEnabled(false);
		boton2.setEnabled(false);
		boton4.setEnabled(false);
		boton4.setEnabled(false);
		boton1.setVisible(true);
		boton2.setVisible(true);
		boton3.setVisible(true);
		boton4.setVisible(true);
	}

	private void colorQuesitos(int opcion) {
		if (opcion == 1) {
			boton1.setBackground(Color.yellow);
			boton2.setBackground(Color.blue);
			boton3.setBackground(Color.green);
			boton4.setBackground(Color.magenta);
		} else {
			boton1.setBackground(Color.white);
			boton2.setBackground(Color.ORANGE);
			boton3.setBackground(Color.cyan);
			boton4.setBackground(Color.red);
		}
	}

	public void tickCategoria(int categoria) {
		switch (categoria) {
		case 1:
			boton1.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			boton1.setIcon(new ImageIcon(getClass()
					.getResource("/img/tick.png")));
			break;
		case 2:
			boton2.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			boton2.setIcon(new ImageIcon(getClass()
					.getResource("/img/tick.png")));
			break;
		case 3:
			boton3.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			boton3.setIcon(new ImageIcon(getClass()
					.getResource("/img/tick.png")));
			break;
		case 4:
			boton4.setDisabledIcon(new ImageIcon(getClass().getResource(
					"/img/tick.png")));
			boton4.setIcon(new ImageIcon(getClass()
					.getResource("/img/tick.png")));
			break;
		}
	}
}
