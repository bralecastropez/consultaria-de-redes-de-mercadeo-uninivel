	package org.brandon.beans;
public class Producto{
	private String nombre;
	private String categoria;
	private int precio;
	
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getCategoria(){
		return this.categoria;
	}
	public void setCategoria(String categoria){
		this.categoria=categoria;
	}
	public int getPrecio(){
		return this.precio;
	}
	public void setPrecio(int precio){
	this.precio=precio;
	}
	public Producto(){
	}
	public Producto(String nombre, String categoria, int precio){
		this.setNombre(nombre);
		this.setCategoria(categoria);
		this.setPrecio(precio);
	}
}