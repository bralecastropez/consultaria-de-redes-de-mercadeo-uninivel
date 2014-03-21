package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.manejadores.ManejadorUsuario;
import org.brandon.manejadores.ManejadorProducto;
import org.brandon.beans.Usuario;
import org.brandon.beans.Producto;

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
					System.out.println("+++++++++++++++++++++++++");
					System.out.println("nombre: "+user.getNombre());
					System.out.println("nick: "+user.getNick());
					System.out.println("rol: "+user.getRol());
					System.out.println("edad: "+user.getEdad());
					System.out.println("");
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
				Producto producto = new Producto();
				
				producto.setNombre(parametros.get("nombre"));
				producto.setCategoria(parametros.get("categoria"));
				producto.setPrecio(Integer.parseInt(parametros.get("precio")));
	
				ManejadorProducto.getInstancia().agregarProducto(producto);

				System.out.println("Producto agregado satisfactoriamente.");
				break;
			case "remove product":
				Producto productoAEliminar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
				if(productoAEliminar!=null){
					ManejadorProducto.getInstancia().eliminarProducto(productoAEliminar);
					System.out.println("	Producto "+parametros.get("nombre")+" eliminado satisfactoriamente.");
				}else{
					System.out.println("El producto no existe.");
				}
				break;
			case "edit product":
				break;
			case "show sales":
				break;
			case "list products":
				for(Producto product : ManejadorProducto.getInstancia().obtenerListaProducto()){
					System.out.println("");
					System.out.println("nombre: "+product.getNombre());
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
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}