package org.blanco.tecmun.bb.screens;


import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BorderFactory;

public class PostComentarioScreen extends MainScreen {

		public PostComentarioScreen(){
			setTitle("Envia un comentario");
			LabelField lblComentario = new LabelField("Comentario:");
			TextField txtComentario = new TextField(TextField.USE_ALL_WIDTH);
			add(lblComentario);
			add(txtComentario);
			
			txtComentario.setBorder(BorderFactory.createBevelBorder(
					new XYEdges(txtComentario.getMarginTop(), txtComentario.getMarginRight(), 
							txtComentario.getMarginBottom(), txtComentario.getMarginLeft())));
			
		}
}
