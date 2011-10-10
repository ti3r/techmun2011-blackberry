package org.blanco.tecmun.bb.net;

import java.util.Date;
import java.util.Vector;

import org.blanco.techmun.entities.Comentario;
import org.blanco.techmun.entities.Evento;

public class ComentariosFetcher {

	public synchronized static Vector fetchComentarios(Evento evento){
		Vector result = new Vector();
		Comentario comentario = new Comentario();
		comentario.setAutor("AleX"); 
		comentario.setComentario("comentario de prueba 1");
		comentario.setContacto("alex@alex.com");
		comentario.setEvento(evento);
		comentario.setFecha(new Date(System.currentTimeMillis()));
		comentario.setId(1);
		result.addElement(comentario);
		
		comentario = new Comentario();
		comentario.setAutor("AleX"); 
		comentario.setComentario("comentario de prueba 2");
		comentario.setContacto("alex@alex.com");
		comentario.setEvento(evento);
		comentario.setFecha(new Date(System.currentTimeMillis()));
		comentario.setId(2);
		result.addElement(comentario);
		
		comentario = new Comentario();
		comentario.setAutor("AleX"); 
		comentario.setComentario("comentario de prueba 3");
		comentario.setContacto("alex@alex.com");
		comentario.setEvento(evento);
		comentario.setFecha(new Date(System.currentTimeMillis()));
		comentario.setId(3);
		result.addElement(comentario);
				
		return result;
		
//		HttpConnection connection =	(HttpConnection) Connector
//		.open("http://tec-ch-mun-2011.herokuapp.com/rest/mesas");
//		connection.setRequestMethod(HttpConnection.GET);
//		String httpResponse = connection.getResponseMessage();
//		System.out.println(httpResponse);
		
	}

	public synchronized static boolean postComentario(Comentario com) {
		//Guardar el comentario en esta parte.
		//HttpConnection connection =	(HttpConnection) Connector
//		.open("http://tec-ch-mun-2011.herokuapp.com/rest/comentarios");
//		connection.setRequestMethod(HttpConnection.GET);
//		String httpResponse = connection.getResponseMessage();
//		System.out.println(httpResponse);
		return true;
	}
}
