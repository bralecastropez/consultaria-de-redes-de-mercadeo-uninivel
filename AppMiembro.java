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
			case "buy product":
				break;
			case "add downline":
				break;
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
			case "help":
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
				System.out.println("show downline - Muestra información detallada del downline especificado, si se agrega [money] mostrara solo la informacion de volumen monetario");
				System.out.println("SINTAXIS: show downline [idDownline] [Money]");
				System.out.println("");
				System.out.println("show history - Muestra el historial de downlines agregados, si se agrega buy mostrará el historial de compras de mi perfil, si se agrega downline y el id del  downline se mostrará o bien el historial de downlines agregados o de compras dependiendo de la combinación. (si se le agrega buy o no)");
				System.out.println("SINTAXIS: show history [buy] [downline] [idDownline] ");
				System.out.println("");
				System.out.println("show me - Muestra la información de mi perfil, si se coloca money mostrara solo la información de volumen monetario");
				System.out.println("SINTAXIS: show me [money]");
				System.out.println("logout - Este comando sirve para cerrar sesion");
				System.out.println("SINTAXIS: logout ");
				System.out.println("");
				System.out.println("edit me - Este comando modifica datos del usuario");
				System.out.println("SINTAXIS: edit me [Parametro]=[Nuevo Valor]");
				System.out.println("");
				System.out.println("add downline - Agregar un downline a tu perfil, o a downline espesificado");
				System.out.println("SINTAXIS: add downline [Datos] [down] [idDownline] [Producto]");
				System.out.println("");
				System.out.println("search downline - Muestra la información detallada del downline si coincide con la búsqueda");
				System.out.println("SINTAXIS: search downline [Datos]");
				System.out.println("");
				System.out.println("buy product - Comprar un producto del Stock");
				System.out.println("SINTAXIS: buy product [Nombre del Producto] [Numero de Tarjeta]");
				System.out.println("");
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Compruebe su sintaxis");
		}
	}
}