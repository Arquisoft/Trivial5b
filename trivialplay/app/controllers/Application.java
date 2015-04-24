package controllers;

import models.Pregunta;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	Pregunta p = new Pregunta("¿Que es xxxx?", "a", "b", "c");
    	session("correcta", "2");
    	return ok(index.render(p));
    }
    
    public static Result responder(int indice) {
    	
    	int correcta = Integer.parseInt(session("correcta"));
    	String strAcertadas = session("acertadas");
    	int acertadas = strAcertadas == null ? 0 : Integer.parseInt(strAcertadas);
    	if (indice == correcta) {
    		acertadas++;
    	}
    	session("acertadas", Integer.toString(acertadas));
    	
    	return redirect("/");
    }
    
    public static Result tablero() {
    	return ok(tablero.render());
    }

}
