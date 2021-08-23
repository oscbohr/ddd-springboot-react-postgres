package com.challenge.app.tienda.services;

import com.challenge.app.tienda.modelo.ArticuloDTO;
import com.challenge.app.tienda.modelo.excepcion.PlaceToPayException;

/**
 * Interface para Gestionar la tabla articulos
 * @author ombohorquez
 *
 */
public interface IGestorInventarios {
	
	/**
	 * Metodo que permite consultar todos los articulos
	 * @return Lista
	 * @throws PlaceToPayException
	 */
	public Iterable<ArticuloDTO> consultarArticulos() throws PlaceToPayException;
	
}
