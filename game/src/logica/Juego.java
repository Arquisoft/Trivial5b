package logica;

public class Juego {

	private int numeroDado;
	private int numeroJugadores;
	
	public int getNumeroDado() {
		return numeroDado;
	}

	public void setNumeroDado(int numeroDado) {
		this.numeroDado = numeroDado;
	}
	
	public int tirarDado() {
		numeroDado = (int) (1 + (Math.random() * (6)));
		return numeroDado;
	}

	public int getNumeroJugadores() {
		return numeroJugadores;
	}

	public void setNumeroJugadores(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}

}
