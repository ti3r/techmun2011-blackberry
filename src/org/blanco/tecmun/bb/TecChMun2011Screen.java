package org.blanco.tecmun.bb;

import java.util.Vector;

import org.blanco.tecmun.bb.screens.MesasScreen;

import net.rim.device.api.command.Command;
import net.rim.device.api.command.CommandHandler;
import net.rim.device.api.command.ReadOnlyCommandMetadata;
import net.rim.device.api.system.EventLogger;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.container.MainScreen;

import org.blanco.tecmun.bb.TecChMun2011App;
/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class TecChMun2011Screen extends MainScreen
{
	ButtonField button = null;
	Vector listElements = null;
    ListField lista = null;
	/**
     * Creates a new TecChMun2011Screen object
     */
    public TecChMun2011Screen()
    {        
        // Set the displayed title of the screen       
    	setTitle("Tec.Ch.Mun 2011");
        initComponents();
    }

	private void initComponents() {
		button = new ButtonField("Mesas");
		button.setCommand(new Command(new LaunchScreenCommandHandler(new MesasScreen())));
		ButtonField btnCalendario = new ButtonField("Calendario");
		ButtonField btnMapa = new ButtonField("Mapa");
		ButtonField btnCompartir = new ButtonField("Compartir");
		
		add(button);add(btnCalendario);add(btnMapa);add(btnCompartir);
		
	}
    
    class LaunchScreenCommandHandler extends CommandHandler{

    	Screen screen = null;
    	
    	public LaunchScreenCommandHandler(Screen screenToLaunch){
    		this.screen = screenToLaunch;
    	}
    	
		public void execute(ReadOnlyCommandMetadata metadata, Object context) {
			String msg = "Executing Launch Screen: "+screen;
			EventLogger.logEvent(TecChMun2011App.GUID, 
					msg.getBytes(), EventLogger.ALWAYS_LOG);
			getUiEngine().pushScreen(screen);
		}
    	
    }
    
}
