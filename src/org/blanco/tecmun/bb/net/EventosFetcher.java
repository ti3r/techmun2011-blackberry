package org.blanco.tecmun.bb.net;

import java.util.Date;
import java.util.Vector;

import org.blanco.techmun.entities.Evento;
import org.blanco.techmun.entities.Mesa;

public class EventosFetcher {

	public static Vector fetchEventos(Mesa mesa){
		Vector result = new Vector();
		Evento evento = new Evento();
		evento.setId(new Long(1L)); evento.setMesaId(mesa.getId());
		evento.setTitulo("Prueba");
		evento.setDescripcion("Evento de prueba para la mesa: "+mesa.getNombre());
		evento.setFecha(new Date());
		result.addElement(evento);
		
		evento = new Evento();
		evento.setId(new Long(1L)); evento.setMesaId(mesa.getId());
		evento.setTitulo("Prueba 2");
		evento.setDescripcion("Evento de prueba para la mesa: "+mesa.getNombre());
		evento.setFecha(new Date());
		result.addElement(evento);
		
		evento = new Evento();
		evento.setId(new Long(1L)); evento.setMesaId(mesa.getId());
		evento.setTitulo("Prueba 3");
		evento.setDescripcion("Evento de prueba para la mesa: "+mesa.getNombre());
		evento.setFecha(new Date());
		result.addElement(evento);
		
		
		return result;
		
//		HttpConnection connection =	(HttpConnection) Connector
//		.open("http://tec-ch-mun-2011.herokuapp.com/rest/mesas");
//		connection.setRequestMethod(HttpConnection.GET);
//		String httpResponse = connection.getResponseMessage();
//		System.out.println(httpResponse);
		
	}
}
