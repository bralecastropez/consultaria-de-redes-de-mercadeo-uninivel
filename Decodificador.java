package org.brandon.utilidades;

import org.brandon.utilidades.eventos.DecodeListener;

import java.util.HashMap;
import java.util.ArrayList;

/**
*	@author Brandon Castro
*	Esta clase como su nombre lo indica esta creada para decodificar los comandos.
*/

public class Decodificador{

	private DecodeListener decodeListener;	
	
	public void addDecodeListener(DecodeListener decodeListener){
		this.decodeListener=decodeListener;
	}
	
	public void decodificarComando(String comando){
		try{
			HashMap<String, String> diccionario = new HashMap<String, String>();
			ArrayList<String> listaUbicacion = new ArrayList<String>();
			
			for(int ubicaciones=0;ubicaciones<comando.length();ubicaciones++){
				if(comando.substring(ubicaciones, ubicaciones+1).equals("'")){
					listaUbicacion.add(""+ubicaciones+"");
				}
			}
			int ubicacion=-1;
			
			for(int contador=0;contador<listaUbicacion.size();contador=contador+2){
				ubicacion=contador+1;
				int varContador=Integer.parseInt(listaUbicacion.get(contador));
				int varUbicacion=Integer.parseInt(listaUbicacion.get(ubicacion));
				String varTemporal=comando.substring(varContador,varUbicacion);
				String varReemplazar=comando.substring(varContador,varUbicacion).replace(' ','-');
				comando=comando.replace(varTemporal,varReemplazar);
			}
			listaUbicacion.clear();
			String[] comandos=comando.split(" ");
			String accion = null;
			
			if(comandos.length>1){
				accion = comandos[0]+" "+comandos[1];
			}else{
				accion = comandos[0];
			}
			
			for(int posicion=2;posicion<comandos.length;posicion++){
				String claveValor[] = comandos[posicion].split("=");
				diccionario.put(claveValor[0], claveValor[1]);
			}
			this.decodeListener.avisarAccionar(accion, diccionario);
		
		}catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("");
			System.out.println("Ingrese datos validos");
		}
	}
	
}