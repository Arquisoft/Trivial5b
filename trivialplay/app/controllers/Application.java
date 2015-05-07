package controllers;

import models.*;
import play.*;
import play.db.jpa.Transactional;
import play.db.jpa.JPA;
import play.mvc.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.*;

import views.html.*;

public class Application extends Controller {


    public static Result index() {
        return ok(index.render());
    }

    public static Result categorias() {
        return ok(categorias.render(new String [] {
            "Geografía",
            "Deportes",
            "Arte y Literatura",
            "Espectáculos",
            "Ciencias Naturales",
            "Historia"
        }));
    }
    
    @Transactional
    public static Result login() {
        
        String nombre = request().getQueryString("nombre");
        String clave = request().getQueryString("clave");
        
    	List<User> us = JPA.em()
    	    .createQuery("SELECT u FROM User u WHERE u.login = :nombre AND u.password = :clave", User.class)
    	    .setParameter("nombre", nombre)
    	    .setParameter("clave", clave)
    	    .setMaxResults(1)
    	    .getResultList();
        
        if (us.size() == 0) {
    	    flash("mensaje", "Nombre de usuario o contraseña no validos");
            return redirect("/");
        }
        else {
            return redirect("/categorias");
        }
        
    }
    
    public static Result seleccionaCategoria(String categoria) {
        session("categoria", categoria);
        session("falladas", "0");
        session("acertadas", "0");
        return redirect("/pregunta");
    }

    public static Result pregunta() {
    	return ok(pregunta.render());
    }

	@Transactional
    public static Result preguntaAPIRest() {
    	Pregunta p = JPA.em()
    	    .createQuery("SELECT p FROM Pregunta p WHERE p.categoria LIKE :categoria ORDER BY rand()", Pregunta.class)
    	    .setParameter("categoria", "%" + session("categoria") + "%")
    	    .setMaxResults(1)
    	    .getSingleResult();
    	    
    	ObjectNode resultado = Json.newObject();
    	resultado.put("enunciado", p.getEnunciado());
    	ArrayNode opciones = resultado.putArray("respuestas");
    	for (Object [] r: p.getRespuestas()) {
        	ObjectNode respuesta = Json.newObject();
    	    respuesta.put("correcta", (Boolean)r[0]);
    	    respuesta.put("valor", (String)r[1]);
    	    opciones.add(respuesta);
    	}

    	return ok(resultado);
    }
    
    public static Result responder() {
    	
    	boolean correcta = Boolean.parseBoolean(request().getQueryString("correcta"));
    	
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
    	
    	ObjectNode resultado = Json.newObject();
    	resultado.put("acertadas", acertadas);
    	if (falladas == 3) {
    	    flash("mensaje", "Juego terminado: Fallaste 3 preguntas");
    	    session().clear();
        	resultado.put("fin", true);
    	}
    	else {
        	resultado.put("fin", false);
    	}
    	return ok(resultado);
    }
    
    public static Result tablero() {
    	return ok(tablero.render());
    }

}
