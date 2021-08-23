package com.challenge.app.tienda.repositorio;

import com.challenge.app.tienda.modelo.OrderDTO;
import com.challenge.app.tienda.repositorio.modelo.pay.RedirectInformation;
import com.challenge.app.tienda.repositorio.modelo.pay.RedirectResponse;

/**
 * Interface para manejar las operaciones de PlaceToPay
 * 	- CreateRequest
 * 	- GetRequestInformation
 * @author ombohorquez
 */
public interface ISrvPlaceToPay {
	
	/**
	 * Metodo inicial para consumir un pago
	 * @param redirectRequest request
	 * @return response
	 */
	public RedirectResponse createRequestPay(OrderDTO order);
	
	/**
	 * Metodo para consultar una transaccion
	 * @param requestId id de la transaccion
	 * @return objeto
	 */
	public RedirectInformation getRequestInformationPay(Integer requestId);
	
}
