package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.manejadores.ManejadorUsuario;
import org.brandon.beans.Usuario;

import java.util.HashMap;

public class AppAdmin extends AbstractAppRol implements DecodeListener{

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
				usuario.setEdad(Integer.parseInt(parametros.get("edad")));
	
				ManejadorUsuario.getInstancia().agregarUsuario(usuario);

				System.out.println("Administrador agregado satisfactoriamente.");
				
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
			case "list user":
				for(Usuario user : ManejadorUsuario.getInstancia().obtenerListaUsuario()){
					System.out.println("");
					System.out.println("nombre: "+user.getNombre());
					System.out.println("nick: "+user.getNick());
					System.out.println("rol: "+user.getRol());
					System.out.println("edad: "+user.getEdad());
				}
				System.out.println("");
				System.out.println("------------------------------");
				System.out.println("Fin de la lista");
				System.out.println("");
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
			case "show product":
				break;
			case "show downline":
				break;
			case "list downlines":
				break;
			case "show me":
				Usuario user = ManejadorUsuario.getInstancia().obtenerUsuarioAutenticado();
				System.out.println("");
				System.out.println("nombre: "+user.getNombre());
				System.out.println("nick: "+user.getNick());
				System.out.println("edad: "+user.getEdad());
				System.out.println("");
				break;
			case "show history":
				break;
			case "search downline":
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}