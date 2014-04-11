package org.brandon.beans;

import java.util.ArrayList;

import org.brandon.manejadores.ManejadorProducto;
import org.brandon.manejadores.ManejadorAdmin;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.beans.Admin;
import org.brandon.beans.Miembro;
import org.brandon.beans.Producto;

/**
* @author Brandon Castro
* Esta clase nos sirve para listar los historiales.
*/

public class Historial{
	
	private static Historial instancia;
	
	
	
	private Historial(){
		
		
	}
	
	public static Historial getInstancia(){
		if(instancia==null){
			instancia=new Historial();
		}
		return instancia;
	}
	
	
	
}