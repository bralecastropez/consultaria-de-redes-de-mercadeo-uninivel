package org.brandon.manejadores;

import java.util.ArrayList;

import org.brandon.beans.Usuario;

public class ManejadorUsuario{
	private ArrayList<Usuario> listaUsuario;
	private Usuario usuarioAutenticado;
	private static ManejadorUsuario instancia;
	
	private ManejadorUsuario(){
		this.listaUsuario=new ArrayList<Usuario>();

		this.listaUsuario.add(new Usuario("Brandon Castro", "brandon", 		"bcastro", 		"admin", 		16));
		this.listaUsuario.add(new Usuario("prueba", 		"prueba", 		"prueba",		"admin",	 	15));
		this.listaUsuario.add(new Usuario("default", 		"default", 		"default",		"miembro",	 	15));
	}
	
	public void agregarUsuario(Usuario usuario){
		this.listaUsuario.add(usuario);
	}
	public void eliminarUsuario(Usuario usuario){
		this.listaUsuario.remove(usuario);
	}
	/*public void editarUsuario(Usuario usuario){
		this.listaUsuario.edit(usuario);
	}*/
	public ArrayList<Usuario> obtenerListaUsuario(){
		return this.listaUsuario;
	}
	public Usuario buscarUsuario(String nick){
		for(int posicion=0;posicion<this.listaUsuario.size();posicion++){
			if(this.listaUsuario.get(posicion).getNick().equals(nick)){
				return this.listaUsuario.get(posicion);
			}
		}
		return null;
	}
	public boolean autenticarUsuario(String nick, String password){
		Usuario usuarioBuscado = this.buscarUsuario(nick);
		if(usuarioBuscado!=null){
			if(usuarioBuscado.getPassword().equals(password)){
				this.usuarioAutenticado = usuarioBuscado;
				return true;
			}
		}
		return false;
	}
	public void desautenticarUsuario(){
		this.usuarioAutenticado=null;
	}
	public Usuario obtenerUsuarioAutenticado(){
		return this.usuarioAutenticado;
	}
	public static ManejadorUsuario getInstancia(){
		if(instancia==null)
			instancia=new ManejadorUsuario();
		return instancia;
	}
}