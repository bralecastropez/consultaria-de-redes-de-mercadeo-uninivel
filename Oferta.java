package org.brandon.beans;

/**
* @author Brandon Castro
* Esta clase sirve para listar ofertas.
*/

public class Oferta{

	private String tipo;
	private int cantidad;
	private int precio;
	private int descuento;
	
	public String getTipo(){
		return this.tipo;
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	public void setCantidad(int cantidad){
		this.cantidad=cantidad;
	}
	
	public int getPrecio(){
		return this.precio;
	}
	public void setPrecio(int precio){
		this.precio=precio;
	}
	
	public int getDescuento(){
		return this.descuento;
	}
	public void setDescuento(int descuento){
		this.descuento=descuento;
	}
	
	public Oferta(){
	
	}
	public Oferta(String tipo, int cantidad, int precio, int descuento){
		this.setTipo(tipo);
		this.setCantidad(cantidad);
		this.setPrecio(precio);
		this.setDescuento(descuento);
	}
}