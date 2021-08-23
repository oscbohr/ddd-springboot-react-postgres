package com.challenge.app.tienda.modelo.excepcion;

/**
 * Exception de Negocio/Tecnica
 * @author ombohorquez
 *
 */
public class PlaceToPayException extends Exception {
	private static final long serialVersionUID = 1L;

	public PlaceToPayException(String message) {
		super(message);
	}
}
