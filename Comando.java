package org.brandon.utilidades;

import org.brandon.manejadores.ManejadorProducto;
import org.brandon.manejadores.ManejadorAdmin;
import org.brandon.manejadores.ManejadorMiembro;
import org.brandon.beans.Admin;
import org.brandon.beans.Miembro;
import org.brandon.beans.Producto;
import org.brandon.utilidades.eventos.DecodeListener;
import org.brandon.utilidades.Decodificador;

import java.util.HashMap;

/**
*	@author Brandon Castro
*	Esta clase se creo para no repetir comandos en nuestros Apps.
*/

public class Comando{
	
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
	}
	
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
		System.out.println("search downline - Muestra la información detallada del downline si coincide con la busqueda");
		System.out.println("SINTAXIS: search downline [Datos]");
		System.out.println("");
		System.out.println("buy product - Comprar un producto del Stock");
		System.out.println("SINTAXIS: buy product [Nombre del Producto] [Numero de Tarjeta]");
		System.out.println("");
		System.out.println("exit - Sale totalmente del programa");
		System.out.println("SINTAXIS: exit");
		System.out.println("");
	}
	
	public void exit(){
		System.out.println("Gracias por utilizar mi programa");
		System.exit(0);
	}
	
	public void listarProductos(){
		for(Producto product : ManejadorProducto.getInstancia().obtenerListaProducto()){
			System.out.println("");
			System.out.println("nombre: "+product.getNombre());
		}
		System.out.println("");
		System.out.println("------------------------------");
		System.out.println("Fin de la lista");
		System.out.println("");
	}
	
	public void showmeAdmin(){
		Admin adminAMostrar = ManejadorAdmin.getInstancia().obtenerAdminAutenticado();
		System.out.println("");
		System.out.println("Nombre: "+adminAMostrar.getNombre());
		System.out.println("Nombre de Usuario (nick): "+adminAMostrar.getNick());
		System.out.println("");
	}
	
	public void showmeMiembro(){
		Miembro miembroAMostrar = ManejadorMiembro.getInstancia().obtenerMiembroAutenticado();
		System.out.println("");
		System.out.println("Nombre: "+miembroAMostrar.getNombre());
		System.out.println("Nick: "+miembroAMostrar.getNick());
		System.out.println("Edad: "+miembroAMostrar.getEdad());
		System.out.println("Tarjeta de Credito: "+miembroAMostrar.getTarjeta());
		System.out.println("");
	}
	public void editMe(HashMap<String,String> parametros){
	
		if(ManejadorAdmin.getInstancia().obtenerAdminAutenticado().getRol().equals("admin")){
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
		}else{
			if(ManejadorMiembro.getInstancia().obtenerMiembroAutenticado().getRol().equals("miembro")){
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
			}
		}
		
	}
}