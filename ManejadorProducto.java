package org.brandon.manejadores;

import java.util.ArrayList;

import org.brandon.beans.Producto;

/**
*	@author Brandon Castro
*	Esta clase es el manejador del beans producto.
*/

public class ManejadorProducto{

	private ArrayList<Producto> listaProducto;
	private ArrayList<Producto> historial;
	private ArrayList<Producto> historialVentas;
	private Producto productoAutenticado;
	private static ManejadorProducto instancia;
	
	private ManejadorProducto(){
	
		this.historial=new ArrayList<Producto>();
		
		this.historialVentas=new ArrayList<Producto>();
		
		this.listaProducto=new ArrayList<Producto>();
		this.listaProducto.add(new Producto("producto1", 			"default", 				1000));
		this.listaProducto.add(new Producto("producto2", 			"default", 				2000));
		this.listaProducto.add(new Producto("producto3", 			"default", 				3000));
		this.listaProducto.add(new Producto("producto4", 			"default", 				4000));
		this.listaProducto.add(new Producto("producto5", 			"default", 				5000));
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
	
	public ArrayList<Producto> obtenerHistorialVentas(){
		return this.historialVentas;
	}
	public void agregarHistorialVentas(Producto producto){
		this.historialVentas.add(producto);
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
		if(instancia==null){
			instancia=new ManejadorProducto();
		}
		return instancia;
	}
}