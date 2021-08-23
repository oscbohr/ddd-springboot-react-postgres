package com.challenge.app.tienda.modelo;

import java.io.Serializable;

/**
 * DTO para manejar Articulos
 * @author ombohorquez
 *
 */
public class ArticuloDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private Double valor;

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param valor
	 */
	public ArticuloDTO(Long id, String nombre, Double valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ArticuloDTO [id=" + id + ", nombre=" + nombre + ", valor=" + valor + "]";
	}
	
}
