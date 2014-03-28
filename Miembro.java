package org.brandon.beans;
public class Miembro{
	private String nombre;
	private String nick;
	private String password;
	private String rol="miembro";
	private int idDownline;
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
	public int getIdDownline(){
		return this.idDownline;
	}
	public void setIdDownline(int idDownline){
		this.idDownline=idDownline;
	}
	public Miembro(){

	}
	public Miembro(String nombre, String nick, String password, int edad,int tarjeta,int pin, int idDownline){
		this.setNombre(nombre);
		this.setNick(nick);
		this.setPassword(password);
		this.setEdad(edad);
		this.setEdad(tarjeta);
		this.setEdad(pin);
		this.setIdDownline(idDownline);
	}
}