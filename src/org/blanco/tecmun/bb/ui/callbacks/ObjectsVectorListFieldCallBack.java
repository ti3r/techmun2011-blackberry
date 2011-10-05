package org.blanco.tecmun.bb.ui.callbacks;

import java.util.Vector;

import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;

public class ObjectsVectorListFieldCallBack implements ListFieldCallback {

	Vector items = null;
	
	public ObjectsVectorListFieldCallBack(Vector items) {
		super();
		this.items = items;
	}

	public void drawListRow(ListField listField, Graphics graphics, int index,
			int y, int width) {
		String text = items.elementAt(index).toString(); 
        graphics.drawText(text, 0, y, 0, width); 
	}

	public Object get(ListField listField, int index) {
		if( items == null || index > items.size())
			throw new IndexOutOfBoundsException("Unable to retrieve object for index "+index);
		return items.elementAt(index);
	}

	public int getPreferredWidth(ListField listField) {
		return listField.getContentWidth();
	}

	public int indexOfList(ListField listField, String prefix, int start) {
		return items.indexOf(prefix, start);
	}

	public int insert(Object item){
		this.items.addElement(item);
		return this.items.size();
	}
	
}
