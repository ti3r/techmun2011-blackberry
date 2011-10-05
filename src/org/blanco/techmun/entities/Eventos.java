/*  Tech Mun 2011 is a web application that handles all the information
 *  of the event that will be held on September 2011 on Tec de Monterrey
 *  campus Chihuahua.
 *  You can use this application as an example of how to use the
 *  different technologies listed.
 *  
 *  Copyright (C) 2011  Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.blanco.techmun.entities;

import java.util.Vector;

import net.rim.device.api.collection.Collection;
import net.rim.device.api.collection.List;
import net.rim.device.api.collection.util.UnsortedReadableList;

/**
 * A class that represents a List of Evento objects, copied
 * from the classes used in the web application but the
 * annotations and extra information was removed.
 * 
 * @author Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 */

public class Eventos {

	private Vector eventos = null;
	
	/**
	 * Default constructor to build an empty list of evento 
	 * objects
	 */
	public Eventos(){
		this.eventos = new Vector(5,2);
	}
	/**
	 * Constructor to build a list of Evento objects
	 * with one element
	 * @param e The Evento element to be added to the list
	 */
	public Eventos(Evento e){
		this();
		this.eventos.addElement(e);
	}
	

	
	public Vector getEventos() {
		return eventos;
	}

	public void setEventos(Vector eventos) {
		this.eventos = eventos;
	}
	
}
