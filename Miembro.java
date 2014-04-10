package org.brandon.beans;

/**
*	@author Brandon Castro
*	Este es el beans del miembro.
*/

public class Miembro extends Downline{
	
	private String nombre;
	private String nick;
	private String password;
	private String rol="miembro";
	private int edad;
	private int tarjeta;
	private int pin;
	
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
	
	public int getTarjeta(){
		return this.tarjeta;
	}
	public void setTarjeta(int tarjeta){
		this.tarjeta=tarjeta;
	}
	
	public int getPin(){
		return this.pin;
	}
	public void setPin(int pin){
		this.pin=pin;
	}
	
	public Miembro(){
		super();
	}
	public Miembro(String nombre, String nick, String password, int edad,int tarjeta,int pin){
		this.setNombre(nombre);
		this.setNick(nick);
		this.setPassword(password);
		this.setEdad(edad);
		this.setTarjeta(tarjeta);
		this.setPin(pin);
	}
	
}