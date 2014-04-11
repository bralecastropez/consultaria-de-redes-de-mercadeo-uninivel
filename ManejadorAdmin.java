package org.brandon.manejadores;

import java.util.ArrayList;

import org.brandon.beans.Admin;

/**
*	@author Brandon Castro
*	Esta clase es el manejador del Administrador.
*/

public class ManejadorAdmin{

	private ArrayList<Admin> listaAdmin;
	private Admin adminAutenticado;
	private static ManejadorAdmin instancia;
	
	private ManejadorAdmin(){
		this.listaAdmin=new ArrayList<Admin>();
		this.listaAdmin.add(new Admin( "Administrador", 			"admin", 		"admin"));
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
	
	public boolean autenticarAdmin(String nick, String password){
		Admin adminBuscado = this.buscarAdmin(nick);
		if(adminBuscado!=null){
			if(adminBuscado.getPassword().equals(password)){
				this.adminAutenticado = adminBuscado;
				return true;
			}
		}
		return false;
	}
	public void desautenticarAdmin(){
		this.adminAutenticado=null;
	}
	public Admin obtenerAdminAutenticado(){
		return this.adminAutenticado;
	}
	
	public static ManejadorAdmin getInstancia(){
		if(instancia==null){
			instancia=new ManejadorAdmin();
		}
		return instancia;
	}
}