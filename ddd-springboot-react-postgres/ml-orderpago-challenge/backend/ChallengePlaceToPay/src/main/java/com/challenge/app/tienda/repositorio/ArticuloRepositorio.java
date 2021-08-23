package com.challenge.app.tienda.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.challenge.app.tienda.repositorio.modelo.persistencia.ArticuloJPA;

/**
 * HIBERNATE Repositorio de Articulos
 * @author ombohorquez
 *
 */
public interface ArticuloRepositorio extends CrudRepository<ArticuloJPA, Long> {

}
