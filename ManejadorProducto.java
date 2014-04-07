package org.brandon.manejadores;

import java.util.ArrayList;

import org.brandon.beans.Producto;

public class ManejadorProducto{
	private ArrayList<Producto> listaProducto;
	private ArrayList<Producto> historial;
	private Producto productoAutenticado;
	private static ManejadorProducto instancia;
	
	private ManejadorProducto(){
		this.listaProducto=new ArrayList<Producto>();
		this.listaProducto.add(new Producto("producto1", 			"default", 				1000));
		this.listaProducto.add(new Producto("producto2", 			"default", 				2000));
		this.listaProducto.add(new Producto("producto3", 			"default", 				3000));
		this.listaProducto.add(new Producto("producto4", 			"default", 				4000));
		this.listaProducto.add(new Producto("producto5", 			"default", 				5000));
		this.listaProducto.add(new Producto("producto6", 			"default", 				6000));
		this.listaProducto.add(new Producto("producto7", 			"default", 				7000));
		this.listaProducto.add(new Producto("producto8", 			"default", 				8000));
		this.listaProducto.add(new Producto("producto9", 			"default", 				9000));
		
		this.historial=new ArrayList<Producto>();
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
	public ArrayList<Producto> obtenerHistorial(){
		return this.historial;
	}
	public void agregarHistorial(Producto producto){
		this.historial.add(producto);
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