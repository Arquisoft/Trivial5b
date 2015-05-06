package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table(name = "TQUESTION")
public class Pregunta {
    
	@Id
	@Column(name = "ID")
	public Long id;
	
	@Column(name = "QUESTION")
	public String enunciado;
	@Column(name = "CORRECTANSWER")
	public String opcion1;
	@Column(name = "WRONGANSWER1")
	public String opcion2;
	@Column(name = "WRONGANSWER2")
	public String opcion3;
	
	@Column(name = "CATEGORY")
	public String categoria;
	
	public Pregunta() {}
	
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
	
	public List<Object[]> getRespuestas() {
	
	    List<Object[]> respuestas = new ArrayList<Object[]>();
	    
	    respuestas.add(new Object[] {true, opcion1});
	    respuestas.add(new Object[] {false, opcion2});
	    respuestas.add(new Object[] {false, opcion3});

	    Collections.shuffle(respuestas);

	    return respuestas;
	}

}
