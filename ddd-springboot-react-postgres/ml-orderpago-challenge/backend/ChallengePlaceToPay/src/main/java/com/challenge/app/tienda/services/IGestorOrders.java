package com.challenge.app.tienda.services;

import com.challenge.app.tienda.modelo.OrderDTO;
import com.challenge.app.tienda.modelo.excepcion.PlaceToPayException;

/**
 * Interface para Gestionar la tabla orders
 * @author ombohorquez
 *
 */
public interface IGestorOrders {
	/**
	 * Crear una orden
	 * @param order
	 * @return order
	 * @throws PlaceToPayException
	 */
	public OrderDTO crearOrders(OrderDTO order) throws PlaceToPayException;
	
	/**
	 * Crear una transaccion de pago 
	 * @param id identificador de la Order
	 * @return Url del tercero
	 * @throws PlaceToPayException
	 */
	public String crearTransaccion(Long id) throws PlaceToPayException;
	
	/**
	 * Listar todas las ordenes
	 * @return Lista
	 * @throws PlaceToPayException
	 */
	public Iterable<OrderDTO> consultarOrders() throws PlaceToPayException;
	
	/**
	 * Listar las ordenes por id
	 * @param id identificador
	 * @return lsita
	 * @throws PlaceToPayException
	 */
	public OrderDTO consultarOrderXid(Long id)throws PlaceToPayException;
	
//	/**
//	 * Actualizar una order
//	 * @param order
//	 * @return
//	 * @throws PlaceToPayException
//	 */
//	public OrderDTO actualizarStatusOrder(OrderDTO order) throws PlaceToPayException;
}
