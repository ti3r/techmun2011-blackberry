package org.blanco.tecmun.bb.screens;

import java.util.Vector;

import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

import org.blanco.techmun.entities.Evento;
import org.blanco.techmun.entities.Mesa;
import org.blanco.tecmun.bb.Logger;
import org.blanco.tecmun.bb.misc.Utils;
import org.blanco.tecmun.bb.net.EventosFetcher;
import org.blanco.tecmun.bb.ui.EventosListField;
import org.blanco.tecmun.bb.ui.ScreenHeader;
import org.blanco.tecmun.bb.ui.callbacks.EventosVectorListFieldCallBack;

public class EventosScreen extends MainScreen {

	Mesa mesa = null;
	EventosListField lista = null;
	
	public EventosScreen(Mesa mesa){
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		if (mesa != null)
			
			setTitle(new ScreenHeader("Eventos para Mesa: "+mesa.getNombre()));
		this.mesa = mesa;
		lista = new EventosListField(Utils.parseHtmlColor(mesa.getColor()),
				mesa.isDarkColor());
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
		
	protected boolean navigationClick(int status, int time){
		Logger.a("Navidation Clicked");
		if (lista.isFocus()){
			Object evento =
			lista.getCallback().get(lista, lista.getSelectedIndex());
			if (evento != null){
				Evento e = (Evento) evento;
				ComentariosScreen screen = new ComentariosScreen(e);
				getUiEngine().pushScreen(screen);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
}
