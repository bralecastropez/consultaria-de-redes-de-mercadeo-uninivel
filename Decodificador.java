package org.brandon.utilidades;

import org.brandon.utilidades.eventos.DecodeListener;

import java.util.HashMap;

public class Decodificador{
	private DecodeListener decodeListener;	
	
	public void addDecodeListener(DecodeListener decodeListener){
		this.decodeListener=decodeListener;
	}
	
	public void decodificarComando(String comando){
		String[] comandos=comando.split(" ");
		HashMap<String, String> diccionario = new HashMap<String, String>();
		String accion = null;

		if(comandos.length>1){
			accion = comandos[0]+" "+comandos[1];
		}if(comandos.length>2){
			accion = comandos[0]+" "+comandos[1]+" "+comandos[2];
		}else{
			accion = comandos[0];
		}		
		for(int posicion=2;posicion<comandos.length;posicion++){
			String claveValor[] = comandos[posicion].split("=");
			diccionario.put(claveValor[0], claveValor[1]);
		}

		this.decodeListener.avisarAccionar(accion, diccionario);
	}
}