package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.utilidades.Comando;
import org.brandon.manejadores.ManejadorAdmin;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.manejadores.ManejadorProducto;
import org.brandon.beans.Admin;
import org.brandon.beans.Miembro;
import org.brandon.beans.Downline;
import org.brandon.beans.Producto;

import java.util.HashMap;

/**
*	@author Brandon Castro
*	Esta clase nos sirve para la Aplicacion del Administrador.
*/

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
		
			case "add member":
				if(parametros.size()==6){
					Miembro miembro = new Miembro();
					if(parametros.get("nombre")!=null && parametros.get("nick")!=null && parametros.get("password")!=null && parametros.get("edad")!=null && parametros.get("tarjeta")!=null && parametros.get("pin")!=null){
						miembro.setNombre(parametros.get("nombre"));
						miembro.setNick(parametros.get("nick"));
						miembro.setPassword(parametros.get("password"));
						miembro.setEdad(Integer.parseInt(parametros.get("edad")));
						miembro.setTarjeta(Integer.parseInt(parametros.get("tarjeta")));
						miembro.setPin(Integer.parseInt(parametros.get("pin")));
						ManejadorMiembro.getInstancia().agregarMiembro(miembro);
						System.out.println("Miembro agregado satisfactoriamente.");
					}
				}else{
					System.out.println("Compruebe su sintaxis. Escribe || help || para obtener ayuda");
				}
			break;
			
			case "remove member":
				if(parametros.size()>0 && parametros.size()<2){
					Miembro miembroAEliminar = ManejadorMiembro.getInstancia().buscarMiembro(parametros.get("nick"));
					if(miembroAEliminar!=null){
						ManejadorMiembro.getInstancia().eliminarMiembro(miembroAEliminar);
						System.out.println("Miembro eliminado satisfactoriamente.");
					}else{
						System.out.println("El usuario no existe.");
					}
				}else{
					System.out.println("Compruebe su sintaxis. Escribe || help || para obtener ayuda");
				}
			break;
				
			case "list products":
				if(parametros.size()>0){
					System.out.println("");
					System.out.println("La sintaxis correcta es : list products. Escribe || help || para obtener ayuda");
				}else{
					Comando.getInstancia().listarProductos();
				}
			break;
				
			case "show product":
				if(parametros.size()>0 && parametros.size()<2){
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
					System.out.println("Solo se puede ingresar un producto. Escribe || help || para obtener ayuda");
				}
			break;
				
			case "exit":
				Comando.getInstancia().exit();
			break;
				
			case "":
				System.out.println("Escribe || help || para obtener ayuda");
			break;
				
			case "edit me":
				if(parametros.size()>=1 && parametros.size()<=3){
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
				}else{
					System.out.println("Compruebe su sintaxis.");
				}
			break;
				
			case "add user":
				if(parametros.size()>1 && parametros.size()<4){
					Admin admin = new Admin();
					if(parametros.get("nombre")!=null && parametros.get("nick")!=null && parametros.get("password")!=null){
					
						admin.setNombre(parametros.get("nombre"));
						admin.setNick(parametros.get("nick"));
						admin.setPassword(parametros.get("password"));
						ManejadorAdmin.getInstancia().agregarAdmin(admin);
						System.out.println("Administrador agregado satisfactoriamente.");
					}
				}else{
					System.out.println("Compruebe su sintaxis. Escribe || help || para obtener ayuda");
				}
			break;
				
			case "remove user":
				if(parametros.size()>0 && parametros.size()<2){
					Admin adminAEliminar = ManejadorAdmin.getInstancia().buscarAdmin(parametros.get("nick"));
					if(adminAEliminar!=null){
						ManejadorAdmin.getInstancia().eliminarAdmin(adminAEliminar);
						System.out.println("Administrador eliminado satisfactoriamente.");
					}else{
						System.out.println("El usuario no existe. Escribe || help || para obtener ayuda");
					}
				}else{
					System.out.println("Comprueba tu sintaxis. Escribe ||help|| para obtener ayuda.");
				}
			break;
				
			case "list user":
				System.out.println("");
				System.out.println("------------------------------------");
				System.out.println("Administradores: ");
				for(Admin administrador : ManejadorAdmin.getInstancia().obtenerListaAdmin()){
					System.out.println("");
					System.out.println("Nombre: "+administrador.getNombre());
					System.out.println("Nombre de Usuario (nick): "+administrador.getNick());
					System.out.println("");
				}
				System.out.println("------------------------------------");
				System.out.println("Miembros");
				for(Miembro member : ManejadorMiembro.getInstancia().obtenerListaMiembro()){
					System.out.println("");
					System.out.println("Nombre: "+member.getNombre());
					System.out.println("Nombre de usuario (nick): "+member.getNick());
					System.out.println("Tarjeta: "+member.getTarjeta());
					System.out.println("");
				}
				System.out.println("------------------------------------");
				System.out.println("Fin de la lista");
				System.out.println("");
			break;
				
			case "logout":
				super.setConnected(false);
			break;
				
			case "add product":
				try{
					Producto producto = new Producto();
				
					producto.setNombre(parametros.get("nombre"));
					producto.setCategoria(parametros.get("categoria"));
					producto.setPrecio(Integer.parseInt(parametros.get("precio")));
		
					ManejadorProducto.getInstancia().agregarProducto(producto);
	
					System.out.println("Producto agregado satisfactoriamente.");
				}catch(NumberFormatException numexc){
					System.out.println("");
					System.out.println("Ingresa datos validos. Escribe || help || para obtener ayuda");
				}
			break;
			
			case "remove product":
				if(parametros.size()>0 && parametros.size()<2){
					Producto productoAEliminar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
					if(productoAEliminar!=null){
						ManejadorProducto.getInstancia().eliminarProducto(productoAEliminar);
						System.out.println("	Producto eliminado satisfactoriamente.");
					}else{
						System.out.println("El producto no existe. Escribe || help || para obtener ayuda");
					}
				}else{
					System.out.println("Comprueba tu sintaxis. Escribe ||help|| para obtener ayuda.");
				}
			break;
				
			case "edit product":
				try{
					if(parametros.size()>=1 && parametros.size()<=3){
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
				}catch(NumberFormatException pinexc){
					System.out.println("");
					System.out.println("Ingresa datos validos. Escribe || help || para obtener ayuda");
				}
			break;
				
			case "show sales":
				Comando.getInstancia().showSales();
			break;
				
			case "show downline":
			break;
			
			case "list downlines":
				for(Miembro miembro : ManejadorMiembro.getInstancia().obtenerListaMiembro()){
					System.out.println("---------------------------------");
					System.out.println("Nombre: "+miembro.getNombre());
					System.out.println("idDowline: "+miembro.getIdDownline());
					System.out.println("Edad: "+miembro.getEdad());
					System.out.println("--------Downlines-------");
					this.listarDownlines(miembro, 1);
				}
				System.out.println("---------------------------------");
			break;
				
			case "show me":
				Comando.getInstancia().showmeAdmin();
			break;
				
			case "show history":
				if(parametros.size()<1){
					System.out.println("La sintaxis correcta es : ||| show history [buy] --- show history [downline] [idDownline] |||");
				}else{
					if(parametros.size()>0 && parametros.size()<2){
						System.out.println("");
						System.out.println("Los Productos que ha comprado son: ");
						System.out.println("");
						for(Producto history : ManejadorProducto.getInstancia().obtenerHistorial()){
							System.out.println("");
							System.out.println("Nombre: "+history.getNombre()+"     ");
							System.out.println("Categoria: "+history.getCategoria()+"     ");
							System.out.println("Precio: "+history.getPrecio()+"     ");
							System.out.println("");
						}
						System.out.println("");
						System.out.println("Fin de la lista");
						System.out.println("");
					}/*else{
						if(parametros.size()>=2 && parametros.size()<4){
							System.out.println("Sus downline son:");
							for(Downline historial : ManejadorMiembro.getInstancia().obtenerHistorialDownline()){
								System.out.println("Nombre: "+historial.getNombre());
								System.out.println("Edad: "+historial.getEdad());
								System.out.println("IdDOWNLINE: "+historial.getIdDownline());
							}
						}else{
							System.out.println("Comprueba tu sintaxis");
						}
					}*/
				}
			break;
			
			case "search downline":
			break;
				
			case "help":
				Comando.getInstancia().ayudaadmin();
			break;
				
			default:
				System.out.println("");
				System.out.println("Compruebe su sintaxis. Escribe || help || para obtener ayuda");
		}
	}
}