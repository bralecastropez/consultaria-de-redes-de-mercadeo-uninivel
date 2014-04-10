package org.brandon.beans;

import java.util.ArrayList;

/**
*	@author Brandon Castro
*/

public class Downline{

	private ArrayList<Downline> listaDownlines;
	private String nombre;
	private int idDownline;
	private int edad;
	
	public void setListaDownlines(ArrayList<Downline> listaDownlines){
		this.listaDownlines=listaDownlines;
	}
	public 	ArrayList<Downline> getListaDownlines(){
		return this.listaDownlines;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setIdDownline(int idDownline){
		this.idDownline=idDownline;
	}
	public int getIdDownline(){
		return this.idDownline;
	}
	
	public void setEdad(int edad){
		this.edad=edad;
	}
	public int getEdad(){
		return this.edad;
	}
}