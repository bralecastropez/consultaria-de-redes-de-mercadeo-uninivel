package org.Brandon.utilidades.eventos;

import java.util.HashMap;

public interface DecodeListener{
	void avisarAccionar(String accion, HashMap<String, String> parametros);
}