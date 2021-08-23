package com.challenge.app.tienda.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.app.tienda.modelo.OrderDTO;
import com.challenge.app.tienda.modelo.excepcion.PlaceToPayException;
import com.challenge.app.tienda.repositorio.ISrvPlaceToPay;
import com.challenge.app.tienda.repositorio.OrdersRepositorio;
import com.challenge.app.tienda.repositorio.TransaccionOrderRepositorio;
import com.challenge.app.tienda.repositorio.modelo.pay.RedirectInformation;
import com.challenge.app.tienda.repositorio.modelo.pay.RedirectResponse;
import com.challenge.app.tienda.repositorio.modelo.persistencia.OrdersJPA;
import com.challenge.app.tienda.repositorio.modelo.persistencia.TransaccionOrderJPA;
import com.challenge.app.tienda.services.IGestorOrders;
import com.challenge.app.tienda.util.EnumStatus;
import com.challenge.app.tienda.util.UtilidadesSistema;

/**
 * Implementación para manejar el service de Ordenes
 * @author ombohorquez
 *
 */
@Service
public class OrdersServices implements IGestorOrders {

	@Autowired
	private OrdersRepositorio repoOrders;
	@Autowired
	private TransaccionOrderRepositorio repoTransac;
	
	@Autowired
	private ISrvPlaceToPay pay;
	
	@Override
	@Transactional
	public OrderDTO crearOrders(OrderDTO order) throws PlaceToPayException {
		OrdersJPA itemJPA = UtilidadesSistema.setearValoresOrderDTOaJPA(order);
		itemJPA = repoOrders.save(itemJPA);
		OrderDTO orderDTO = UtilidadesSistema.setearValoresOrderJPAaDTO(itemJPA);
		return (orderDTO);
	}
	
	@Override
	@Transactional
	public String crearTransaccion(Long id) throws PlaceToPayException{
		String processUrl = "";
		try {
			OrdersJPA orderJPA = consultarXIdOrder(id);
			if (orderJPA != null) {
				OrderDTO order = UtilidadesSistema.setearValoresOrderJPAaDTO(orderJPA);
				RedirectResponse response = pay.createRequestPay(order);
				System.out.println("RESPONSE CREAR==" + response);
				processUrl = response.getProcessUrl();
				
				TransaccionOrderJPA transJPA = orderJPA.getTransaccionOrder();
				if(transJPA == null) {
					transJPA = new TransaccionOrderJPA();
					transJPA.setOrder(orderJPA);
					transJPA.setRequestId(response.getRequestId().longValue());
					transJPA.setStatus(EnumStatus.PENDING.toString());
					repoTransac.save(transJPA);
					orderJPA.setTransaccionOrder(transJPA);
					orderJPA = repoOrders.save(orderJPA);
				} 	
			} else {
				throw new PlaceToPayException("ENTIDAD NO EXISTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlaceToPayException(e.getMessage());
		}
		return (processUrl);
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<OrderDTO> consultarOrders() throws PlaceToPayException {
		List<OrderDTO> listaOrders = new ArrayList<>();
		try {
			Iterable<OrdersJPA> listaJPA = repoOrders.findAll();
			for (OrdersJPA ordersJPA : listaJPA) {
				OrderDTO order = UtilidadesSistema.setearValoresOrderJPAaDTO(ordersJPA);
				listaOrders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlaceToPayException(e.getMessage());
		}
		return listaOrders;
	}

	@Transactional
	public OrderDTO consultarOrderXid(Long id) throws PlaceToPayException {
		OrderDTO orderDTO = null;
		try {
			OrdersJPA itemJPA = consultarXIdOrder(id);
			if(itemJPA != null) { 
				if(! itemJPA.getStatus().equalsIgnoreCase(EnumStatus.PAYED.toString())) {
					TransaccionOrderJPA transJPA = itemJPA.getTransaccionOrder();
					if(transJPA != null) {
						if(transJPA.getStatus().equalsIgnoreCase(EnumStatus.PENDING.toString())) {
							RedirectInformation redirectInfo = pay.getRequestInformationPay(transJPA.getRequestId().intValue());
							System.out.println("RESPONSE GET ==" + redirectInfo);
							if(redirectInfo.getStatus().getStatus().equalsIgnoreCase(EnumStatus.PENDING.toString())) {
								orderDTO = UtilidadesSistema.setearValoresOrderJPAaDTO(itemJPA);
							} else {
								transJPA.setStatus(redirectInfo.getStatus().getStatus());
								if(redirectInfo.getStatus().getStatus().equalsIgnoreCase(EnumStatus.REJECTED.toString())) {
									itemJPA.setStatus(EnumStatus.REJECTED.toString());
									itemJPA.setTransaccionOrder(transJPA);
								} else {
									itemJPA.setStatus(EnumStatus.PAYED.toString());
									itemJPA.setTransaccionOrder(transJPA);
								}
								itemJPA.setTransaccionOrder(transJPA);
								itemJPA = repoOrders.save(itemJPA);
								orderDTO = UtilidadesSistema.setearValoresOrderJPAaDTO(itemJPA);
							}
						} 
					} 
				}
			} else {
				orderDTO = new OrderDTO();
			}
			orderDTO = UtilidadesSistema.setearValoresOrderJPAaDTO(itemJPA);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PlaceToPayException(e.getMessage());
		}
		return orderDTO;
	}
//
//	@Override
//	public OrderDTO actualizarStatusOrder(OrderDTO order) throws PlaceToPayException {
//		OrderDTO orderDTO = null; 
//		try {
//			OrdersJPA itemJPA = consultarXIdOrder(order.getId());
//			if(itemJPA != null) {
//				itemJPA.setStatus(order.getStatusTransaccion());
//				itemJPA = repoOrders.save(itemJPA);
//				orderDTO = UtilidadesSistema.setearValoresOrderJPAaDTO(itemJPA);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new PlaceToPayException(e.getMessage());
//		}
//		return orderDTO;
//	}
	
	/**
	 * Metodo apra consultar una OrderJPA por ID
	 * @param id Llave primaria
	 * @return
	 */
	private OrdersJPA consultarXIdOrder(Long id) {
		Optional<OrdersJPA> op = repoOrders.findById(id);
		if(! op.isEmpty()) {
			return (op.get());
		} else {
			return (null);
		}
	}
}
