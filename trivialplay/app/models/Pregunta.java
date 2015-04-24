package models;

public class Pregunta {

	public String enunciado;
	public String opcion1;
	public String opcion2;
	public String opcion3;
	
	public Pregunta(String enunciado, String opcion1, String opcion2, String opcion3) {
		this.enunciado = enunciado;
		this.opcion1 = opcion1;
		this.opcion2 = opcion2;
		this.opcion3 = opcion3;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getOpcion1() {
		return opcion1;
	}

	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}

	public String getOpcion2() {
		return opcion2;
	}

	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}

	public String getOpcion3() {
		return opcion3;
	}

	public void setOpcion3(String opcion3) {
		this.opcion3 = opcion3;
	}

}
