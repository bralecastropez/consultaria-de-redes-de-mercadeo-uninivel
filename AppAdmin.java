package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.utilidades.Comando;
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
				new Comando().exit();
				break;
			case "":
				break;
			case "edit me":
				if(parametros.size()<=2){
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
				}else{
					System.out.println("Compruebe su sintaxis.");
				}
				break;
			case "add user":
				if(parametros.size()<=2){
					Admin admin = new Admin();
					if(parametros.size()==3){
						admin.setNombre(parametros.get("nombre"));
						admin.setNick(parametros.get("nick"));
						admin.setPassword(parametros.get("password"));
						ManejadorAdmin.getInstancia().agregarAdmin(admin);
						System.out.println("Administrador agregado satisfactoriamente.");
					}else{
						System.out.println("Compruebe su sintaxis.");
					}
				}else{
					System.out.println("Ingrese bien los parametros");
				}
				break;
			case "remove user":
				Admin adminAEliminar = ManejadorAdmin.getInstancia().buscarAdmin(parametros.get("nick"));
				if(adminAEliminar!=null){
					ManejadorAdmin.getInstancia().eliminarAdmin(adminAEliminar);
					System.out.println("Administrador eliminado satisfactoriamente.");
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
				if(parametros.size()>=1){
					Producto productoAEditar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
					if(parametros.get("nuevonombre")!=null){
						productoAEditar.setNombre(parametros.get("nuevonombre"));
					}
					if(parametros.get("nuevacategoria")!=null){
						productoAEditar.setCategoria(parametros.get("nuevacategoria"));
					}
					if(parametros.get("nuevoprecio")!=null){
						productoAEditar.setPrecio(Integer.parseInt(parametros.get("nuevoprecio")));
					}
					System.out.println("Producto editado Satisfactoriamente.");
				}
				break;
			case "show sales":
				if(parametros.size()==0){
					for(Producto product : ManejadorProducto.getInstancia().obtenerListaProducto()){
						System.out.println("");
						System.out.println("nombre: "+product.getNombre());
					}
				}if(parametros.size()==1){
					Producto productoAMostrar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
					if(productoAMostrar!=null){
						System.out.println("");
						System.out.println("Nombre: "+productoAMostrar.getNombre());
						System.out.println("Categoria: "+productoAMostrar.getCategoria());
						System.out.println("Precio: "+productoAMostrar.getPrecio());
					}else{
						System.out.println("");
						System.out.println("El producto no existe.");
						System.out.println("");
					}
				}else{
					System.out.println("Compruebe su sintaxis.");
				}
				break;
			case "list products":
				new Comando().listarProductos();
				break;
			case "show product":
				if(parametros.size()>=1){
					Producto productoAMostrar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
					if(productoAMostrar!=null){
						System.out.println("");
						System.out.println("Nombre: "+productoAMostrar.getNombre());
						System.out.println("Categoria: "+productoAMostrar.getCategoria());
						System.out.println("Precio: "+productoAMostrar.getPrecio());
					}else{
						System.out.println("");
						System.out.println("El producto no existe.");
						System.out.println("");
					}
				}else{
					System.out.println("Compruebe su sintaxis.");
				}
				break;
			case "show downline":
				break;
			case "list downlines":
				break;
			case "show me":
				new Comando().showmeAdmin();
				break;
			case "show history":
				break;
			case "search downline":
				break;
			case "help":
				new Comando().ayudaadmin();
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}