package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logica.Jugada;

public class Casilla extends JButton {

	private static final long serialVersionUID = 1L;
	private int categoria;
	private boolean especial;

	public Casilla() {
		super();
		especial = false;
	}

	public void cambiarEspecial() {
		this.especial = true;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public void action(final VentanaTablero tablero, final int i, final int j,
			final Jugada jugada) {
		if ((i == 0 && j == 4) || (i == 4 && j == 0) || (i == 4 && j == 8)
				|| (i == 8 && j == 4))
			return;
		else {
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int aux_i = jugada.getJugadorActivo().getI();
					int aux_j = jugada.getJugadorActivo().getJ();
					jugada.getJugadorActivo().setI(i);
					jugada.getJugadorActivo().setJ(j);
					tablero.quitarFicha(aux_i, aux_j);
					tablero.moverJugador(jugada.getJugadorActivo());
					VentanaPregunta v = new VentanaPregunta(categoria,
							especial, tablero, jugada);
					v.setVisible(true);
				}
			});
		}
	}

	public boolean isEspecial() {
		return especial;
	}
}
