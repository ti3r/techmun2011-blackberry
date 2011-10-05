package org.blanco.tecmun.bb;

import net.rim.device.api.system.EventLogger;
import net.rim.device.api.ui.UiApplication;

public class TecChMun2011App extends UiApplication{
    
	public static final String APP_NAME = "Tec-Ch-Mun-2011";
	public static final long GUID = 0x2015fd76b72d21L;

	/**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
    public static void main(String[] args){
    	EventLogger.register(GUID, APP_NAME, 
    			EventLogger.VIEWER_STRING);
    	    	
    	TecChMun2011App app = new TecChMun2011App();
    	app.enterEventDispatcher();
    }
    
    /**
     * Creates a new HelloBlackBerry object
     */
    public TecChMun2011App() {
        // Push a screen onto the UI stack for rendering.
        pushScreen( new TecChMun2011Screen() );
    }
}
