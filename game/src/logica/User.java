package logica;

public class User {

	private String nombre;
	private String apellidos;
	private String login;
	private String password;
	
	public User(){}
	
	public User(String nombre, String apellidos, String login, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", login=" + login + ", password=" + password + "]";
	}
	
	
	
}
