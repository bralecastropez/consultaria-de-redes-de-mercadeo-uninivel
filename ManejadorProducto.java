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
	private ArrayList<Producto> HistorialOfertas;
	private Producto productoAutenticado;
	private static ManejadorProducto instancia;
	
	private ManejadorProducto(){
	
		this.historial			=	new ArrayList<Producto>();
		this.HistorialOfertas	=	new ArrayList<Producto>();
		this.historialVentas	=	new ArrayList<Producto>();
		this.listaProducto		=	new ArrayList<Producto>();
		
		this.listaProducto.add(new Producto("producto1", 			"default", 				1000));
		this.listaProducto.add(new Producto("producto2", 			"default", 				2000));
		this.listaProducto.add(new Producto("producto3", 			"default", 				3000));
		this.listaProducto.add(new Producto("producto4", 			"default", 				4000));
		this.listaProducto.add(new Producto("producto5", 			"default", 				5000));
	}
	
	//Agregar a Lista de Productos
	public void agregarProducto(Producto producto){
		this.listaProducto.add(producto);
	}
	//Eliminar de la lista un Producto
	public void eliminarProducto(Producto producto){
		this.listaProducto.remove(producto);
	}
	//Obtener Lista de Productos
	public ArrayList<Producto> obtenerListaProducto(){
		return this.listaProducto;
	}
	//Buscar un Producto en la lista.
	public Producto buscarProducto(String nombre){
		for(int posicion=0;posicion<this.listaProducto.size();posicion++){
			if(this.listaProducto.get(posicion).getNombre().equals(nombre)){
				return this.listaProducto.get(posicion);
			}
		}
		return null;
	}
	
	//Obtener historial de Compras
	public ArrayList<Producto> obtenerHistorial(){
		return this.historial;
	}
	//Agregar Historial de Compras
	public void agregarHistorial(Producto producto){
		this.historial.add(producto);
	}
	
	//Obtener historial de ventas
	public ArrayList<Producto> obtenerHistorialVentas(){
		return this.historialVentas;
	}
	//Agregar a historial de ventas
	public void agregarHistorialVentas(Producto producto){
		this.historialVentas.add(producto);
	}
	
	//Obtener historial de ofertas
	public ArrayList<Producto> obtenerHistorialOfertas(){
		return this.HistorialOfertas;
	}
	//Agregar a historial de Ofertas
	public void agregarHistorialOfertas(Producto producto){
		this.HistorialOfertas.add(producto);
	}
	
	//Instancia de la Clase.
	public static ManejadorProducto getInstancia(){
		if(instancia==null){
			instancia=new ManejadorProducto();
		}
		return instancia;
	}
}