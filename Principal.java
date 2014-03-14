package org.brandon.sistema;

import org.brandon.utilidades.Entrada;

public class Principal{
	public void iniciar(){
		String nombreusuario, password;
		System.out.println("Ingrese Nombre de Usuario: ");
		nombreusuario=Entrada.getInstancia().leer();
		System.out.println("Ingrese su Contraseña: ");
		password=Entrada.getInstancia().leer();
	}
}