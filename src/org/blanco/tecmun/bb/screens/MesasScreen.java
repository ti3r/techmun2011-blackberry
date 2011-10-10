package org.blanco.tecmun.bb.screens;

import java.util.Vector;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.container.MainScreen;

import org.blanco.techmun.entities.Mesa;
import org.blanco.tecmun.bb.Logger;
import org.blanco.tecmun.bb.net.MesasFetcher;
import org.blanco.tecmun.bb.ui.ScreenHeader;
import org.blanco.tecmun.bb.ui.callbacks.MesasVectorListFieldCallBack;

public class MesasScreen extends MainScreen {

	ListField mesasList = null;
	MesasFetcher fetcher = null;
	/**
	 * The screen that will show the Mesa objects
	 */
	public MesasScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		setTitle(new ScreenHeader("Mesas"));
		
		fetcher = new MesasFetcher();
		Vector mesas = MesasFetcher.fetchMesas();
		mesasList = new ListField(mesas.size());
		mesasList.setCallback(new MesasVectorListFieldCallBack(mesas));
		
		add(mesasList);
		//    	getUiEngine().pushModalScreen(dlg);
//		
		//loader.start();
//		try {
//			//MesasFetcher.fetchMesas();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
		
	protected void onDisplay() {
		Dialog dlg = new Dialog("wait please...", null, null, Dialog.OK,
		        Bitmap.getPredefinedBitmap(Bitmap.HOURGLASS));
		
	}

	protected boolean navigationClick(int status, int time) {
			Logger.a("Navidation Clicked");
			Object mesa =
			mesasList.getCallback().get(mesasList, mesasList.getSelectedIndex());
			if (mesa != null){
				Mesa m = (Mesa) mesa;
				getUiEngine().pushModalScreen(new EventosScreen(m));
				return true;
			}else{
				return false;
			}
	}
	
	

}
