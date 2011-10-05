package org.blanco.tecmun.bb.misc;

import net.rim.device.api.ui.Color;

public class Utils {

	public static int parseHtmlColor(String color){
		if (!color.startsWith("#")){
			throw new IllegalArgumentException("Color does not start with #");
		}
		if ("#\\d{6}".regionMatches(true, 0, color, 0, color.length())){
			String sR = color.substring(1, 2);
			String sG = color.substring(3,4);
			String sB = color.substring(5, 6);
			return Color.BLUE;
		}else{
			throw new IllegalArgumentException("Color does not match the color" +
					" expression #\\d{6}");
		}
	}
	
}
