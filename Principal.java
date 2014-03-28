package org.brandon.sistema;

import org.brandon.utilidades.Entrada;
import org.brandon.utilidades.Decodificador;
import org.brandon.manejadores.ManejadorAdmin;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.app.AppAdmin;
import org.brandon.app.AppMiembro;
import org.brandon.app.AbstractAppRol;

public class Principal{
	public void iniciar(){
		do{
			AbstractAppRol app = null;		
			String nick, password;
			System.out.println("");
			System.out.println("Ingrese Nombre de Usuario(nick): ");
			nick=Entrada.getInstancia().leer();
			System.out.println("Ingrese Contrase a: ");
			password=Entrada.getInstancia().leer();
		
			boolean resultadoadmin = ManejadorAdmin.getInstancia().autenticarAdmin(nick, password);
			boolean resultadomim = ManejadorMiembro.getInstancia().autenticarMiembro(nick, password);
			
			if(resultadoadmin){
				System.out.println("");
				System.out.println("Bienvenido "+ManejadorAdmin.getInstancia().obtenerAdminAutenticado().getNombre());
				switch(ManejadorAdmin.getInstancia().obtenerAdminAutenticado().getRol()){
					case "admin":
						app=new AppAdmin(new Decodificador());
						app.iniciar();
						break;
					default:
						System.out.println("Usuario no encontrado");
				}
			}if(resultadomim){
				System.out.println("");
				System.out.println("Bienvenido "+ManejadorMiembro.getInstancia().obtenerMiembroAutenticado().getNombre());
				switch(ManejadorMiembro.getInstancia().obtenerMiembroAutenticado().getRol()){
					case "miembro":
						app=new AppMiembro(new Decodificador());
						app.iniciar();
						break;
					default:
						System.out.println("Usuario no encontrado");
				}
			}else{
				System.out.println("");
				System.out.println("Nombre de usuario o contrase a incorrecta.");
			}
			/*
				clase de respaldo
			*/
			/*boolean resultado = ManejadorAdmin.getInstancia().autenticarAdmin(nick, password);

			if(resultado){
				System.out.println("");
				System.out.println("Bienvenido "+ManejadorAdmin.getInstancia().obtenerAdminAutenticado().getNombre());
				switch(ManejadorAdmin.getInstancia().obtenerAdminAutenticado().getRol()){
					case "admin":
						app=new AppAdmin(new Decodificador());
						app.iniciar();
						break;
					case "miembro":
						app=new AppMiembro(new Decodificador());
						app.iniciar();
						break;
					default:
						System.out.println("Usuario no encontrado");
				}
			}else{
				System.out.println("");
				System.out.println("Nombre de usuario o contrase a incorrecta.");
			}*/
		}while(true);
	}
}