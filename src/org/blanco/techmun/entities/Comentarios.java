package org.blanco.techmun.entities;

import net.rim.device.api.collection.Collection;
import net.rim.device.api.collection.List;
import net.rim.device.api.collection.util.UnsortedReadableList;

/**
 * A class that represents a List of Comentario objects, copied
 * from the classes used in the web application but the
 * annotations and extra information was removed.
 * 
 * @author Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 */
public class Comentarios{

	/**
	 * The list that will hold the elements
	 */
	private UnsortedReadableList comentarios = null;

	/**
	 * Default constructor creates and empty list
	 */
	public Comentarios(){
		this.comentarios = new UnsortedReadableList();
	}
	/**
	 * Constructor that builds the list with one element
	 * @param comentario The Comentario item to be added
	 */
	public Comentarios(Comentario comentario){
		this();
		//this.comentarios.doAdd(comentario);
	}
	/**
	 * Constructor that build the list with the elements in
	 * the passed colection
	 * @param comentarios The Comentario items to be added
	 */
	public Comentarios(Collection comentarios){
		this();
		//this.comentarios.doAdd(comentarios);
	}
	
	public List getComentarios() {
		//return comentarios;
		return null;
	}

	public void setComentarios(List comentarios) {
		//this.comentarios = comentarios;
	}
		
	public void addComentario(Comentario comenratio){
		//this.comentarios.doAdd(comenratio);
	}
	
	public void addComentarios(Comentarios comentarios){
		//this.comentarios.doAdd(comentarios.getComentarios());
	}
	
}
