package org.brandon.manejadores;

import org.brandon.beans.Oferta;

import java.util.ArrayList;

/**
* @author Brandon Castro
* Esta clase es el manejador de Oferta.
*/

public class ManejadorOferta{

	private static ManejadorOferta instancia;
	private ArrayList<Oferta> listaOferta;
	
	private ManejadorOferta(){
		this.listaOferta=new ArrayList<Oferta>();
	}
	
	public ArrayList<Oferta> obtenerListaOferta(){
		return this.listaOferta;
	}
	public void agregarListaOferta(Oferta oferta){
		this.listaOferta.add(oferta);
	}
	
	public static ManejadorOferta getInstancia(){
		if(instancia==null){
			instancia=new ManejadorOferta();
		}
		return instancia;
	}
	
}