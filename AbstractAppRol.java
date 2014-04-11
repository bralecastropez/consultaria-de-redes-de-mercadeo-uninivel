package org.brandon.app;

import org.brandon.utilidades.Entrada;
import org.brandon.utilidades.Decodificador;
import org.brandon.beans.Miembro;
import org.brandon.beans.Downline;
import org.brandon.manejadores.ManejadorMiembro;

import java.util.HashMap;
import java.util.ArrayList;

/**
*	@author Brandon Castro
*	Esta clase sirve para cuando el usuario se ha autenticado.
*/

public abstract class AbstractAppRol{

	private Decodificador decodificador;
	private boolean estadoSesion;

	public Decodificador getDecodificador(){
		return this.decodificador;
	}
	
	public void setDecodificador(Decodificador decodificador){
		this.decodificador=decodificador;
	}
	
	public boolean isConnected(){
		return this.estadoSesion;
	}
	public void setConnected(boolean estadoSesion){
		this.estadoSesion=estadoSesion;
	}
	
	public void iniciar(){
		do{
			System.out.println("");
			System.out.print(">>");
			String comando=Entrada.getInstancia().leer();
			if(this.decodificador!=null){
				this.decodificador.decodificarComando(comando);
			}
		}while(estadoSesion);
	}
	
	public String obtenerLineas(int nivel){
		String resultado="";
		for(int posicion=0;posicion<nivel;posicion++){
			resultado+="     ";
		}
		return resultado;
	}
	
	public void listarDownlines(Downline downline, int nivel){
		String numeroDeLineas=this.obtenerLineas(nivel);
		for(Downline downlineDentro : downline.getListaDownlines()){
			System.out.println(numeroDeLineas+"-----------------------");
			System.out.println(numeroDeLineas+"|_____Nombre: "+downlineDentro.getNombre());
			System.out.println(numeroDeLineas+"|_____idDownline: "+downlineDentro.getIdDownline());
			System.out.println(numeroDeLineas+"|_____Edad: "+downlineDentro.getEdad());
			this.listarDownlines(downlineDentro, nivel+1);
		}
		System.out.println(numeroDeLineas+"-----------------------");
	}
	
}