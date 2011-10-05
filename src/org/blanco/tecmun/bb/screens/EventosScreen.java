package org.blanco.tecmun.bb.screens;

import java.util.Vector;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.XYRect;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.Background;

import org.blanco.techmun.entities.Mesa;
import org.blanco.tecmun.bb.misc.Utils;
import org.blanco.tecmun.bb.net.EventosFetcher;
import org.blanco.tecmun.bb.ui.callbacks.EventosVectorListFieldCallBack;

public class EventosScreen extends MainScreen {

	Mesa mesa = null;
	ListField lista = null;
	
	public EventosScreen(Mesa mesa){
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		if (mesa != null)
			setTitle("Eventos para Mesa: "+mesa.getNombre());
		this.mesa = mesa;
		Background background = new Background() {
			
			public boolean isTransparent() {				
				return false;
			}
			
			public void draw(Graphics graphics, XYRect rect) {
				graphics.setColor(
						Utils.parseHtmlColor(EventosScreen.this.mesa.getColor()));
				graphics.fillRoundRect(rect.x, rect.y, 
						rect.width, rect.height, 5, 5);
			}
		};
		setBackground(Field.VISUAL_STATE_ACTIVE, background);
		lista = new ListField();
		add(lista);
		ButtonField masBtn = new ButtonField("Mas eventos");
		add(masBtn);
	}

	protected void onDisplay(){
		//launch the fetcher
		Vector eventos = EventosFetcher.fetchEventos(mesa);
		lista.setCallback(new EventosVectorListFieldCallBack(eventos));
		for(int i=0; i < eventos.size(); i++){
			lista.insert(0); //insert empty rows on the list to refresh the 
			//call back rows and draw the correct information.
		}
	}
	
	
	
}
