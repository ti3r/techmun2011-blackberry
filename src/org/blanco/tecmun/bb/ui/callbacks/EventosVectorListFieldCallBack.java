package org.blanco.tecmun.bb.ui.callbacks;

import java.util.Vector;

import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ListField;

import org.blanco.techmun.entities.Evento;

public class EventosVectorListFieldCallBack extends
		ObjectsVectorListFieldCallBack {

	public EventosVectorListFieldCallBack(Vector items) {
		super(items);
	}

	public void drawListRow(ListField listField, Graphics graphics, int index,
			int y, int width) {
		Object mObject = get(listField, index);
		if (!(mObject instanceof Evento)){
			throw new IllegalArgumentException("Can't get a Evento object from " +
					"the items. returned: "+mObject.getClass().getName());
		}
		Evento evento = (Evento) mObject;
		//Draw the Title of the evento
		graphics.drawText(evento.getTitulo(),
				0, y, 0, width);		
	}

}
