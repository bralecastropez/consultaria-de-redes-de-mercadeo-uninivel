package org.Brandon.app;

import org.Brandon.utilidades.eventos.DecodeListener;
import org.Brandon.utilidades.Decodificador;
import org.Brandon.manejadores.ManejadorUsuario;
import org.Brandon.beans.Usuario;

import java.util.HashMap;

public class AppMiembro extends AbstractAppRol implements DecodeListener{

	public AppAdmin(Decodificador decodificador){
		decodificador.addDecodeListener(this);	
		super.setDecodificador(decodificador);
		super.setConnected(true);
	}
	
	public void iniciar(){                    
		super.iniciar();
	}
	public void avisarAccionar(String accion, HashMap<String, String> parametros){
		switch(accion.trim()){
			case "add user":
				Usuario usuario = new Usuario();

				String nombre=parametros.get("nombre");
				usuario.setNombre(nombre);

				usuario.setNick(parametros.get("nick"));
				usuario.setPassword(parametros.get("password"));
				usuario.setRol(parametros.get("rol"));
				usuario.setEdad(Integer.parseInt(parametros.get("edad")));
	
				ManejadorUsuario.getInstancia().agregarUsuario(usuario);

				System.out.println("Miembro agregado satisfactoriamente.");
				
				break;
			case "remove user":
				Usuario usuarioAEliminar = ManejadorUsuario.getInstancia().buscarUsuario(parametros.get("nick"));
				if(usuarioAEliminar!=null){
					ManejadorUsuario.getInstancia().eliminarUsuario(usuarioAEliminar);
					System.out.println("	Usuario "+parametros.get("nick")+" eliminado satisfactoriamente.");
				}else{
					System.out.println("El usuario no existe.");
				}
				break;
			case "logout":
				super.setConnected(false);
				break;
			case "buy product":
				break;
			case "add downline":
				break;
			case "edit me":
				break;
			case "logout":
				super.setConnected(false);
				break;
			case "add product":
				break;
			case "remove product":
				break;
			case "edit product":
				break;
			case "show sales":
				break;
			case "list products":
				break;
			case "show products":
				break;
			case "show downline":
				break;
			case "show me":
				break;
			case "show history":
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}