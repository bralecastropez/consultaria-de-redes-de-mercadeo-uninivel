package org.brandon.utilidades.eventos;

import java.util.HashMap;

/**
*	@author Brandon Castro
*	Esta clase fue creada para ingresar los comandos del usuario.
*/

public interface DecodeListener{

	void avisarAccionar(String accion, HashMap<String, String> parametros);
	
}