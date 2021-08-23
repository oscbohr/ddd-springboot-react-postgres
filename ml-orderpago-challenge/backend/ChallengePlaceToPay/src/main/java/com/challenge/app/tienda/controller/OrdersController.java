package com.challenge.app.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.app.tienda.modelo.OrderDTO;
import com.challenge.app.tienda.modelo.excepcion.PlaceToPayException;
import com.challenge.app.tienda.services.IGestorOrders;
import com.challenge.app.tienda.util.EnumStatus;
import com.challenge.app.tienda.util.UtilidadesSistema;


/**
 * Controlador para ORDENES. Punto de exposición para la entidad de negocio "orders"
 * @author ombohorquez
 *
 */
@Controller
@RequestMapping("/orders")
@ComponentScan(basePackages={"com.challenge.app.tienda"})
public class OrdersController {
	/**
	 * Services para gestionar Ordenes
	 */
	@Autowired
	private IGestorOrders service;
	
	/**
	 * Metodo POST para crear una ordern
	 * @param orderDTO
	 * @return orderDTO
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crearOrder(@RequestBody OrderDTO order) {
		if(UtilidadesSistema.validarOrdersDTO(order)) {
			try { 
				order.setStatusTransaccion(EnumStatus.CREATED.name());
				order = service.crearOrders(order);
				return new ResponseEntity<>(order, HttpStatus.OK);
			} catch (PlaceToPayException e) {
				e.printStackTrace();
				return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("OBJETO VACIO", HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * Metodo POST para crear un transaccion de pago
	 * @param id idOrder a crear la pasarela de pago
	 * @return URL (procesUrl) para realizar el pago
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(value = "{id}/transaccion")
	public ResponseEntity<?> crearTransaccion(@PathVariable Long id) {
		String strProcessURL = null;
		try {
			strProcessURL = service.crearTransaccion(id);
			return new ResponseEntity<>(strProcessURL, HttpStatus.OK);
		} catch (PlaceToPayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> modificarOrder(@RequestBody OrderDTO order) {
//		if(UtilidadesSistema.validarOrdersDTO(order)) {
//			try {
//				order = service.actualizarStatusOrder(order);
//				return new ResponseEntity<>(order, HttpStatus.OK);
//			} catch (PlaceToPayException e) {
//				e.printStackTrace();
//				return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		} else {
//			return new ResponseEntity<>("OBJETO VACIO", HttpStatus.NO_CONTENT);
//		}
//	}
	
	/**
	 * GET para consultar todas las ordenes
	 * @return Lista de Ordenes
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping()
	@ResponseBody
	public ResponseEntity<?>consultarAllOrders() {
		try {
			Iterable<OrderDTO> listaOrders = service.consultarOrders();
			return new ResponseEntity<>(listaOrders, HttpStatus.OK);
		} catch (PlaceToPayException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * GET para consultar solo una order
	 * @param id idOrder
	 * @return OrderDTO
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<?>consultarOrdersXId(@PathVariable Long id) {
		if(id != null) {
			try {
				OrderDTO order = service.consultarOrderXid(id);
				return new ResponseEntity<>(order, HttpStatus.OK);
			} catch (PlaceToPayException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("OBJETO VACIO", HttpStatus.NO_CONTENT);
		}
	}
}