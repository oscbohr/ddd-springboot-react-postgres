package com.challenge.app.tienda.repositorio.modelo.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa la tabla de transaccion_orders
 * @author ombohorquez
 *
 */
@Entity
@Table(name = "transaccion_orders")
public class TransaccionOrderJPA {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id_tran")
	private Long idTran;

	@Column(name="request_id")
	private Long requestId;

	private String status;

	//bi-directional one-to-one association to OrdersJPA
	@OneToOne
	@MapsId
	@JoinColumn(name = "id_order_fk")
	private OrdersJPA order;
	
	public TransaccionOrderJPA() {
	}

	public TransaccionOrderJPA(Long requestId, String status, OrdersJPA order) {
		super();
		this.requestId = requestId;
		this.status = status;
		this.order = order;
	}

	public Long getIdTran() {
		return this.idTran;
	}

	public void setIdTran(Long idTran) {
		this.idTran = idTran;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrdersJPA getOrder() {
		return this.order;
	}

	public void setOrder(OrdersJPA order) {
		this.order = order;
	}
}
