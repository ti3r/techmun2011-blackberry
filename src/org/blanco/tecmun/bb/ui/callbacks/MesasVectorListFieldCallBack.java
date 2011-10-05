package org.blanco.tecmun.bb.ui.callbacks;

import java.util.Vector;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ListField;

import org.blanco.techmun.entities.Mesa;

public class MesasVectorListFieldCallBack extends ObjectsVectorListFieldCallBack {

	public MesasVectorListFieldCallBack(Vector items) {
		super(items);
	}

	public void drawListRow(ListField listField, Graphics graphics, int index,
			int y, int width) {
		Object mObject = get(listField, index);
		if (!(mObject instanceof Mesa)){
			throw new IllegalArgumentException("Can't get a Mesa object from " +
					"the items. returned: "+mObject.getClass().getName());
		}
		Mesa mesa = (Mesa) mObject;
		//Draw the background
		graphics.setColor(Color.BEIGE);
		graphics.drawRoundRect(0, 0, width, listField.getRowHeight()-1, 5, 5);
		//Draw the Name of the Mesa
		graphics.drawText(mesa.getNombre()+" - "+mesa.getRepresentante().getNombre(),
				0, y, 0, width);
	}

	
		
}
