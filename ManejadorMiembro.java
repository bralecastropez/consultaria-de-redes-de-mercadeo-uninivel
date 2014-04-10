package org.brandon.manejadores;

import java.util.ArrayList;

import org.brandon.beans.Miembro;
import org.brandon.beans.Downline;

/**
*	@author Brandon Castro
*	Esta clase es el manejador del miembro.
*/

public class ManejadorMiembro{

	private ArrayList<Miembro> listaMiembro;
	private Miembro miembroAutenticado;
	private static ManejadorMiembro instancia;
	
	private ManejadorMiembro(){
		this.listaMiembro=new ArrayList<Miembro>();
		this.listaMiembro.add(new Miembro( "Miembro", 		"mim",	 		"mim", 			01,			2013155,		0001));
		this.listaMiembro.add(new Miembro( "Miembro2", 		"mim2", 		"mim2", 		20,			2013156,		0002));
		this.listaMiembro.add(new Miembro( "Miembro3", 		"mim3", 		"mim3", 		30,			2013157,		0003));
		this.listaMiembro.add(new Miembro( "Miembro4", 		"mim4", 		"mim4", 		40,			2013158,		0004));
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
	
	public boolean autenticarMiembro(String nick, String password){
		Miembro miembroBuscado = this.buscarMiembro(nick);
		if(miembroBuscado!=null){
			if(miembroBuscado.getPassword().equals(password)){
				this.miembroAutenticado = miembroBuscado;
				return true;
			}
		}
		return false;
	}
	public void desautenticarMiembro(){
		this.miembroAutenticado=null;
	}
	public Miembro obtenerMiembroAutenticado(){
		return this.miembroAutenticado;
	}
	
	public static ManejadorMiembro getInstancia(){
		if(instancia==null)
			instancia=new ManejadorMiembro();
		return instancia;
	}
}