package logica;

import igu.PanelQuesitos;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private int i, j;
	private PanelQuesitos panelJugador;
	private ArrayList<Boolean> categorias = new ArrayList<Boolean>();
	private int preguntas;

	public Jugador(String nombre, PanelQuesitos panel) {
		this.nombre = nombre;
		panelJugador = panel;
		for (int i = 0; i < 4; i++)
			categorias.add(false);
	}

	public PanelQuesitos getPanelJugador() {
		return panelJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void setCategoria(int categoria) {
		categorias.set(categoria - 1, true);
		panelJugador.tickCategoria(categoria);
	}

	public int getPreguntas() {
		return preguntas;
	}

	public void setPregunta(int preguntas) {
		this.preguntas = preguntas;
	}

	public boolean comprobarGanador() {
		for (Boolean x : categorias) {
			if (x == false)
				return false;
		}
		return true;
	}

}
