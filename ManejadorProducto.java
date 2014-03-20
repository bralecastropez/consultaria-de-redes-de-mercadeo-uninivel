package org.brandon.manejadores;

import java.util.ArrayList;

import org.brandon.beans.Producto;

public class ManejadorProducto{
	private ArrayList<Producto> listaProducto;
	private Producto productoAutenticado;
	private static ManejadorProducto instancia;
	
	private ManejadorProducto(){
		this.listaProducto=new ArrayList<Producto>();

		this.listaProducto.add(new Producto("Reloj avanzado", "Utilidades", 250));
	}
	
	public void agregarProducto(Producto producto){
		this.listaProducto.add(producto);
	}
	public void eliminarProducto(Producto producto){
		this.listaProducto.remove(producto);
	}
	public ArrayList<Producto> obtenerListaProducto(){
		return this.listaProducto;
	}
	public Producto buscarProducto(String nombre){
		for(int posicion=0;posicion<this.listaProducto.size();posicion++){
			if(this.listaProducto.get(posicion).getNombre().equals(nombre)){
				return this.listaProducto.get(posicion);
			}
		}
		return null;
	}
	public static ManejadorProducto getInstancia(){
		if(instancia==null)
			instancia=new ManejadorProducto();
		return instancia;
	}
}