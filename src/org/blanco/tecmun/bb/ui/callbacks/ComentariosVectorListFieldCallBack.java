package org.blanco.tecmun.bb.ui.callbacks;

import java.util.Vector;

import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ListField;

import org.blanco.techmun.entities.Comentario;
import org.blanco.tecmun.bb.Logger;

public class ComentariosVectorListFieldCallBack 
	extends ObjectsVectorListFieldCallBack {

	public ComentariosVectorListFieldCallBack(Vector items) {
		super(items);
	}

	public void drawListRow(ListField listField, Graphics graphics, int index,
			int y, int width) {
		Object item = get(listField, index);
		if (item instanceof Comentario){
			Comentario com = (Comentario)item;
			graphics.drawText(com.getComentario(),
					0, y, 0, width);
		}else{
			Logger.d("item "+index+" does not is not a Comentario." +
					" Item will not be displayed, class: "+item.getClass().getName());
		}
	}

	
	
}
