package com.challenge.app.tienda.modelo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO de Ordenes
 * @author ombohorquez
 *
 */
public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Variables
	 */
	private Long id;
	private String nombreCliente;
	private String apellidoCliente;
	private String emailCliente;
	private String movilCliente;
	private String statusTransaccion;
	private Timestamp fechaCreacion;
	private Timestamp fechaActualizacion;
	private TransaccionOrderDTO transaccionOrder;

	/**
	 * 
	 */
	public OrderDTO() {
	}
	
	/**
	 * 
	 * @param id
	 * @param nombreCliente
	 * @param apellidoCliente
	 * @param emailCliente
	 * @param movilCliente
	 * @param statusTransaccion
	 * @param fechaCreacion
	 * @param fechaActualizacion
	 * @param transaccionOrder
	 */
	public OrderDTO(Long id, String nombreCliente, String apellidoCliente, String emailCliente, String movilCliente,
			String statusTransaccion, Timestamp fechaCreacion, Timestamp fechaActualizacion,
			TransaccionOrderDTO transaccionOrder) {
		super();
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.emailCliente = emailCliente;
		this.movilCliente = movilCliente;
		this.statusTransaccion = statusTransaccion;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.transaccionOrder = transaccionOrder;
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
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return the apellidoCliente
	 */
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	/**
	 * @param apellidoCliente the apellidoCliente to set
	 */
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	/**
	 * @return the emailCliente
	 */
	public String getEmailCliente() {
		return emailCliente;
	}
	/**
	 * @param emailCliente the emailCliente to set
	 */
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	/**
	 * @return the movilCliente
	 */
	public String getMovilCliente() {
		return movilCliente;
	}
	/**
	 * @param movilCliente the movilCliente to set
	 */
	public void setMovilCliente(String movilCliente) {
		this.movilCliente = movilCliente;
	}
	/**
	 * @return the statusTransaccion
	 */
	public String getStatusTransaccion() {
		return statusTransaccion;
	}
	/**
	 * @param statusTransaccion the statusTransaccion to set
	 */
	public void setStatusTransaccion(String statusTransaccion) {
		this.statusTransaccion = statusTransaccion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaActualizacion
	 */
	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}
	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	/**
	 * @return the transaccionOrder
	 */
	public TransaccionOrderDTO getTransaccionOrder() {
		return transaccionOrder;
	}
	/**
	 * @param transaccionOrder the transaccionOrder to set
	 */
	public void setTransaccionOrder(TransaccionOrderDTO transaccionOrder) {
		this.transaccionOrder = transaccionOrder;
	}
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente
				+ ", emailCliente=" + emailCliente + ", movilCliente=" + movilCliente + ", statusTransaccion="
				+ statusTransaccion + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion
				+ ", transaccionOrder=" + transaccionOrder + "]";
	}
}
