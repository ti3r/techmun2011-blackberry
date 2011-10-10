package org.blanco.tecmun.bb.screens;


import java.util.Date;

import org.blanco.techmun.entities.Comentario;
import org.blanco.techmun.entities.Evento;
import org.blanco.tecmun.bb.net.ComentariosFetcher;
import org.blanco.tecmun.bb.ui.ScreenHeader;

import net.rim.device.api.command.Command;
import net.rim.device.api.command.CommandHandler;
import net.rim.device.api.command.ReadOnlyCommandMetadata;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BorderFactory;
import net.rim.device.api.ui.text.EmailAddressTextFilter;

public class PostComentarioScreen extends MainScreen {

	TextField txtComentario = null;
	TextField txtautor = null;
	TextField txtcontacto = null;
	Evento evento = null;
	
	public PostComentarioScreen(Evento evento){
		this.evento = evento;
		init();
	}
	
	public void init(){
			setTitle(new ScreenHeader("Envia un comentario"));
			LabelField lblComentario = new LabelField("*Comentario:");
			add(lblComentario);
			
			txtComentario = new TextField(TextField.USE_ALL_WIDTH);
			
			txtComentario.setBorder(BorderFactory.createBevelBorder(
					new XYEdges(txtComentario.getMarginTop(), txtComentario.getMarginRight(), 
							txtComentario.getMarginBottom(), txtComentario.getMarginLeft())));
			add(txtComentario);
			
			LabelField lblautor = new LabelField("Autor:");
			add(lblautor);
			txtautor = new TextField(TextField.USE_ALL_WIDTH);
			add(txtautor);
			
			LabelField lblcontacto = new LabelField("Correo:");
			add(lblcontacto);
			txtcontacto = new TextField(TextField.USE_ALL_WIDTH);
			txtcontacto.setFilter(new EmailAddressTextFilter());
			add(txtcontacto);
			
			GridFieldManager gridButtons = new GridFieldManager(1, 3, 
					GridFieldManager.USE_ALL_WIDTH | GridFieldManager.FIELD_HCENTER
					|GridFieldManager.FIELD_BOTTOM);
			ButtonField btnAceptar = new ButtonField("Enviar");
			btnAceptar.setCommand(new Command(new CommandHandler() {
				public void execute(ReadOnlyCommandMetadata metadata, Object context) {
						enviarComentario();
				}
			}));
			ButtonField btnLimpiar = new ButtonField("Limpiar");
			btnLimpiar.setCommand(new Command(new CommandHandler() {
				public void execute(ReadOnlyCommandMetadata metadata, Object context) {
					PostComentarioScreen.this.txtComentario.setText("");
					PostComentarioScreen.this.txtautor.setText("");
					PostComentarioScreen.this.txtcontacto.setText("");
				}
			}));
			ButtonField btnCancelar = new ButtonField("Cancelar");
			btnCancelar.setCommand(new Command(new CommandHandler() {
				public void execute(ReadOnlyCommandMetadata metadata, Object context) {
					PostComentarioScreen.this.close();
				}
			}));
			gridButtons.add(btnAceptar);
			gridButtons.add(btnLimpiar);
			gridButtons.add(btnCancelar);
			
			add(gridButtons);
			EditField nota = new EditField(EditField.USE_ALL_WIDTH 
					| EditField.NON_FOCUSABLE);
			nota.setLabel("Nota: ");
			nota.setEditable(false);
			nota.setText("Los campos marcados con * son obligatorios");
			
			add(nota);
		}
	
	private void enviarComentario(){
		Comentario com = new Comentario();
		com.setComentario(txtComentario.getText());
		com.setAutor(txtautor.getText());
		com.setContacto(txtcontacto.getText());
		com.setEvento(evento);
		com.setFecha(new Date(System.currentTimeMillis()));
		ComentariosFetcher.postComentario(com);
	}
}
