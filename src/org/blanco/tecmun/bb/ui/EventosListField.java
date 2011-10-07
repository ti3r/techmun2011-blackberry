package org.blanco.tecmun.bb.ui;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ListField;

public class EventosListField extends ListField {

	int bgColor = Color.BLUE;
	boolean isDarkBackground = true;
	
	public EventosListField(){
		super();
	}
	
	public EventosListField(int bgColor, boolean isDarkBack) {
		super();
		this.bgColor = bgColor;
		this.isDarkBackground = isDarkBack;
	}

	protected void paintBackground(Graphics g) {
		g.setGlobalAlpha(255);
		g.setBackgroundColor(bgColor);
		if (isDarkBackground){
			g.setColor(Color.WHITE);
		}
		g.clear();
		super.paintBackground(g);
	}	
	
	
	
}
