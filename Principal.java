package org.Brandon.sistema;

import org.Brandon.utilidades.Entrada;
import org.Brandon.utilidades.Decodificador;
import org.Brandon.manejadores.ManejadorUsuario;
import org.Brandon.app.AppAdmin;
import org.Brandon.app.AbstractAppRol;

public class Principal{
	public void iniciar(){
		do{
			AbstractAppRol app = null;		
			String nick, password;
			System.out.println("Ingrese Nombre de Usuario: ");
			nick=Entrada.getInstancia().leer();
			System.out.println("Ingrese Contrase a: ");
			password=Entrada.getInstancia().leer();
		
			boolean resultado = ManejadorUsuario.getInstancia().autenticarUsuario(nick, password);

			if(resultado){
				System.out.println("Bienvenido "+ManejadorUsuario.getInstancia().obtenerUsuarioAutenticado().getNombre());
				switch(ManejadorUsuario.getInstancia().obtenerUsuarioAutenticado().getRol()){
					case "admin":
						app=new AppAdmin(new Decodificador());
						app.iniciar();
						break;
					default:
						System.out.println("Usuario no encontrado");
				}
			}else
				System.out.println("Verifique sus datos.");
		}while(true);
	}
}