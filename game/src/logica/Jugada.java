package logica;

import igu.VentanaTablero;

import java.util.ArrayList;

public class Jugada {

	private static Jugador jugadorActivo;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	public Jugador getJugadorActivo() {
		return jugadorActivo;
	}

	public void setJugadorActivo(Jugador jugador) {
		jugadorActivo = jugador;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void siguienteJugador() {
		if (jugadores.get(jugadores.size() - 1).equals(jugadorActivo))
			setJugadorActivo(jugadores.get(0));
		else
			setJugadorActivo(jugadores
					.get(jugadores.indexOf(jugadorActivo) + 1));
	}

	public void addJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public void siguienteTurno(boolean acierto, VentanaTablero ventana) {
		ventana.pintarJugadores();
		if (!acierto)
			siguienteJugador();
		ventana.siguienteTurno();
	}

	public ArrayList<Par> activar(int dado) {
		ArrayList<Par> lista = new ArrayList<Par>();
		int i = jugadorActivo.getI();
		int j = jugadorActivo.getJ();
		if (i == 0 && j == 0) {
			lista.add(new Par(i + dado, j));
			lista.add(new Par(i, j + dado));
			switch (dado) {
			case 5:
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 1));
				break;
			case 6:
				lista.add(new Par(4, 2));
				lista.add(new Par(2, 4));
				break;
			}
		}
		if (i == 8 && j == 0) {
			lista.add(new Par(i - dado, j));
			lista.add(new Par(i, j + dado));
			switch (dado) {
			case 5:
				lista.add(new Par(4, 1));
				lista.add(new Par(7, 4));
				break;
			case 6:
				lista.add(new Par(4, 2));
				lista.add(new Par(6, 4));
				break;
			}
		}
		if (i == 0 && j == 8) {
			lista.add(new Par(i + dado, j));
			lista.add(new Par(i, j - dado));
			switch (dado) {
			case 5:
				lista.add(new Par(4, 1));
				lista.add(new Par(7, 4));
				break;
			case 6:
				lista.add(new Par(4, 2));
				lista.add(new Par(4, 6));
				break;
			}
		}
		if (i == 8 && j == 8) {
			lista.add(new Par(i - dado, j));
			lista.add(new Par(i, j - dado));
			switch (dado) {
			case 5:
				lista.add(new Par(4, 7));
				lista.add(new Par(7, 4));
				break;
			case 6:
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			}
		}
		if (i == 0 && j == 4) {
			if (dado <= 4) {
				lista.add(new Par(i, j - dado));
				lista.add(new Par(i, j + dado));
				lista.add(new Par(i + dado, j));
			} else {
				switch (dado) {
				case 5:
					lista.add(new Par(1, 0));
					lista.add(new Par(4, 3));
					lista.add(new Par(5, 4));
					lista.add(new Par(4, 5));
					lista.add(new Par(1, 8));
					break;
				case 6:
					lista.add(new Par(2, 0));
					lista.add(new Par(4, 2));
					lista.add(new Par(6, 4));
					lista.add(new Par(4, 6));
					lista.add(new Par(2, 8));
					break;
				}
			}
		}
		if (i == 1 && j == 1) {
			switch (dado) {
			case 1:
				lista.add(new Par(i, j - 1));
				lista.add(new Par(i, j + 1));
				break;
			case 2:
				lista.add(new Par(1, 0));
				lista.add(new Par(0, 3));
				break;
			case 3:
				lista.add(new Par(0, 4));
				lista.add(new Par(2, 0));
				break;
			case 4:
				lista.add(new Par(0, 5));
				lista.add(new Par(2, 4));
				lista.add(new Par(3, 0));
				break;
			case 5:
				lista.add(new Par(0, 6));
				lista.add(new Par(4, 0));
				lista.add(new Par(2, 4));
				break;
			case 6:
				lista.add(new Par(5, 0));
				lista.add(new Par(4, 1));
				lista.add(new Par(3, 4));
				lista.add(new Par(0, 7));
				break;
			}
		}
		if (i == 0 && j == 2) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i, j - dado));
				lista.add(new Par(i, j + dado));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(1, 0));
				lista.add(new Par(1, 4));
				break;
			case 4:
				lista.add(new Par(2, 0));
				lista.add(new Par(2, 4));
				lista.add(new Par(0, 6));
				break;
			case 5:
				lista.add(new Par(3, 0));
				lista.add(new Par(3, 4));
				break;
			case 6:
				lista.add(new Par(4, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(0, 8));
				break;
			}
		}
		if (i == 0 && j == 3) {
			switch (dado) {
			case 1:
				lista.add(new Par(0, 2));
				lista.add(new Par(0, 4));
				break;
			case 2:
				lista.add(new Par(0, 1));
				lista.add(new Par(0, 5));
				lista.add(new Par(1, 4));
				break;
			case 3:
				lista.add(new Par(0, 0));
				lista.add(new Par(0, 6));
				lista.add(new Par(2, 4));
				break;
			case 4:
				lista.add(new Par(1, 0));
				lista.add(new Par(3, 4));
				lista.add(new Par(0, 7));
				break;
			case 5:
				lista.add(new Par(2, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(0, 8));
				break;
			case 6:
				lista.add(new Par(3, 0));
				lista.add(new Par(4, 2));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				lista.add(new Par(1, 8));
				break;
			}
		}
		if (i == 0 && j == 5) {
			switch (dado) {
			case 1:
				lista.add(new Par(0, 4));
				lista.add(new Par(0, 6));
				break;
			case 2:
				lista.add(new Par(0, 3));
				lista.add(new Par(0, 7));
				lista.add(new Par(1, 4));
				break;
			case 3:
				lista.add(new Par(0, 8));
				lista.add(new Par(0, 2));
				lista.add(new Par(2, 4));
				break;
			case 4:
				lista.add(new Par(0, 1));
				lista.add(new Par(1, 8));
				lista.add(new Par(3, 4));
				break;
			case 5:
				lista.add(new Par(0, 0));
				lista.add(new Par(2, 8));
				lista.add(new Par(4, 4));
				break;
			case 6:
				lista.add(new Par(1, 0));
				lista.add(new Par(3, 8));
				lista.add(new Par(4, 3));
				lista.add(new Par(4, 5));
				lista.add(new Par(5, 4));
				break;
			}
		}
		if (i == 6 && j == 7) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i, j - dado));
				lista.add(new Par(i, j + dado));
			} else {
				switch (dado) {
				case 3:
					lista.add(new Par(0, 3));
					lista.add(new Par(1, 4));
					lista.add(new Par(1, 8));
					break;
				case 4:
					lista.add(new Par(0, 2));
					lista.add(new Par(2, 4));
					lista.add(new Par(2, 8));
					break;
				case 5:
					lista.add(new Par(0, 1));
					lista.add(new Par(3, 4));
					lista.add(new Par(3, 8));
					break;
				case 6:
					lista.add(new Par(0, 0));
					lista.add(new Par(4, 4));
					lista.add(new Par(4, 8));
					break;
				}
			}
		}
		if (i == 7 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(0, 6));
				lista.add(new Par(0, 8));
				break;
			case 2:
				lista.add(new Par(0, 5));
				lista.add(new Par(1, 8));
				break;
			case 3:
				lista.add(new Par(0, 4));
				lista.add(new Par(2, 8));
				break;
			case 4:
				lista.add(new Par(0, 3));
				lista.add(new Par(1, 4));
				lista.add(new Par(3, 8));
				break;
			case 5:
				lista.add(new Par(0, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 8));
				break;
			case 6:
				lista.add(new Par(0, 1));
				lista.add(new Par(3, 4));
				lista.add(new Par(5, 8));
				lista.add(new Par(4, 7));
				break;
			}
		}
		if (i == 1 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(0, 0));
				lista.add(new Par(2, 0));
				break;
			case 2:
				lista.add(new Par(0, 1));
				lista.add(new Par(3, 0));
				break;
			case 3:
				lista.add(new Par(0, 2));
				lista.add(new Par(4, 0));
				break;
			case 4:
				lista.add(new Par(0, 3));
				lista.add(new Par(5, 0));
				lista.add(new Par(4, 1));
				break;
			case 5:
				lista.add(new Par(0, 4));
				lista.add(new Par(6, 0));
				lista.add(new Par(4, 2));
				break;
			case 6:
				lista.add(new Par(0, 5));
				lista.add(new Par(1, 4));
				lista.add(new Par(7, 0));
				lista.add(new Par(4, 3));
				break;
			}
		}
		if (i == 2 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(1, 0));
				lista.add(new Par(3, 0));
				break;
			case 2:
				lista.add(new Par(0, 0));
				lista.add(new Par(4, 0));
				break;
			case 3:
				lista.add(new Par(0, 1));
				lista.add(new Par(5, 0));
				lista.add(new Par(4, 1));

				break;
			case 4:
				lista.add(new Par(0, 2));
				lista.add(new Par(6, 0));
				lista.add(new Par(4, 2));
				break;
			case 5:
				lista.add(new Par(0, 3));
				lista.add(new Par(7, 0));
				lista.add(new Par(4, 3));
				break;
			case 6:
				lista.add(new Par(0, 4));
				lista.add(new Par(8, 0));
				lista.add(new Par(4, 4));
				break;
			}
		}
		if (i == 3 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(2, 0));
				lista.add(new Par(4, 0));
				break;
			case 2:
				lista.add(new Par(1, 0));
				lista.add(new Par(5, 0));
				lista.add(new Par(4, 1));
				break;
			case 3:
				lista.add(new Par(0, 0));
				lista.add(new Par(6, 0));
				lista.add(new Par(4, 2));
				break;
			case 4:
				lista.add(new Par(0, 1));
				lista.add(new Par(7, 0));
				lista.add(new Par(4, 3));
				break;
			case 5:
				lista.add(new Par(4, 4));
				lista.add(new Par(0, 2));
				lista.add(new Par(8, 0));
				break;
			case 6:
				lista.add(new Par(0, 3));
				lista.add(new Par(8, 1));
				lista.add(new Par(3, 4));
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 5));
				break;
			}
		}
		if (i == 4 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(3, 0));
				lista.add(new Par(4, 1));
				lista.add(new Par(5, 0));
				break;
			case 2:
				lista.add(new Par(2, 0));
				lista.add(new Par(6, 0));
				lista.add(new Par(4, 2));
				break;
			case 3:
				lista.add(new Par(1, 0));
				lista.add(new Par(7, 0));
				lista.add(new Par(4, 3));
				break;
			case 4:
				lista.add(new Par(0, 0));
				lista.add(new Par(8, 0));
				lista.add(new Par(4, 4));
				break;
			case 5:
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 5));
				lista.add(new Par(0, 1));
				lista.add(new Par(8, 1));
				lista.add(new Par(3, 4));
				break;
			case 6:
				lista.add(new Par(0, 2));
				lista.add(new Par(8, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			}
		}
		if (i == 5 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(4, 0));
				lista.add(new Par(6, 0));
				break;
			case 2:
				lista.add(new Par(3, 0));
				lista.add(new Par(7, 0));
				lista.add(new Par(4, 1));
				break;
			case 3:
				lista.add(new Par(2, 0));
				lista.add(new Par(8, 0));
				lista.add(new Par(4, 2));
				break;
			case 4:
				lista.add(new Par(1, 0));
				lista.add(new Par(8, 1));
				lista.add(new Par(4, 3));
				break;
			case 5:
				lista.add(new Par(0, 0));
				lista.add(new Par(8, 2));
				lista.add(new Par(4, 4));
				break;
			case 6:
				lista.add(new Par(0, 1));
				lista.add(new Par(8, 3));
				lista.add(new Par(3, 4));
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 5));
				break;
			}
		}
		if (i == 6 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(5, 0));
				lista.add(new Par(7, 0));
				break;
			case 2:
				lista.add(new Par(4, 0));
				lista.add(new Par(8, 0));
				break;
			case 3:
				lista.add(new Par(4, 1));
				lista.add(new Par(3, 0));
				lista.add(new Par(8, 2));
				break;
			case 4:
				lista.add(new Par(2, 0));
				lista.add(new Par(4, 2));
				lista.add(new Par(8, 2));
				break;
			case 5:
				lista.add(new Par(1, 0));
				lista.add(new Par(4, 3));
				lista.add(new Par(8, 3));
				break;
			case 6:
				lista.add(new Par(0, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(8, 4));
				break;
			}
		}
		if (i == 7 && j == 0) {
			switch (dado) {
			case 1:
				lista.add(new Par(6, 0));
				lista.add(new Par(8, 0));
				break;
			case 2:
				lista.add(new Par(5, 0));
				lista.add(new Par(8, 1));
				break;
			case 3:
				lista.add(new Par(4, 0));
				lista.add(new Par(8, 2));
				break;
			case 4:
				lista.add(new Par(3, 0));
				lista.add(new Par(4, 1));
				lista.add(new Par(8, 3));
				break;
			case 5:
				lista.add(new Par(2, 0));
				lista.add(new Par(4, 2));
				lista.add(new Par(8, 4));
				break;
			case 6:
				lista.add(new Par(1, 0));
				lista.add(new Par(4, 3));
				lista.add(new Par(7, 4));
				lista.add(new Par(8, 5));
				break;
			}
		}
		if (i == 8 && j == 1) {
			switch (dado) {
			case 1:
				lista.add(new Par(8, 0));
				lista.add(new Par(8, 2));
				break;
			case 2:
				lista.add(new Par(7, 0));
				lista.add(new Par(8, 3));
				break;
			case 3:
				lista.add(new Par(6, 0));
				lista.add(new Par(8, 4));
				break;
			case 4:
				lista.add(new Par(5, 0));
				lista.add(new Par(7, 4));
				lista.add(new Par(8, 5));
				break;
			case 5:
				lista.add(new Par(4, 0));
				lista.add(new Par(6, 4));
				lista.add(new Par(8, 6));
				break;
			case 6:
				lista.add(new Par(3, 0));
				lista.add(new Par(4, 1));
				lista.add(new Par(5, 4));
				lista.add(new Par(8, 7));
				break;
			}
		}
		if (i == 8 && j == 2) {
			switch (dado) {
			case 1:
				lista.add(new Par(8, 1));
				lista.add(new Par(8, 3));
				break;
			case 2:
				lista.add(new Par(8, 0));
				lista.add(new Par(8, 4));
				break;
			case 3:
				lista.add(new Par(7, 0));
				lista.add(new Par(7, 4));
				lista.add(new Par(8, 5));
				break;
			case 4:
				lista.add(new Par(6, 0));
				lista.add(new Par(6, 4));
				lista.add(new Par(8, 6));
				break;
			case 5:
				lista.add(new Par(5, 0));
				lista.add(new Par(5, 4));
				lista.add(new Par(8, 7));
				break;
			case 6:
				lista.add(new Par(4, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(8, 8));
				break;
			}
		}
		if (i == 8 && j == 3) {
			switch (dado) {
			case 1:
				lista.add(new Par(8, 2));
				lista.add(new Par(8, 4));
				break;
			case 2:
				lista.add(new Par(8, 1));
				lista.add(new Par(7, 4));
				lista.add(new Par(8, 5));
				break;
			case 3:
				lista.add(new Par(8, 0));
				lista.add(new Par(6, 4));
				lista.add(new Par(8, 6));
				break;
			case 4:
				lista.add(new Par(7, 0));
				lista.add(new Par(5, 4));
				lista.add(new Par(8, 7));
				break;
			case 5:
				lista.add(new Par(6, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(8, 8));
				break;
			case 6:
				lista.add(new Par(5, 0));
				lista.add(new Par(4, 3));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 5));
				lista.add(new Par(7, 8));
				break;
			}
		}
		if (i == 8 && j == 4) {
			switch (dado) {
			case 1:
				lista.add(new Par(8, 3));
				lista.add(new Par(7, 4));
				lista.add(new Par(8, 5));
				break;
			case 2:
				lista.add(new Par(8, 2));
				lista.add(new Par(6, 4));
				lista.add(new Par(8, 6));
				break;
			case 3:
				lista.add(new Par(8, 1));
				lista.add(new Par(5, 4));
				lista.add(new Par(8, 7));
				break;
			case 4:
				lista.add(new Par(8, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(8, 8));
				break;
			case 5:
				lista.add(new Par(7, 0));
				lista.add(new Par(7, 8));
				lista.add(new Par(4, 3));
				lista.add(new Par(4, 5));
				lista.add(new Par(3, 4));
				break;
			case 6:
				lista.add(new Par(6, 0));
				lista.add(new Par(6, 8));
				lista.add(new Par(4, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				break;
			}
		}
		if (i == 8 && j == 5) {
			switch (dado) {
			case 1:
				lista.add(new Par(8, 4));
				lista.add(new Par(8, 6));
				break;
			case 2:
				lista.add(new Par(7, 4));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 7));
				break;
			case 3:
				lista.add(new Par(6, 4));
				lista.add(new Par(8, 2));
				lista.add(new Par(8, 8));
				break;
			case 4:
				lista.add(new Par(5, 4));
				lista.add(new Par(8, 1));
				lista.add(new Par(7, 8));
				break;
			case 5:
				lista.add(new Par(4, 4));
				lista.add(new Par(8, 0));
				lista.add(new Par(6, 8));
				break;
			case 6:
				lista.add(new Par(7, 0));
				lista.add(new Par(5, 8));
				lista.add(new Par(4, 3));
				lista.add(new Par(4, 5));
				lista.add(new Par(3, 4));
				break;
			}
		}
		if (i == 8 && j == 6) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i, j - dado));
				lista.add(new Par(i, j - dado));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(8, 3));
				lista.add(new Par(7, 4));
				lista.add(new Par(7, 8));
				break;
			case 4:
				lista.add(new Par(8, 2));
				lista.add(new Par(6, 4));
				lista.add(new Par(6, 8));
				break;
			case 5:
				lista.add(new Par(8, 1));
				lista.add(new Par(5, 4));
				lista.add(new Par(5, 8));
				break;
			case 6:
				lista.add(new Par(8, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(4, 8));
				break;
			}
		}
		if (i == 8 && j == 7) {
			switch (dado) {
			case 1:
				lista.add(new Par(8, 6));
				lista.add(new Par(8, 8));
				break;
			case 2:
				lista.add(new Par(8, 5));
				lista.add(new Par(7, 8));
				break;
			case 3:
				lista.add(new Par(8, 4));
				lista.add(new Par(6, 8));
				break;
			case 4:
				lista.add(new Par(8, 3));
				lista.add(new Par(7, 4));
				lista.add(new Par(5, 8));
				break;
			case 5:
				lista.add(new Par(8, 2));
				lista.add(new Par(6, 4));
				lista.add(new Par(4, 8));
				break;
			case 6:
				lista.add(new Par(8, 1));
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 7));
				lista.add(new Par(3, 8));
				break;
			}
		}
		if (i == 7 && j == 8) {
			switch (dado) {
			case 1:
				lista.add(new Par(8, 8));
				lista.add(new Par(6, 8));
				break;
			case 2:
				lista.add(new Par(8, 7));
				lista.add(new Par(5, 8));
				break;
			case 3:
				lista.add(new Par(8, 6));
				lista.add(new Par(4, 8));
				break;
			case 4:
				lista.add(new Par(8, 5));
				lista.add(new Par(4, 7));
				lista.add(new Par(3, 8));
				break;
			case 5:
				lista.add(new Par(8, 4));
				lista.add(new Par(2, 8));
				lista.add(new Par(4, 6));
				break;
			case 6:
				lista.add(new Par(8, 3));
				lista.add(new Par(7, 4));
				lista.add(new Par(1, 8));
				lista.add(new Par(4, 5));
				break;
			}
		}
		if (i == 6 && j == 8) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i - dado, j));
				lista.add(new Par(i + dado, j));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(8, 7));
				lista.add(new Par(4, 7));
				lista.add(new Par(3, 8));
				break;
			case 4:
				lista.add(new Par(8, 6));
				lista.add(new Par(4, 6));
				lista.add(new Par(2, 8));
				break;
			case 5:
				lista.add(new Par(8, 5));
				lista.add(new Par(4, 5));
				lista.add(new Par(1, 8));
				break;
			case 6:
				lista.add(new Par(0, 8));
				lista.add(new Par(8, 4));
				lista.add(new Par(4, 4));
				break;
			}
		}
		if (i == 5 && j == 8) {
			switch (dado) {
			case 1:
				lista.add(new Par(6, 8));
				lista.add(new Par(4, 8));
				break;
			case 2:
				lista.add(new Par(7, 8));
				lista.add(new Par(3, 8));
				lista.add(new Par(4, 7));
				break;
			case 3:
				lista.add(new Par(8, 8));
				lista.add(new Par(2, 8));
				lista.add(new Par(4, 6));
				break;
			case 4:
				lista.add(new Par(8, 7));
				lista.add(new Par(1, 8));
				lista.add(new Par(4, 5));
				break;
			case 5:
				lista.add(new Par(8, 6));
				lista.add(new Par(0, 8));
				lista.add(new Par(4, 4));
				break;
			case 6:
				lista.add(new Par(8, 5));
				lista.add(new Par(0, 7));
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 3));
				lista.add(new Par(3, 4));
				break;
			}
		}
		if (i == 4 && j == 8) {
			switch (dado) {
			case 1:
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				lista.add(new Par(4, 7));
				break;
			case 2:
				lista.add(new Par(6, 8));
				lista.add(new Par(2, 8));
				lista.add(new Par(4, 6));
				break;
			case 3:
				lista.add(new Par(7, 8));
				lista.add(new Par(1, 8));
				lista.add(new Par(4, 5));
				break;
			case 4:
				lista.add(new Par(4, 4));
				lista.add(new Par(8, 8));
				lista.add(new Par(0, 8));
				break;
			case 5:
				lista.add(new Par(8, 7));
				lista.add(new Par(0, 7));
				lista.add(new Par(5, 4));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 3));
				break;
			case 6:
				lista.add(new Par(8, 6));
				lista.add(new Par(0, 6));
				lista.add(new Par(4, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(6, 4));
				break;
			}
		}
		if (i == 3 && j == 8) {
			switch (dado) {
			case 1:
				lista.add(new Par(4, 8));
				lista.add(new Par(2, 8));
				break;
			case 2:
				lista.add(new Par(4, 7));
				lista.add(new Par(5, 8));
				lista.add(new Par(1, 8));
				break;
			case 3:
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 8));
				lista.add(new Par(0, 8));
				break;
			case 4:
				lista.add(new Par(0, 7));
				lista.add(new Par(7, 8));
				lista.add(new Par(4, 5));
				break;
			case 5:
				lista.add(new Par(4, 4));
				lista.add(new Par(0, 6));
				lista.add(new Par(8, 8));
				break;
			case 6:
				lista.add(new Par(0, 5));
				lista.add(new Par(8, 7));
				lista.add(new Par(5, 4));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 3));
				break;
			}
		}
		if (i == 2 && j == 8) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i - dado, j));
				lista.add(new Par(i + dado, j));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(4, 7));
				lista.add(new Par(5, 8));
				lista.add(new Par(0, 7));
				break;
			case 4:
				lista.add(new Par(0, 6));
				lista.add(new Par(6, 8));
				lista.add(new Par(4, 6));
				break;
			case 5:
				lista.add(new Par(4, 5));
				lista.add(new Par(7, 8));
				lista.add(new Par(0, 5));
				break;
			case 6:
				lista.add(new Par(4, 4));
				lista.add(new Par(0, 4));
				lista.add(new Par(8, 8));
				break;
			}
		}
		if (i == 1 && j == 8) {
			switch (dado) {
			case 1:
				lista.add(new Par(0, 8));
				lista.add(new Par(2, 8));
				break;
			case 2:
				lista.add(new Par(0, 7));
				lista.add(new Par(3, 8));
				break;
			case 3:
				lista.add(new Par(0, 6));
				lista.add(new Par(4, 8));
				break;
			case 4:
				lista.add(new Par(5, 8));
				lista.add(new Par(4, 7));
				lista.add(new Par(0, 5));
				break;
			case 5:
				lista.add(new Par(0, 4));
				lista.add(new Par(6, 8));
				lista.add(new Par(4, 6));
				break;
			case 6:
				lista.add(new Par(4, 5));
				lista.add(new Par(7, 8));
				lista.add(new Par(0, 3));
				lista.add(new Par(1, 4));
				break;
			}
		}
		if (i == 1 && j == 4) {
			switch (dado) {
			case 1:
				lista.add(new Par(0, 4));
				lista.add(new Par(2, 4));
				break;
			case 2:
				lista.add(new Par(0, 3));
				lista.add(new Par(0, 5));
				lista.add(new Par(3, 4));
				break;
			case 3:
				lista.add(new Par(0, 2));
				lista.add(new Par(0, 6));
				lista.add(new Par(4, 4));
				break;
			case 4:
				lista.add(new Par(0, 1));
				lista.add(new Par(0, 7));
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 3));
				lista.add(new Par(4, 5));
				break;
			case 5:
				lista.add(new Par(0, 0));
				lista.add(new Par(0, 8));
				lista.add(new Par(4, 2));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			case 6:
				lista.add(new Par(1, 0));
				lista.add(new Par(1, 8));
				lista.add(new Par(7, 4));
				lista.add(new Par(4, 1));
				lista.add(new Par(4, 7));
				break;
			}
		}
		if (i == 2 && j == 4) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i - dado, j));
				lista.add(new Par(i + dado, j));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(0, 3));
				lista.add(new Par(0, 5));
				lista.add(new Par(4, 3));
				lista.add(new Par(4, 5));
				lista.add(new Par(5, 4));
				break;
			case 4:
				lista.add(new Par(0, 2));
				lista.add(new Par(0, 6));
				lista.add(new Par(4, 2));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			case 5:
				lista.add(new Par(0, 1));
				lista.add(new Par(0, 7));
				lista.add(new Par(4, 1));
				lista.add(new Par(4, 7));
				lista.add(new Par(7, 4));
				break;
			case 6:
				lista.add(new Par(0, 0));
				lista.add(new Par(0, 8));
				lista.add(new Par(4, 0));
				lista.add(new Par(4, 7));
				lista.add(new Par(8, 4));
				break;
			}
		}
		if (i == 3 && j == 4) {
			switch (dado) {
			case 1:
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 4));
				break;
			case 2:
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 3));
				lista.add(new Par(4, 5));
				lista.add(new Par(5, 4));
				break;
			case 3:
				lista.add(new Par(0, 4));
				lista.add(new Par(4, 2));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			case 4:
				lista.add(new Par(0, 3));
				lista.add(new Par(0, 5));
				lista.add(new Par(4, 1));
				lista.add(new Par(4, 7));
				lista.add(new Par(7, 4));
				break;
			case 5:
				lista.add(new Par(0, 2));
				lista.add(new Par(0, 6));
				lista.add(new Par(4, 0));
				lista.add(new Par(4, 8));
				lista.add(new Par(8, 4));
				break;
			case 6:
				lista.add(new Par(0, 1));
				lista.add(new Par(0, 7));
				lista.add(new Par(3, 0));
				lista.add(new Par(5, 0));
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 5));
				break;
			}
		}
		if (i == 5 && j == 4) {
			switch (dado) {
			case 1:
				lista.add(new Par(4, 4));
				lista.add(new Par(6, 4));
				break;
			case 2:
				lista.add(new Par(4, 3));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 5));
				lista.add(new Par(7, 4));
				break;
			case 3:
				lista.add(new Par(4, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				lista.add(new Par(8, 4));
				break;
			case 4:
				lista.add(new Par(4, 1));
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 7));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 5));
				break;
			case 5:
				lista.add(new Par(4, 0));
				lista.add(new Par(0, 4));
				lista.add(new Par(4, 8));
				lista.add(new Par(8, 2));
				lista.add(new Par(8, 6));
				break;
			case 6:
				lista.add(new Par(5, 0));
				lista.add(new Par(3, 0));
				lista.add(new Par(0, 3));
				lista.add(new Par(0, 5));
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				lista.add(new Par(8, 1));
				lista.add(new Par(8, 7));
				break;
			}
		}
		if (i == 6 && j == 4) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i - dado, j));
				lista.add(new Par(i + dado, j));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(4, 3));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 5));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 5));
				break;
			case 4:
				lista.add(new Par(4, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				lista.add(new Par(8, 2));
				lista.add(new Par(8, 6));
				break;
			case 5:
				lista.add(new Par(4, 1));
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 7));
				lista.add(new Par(8, 1));
				lista.add(new Par(8, 7));
				break;
			case 6:
				lista.add(new Par(4, 0));
				lista.add(new Par(0, 4));
				lista.add(new Par(4, 8));
				lista.add(new Par(8, 0));
				lista.add(new Par(8, 8));
				break;
			}
		}
		if (i == 4 && j == 2) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i, j - dado));
				lista.add(new Par(i, j + dado));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(5, 0));
				lista.add(new Par(3, 0));
				lista.add(new Par(3, 4));
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 5));
				break;
			case 4:
				lista.add(new Par(6, 0));
				lista.add(new Par(2, 0));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			case 5:
				lista.add(new Par(7, 0));
				lista.add(new Par(1, 0));
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 7));
				lista.add(new Par(7, 4));
				break;
			case 6:
				lista.add(new Par(0, 0));
				lista.add(new Par(8, 0));
				lista.add(new Par(0, 4));
				lista.add(new Par(4, 8));
				lista.add(new Par(8, 4));
				break;
			}
		}
		if (i == 4 && j == 6) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i, dado + j));
				lista.add(new Par(i, dado - j));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 3));
				lista.add(new Par(5, 4));
				break;
			case 4:
				lista.add(new Par(2, 8));
				lista.add(new Par(6, 8));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 2));
				lista.add(new Par(6, 4));
				break;
			case 5:
				lista.add(new Par(1, 8));
				lista.add(new Par(7, 8));
				lista.add(new Par(1, 4));
				lista.add(new Par(7, 4));
				lista.add(new Par(4, 1));
				break;
			case 6:
				lista.add(new Par(0, 8));
				lista.add(new Par(8, 8));
				lista.add(new Par(0, 4));
				lista.add(new Par(4, 0));
				lista.add(new Par(8, 4));
				break;
			}
		}
		if (i == 7 && j == 4) {
			switch (dado) {
			case 1:
				lista.add(new Par(6, 4));
				lista.add(new Par(8, 4));
				break;
			case 2:
				lista.add(new Par(5, 4));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 5));
				break;
			case 3:
				lista.add(new Par(4, 4));
				lista.add(new Par(8, 2));
				lista.add(new Par(8, 6));
				break;
			case 4:
				lista.add(new Par(4, 3));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 5));
				lista.add(new Par(8, 1));
				lista.add(new Par(8, 7));
				break;
			case 5:
				lista.add(new Par(4, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				lista.add(new Par(8, 0));
				lista.add(new Par(8, 8));
				break;
			case 6:
				lista.add(new Par(4, 1));
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 7));
				lista.add(new Par(7, 0));
				lista.add(new Par(7, 8));
				break;
			}
		}
		if (i == 4 && j == 1) {
			switch (dado) {
			case 1:
				lista.add(new Par(4, 0));
				lista.add(new Par(4, 2));
				break;
			case 2:
				lista.add(new Par(3, 0));
				lista.add(new Par(5, 0));
				lista.add(new Par(4, 3));
				break;
			case 3:
				lista.add(new Par(2, 0));
				lista.add(new Par(6, 0));
				lista.add(new Par(4, 4));
				break;
			case 4:
				lista.add(new Par(1, 0));
				lista.add(new Par(7, 0));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 5));
				lista.add(new Par(5, 4));
				break;
			case 5:
				lista.add(new Par(0, 0));
				lista.add(new Par(8, 0));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			case 6:
				lista.add(new Par(0, 1));
				lista.add(new Par(8, 1));
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 7));
				lista.add(new Par(7, 4));
				break;
			}
		}
		if (i == 4 && j == 3) {
			switch (dado) {
			case 1:
				lista.add(new Par(4, 2));
				lista.add(new Par(4, 4));
				break;
			case 2:
				lista.add(new Par(4, 1));
				lista.add(new Par(3, 4));
				lista.add(new Par(4, 5));
				lista.add(new Par(5, 4));
				break;
			case 3:
				lista.add(new Par(4, 0));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 6));
				lista.add(new Par(6, 4));
				break;
			case 4:
				lista.add(new Par(5, 0));
				lista.add(new Par(3, 0));
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 7));
				lista.add(new Par(7, 4));
				break;
			case 5:
				lista.add(new Par(6, 0));
				lista.add(new Par(2, 0));
				lista.add(new Par(0, 4));
				lista.add(new Par(4, 8));
				lista.add(new Par(8, 4));
				break;
			case 6:
				lista.add(new Par(7, 0));
				lista.add(new Par(1, 0));
				lista.add(new Par(0, 3));
				lista.add(new Par(0, 5));
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 5));
				break;
			}
		}
		if (i == 4 && j == 5) {
			switch (dado) {
			case 1:
				lista.add(new Par(4, 4));
				lista.add(new Par(4, 6));
				break;
			case 2:
				lista.add(new Par(4, 7));
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 3));
				lista.add(new Par(3, 4));
				break;
			case 3:
				lista.add(new Par(4, 8));
				lista.add(new Par(6, 4));
				lista.add(new Par(2, 4));
				lista.add(new Par(4, 2));
				break;
			case 4:
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				lista.add(new Par(7, 4));
				lista.add(new Par(1, 4));
				lista.add(new Par(4, 1));
				break;
			case 5:
				lista.add(new Par(2, 8));
				lista.add(new Par(6, 8));
				lista.add(new Par(8, 4));
				lista.add(new Par(0, 4));
				lista.add(new Par(4, 0));
				break;
			case 6:
				lista.add(new Par(1, 8));
				lista.add(new Par(7, 8));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 5));
				lista.add(new Par(5, 0));
				lista.add(new Par(3, 0));
				lista.add(new Par(0, 5));
				lista.add(new Par(0, 3));
				break;
			}
		}
		if (i == 4 && j == 7) {
			switch (dado) {
			case 1:
				lista.add(new Par(4, 6));
				lista.add(new Par(4, 8));
				break;
			case 2:
				lista.add(new Par(4, 5));
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				break;
			case 3:
				lista.add(new Par(4, 4));
				lista.add(new Par(2, 8));
				lista.add(new Par(6, 8));
				break;
			case 4:
				lista.add(new Par(5, 4));
				lista.add(new Par(4, 3));
				lista.add(new Par(3, 4));
				lista.add(new Par(1, 8));
				lista.add(new Par(7, 8));
				break;
			case 5:
				lista.add(new Par(6, 4));
				lista.add(new Par(4, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(0, 8));
				lista.add(new Par(8, 8));
				break;
			case 6:
				lista.add(new Par(7, 4));
				lista.add(new Par(4, 1));
				lista.add(new Par(1, 4));
				lista.add(new Par(0, 7));
				lista.add(new Par(8, 7));
				break;
			}
		}
		if (i == 4 && j == 4) {
			if (dado == 5) {
				lista.add(new Par(5, 0));
				lista.add(new Par(3, 0));
				lista.add(new Par(0, 3));
				lista.add(new Par(0, 5));
				lista.add(new Par(3, 8));
				lista.add(new Par(5, 8));
				lista.add(new Par(8, 3));
				lista.add(new Par(8, 5));
			} else if (dado == 6) {
				lista.add(new Par(6, 0));
				lista.add(new Par(2, 0));
				lista.add(new Par(0, 2));
				lista.add(new Par(0, 6));
				lista.add(new Par(2, 8));
				lista.add(new Par(6, 8));
				lista.add(new Par(8, 2));
				lista.add(new Par(8, 6));
			} else {
				lista.add(new Par(i - dado, j));
				lista.add(new Par(i + dado, j));
				lista.add(new Par(i, j + dado));
				lista.add(new Par(i, j - dado));
			}
		}
		if (i == 0 && j == 6) {
			if (dado == 1 || dado == 2) {
				lista.add(new Par(i, j + dado));
				lista.add(new Par(i, j - dado));
			}
			switch (dado) {
			case 3:
				lista.add(new Par(0, 3));
				lista.add(new Par(1, 4));
				lista.add(new Par(1, 8));
				break;
			case 4:
				lista.add(new Par(0, 2));
				lista.add(new Par(2, 4));
				lista.add(new Par(2, 8));
				break;
			case 5:
				lista.add(new Par(0, 1));
				lista.add(new Par(3, 4));
				lista.add(new Par(3, 8));
				break;
			case 6:
				lista.add(new Par(0, 0));
				lista.add(new Par(4, 4));
				lista.add(new Par(4, 8));
				break;
			}
		}
		if (i == 0 && j == 1) {
			switch (dado) {
			case 1:
				lista.add(new Par(0, 0));
				lista.add(new Par(0, 2));
				break;
			case 2:
				lista.add(new Par(0, 3));
				lista.add(new Par(1, 0));
				break;
			case 3:
				lista.add(new Par(2, 0));
				lista.add(new Par(0, 4));
				break;
			case 4:
				lista.add(new Par(3, 0));
				lista.add(new Par(0, 5));
				lista.add(new Par(1, 4));
				break;
			case 5:
				lista.add(new Par(4, 0));
				lista.add(new Par(0, 6));
				lista.add(new Par(2, 4));
				break;
			case 6:
				lista.add(new Par(5, 0));
				lista.add(new Par(4, 1));
				lista.add(new Par(0, 7));
				lista.add(new Par(3, 4));
				break;
			}
		}
		if (i == 0 && j == 7) {
			switch (dado) {
			case 1:
				lista.add(new Par(0,6));
				lista.add(new Par(0,8));
				break;
			case 2:
				lista.add(new Par(0,5));
				lista.add(new Par(1,8));
				break;
			case 3:
				lista.add(new Par(0,4));
				lista.add(new Par(2,8));
				break;
			case 4:
				lista.add(new Par(0,3));
				lista.add(new Par(1,4));
				lista.add(new Par(3,8));
				break;
			case 5:
				lista.add(new Par(0,2));
				lista.add(new Par(2,4));
				lista.add(new Par(4,8));
				break;
			case 6:
				lista.add(new Par(0,1));
				lista.add(new Par(3,4));
				lista.add(new Par(4,7));
				lista.add(new Par(5,8));
				break;
			}
		}
		return lista;
	}
}
