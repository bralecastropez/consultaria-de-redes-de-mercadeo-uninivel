package org.brandon.utilidades;

import org.brandon.manejadores.ManejadorProducto;
import org.brandon.manejadores.ManejadorAdmin;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.manejadores.ManejadorOferta;
import org.brandon.beans.Admin;
import org.brandon.beans.Oferta;
import org.brandon.beans.Miembro;
import org.brandon.beans.Producto;

import java.util.HashMap;
import java.util.Date; 
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 

/**
*	@author Brandon Castrow
*	Esta clase se creo para no repetir comandos en nuestros Apps.
*/

public class Comando{
	private static Comando instancia;
	
	public static Comando getInstancia(){
		if(instancia==null)
			instancia=new Comando();
		return instancia;
	}
	
	//Comando para mostrar Ayuda al Administrador.
	public void ayudaadmin(){
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
		System.out.println("show downline - Muestra informacion detallada del downline especificado, si se agrega [money] mostrara solo la informacion de volumen monetario");
		System.out.println("SINTAXIS: show downline [idDownline] [Money]");
		System.out.println("");
		System.out.println("show history - Muestra el historial de downlines agregados, si se agrega buy mostrara el historial de compras de mi perfil, si se agrega downline y el id del  downline se mostrara o bien el historial de downlines agregados o de compras dependiendo de la combinacon (si se le agrega buy o no)");
		System.out.println("SINTAXIS: show history [buy] [downline] [idDownline] ");
		System.out.println("");
		System.out.println("show me - Muestra la informacion de mi perfil, si se coloca money mostrara solo la informacion de volumen monetario");
		System.out.println("SINTAXIS: show me [money]");
		System.out.println("");
		System.out.println("logout - Este comando sirve para cerrar sesion");
		System.out.println("SINTAXIS: logout ");
		System.out.println("");
		System.out.println("search downline - Muestra la información detallada del downline si coincide con la busqueda");
		System.out.println("SINTAXIS: search downline [Datos]");
		System.out.println("");
		System.out.println("exit - Sale totalmente del programa");
		System.out.println("SINTAXIS: exit");
		System.out.println("");
		System.out.println("add product - Agrega un producto del stock");
		System.out.println("SINTAXIS: add product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]");
		System.out.println("");
		System.out.println("add offert - Agrega un producto del stock");
		System.out.println("SINTAXIS: add affert nombre=[nombre del producto] tipo=[tipo de oferta]  precio=[cantidad de pago del producto] cantidad=[cantidad de pago del producto] descuento=[descuento del producto si hay]");
		System.out.println("");
		System.out.println("remove product - Elimina un producto del stock");
		System.out.println("SINTAXIS: remove product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]");
		System.out.println("");
		System.out.println("edit product - Modifica un producto del stock");
		System.out.println("SINTAXIS: edit product nombre=[nombre del nuevo producto] categoria=[categoria del nuevo producto]  precio=[precio del nuevo producto]");
		System.out.println("");
		System.out.println("show sales - Muestra informacion de venta de un producto si se especifica, o de todos si no se especifica.");
		System.out.println("SINTAXIS: show sales [product [nombre del producto] ]");
		System.out.println("");
		System.out.println("add user - Agrega un Administrador");
		System.out.println("SINTAXIS: add user nombre=[nombre que desea ponerle al admnistrador] password=[contrasenha del administrador] nick=[nombre de usuario del nuevo administrador]");
		System.out.println("");
		System.out.println("add member - Agrega un Miembro a la red");
		System.out.println("SINTAXIS: add member nombre=[nombre que desea ponerle al admnistrador] password=[contrasenha del administrador] nick=[nombre de usuario del nuevo administrador] tarjeta=[tarjeta de credito] pin=[pin de la tarjeta de credito]");
		System.out.println("");
		System.out.println("remove member - Elimina un Miembro a la red");
		System.out.println("SINTAXIS: remove member nick=[nombre de usuario del miembro]");
		System.out.println("");
	}
	
	//Comando para obtener hora.
	public String getTime(){ 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	} 
	
	//Comando de Ayuda para el Miembro
	public void ayudamiembro(){
		System.out.println("Comandos que puede usar el Miembro");
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
		System.out.println("show downline - Muestra informacion detallada del downline especificado, si se agrega [money] mostrara solo la informacion de volumen monetario");
		System.out.println("SINTAXIS: show downline [idDownline] [Money]");
		System.out.println("");
		System.out.println("show history - Muestra el historial de downlines agregados, si se agrega buy mostrara el historial de compras de mi perfil, si se agrega downline y el id del  downline se mostrara o bien el historial de downlines agregados o de compras dependiendo de la combinacion. (si se le agrega buy o no)");
		System.out.println("SINTAXIS: show history [buy] [downline] [idDownline] ");
		System.out.println("");
		System.out.println("show me - Muestra la informacion de mi perfil, si se coloca money mostrara solo la informacion de volumen monetario");
		System.out.println("SINTAXIS: show me [money]");
		System.out.println("");
		System.out.println("logout - Este comando sirve para cerrar sesion");
		System.out.println("SINTAXIS: logout ");
		System.out.println("");
		System.out.println("edit me - Este comando modifica datos del usuario");
		System.out.println("SINTAXIS: edit me [Parametro]=[Nuevo Valor]");
		System.out.println("");
		System.out.println("add downline - Agregar un downline a tu perfil, o a downline especificado");
		System.out.println("SINTAXIS: add downline [Datos] [down] [idDownline] [Producto]");
		System.out.println("");
		System.out.println("search downline - Muestra la informacion detallada del downline si coincide con la busqueda");
		System.out.println("SINTAXIS: search downline [Datos]");
		System.out.println("");
		System.out.println("buy product - Comprar un producto del Stock");
		System.out.println("SINTAXIS: buy product [Nombre del Producto] [Numero de Tarjeta]");
		System.out.println("");
		System.out.println("exit - Sale totalmente del programa");
		System.out.println("SINTAXIS: exit");
		System.out.println("");
	}
	
