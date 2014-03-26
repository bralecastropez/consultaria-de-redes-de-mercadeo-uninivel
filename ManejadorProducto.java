package org.brandon.manejadores;

import java.util.ArrayList;

import org.brandon.beans.Producto;

public class ManejadorProducto{
	private ArrayList<Producto> listaProducto;
	private Producto productoAutenticado;
	private static ManejadorProducto instancia;
	
	private ManejadorProducto(){
		this.listaProducto=new ArrayList<Producto>();

		this.listaProducto.add(new Producto("Reloj avanzado", 		"Relojes", 				1000));
		this.listaProducto.add(new Producto("Reloj medio", 			"Relojes", 				750));
		this.listaProducto.add(new Producto("reloj", 				"Relojes", 				250));
		this.listaProducto.add(new Producto("Samsung galaxi s3", 	"Smartphones",			6500));
		this.listaProducto.add(new Producto("Samsung galaxi s4", 	"Smartphones", 			7000));
		this.listaProducto.add(new Producto("Lg optimus l5", 		"Smartphones", 			3500));
		this.listaProducto.add(new Producto("Lg optimus l3", 		"Smartphones", 			1000));
		this.listaProducto.add(new Producto("Lg optimus l7", 		"Smartphones", 			6790));
		this.listaProducto.add(new Producto("Mouse laser x", 		"Computacion", 			250));
		this.listaProducto.add(new Producto("teclado laser", 		"Computacion", 			350));
		
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