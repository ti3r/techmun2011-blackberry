package org.blanco.tecmun.bb.ui;

import org.blanco.tecmun.bb.misc.Utils;

import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.GridFieldManager;

public class ScreenHeader extends GridFieldManager {

	public ScreenHeader(String title){
		super(1, 2, GridFieldManager.NON_FOCUSABLE | 
				GridFieldManager.USE_ALL_WIDTH);
		//add the image to the header
		BitmapField logo = new BitmapField(Utils.bitmapLogo);
		add(logo);
		//create the text header
		LabelField headerText = new LabelField(title);
		add(headerText);
	}
	
}
