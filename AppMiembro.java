package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.utilidades.Entrada;
import org.brandon.utilidades.Ayuda;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.manejadores.ManejadorProducto;
import org.brandon.beans.Miembro;
import org.brandon.beans.Producto;

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
			case "exit":
				System.exit(0);
				System.out.println("Gracias por utilizar mi programa.");
				break;
			case "logout":
				super.setConnected(false);
				break;
			case "show sales":
				break;
			case "list products":
				for(Producto producto : ManejadorProducto.getInstancia().obtenerListaProducto()){
					System.out.println("");
					System.out.println("Nombre: "+producto.getNombre());
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
				Miembro miembroAMostrar = ManejadorMiembro.getInstancia().obtenerMiembroAutenticado();
				System.out.println("");
				System.out.println("Nombre: "+miembroAMostrar.getNombre());
				System.out.println("Nick: "+miembroAMostrar.getNick());
				System.out.println("Edad: "+miembroAMostrar.getEdad());
				System.out.println("idDownline: "+miembroAMostrar.getIdDownline());
				System.out.println("Tarjeta de Credito: "+miembroAMostrar.getTarjeta());
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
					Miembro miembroAmodificar = ManejadorMiembro.getInstancia().obtenerMiembroAutenticado();
					if(parametros.get("nombre")!=null){
						miembroAmodificar.setNombre(parametros.get("nombre"));
					}
					if(parametros.get("nick")!=null){
						miembroAmodificar.setNick(parametros.get("nick"));
					}
					if(parametros.get("password")!=null){
						miembroAmodificar.setPassword(parametros.get("password"));
					}
					if(parametros.get("edad")!=null){
						miembroAmodificar.setEdad(Integer.parseInt(parametros.get("edad")));
					}
					if(parametros.get("tarjeta")!=null){
						miembroAmodificar.setEdad(Integer.parseInt(parametros.get("tarjeta")));
					}
					if(parametros.get("pin")!=null){
						miembroAmodificar.setEdad(Integer.parseInt(parametros.get("pin")));
					}
					System.out.println("Miembro Modificado");
				}
				break;
			case "help":
				new Ayuda().ayudamiembro();
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}