package org.brandon.app;

import org.brandon.utilidades.Entrada;
import org.brandon.utilidades.Decodificador;

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
}