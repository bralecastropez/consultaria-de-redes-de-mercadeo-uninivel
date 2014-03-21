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
			case "add product":
				break;
			case "remove product":
				break;
			case "edit product":
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
				break;
			case "show history":
				break;
			case "search downline":
				break;
			case "buy producto":
				break;
			case "add downline":
				break;
			case "edit me":
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}