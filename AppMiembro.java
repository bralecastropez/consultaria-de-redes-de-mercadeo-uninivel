package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.utilidades.Entrada;
import org.brandon.utilidades.Comando;
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
				new Comando().exit();
				break;
			case "logout":
				super.setConnected(false);
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
				}
				break;
			case "list products":
				new Comando().listarProductos();
				break;
			case "show product":
				if(parametros.size()==1){
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
					System.out.println("Comprueba tu sintaxis.");
				}
				break;
			case "show downline":
				break;
			case "list downlines":
				break;
			case "show me":
				new Comando().showmeMiembro();
				break;
			case "":
				break;
			case "show history":
				break;
			case "search downline":
				break;
			case "buy product":
				/*if(parametros.size()==2){
					Producto productoAComprar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
					Miembro tarjetaSinAutenticar = ManejadorMiembro.getInstancia().buscarMiembro(parametros.get("tarjeta"));
					if(productoAComprar!=null){
						if(){
							System.out.println("");
						}else{
							System.out.println("Ingrese el No. de Tarjeta Correctamente");
						}
					}else{
						System.out.println("El Producto no existe.");
					}
				}else{
					System.out.println("Comprueba tu sintaxis.");
				}*/
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
				new Comando().ayudamiembro();
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}