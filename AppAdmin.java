package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.manejadores.ManejadorAdmin;
import org.brandon.manejadores.ManejadorProducto;
import org.brandon.beans.Admin;
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
			case "exit":
				System.exit(0);
				break;
			case "edit me":
				if(parametros.size()>=1){
					Admin adminAEditar = ManejadorAdmin.getInstancia().obtenerAdminAutenticado();
					if(parametros.get("nombre")!=null){
						adminAEditar.setNombre(parametros.get("nombre"));
					}
					if(parametros.get("nick")!=null){
						adminAEditar.setNick(parametros.get("nick"));
					}
					if(parametros.get("password")!=null){
						adminAEditar.setPassword(parametros.get("password"));
					}
					System.out.println("Administrador Modificado");
				}
				break;
			case "add user":
				Admin admin = new Admin();

				admin.setNombre(parametros.get("nombre"));
				admin.setNick(parametros.get("nick"));
				admin.setPassword(parametros.get("password"));
				ManejadorAdmin.getInstancia().agregarAdmin(admin);

				System.out.println("Administrador agregado satisfactoriamente.");
				
				break;
			case "remove user":
				Admin adminAEliminar = ManejadorAdmin.getInstancia().buscarAdmin(parametros.get("nick"));
				if(adminAEliminar!=null){
					ManejadorAdmin.getInstancia().eliminarAdmin(adminAEliminar);
					System.out.println("	Usuario "+parametros.get("nick")+" eliminado satisfactoriamente.");
				}else{
					System.out.println("El usuario no existe.");
				}
				break;
			case "list user":
				for(Admin administrador : ManejadorAdmin.getInstancia().obtenerListaAdmin()){
					System.out.println("+++++++++++++++++++++++++");
					System.out.println("nombre: "+administrador.getNombre());
					System.out.println("nick: "+administrador.getNick());
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
					System.out.println("	Producto eliminado satisfactoriamente.");
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
				/*Producto productoAMostrar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
				//Producto product = ManejadorProducto.getInstancia().obtenerListaProducto();
				if(productoAMostrar.equals(product)){
					System.out.println("Nombre: "+productoAMostrar.getNombre());
					System.out.println("Precio: "+productoAMostrar.getPrecio());
					System.out.println("Categoria: "+productoAMostrar.getCategoria());
				}else{
					System.out.println("El producto no existe.");
				}*/
				break;
			case "show downline":
				break;
			case "list downlines":
				break;
			case "show me":
				Admin admi = ManejadorAdmin.getInstancia().obtenerAdminAutenticado();
				System.out.println("");
				System.out.println("nombre: "+admi.getNombre());
				System.out.println("nick: "+admi.getNick());
				System.out.println("");
				break;
			case "show history":
				break;
			case "search downline":
				break;
			case "help":
				System.out.println("Comandos que puede usar el Administrador");
				System.out.println("");
				System.out.println("list products - Muestra un listado de los productos");
				System.out.println("SINTAXIS: list products");
				System.out.println("");
				System.out.println("show product - Muestra informacion detallada de un producto. ");
				System.out.println("SINTAXIS: show product[nombre del producto]");
				System.out.println("");
				System.out.println("list downlines - Muestra una lista de tus downlines o del downline especificado");
				System.out.println("SINTAXIS: list downlines [idDownline]");
				System.out.println("");
				System.out.println("show downline - Muestra información detallada del downline especificado, si se agrega [money] mostrara solo la informacion de volumen monetario");
				System.out.println("SINTAXIS: show downline [idDownline] [Money]");
				System.out.println("");
				System.out.println("show history - Muestra el historial de downlines agregados, si se agrega buy mostrará el historial de compras de mi perfil, si se agrega downline y el id del  downline se mostrará o bien el historial de downlines agregados o de compras dependiendo de la combinación (si se le agrega buy o no)");
				System.out.println("SINTAXIS: show history [buy] [downline] [idDownline] ");
				System.out.println("");
				System.out.println("show me - Muestra la información de mi perfil, si se coloca money mostrara solo la información de volumen monetario");
				System.out.println("SINTAXIS: show me [money]");
				System.out.println("");
				System.out.println("logout - Este comando sirve para cerrar sesion");
				System.out.println("SINTAXIS: logout ");
				System.out.println("");
				System.out.println("search downline - Muestra la información detallada del downline si coincide con la búsqueda");
				System.out.println("SINTAXIS: search downline [Datos]");
				System.out.println("");
				System.out.println("exit - Sale totalmente del programa");
				System.out.println("SINTAXIS: exit");
				System.out.println("");
				System.out.println("add product - Agrega un producto del stock");
				System.out.println("SINTAXIS: add product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]");
				System.out.println("");
				System.out.println("remove product - Elimina un producto del stock");
				System.out.println("SINTAXIS: remove product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]");
				System.out.println("");
				System.out.println("edit product - Modifica un producto del stock");
				System.out.println("SINTAXIS: edit product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]");
				System.out.println("");
				System.out.println("show sales - Muestra información de venta de un producto si se especifica, o de todos si no se especifica.");
				System.out.println("SINTAXIS: show sales [product [nombre del producto] ]");
				System.out.println("");
				System.out.println("add user - Agrega un Administrador");
				System.out.println("SINTAXIS: add user nombre=[nombre que desea ponerle al admnistrador] password=[contraseña del administrador] edad=[edad del nuevo administrador] nick=[nombre de usuario del nuevo administrador]");
				System.out.println("");
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}