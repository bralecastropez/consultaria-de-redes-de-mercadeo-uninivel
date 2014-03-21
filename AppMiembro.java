package org.brandon.sistema;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.manejadores.ManejadorUsuario;
import org.brandon.manejadores.ManejadorProducto;
import org.brandon.beans.Usuario;
import org.brandon.beans.Producto;
import org.brandon.app.AbstractAppRol;

import java.util.HashMap;

public class AppMiembro extends AbstractAppRol implements DecodeListener{

	public AppMiembro(Decodificador decodificador){
		decodificador.addDecodeListener(this);	
		super.setDecodificador(decodificador);
		super.setConnected(true);
	}
	
	public void iniciar(){                    
		super.iniciar();
	}
	public void avisarAccionar(String accion, HashMap<String, String> parametros){
		switch(accion.trim()){
			case "logout":
				super.setConnected(false);
				break;
			case "show sales":
				break;
			case "list products":
			for(Producto producto : ManejadorProducto.getInstancia().obtenerListaProducto()){
					System.out.println("");
					System.out.println("nombre: "+producto.getNombre());
				}
				System.out.println("");
				System.out.println("------------------------------");
				System.out.println("Fin de la lista");
				System.out.println("");
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
			case "buy product":
				break;
			case "add downline":
				break;
			case "edit me":
				if(parametros.size()>=1){
					Usuario usuarioAmodificar = ManejadorUsuario.getInstancia().obtenerUsuarioAutenticado();
					if(parametros.get("nombre")!=null){
						usuarioAmodificar.setNombre(parametros.get("nombre"));
					}
					if(parametros.get("nick")!=null){
						usuarioAmodificar.setNick(parametros.get("nick"));
					}
					if(parametros.get("password")!=null){
						usuarioAmodificar.setPassword(parametros.get("password"));
					}
					if(parametros.get("rol")!=null){
						usuarioAmodificar.setRol(parametros.get("rol"));
					}
					if(parametros.get("edad")!=null){
						usuarioAmodificar.setEdad(Integer.parseInt(parametros.get("edad")));
					}
					System.out.println("Administrador Modificado");
				}
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}