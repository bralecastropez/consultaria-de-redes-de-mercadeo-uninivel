package org.brandon.app;

import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;
import org.brandon.utilidades.Entrada;
import org.brandon.utilidades.Comando;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.manejadores.ManejadorProducto;
import org.brandon.beans.Miembro;
import org.brandon.beans.Downline;
import org.brandon.beans.Producto;

import java.io.Console;
import java.util.HashMap;
import java.util.Date; 
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 

/**
*	@author Brandon Castro
*	Esta clase nos sirve para la aplicacion del Miembro.
*/

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
			
			case "":
				System.out.println("Escribe || help || para obtener ayuda");
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
						System.out.println("El producto no existe. Escribe || help || para obtener ayuda");
						System.out.println("");
					}
				}else{
					System.out.println("Comprueba tu sintaxis. Escribe || help || para obtener ayuda");
				}
			break;
				
			case "exit":
				Comando.getInstancia().exit();
			break;
				
			case "logout":
				super.setConnected(false);
			break;
				
			case "show sales":
				Comando.getInstancia().showSales();
				
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
				Comando.getInstancia().showmeMiembro();
			break;
				
			case "show history":
				if(parametros.size()<1){
					System.out.println("La sintaxis correcta es : ||| show history [buy] --- show history [downline] [idDownline] |||");
				}else{
					if(parametros.size()>1){
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
						
					}else{
						/*if(parametros.size()>=2){
							System.out.println("Sus downline son:");
							for(Downline historial : ManejadorMiembro.getInstancia().obtenerHistorialDownline()){
								System.out.println("Nombre: "+historial.getNombre());
								System.out.println("Edad: "+historial.getEdad());
								System.out.println("IdDOWNLINE: "+historial.getIdDownline());
							}
						}else{
							System.out.println("Comprueba tu sintaxis");
						}*/
					}
				}
			break;
				
			case "search downline":
			break;
				
			case "buy product":
				try{
					if(parametros.size()>1 && parametros.size()<3){
						Producto productoAComprar = ManejadorProducto.getInstancia().buscarProducto(parametros.get("nombre"));
						Miembro tarjeta = ManejadorMiembro.getInstancia().buscarMiembro(parametros.get("tarjeta"));
						if(productoAComprar!=null){
							Console terminal = System.console();
							if (terminal==null ) {
								System.err.println("No puedo obtener la consola.");
								return;
							}
							System.out.print("Ingrese su pin");
							String pinSinAutenticar= new String (terminal.readPassword(">>"));
							int pinAutenticado=Integer.parseInt(pinSinAutenticar);
							if(ManejadorMiembro.getInstancia().obtenerMiembroAutenticado().getPin()==pinAutenticado){
								System.out.println("");
								System.out.println("Acaba de comprar el producto: "+productoAComprar.getNombre()+"	FECHA:	"+Comando.getInstancia().getTime());
								System.out.println("");
								System.out.println("Nombre: "+productoAComprar.getNombre());
								System.out.println("Categoria: "+productoAComprar.getCategoria());
								System.out.println("Precio: "+productoAComprar.getPrecio());
								System.out.println("");
								ManejadorProducto.getInstancia().agregarHistorial(productoAComprar);
								ManejadorProducto.getInstancia().agregarHistorialVentas(productoAComprar);
							}else{
								System.out.println("Pin incorrecto");
							}
						}else{
							System.out.println("El Producto o Tarjeta ingresada no existe. Escribe || help || para obtener ayuda");
						}
					}else{
						System.out.println("Comprueba tu sintaxis.");
					}
				}catch(NumberFormatException excepcionnumero){
					System.out.println("Ingrese parametros validos. Escribe || help || para obtener ayuda");
				}
			break;
				
			case "add downline":
			try{
				if(parametros.size()>1 /*&& parametros.size()<5*/){
					Downline downline = new Downline();
					downline.setNombre(parametros.get("nombre"));
					downline.setIdDownline(parametros.get("idDownline"));
					downline.setEdad(Integer.parseInt(parametros.get("edad")));
					String[] ruta = parametros.get("down").split(",");
					if(parametros.get("nombre")!=null && parametros.get("edad")!=null /*&& parametros.get("idDowline")!=null*/ && parametros.get("down")!=null){
						/*Miembro nombremim = ManejadorMiembro.getInstancia().buscarMiembro().get("nombre");
						if(nombremim!=null){*/
							Downline peliR = ManejadorMiembro.getInstancia().buscarMiembro(ruta[0]);
								if(!(peliR.equals(null))){
									Downline downlineResultado = peliR;
				
									for(int posicion=1;posicion<ruta.length;posicion++){
									downlineResultado=ManejadorMiembro.getInstancia().buscarDentroDeDownline(downlineResultado, ruta[posicion]);
									}
								/*ManejadorMiembro.getInstancia().agregarHistorialDownline(downline);*/
								downlineResultado.getListaDownlines().add(downline);
								System.out.println("Downline agregado satisfactoriamente.");
							}else{
								System.err.println("Hay algo mal");
							}
						/*}else{
							System.out.println("El miembro no existe. Pongase en contacto con el administrador.");
						}*/
					}else{
						System.out.println("down=[down]");
					}
				}else{
					System.out.println("La sintaxis correcta es: add downline nombre=[nombre] edad=[edad] idDownline=[idDownline] down=[down]");
				}
			}catch(NullPointerException nulex){
				System.out.println("Ingresa todos los parametros");
			}
			break;
				
			case "edit me":
				if(parametros.size()>=1 && parametros.size()<=5){
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
				Comando.getInstancia().ayudamiembro();
			break;
				
			default:
				System.out.println("");
				System.out.println("Compruebe su sintaxis. Escribe || help || para obtener ayuda");
		}
	}
}