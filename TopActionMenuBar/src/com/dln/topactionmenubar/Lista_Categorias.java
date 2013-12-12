package com.dln.topactionmenubar;

public class Lista_Categorias {
	private int idImagen; 
	private String textoTitulo; 
	private String textoDescripcion; 
	  
	public Lista_Categorias (int idImagen, String textoTitulo, String textoDescripcion) { 
	    this.idImagen = idImagen; 
	    this.textoTitulo = textoTitulo; 
	    this.textoDescripcion = textoDescripcion; 
	}
	
	public String get_textoTitulo() { 
	    return textoTitulo ; 
	}
	
	public String get_textoDescripcion() { 
	    return textoDescripcion; 
	}
	
	public int get_idImagen() {
	    return idImagen; 
	} 
}
