package org.brandon.utilidades;

import java.util.Scanner;

/**
*	@author Brandon Castro
*	Esta clase sirve para leer entradas escritas por el usuario.
*/

public class Entrada{

	private static Entrada instancia;
	private Scanner scaner;
	
	private Entrada(){
		this.scaner=new Scanner(System.in);
	}
	
	public String leer(){
		return scaner.nextLine();
	}
	
	public void cerrar(){
		scaner.close();
	}
	
	public static Entrada getInstancia(){
		if(instancia==null)
			instancia=new Entrada();
		return instancia;
	}

}