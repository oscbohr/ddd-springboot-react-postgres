package com.challenge.app.tienda.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.app.tienda.modelo.ArticuloDTO;
import com.challenge.app.tienda.modelo.excepcion.PlaceToPayException;
import com.challenge.app.tienda.repositorio.ArticuloRepositorio;
import com.challenge.app.tienda.repositorio.modelo.persistencia.ArticuloJPA;
import com.challenge.app.tienda.services.IGestorInventarios;

/**
 * Implementación para manejar el service de Inventarios
 * @author ombohorquez
 *
 */
@Service
public class InventarioServices implements IGestorInventarios {
	@Autowired
	private ArticuloRepositorio repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<ArticuloDTO> consultarArticulos() throws PlaceToPayException {
		List<ArticuloDTO> listaDTO = new ArrayList<>();
		try {
			Iterable<ArticuloJPA> listaJPA = repository.findAll();
			for (ArticuloJPA articuloJPA : listaJPA) {
				ArticuloDTO item = new ArticuloDTO(articuloJPA.getId(), articuloJPA.getNombre(), articuloJPA.getValor());
				listaDTO.add(item);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PlaceToPayException(e.getMessage());
		}
		return (listaDTO);
	}
}
