package org.blanco.tecmun.bb.screens;

import java.util.Vector;

import net.rim.device.api.command.Command;
import net.rim.device.api.command.CommandHandler;
import net.rim.device.api.command.ReadOnlyCommandMetadata;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.util.StringProvider;

import org.blanco.techmun.entities.Comentario;
import org.blanco.techmun.entities.Evento;
import org.blanco.tecmun.bb.net.ComentariosFetcher;
import org.blanco.tecmun.bb.ui.ScreenHeader;
import org.blanco.tecmun.bb.ui.callbacks.ComentariosVectorListFieldCallBack;

public class ComentariosScreen extends MainScreen {

	Evento evento = null;
	ListField lista = null;
	Vector comentarios = null;
	/**
	 * 
	 */
	public ComentariosScreen(Evento evento) {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		if (evento == null)
			throw new IllegalArgumentException("Evento for comentarios " +
					"screen should not be null");
		this.evento = evento;
		setTitle(new ScreenHeader("Comentarios"));
		lista = new ListField();
		add(lista);
	}
	protected void onDisplay() {
		comentarios = ComentariosFetcher.fetchComentarios(evento);
		lista.setCallback(new ComentariosVectorListFieldCallBack(comentarios));
		for(int i=0; i < comentarios.size(); i++){
			lista.insert(0); //insert empty rows on the list to refresh the 
			//call back rows and draw the correct information.
		}
	}
	protected void muestraDetalleComentario(){
		Object com = lista.getCallback().get(lista, lista.getSelectedIndex());
		if (com != null && com instanceof Comentario){
			ComentarioDetalleScreen screen = new ComentarioDetalleScreen(
					(Comentario) com);
			getUiEngine().pushScreen(screen);
		}
	}
	
	protected void makeMenu(Menu menu, int instance) {
		MenuItem detalleComentMItem = new MenuItem(new StringProvider("Detalle de Comentario"), 
				1, 1);
		detalleComentMItem.setCommand(new Command(new CommandHandler() {
			public void execute(ReadOnlyCommandMetadata metadata, Object context) {
				muestraDetalleComentario();
			}
		}));
		menu.add(detalleComentMItem);
		
		MenuItem postComentMItem = new MenuItem(new StringProvider("Agregar Comentario"), 
				2, 1);
		postComentMItem.setCommand(new Command(new CommandHandler() {
			public void execute(ReadOnlyCommandMetadata metadata, Object context) {
				getUiEngine().pushScreen(new PostComentarioScreen(
						ComentariosScreen.this.evento));
			}
		}));
		menu.add(postComentMItem);
		
		super.makeMenu(menu, instance);
	}

	protected boolean onNavigationClick(int status, int time){
		if (lista.isFocus()){
			muestraDetalleComentario();
			return true;
		}else{
			return false;
		}
	}
	
}
