package com.challenge.app.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.app.tienda.modelo.ArticuloDTO;
import com.challenge.app.tienda.modelo.excepcion.PlaceToPayException;
import com.challenge.app.tienda.services.IGestorInventarios;

/**
 * Controlador para INVENTARIOS. Punto de exposición para la entidad de negocio "ARTICULOS"
 * @author ombohorquez
 *
 */

@RestController
@RequestMapping("/inventario")
@ComponentScan(basePackages={"com.challenge.app.tienda"})
public class InventarioController {
	/**
	 * Services para Invenarios
	 */
	@Autowired
	private IGestorInventarios service;
	
	/**
	 * GET para consultar todos los articulos
	 * @return
	 */
	@GetMapping()
	@ResponseBody
	public ResponseEntity<?>consultarArticulos() {
		try {
			Iterable<ArticuloDTO> lista = service.consultarArticulos();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (PlaceToPayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
