package controllers;

import models.Pregunta;
import play.*;
import play.db.jpa.Transactional;
import play.db.jpa.JPA;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(new String [] {
            "Geografía",
            "Deportes",
            "Arte y Literatura",
            "Espectáculos",
            "Ciencias Naturales",
            "Historia"
        }));
    }
    
    public static Result seleccionaCategoria(String categoria) {
        session("categoria", categoria);
        session("falladas", "0");
        session("acertadas", "0");
        return redirect("/pregunta");
    }

	@Transactional
    public static Result pregunta() {
    	Pregunta p = JPA.em()
    	    .createQuery("SELECT p FROM Pregunta p WHERE p.categoria LIKE :categoria ORDER BY rand()", Pregunta.class)
    	    .setParameter("categoria", "%" + session("categoria") + "%")
    	    .setMaxResults(1)
    	    .getSingleResult();
    	return ok(pregunta.render(p));
    }
    
    public static Result responder(boolean correcta) {
    	
    	//int correcta = Integer.parseInt(session("correcta"));
    	String strAcertadas = session("acertadas");
    	String strFalladas = session("falladas");
    	int acertadas = strAcertadas == null ? 0 : Integer.parseInt(strAcertadas);
    	int falladas = strFalladas == null ? 0 : Integer.parseInt(strFalladas);
    	if (correcta) {
    		acertadas++;
    	}
    	else {
    	    falladas++;
    	}
    	session("acertadas", Integer.toString(acertadas));
    	session("falladas", Integer.toString(falladas));
    	
    	if (falladas == 3) {
    	    flash("mensaje", "Juego terminado: Fallaste 3 preguntas");
    	    session().clear();
    	    return redirect("/");
    	}
    	else {
    	    return redirect("/pregunta");
    	}
    }
    
    public static Result tablero() {
    	return ok(tablero.render());
    }

}
