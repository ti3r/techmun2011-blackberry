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



/**
 * This class represents one Mesa object. One copy of the
 * Mesa object used in the web application with out all
 * the annotations and implementing Serializable in order
 * to be added to intent extras.
 * 
 * @author Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 */
public class Mesa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9083683486131700233L;
	
	private Long id = null;
	private String nombre = null;
	private Usuario representante = null;
	private String color = null;
	private boolean isDarkColor = false;
	
	public Mesa(){
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Usuario getRepresentante() {
		return representante;
	}
	public void setRepresentante(Usuario representante) {
		this.representante = representante;
	}
	
	public String toString() {
		return "Mesa[ "+id+", "+nombre+", "+representante;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isDarkColor() {
		return isDarkColor;
	}
	public void setDarkColor(boolean isDarkColor) {
		this.isDarkColor = isDarkColor;
	}
	
}
