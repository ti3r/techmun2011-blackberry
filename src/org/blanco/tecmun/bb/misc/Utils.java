package org.blanco.tecmun.bb.misc;

import org.blanco.tecmun.bb.Logger;

import net.rim.device.api.math.Color3f;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.util.CharacterUtilities;
import net.rim.device.api.util.StringMatch;
import net.rim.device.api.util.StringPattern;

public class Utils {

	public static int parseHtmlColor(String color){
		if (!color.startsWith("#")){
			throw new IllegalArgumentException("Color does not start with #");
		}
		boolean pass = false;
		color = color.toUpperCase();
		pass = (
				(CharacterUtilities.isDigit(color.charAt(1)) || (color.charAt(1) == 'A') || 
				(color.charAt(1) == 'B') || (color.charAt(1) == 'C') || (color.charAt(1) == 'D') 
				|| (color.charAt(1) == 'E') || (color.charAt(1) == 'F'))
				&&
				(CharacterUtilities.isDigit(color.charAt(2)) || (color.charAt(2) == 'A') || 
				(color.charAt(2) == 'B') || (color.charAt(2) == 'C') || (color.charAt(2) == 'D') 
				|| (color.charAt(2) == 'E') || (color.charAt(2) == 'F'))
				&&
				(CharacterUtilities.isDigit(color.charAt(3)) || (color.charAt(3) == 'A') || 
				(color.charAt(3) == 'B') || (color.charAt(3) == 'C') || (color.charAt(3) == 'D') 
				|| (color.charAt(3) == 'E') || (color.charAt(3) == 'F'))
				&&
				(CharacterUtilities.isDigit(color.charAt(4)) || (color.charAt(4) == 'A') || 
				(color.charAt(4) == 'B') || (color.charAt(4) == 'C') || (color.charAt(4) == 'D') 
				|| (color.charAt(4) == 'E') || (color.charAt(4) == 'F'))
				&&
				(CharacterUtilities.isDigit(color.charAt(5)) || (color.charAt(5) == 'A') || 
				(color.charAt(5) == 'B') || (color.charAt(5) == 'C') || (color.charAt(5) == 'D') 
				|| (color.charAt(5) == 'E') || (color.charAt(5) == 'F'))
				&&
				(CharacterUtilities.isDigit(color.charAt(6)) || (color.charAt(6) == 'A') || 
				(color.charAt(6) == 'B') || (color.charAt(6) == 'C') || (color.charAt(6) == 'D') 
				|| (color.charAt(6) == 'E') || (color.charAt(6) == 'F'))
		);
		if (pass){
			String sR = color.substring(1, 3);
			String sG = color.substring(3,5);
			String sB = color.substring(5, 7);
			return Color.BLUE;
		}else{
			Logger.d("parseHtmlColor. color not recognized returning withe");
			return Color.WHITE;
		}
	}
	
}
