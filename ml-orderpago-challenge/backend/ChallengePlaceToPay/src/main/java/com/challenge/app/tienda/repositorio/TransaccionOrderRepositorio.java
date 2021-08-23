package com.challenge.app.tienda.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.challenge.app.tienda.repositorio.modelo.persistencia.TransaccionOrderJPA;

/**
 * HIBERNATE Repositorio de TransaccionOrders
 * @author ombohorquez
 *
 */
public interface TransaccionOrderRepositorio extends CrudRepository<TransaccionOrderJPA, Long> {

}
