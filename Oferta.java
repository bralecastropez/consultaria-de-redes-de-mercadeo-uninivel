package org.brandon.beans;

/**
* @author Brandon Castro
* Esta clase sirve para listar ofertas.
*/

public class Oferta extends Producto{

	private String tipo;
	private String producto;
	private int cantidad;
	private int precio;
	private int precioOficial;
	private int precioOferta;
	private int descuento;
	
	public String getTipo(){
		return this.tipo;
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public String getProducto(){
		return this.producto;
	}
	public void setProducto(String producto){
		this.producto=producto;
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
	
	public int getPrecioOficial(){
		return this.precioOficial;
	}
	public void setPrecioOficial(int precioOficial){
		this.precioOficial=precioOficial;
	}
	
	public int getPrecioOferta(){
		return this.precioOferta;
	}
	public void setPrecioOferta(int precioOferta){
		this.precioOferta=precioOferta;
	}
	
	public int getDescuento(){
		return this.descuento;
	}
	public void setDescuento(int descuento){
		this.descuento=descuento;
	}
	
	public Oferta(){
	
	}
	public Oferta(String tipo, int cantidad, int precio, int precioOficial, int precioOferta, int descuento,String producto){
		this.setTipo(tipo);
		this.setCantidad(cantidad);
		this.setPrecio(precio);
		this.setPrecioOficial(precioOficial);
		this.setPrecioOferta(precioOferta);
		this.setDescuento(descuento);
		this.setProducto(producto);
	}
}