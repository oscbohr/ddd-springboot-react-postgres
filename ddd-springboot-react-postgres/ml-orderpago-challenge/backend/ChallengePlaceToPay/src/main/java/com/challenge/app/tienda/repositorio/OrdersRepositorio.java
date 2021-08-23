package com.challenge.app.tienda.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.challenge.app.tienda.repositorio.modelo.persistencia.OrdersJPA;

/**
 * HIBERNATE Repositorio de Orders
 * @author ombohorquez
 *
 */
public interface OrdersRepositorio extends CrudRepository<OrdersJPA, Long> {

}
