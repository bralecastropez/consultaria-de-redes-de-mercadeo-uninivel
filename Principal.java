package org.brandon.sistema;

import org.brandon.utilidades.Entrada;
import org.brandon.utilidades.Decodificador;
import org.brandon.manejadores.ManejadorAdmin;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.app.AppAdmin;
import org.brandon.app.AppMiembro;
import org.brandon.app.AbstractAppRol;

import java.io.Console;

/**
*	@author Brandon Castro
*	Esta clase es la principal y hace que el usuario pueda entrar como miembro o administrador.
*/

public class Principal{

	public void iniciar(){
	
		do{
			try{
			
				Console terminal = System.console();
				if (terminal==null ) {
					System.err.println("No puedo obtener la consola.");
					return;
				}
				
				AbstractAppRol app = null;	
				
				System.out.println("");
				System.out.println("Ingrese Nombre de Usuario(nick): ");
				String nick=Entrada.getInstancia().leer();
			
				System.out.println("Ingrese Contrase a: ");
				String password = new String (terminal.readPassword("******"));
			
				boolean resultadoadmin = ManejadorAdmin.getInstancia().autenticarAdmin(nick, password);
				boolean resultadomim = ManejadorMiembro.getInstancia().autenticarMiembro(nick, password);
			
				if(resultadoadmin){
					System.out.println("");
					System.out.println("Bienvenido "+ManejadorAdmin.getInstancia().obtenerAdminAutenticado().getNombre());
					app=new AppAdmin(new Decodificador());
					app.iniciar();
				}if(resultadomim){
					System.out.println("");
					System.out.println("Bienvenido "+ManejadorMiembro.getInstancia().obtenerMiembroAutenticado().getNombre());
					app=new AppMiembro(new Decodificador());
					app.iniciar();
				}else{
					System.out.println("");
					System.out.println("Nombre de usuario o contrase a incorrecta.");
				}
				
			}catch(NullPointerException nullexception){
				System.out.println("Datos Erroneos, porfavor compruebe su sintaxis.");
			}
			
		}while(true);
		
	}
	
}