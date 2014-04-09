package org.brandon.beans;

/**
*	@author Brandon Castro
*	Este es el beans que usa el Administrador.
*/

public class Admin{

	private String nombre;
	private String nick;
	private String password;
	private String rol="admin";
	
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public String getNick(){
		return this.nick;
	}
	public void setNick(String nick){
		this.nick=nick;
	}
	
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getRol(){
		return this.rol;
	}
	public void setRol(String rol){
		this.rol=rol;
	}
	
	/**
	*	Constructor vacio.
	*/
	public Admin(){

	}
	public Admin(String nombre, String nick, String password){
		this.setNombre(nombre);
		this.setNick(nick);
		this.setPassword(password);
	}
	
}