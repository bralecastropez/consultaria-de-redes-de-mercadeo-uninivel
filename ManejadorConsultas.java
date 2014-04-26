package org.brandon.manejadores;


import org.brandon.beans.Admin;
import org.brandon.beans.Oferta;
import org.brandon.beans.Miembro;
import org.brandon.beans.Producto;
import org.brandon.beans.Downline;

import java.util.ArrayList;

public class ManejadorConsultas{

	private static ManejadorConsultas instancia;
	private ArrayList<Producto> listaProducto;
	private ArrayList<Producto> historial;
	private ArrayList<Producto> historialVentas;
	private ArrayList<Producto> HistorialOfertas;
	private ArrayList<Miembro> listaMiembro;
	private ArrayList<Downline> historialDownline;
	private ArrayList<Admin> listaAdmin;
	private ArrayList<Oferta> listaOferta;
	
	public static ManejadorConsultas getInstancia(){
		if(instancia==null){
			instancia = new ManejadorConsultas();
		}
		return instancia;
	}
	
	private ManejadorConsultas(){
	
		this.listaMiembro		=	new ArrayList<Miembro>();
		this.historialDownline	=	new ArrayList<Downline>();
		this.historial			=	new ArrayList<Producto>();
		this.HistorialOfertas	=	new ArrayList<Producto>();
		this.historialVentas	=	new ArrayList<Producto>();
		this.listaProducto		=	new ArrayList<Producto>();
		this.listaAdmin			=	new ArrayList<Admin>();
		this.listaOferta		=	new ArrayList<Oferta>();
	
	}
	
	public ArrayList<Oferta> obtenerListaOferta(){
		return this.listaOferta;
	}
	public void agregarListaOferta(Oferta oferta){
		this.listaOferta.add(oferta);
	}
	
	public void agregarAdmin(Admin admin){
		this.listaAdmin.add(admin);
	}
	
	public void eliminarAdmin(Admin admin){
		this.listaAdmin.remove(admin);
	}
	
	public ArrayList<Admin> obtenerListaAdmin(){
		return this.listaAdmin;
	}
	
	public Admin buscarAdmin(String nick){
		for(int posicion=0;posicion<this.listaAdmin.size();posicion++){
			if(this.listaAdmin.get(posicion).getNick().equals(nick)){
				return this.listaAdmin.get(posicion);
			}
		}
		return null;
	}
	
	
	public void agregarMiembro(Miembro miembro){
		this.listaMiembro.add(miembro);
	}
	
	public void eliminarMiembro(Miembro miembro){
		this.listaMiembro.remove(miembro);
	}
	
	public ArrayList<Miembro> obtenerListaMiembro(){
		return this.listaMiembro;
	}
	
	public ArrayList<Downline> obtenerHistorialDownline(){
		return this.historialDownline;
	}
	public void agregarHistorialDownline(Downline downline){
		this.historialDownline.add(downline);
	}
	
	public Miembro buscarMiembro(String nick){
		for(int posicion=0;posicion<this.listaMiembro.size();posicion++){
			if(this.listaMiembro.get(posicion).getNick().equals(nick)){
				return this.listaMiembro.get(posicion);
			}
		}
		return null;
	}
	
	public Downline buscarDentroDeDownline(Downline downline, String nombre){
		for(Downline downlineDentro : downline.getListaDownlines()){
			if(downlineDentro.getNombre().equals(nombre))
				return downlineDentro;
		}
		return null;
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
}