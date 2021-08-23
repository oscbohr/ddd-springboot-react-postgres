package com.challenge.app.tienda.util;

import java.sql.Timestamp;

import com.challenge.app.tienda.modelo.OrderDTO;
import com.challenge.app.tienda.modelo.TransaccionOrderDTO;
import com.challenge.app.tienda.repositorio.modelo.persistencia.OrdersJPA;
import com.challenge.app.tienda.repositorio.modelo.persistencia.TransaccionOrderJPA;

/**
 * Clase de utilidades generales
 * @author ombohorquez
 *
 */
public class UtilidadesSistema {

	/**
	 * Valida una orden
	 * @param order
	 * @return boolean
	 */
	public static boolean validarOrdersDTO(OrderDTO order) {
		boolean retorno = true;
		if (order == null) {
			retorno = false;
		} else if (order.getEmailCliente().equals(null)) {
			retorno = false;
		} else if (order.getMovilCliente().equals(null)) {
			retorno = false;
		} else if (order.getNombreCliente().equals(null)) {
			retorno = false;
		} else if (order.getApellidoCliente().equals(null)) {
			retorno = false;
		}
		return (retorno);
	}

	/**
	 * Metodo para replicar valores entreo DTO <==> JPA
	 * @param orderJPA
	 * @return orderDTO
	 */
	public static OrderDTO setearValoresOrderJPAaDTO(OrdersJPA orderJPA) {
		if (orderJPA != null) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setEmailCliente(orderJPA.getCustomerEmail());
			orderDTO.setFechaActualizacion(orderJPA.getUpdateAt());
			orderDTO.setFechaCreacion(orderJPA.getUpdateAt());
			orderDTO.setId(orderJPA.getIdOrder());
			orderDTO.setMovilCliente(orderJPA.getCustomerMobile());
			orderDTO.setNombreCliente(orderJPA.getCustomerName());
			orderDTO.setApellidoCliente(orderJPA.getCustomerName());
			orderDTO.setStatusTransaccion(orderJPA.getStatus());
			
			TransaccionOrderDTO transDTO = null;
			if(orderJPA.getTransaccionOrder() != null) {
				transDTO = new TransaccionOrderDTO();
				transDTO.setRequestid(orderJPA.getTransaccionOrder().getRequestId());
				transDTO.setStatus(orderJPA.getTransaccionOrder().getStatus());
			}
			orderDTO.setTransaccionOrder(transDTO);
			return (orderDTO);
		} else {
			return (null);
		}
	}

	/**
	 * Metodo para replicar valores entreo JPA <==> DTO  
	 * @param orderDTO
	 * @return orderJPA
	 */
	public static OrdersJPA setearValoresOrderDTOaJPA(OrderDTO order) {
		if (order != null) {
			OrdersJPA itemJPA = new OrdersJPA();
			itemJPA.setCustomerEmail(order.getEmailCliente());
			itemJPA.setCustomerMobile(order.getMovilCliente());
			itemJPA.setCustomerName(order.getNombreCliente().toUpperCase() + " " + order.getApellidoCliente().toUpperCase());
			itemJPA.setStatus(order.getStatusTransaccion());
			itemJPA.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			itemJPA.setUpdateAt(new Timestamp(System.currentTimeMillis()));
			
			TransaccionOrderJPA transJPA = null;
			if(order.getTransaccionOrder() != null) {
				transJPA = new TransaccionOrderJPA();
				transJPA.setOrder(itemJPA);
				transJPA.setRequestId(order.getTransaccionOrder().getRequestid());
				transJPA.setStatus(order.getTransaccionOrder().getStatus());
			} 
			itemJPA.setTransaccionOrder(transJPA);
			
			return (itemJPA);
		} else {
			return (null);
		}
	}
}
