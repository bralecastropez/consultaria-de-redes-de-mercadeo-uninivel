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
					Usuario usuarioAEditar = ManejadorUsuario.getInstancia().obtenerUsuarioAutenticado();
					if(parametros.get("nombre")!=null){
						usuarioAEditar.setNombre(parametros.get("nombre"));
					}
					if(parametros.get("nick")!=null){
						usuarioAEditar.setNick(parametros.get("nick"));
					}
					if(parametros.get("password")!=null){
						usuarioAEditar.setPassword(parametros.get("password"));
					}
					if(parametros.get("rol")!=null){
						usuarioAEditar.setRol(parametros.get("rol"));
					}
					if(parametros.get("edad")!=null){
						usuarioAEditar.setEdad(Integer.parseInt(parametros.get("edad")));
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
			case "help":
				System.out.println("Comandos que puede usar el Administrador");
				System.out.println("");
				System.out.println("edit me - Este comando modifica datos del usuario");
				System.out.println("SINTAXIS: edit me [Parametro]=[Nuevo Valor]");
				System.out.println("");
				System.out.println("add user - Este comando agrega un nuevo administrador");
				System.out.println("SINTAXIS: add user [nombre]=[nuevo valor] []=[] []=[]");
				System.out.println("");
				System.out.println("remove user - Este comando elimina un usuario por medio de su nik");
				System.out.println("SINTAXIS: remove user [nick]=[nick del usuario a eliminar]");
				System.out.println("");
				System.out.println("list user - muestra un listado de todos los administradores");
				System.out.println("SINTAXIS: list user");
				System.out.println("");
				System.out.println("logout - Este comando sirve para cerrar sesion");
				System.out.println("SINTAXIS: logout ");
				System.out.println("");
				System.out.println("search downline - ");
				System.out.println("SINTAXIS:");
				System.out.println("");
				System.out.println("add product - Este comando agrega un producto a la base de datos");
				System.out.println("SINTAXIS: add producto [nombre]=[nombre del producto] [categoria]=[categoria del producto] [precio]=[precio del producto]");
				System.out.println("");
				System.out.println("show history - ");
				System.out.println("SINTAXIS:");
				System.out.println("");
				System.out.println("show me - Muestra la informacion del administrador auntentificado");
				System.out.println("SINTAXIS: show me");
				System.out.println("");
				System.out.println("remove product - Elimina un producto de la base de datos");
				System.out.println("SINTAXIS: remove producto [nombre]=[nombre del producto a elimibnar]");
				System.out.println("");
				System.out.println("edit product - ");
				System.out.println("SINTAXIS:");
				System.out.println("");
				System.out.println("show sales - ");
				System.out.println("SINTAXIS:");
				System.out.println("");
				System.out.println("list products - Muestra un listado de los productos");
				System.out.println("SINTAXIS: list products");
				System.out.println("");
				System.out.println("show product - ");
				System.out.println("SINTAXIS:");
				System.out.println("");
				System.out.println("list downlines - ");
				System.out.println("SINTAXIS:");
				System.out.println("");
				System.out.println("show downline - ");
				System.out.println("SINTAXIS:");
				System.out.println("");
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}