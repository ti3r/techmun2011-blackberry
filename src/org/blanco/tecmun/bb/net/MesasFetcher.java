package org.blanco.tecmun.bb.net;

import java.util.Vector;

import org.blanco.techmun.entities.Mesa;
import org.blanco.techmun.entities.Usuario;

public class MesasFetcher {
	
	public static Vector fetchMesas(){
		Vector result = new Vector();
		Mesa m = new Mesa();
		m.setId(new Long(1L)); m.setNombre("Desarme"); m.setColor("#FF0000");
		m.setRepresentante(new Usuario("Alexandro", "alex@alex.com"));
		result.addElement(m);
		return result;
		
//		HttpConnection connection =	(HttpConnection) Connector
//		.open("http://tec-ch-mun-2011.herokuapp.com/rest/mesas");
//		connection.setRequestMethod(HttpConnection.GET);
//		String httpResponse = connection.getResponseMessage();
//		System.out.println(httpResponse);
		
	}
	
}
