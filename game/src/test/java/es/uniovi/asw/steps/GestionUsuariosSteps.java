package es.uniovi.asw.steps;

import java.util.List;

import es.uniovi.asw.game.User;
import es.uniovi.asw.game.UserDb;
import cucumber.api.java.es.*;
import cucumber.api.PendingException;
import static org.assertj.core.api.Assertions.*;

public class GestionUsuariosSteps {
	 
	private UserDb users ;
	private Boolean loginValue;
	private es.uniovi.asw.game.User usuario_buscado = null;

	@Dada("^una lista vacía de usuarios$")
	public void una_lista_vacía_de_usuarios() throws Throwable {
		users = new UserDb();
	}

	@Cuando("^creo un usuario de nombre \"(.*?)\" y clave \"(.*?)\"$")
	public void creo_un_usuario_de_nombre_y_clave(String nombre, String clave) throws Throwable {
		users.addUser(nombre,clave);
	}

	@Entonces("^el número de usuarios es (\\d+)$")
	public void el_número_de_usuarios_es(int n) throws Throwable {
	    assertThat(users.size()).isEqualTo(n);  
	}

	@Dada("^la siguiente lista de usuarios:$")
	public void la_siguiente_lista_de_usuarios(List<User> userList) throws Throwable {
		users = new UserDb();
		for (User u : userList) {
            users.addUser(u.nombre, u.clave);
        }
	}

	@Cuando("^introduzco el nombre \"(.*?)\" y la clave \"(.*?)\"$")
	public void introduzco_el_nombre_y_la_clave(String nombre, String clave) throws Throwable {
		loginValue = users.login(nombre, clave);
	}

	@Entonces("^puedo entrar en el sistema$")
	public void puedo_entrar_en_el_sistema() throws Throwable {
		assertThat(loginValue).isEqualTo(true);
	}
	
	@Entonces("^no puedo entrar en el sistema$")
	public void no_puedo_entrar_en_el_sistema() throws Throwable {
		assertThat(loginValue).isEqualTo(false);
	}

	@Cuando("^busco el usuario \"(.*?)\"$")
	public void busco_el_usuario(String nombre) throws Throwable {
		usuario_buscado = users.lookup(nombre);
	}

	@Entonces("^lo encuentro$")
	public void lo_encuentro() throws Throwable {
		assertThat(usuario_buscado).isNotNull();
	}

	@Entonces("^no me deja entrar en el sistema$")
	public void no_me_deja_entrar_en_el_sistema() throws Throwable {
		assertThat(loginValue).isEqualTo(false);
	}
	
	@Cuando("^creo otro usuario cualquiera$")
	public void creo_otro_usuario_cualquiera() throws Throwable {
        users.addUser("otro", "usuario");
	}

	@Entonces("^el tamaño de la lista de usuarios es (\\d+)$")
	public void el_tamanio_de_la_lista_de_usuarios_es(int n) throws Throwable {
	    assertThat(users.size()).isEqualTo(n);  
	}
	
	
	public static class User {
        private String nombre;
        private String clave;
    }	
}
