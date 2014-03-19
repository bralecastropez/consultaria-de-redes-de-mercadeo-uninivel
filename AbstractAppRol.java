package org.Brandon.app;

import org.Brandon.utilidades.Entrada;
import org.Brandon.utilidades.Decodificador;

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
	

	public void buscarPelicula(){
		
	}
	public void obtenerPeliculas(){

	}
	public void obtenerSalas(){
		
	}
	public void iniciar(){
		do{
			System.out.print("comandos>>");
			String comando=Entrada.getInstancia().leer();
			if(this.decodificador!=null){
				this.decodificador.decodificarComando(comando);
			}
		}while(estadoSesion);
	}
}