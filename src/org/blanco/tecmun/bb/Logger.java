package org.blanco.tecmun.bb;

import net.rim.device.api.system.EventLogger;

public class Logger {

	public static void a(String msg){
		EventLogger.logEvent(TecChMun2011App.GUID, msg.getBytes(),
				EventLogger.ALWAYS_LOG);
	}
	
	public static void d(String msg){
		EventLogger.logEvent(TecChMun2011App.GUID, msg.getBytes(),
				EventLogger.DEBUG_INFO);
	}
	
	public static void i(String msg){
		EventLogger.logEvent(TecChMun2011App.GUID, msg.getBytes(),
				EventLogger.DEBUG_INFO);
	}
}
