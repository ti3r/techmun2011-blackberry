package org.blanco.tecmun.bb.screens;

import net.rim.device.api.command.Command;
import net.rim.device.api.command.CommandHandler;
import net.rim.device.api.command.ReadOnlyCommandMetadata;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;

import org.blanco.techmun.entities.Comentario;
import org.blanco.tecmun.bb.ui.ScreenHeader;

public class ComentarioDetalleScreen extends MainScreen {

	Comentario comentario = null;
	
	public ComentarioDetalleScreen(Comentario comentario) {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		if (comentario == null)
			throw new IllegalArgumentException("Comentario can't be null");
		this.comentario = comentario;
		setTitle(new ScreenHeader("Detalle"));
				
		LabelField autLabelField = new LabelField("Autor: ");
		add(autLabelField);
		LabelField autValLabelField = new LabelField(comentario.getAutor());
		add(autValLabelField);
		
		LabelField comLabelField = new LabelField("Comentario: ");
		add(comLabelField);
		LabelField comValLabelField = new LabelField(comentario.getComentario());
		add(comValLabelField);
		
		LabelField fecLabelField = new LabelField("Fecha: ");
		add(fecLabelField);
		LabelField fecValLabelField = new LabelField(comentario.getFecha().toString());
		add(fecValLabelField);
		
		LabelField evtLabelField = new LabelField("Para el Evento: ");
		add(evtLabelField);
		LabelField evtValLabelField = new LabelField(comentario.getEvento()
				.getDescripcion());
		add(evtValLabelField);
		
		ButtonField btnSalir = new ButtonField("Cerrar");
		btnSalir.setCommand(new Command(new CommandHandler() {
			public void execute(ReadOnlyCommandMetadata metadata, Object context) {
				ComentarioDetalleScreen.this.close();
			}
		}));
		ButtonField btnPostComentario = new ButtonField("Agregar Comentario");
		btnPostComentario.setCommand(new Command(new CommandHandler() {
			public void execute(ReadOnlyCommandMetadata metadata, Object context) {
				ComentarioDetalleScreen.this.getUiEngine().pushScreen(
						new PostComentarioScreen(
								ComentarioDetalleScreen.this.comentario.getEvento()));
			}
		}));
		GridFieldManager btnsGrid = new GridFieldManager(1, 2, 0);
		btnsGrid.add(btnSalir);
		btnsGrid.add(btnPostComentario);
		add(btnsGrid);
	}

}
