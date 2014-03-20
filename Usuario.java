package org.brandon.beans;
public class Usuario{
	private String nombre;
	private String nick;
	private String password;
	private String rol;
	private int edad;
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
	public int getEdad(){
		return this.edad;
	}
	public void setEdad(int edad){
		this.edad=edad;
	}
	public Usuario(){

	}
	public Usuario(String nombre, String nick, String password, String rol, int edad){
		this.setNombre(nombre);
		this.setNick(nick);
		this.setPassword(password);
		this.setRol(rol);
		this.setEdad(edad);
	}
}