	//Comando para salir del programa
	public void exit(){
		System.out.println("Gracias por utilizar mi programa");
		System.exit(0);
	}
	
	//Comando para listar Productos
	public void listarProductos(){
		/*String oferta = "oferta";
		String descuento = "descuento";
		System.out.println("------------------------------");*/
		System.out.println("Productos en oferta: ");
		//String productoOferta = ManejadorOferta.getInstancia().obtenerListaOferta();
		for(Oferta productoOferta : ManejadorOferta.getInstancia().obtenerListaOferta()){
			System.out.println("");
			System.out.println("Tipo de oferta: "+productoOferta.getTipo());
			System.out.println("Producto de oferta: "+productoOferta.getProducto());
			System.out.println("Precio de Normal: "+productoOferta.getPrecioOficial());
			System.out.println("Precio de Oferta: "+productoOferta.getPrecioOferta());
			System.out.println("Al : "+productoOferta.getCantidad()+" x "+productoOferta.getPrecio());
			System.out.println("Con un descuento de : "+"Q. "+productoOferta.getDescuento()+".00");
		}
			/*if(ManejadorOferta.getInstancia().obtenerListaOferta().getTipo().equals(oferta)){
				for(Oferta productoOfe : ManejadorOferta.getInstancia().obtenerListaOferta()){
					System.out.println("");
					System.out.println("------------------------------");
					System.out.println("Tipo de oferta: "+productoOfe.getTipo());
					System.out.println("Producto de oferta: "+productoOfe.getProducto());
					System.out.println("Precio de Normal: "+productoOfe.getPrecioOficial());
					System.out.println("Al : "+productoOfe.getCantidad()+" x "+productoOfe.getPrecio());
					System.out.println("------------------------------");
				}
			}
			if(ManejadorOferta.getInstancia().obtenerListaOferta().getTipo().equals(descuento)){
				for(Oferta productoDes : ManejadorOferta.getInstancia().obtenerListaOferta()){
					System.out.println("");
					System.out.println("Tipo de oferta: "+productoDes.getTipo());
					System.out.println("Producto de oferta: "+productoDes.getProducto());
					System.out.println("Precio de Normal: "+productoDes.getPrecioOficial());
					System.out.println("Precio de Oferta: "+productoDes.getPrecioOferta());
					System.out.println("Con un descuento de : "+"Q. "+productoDes.getDescuento()+".00");
				}
			}*/
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("Productos sin ofertas o descuentos: ");
		for(Producto product : ManejadorProducto.getInstancia().obtenerListaProducto()){
			System.out.println("");
			System.out.println("nombre: "+product.getNombre());
		}
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("Fin de la lista");
		System.out.println("");
		
	}
	
	//Comando para mostrar las caracteristicas del administrador
	public void showmeAdmin(){
	
		Admin adminAMostrar = ManejadorAdmin.getInstancia().obtenerAdminAutenticado();
		System.out.println("");
		System.out.println("Nombre: "+adminAMostrar.getNombre());
		System.out.println("Nombre de Usuario (nick): "+adminAMostrar.getNick());
		System.out.println("");
		
	}
	
	//Comando para mostrar las caracteristicas del miembro
	public void showmeMiembro(){
	
		Miembro miembroAMostrar = ManejadorMiembro.getInstancia().obtenerMiembroAutenticado();
		System.out.println("");
		System.out.println("Nombre: "+miembroAMostrar.getNombre());
		System.out.println("Nick: "+miembroAMostrar.getNick());
		System.out.println("Edad: "+miembroAMostrar.getEdad());
		System.out.println("Tarjeta de Credito: "+miembroAMostrar.getTarjeta());
		System.out.println("");
		
	}
	
	//Comando para mostrar productos vendidos.
	public void showSales(){
		//if(parametros.size()<=0 || parametros.size()==0){
		
			System.out.println("");
			System.out.println("Los productos que se han vendido son: ");
			System.out.println("---------------------------------");
			for(Producto product : ManejadorProducto.getInstancia().obtenerHistorialVentas()){
				System.out.println("");
				System.out.println("Nombre: "+product.getNombre());
				System.out.println("Categoria: "+product.getCategoria());
				System.out.println("Precio: "+product.getPrecio());
			}
			System.out.println("---------------------------------");
			System.out.println("Fin de la Lista.");
			
		/*}if(parametros.size()>=1 && parametros.size()<2){
		
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
			
		}*/
	}
	
	//Comando para mostrar Productos
	public void showProduct(HashMap<String,String> parametros){
		//if(parametros.size()<2){
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
		/*}else{
			System.out.println("Solo se puede ingresar un producto. Escribe || help || para obtener ayuda");
		}*/
	}
}