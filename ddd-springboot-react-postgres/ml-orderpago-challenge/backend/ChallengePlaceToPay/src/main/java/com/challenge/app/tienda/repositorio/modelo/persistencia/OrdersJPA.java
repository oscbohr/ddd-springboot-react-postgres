package com.challenge.app.tienda.repositorio.modelo.persistencia;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa la tabla de "orders"
 * @author ombohorquez
 *
 */
@Entity
@Table(name = "orders")
public class OrdersJPA {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_order")
	private Long idOrder;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="customer_email")
	private String customerEmail;

	@Column(name="customer_mobile")
	private String customerMobile;

	@Column(name="customer_name")
	private String customerName;

	private String status;

	@Column(name="update_at")
	private Timestamp updateAt;

	//bi-directional one-to-one association to TransaccionOrderJPA
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name="id_order", referencedColumnName="id_order_fk")
	private TransaccionOrderJPA transaccionOrder;

	public OrdersJPA() {
	}

	public OrdersJPA(Timestamp createdAt, String customerEmail, String customerMobile, String customerName,
			String status, Timestamp updateAt, TransaccionOrderJPA transaccionOrder) {
		super();
		this.createdAt = createdAt;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.customerName = customerName;
		this.status = status;
		this.updateAt = updateAt;
		this.transaccionOrder = transaccionOrder;
	}

	public Long getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return this.customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public TransaccionOrderJPA getTransaccionOrder() {
		return this.transaccionOrder;
	}

	public void setTransaccionOrder(TransaccionOrderJPA transaccionOrder) {
		this.transaccionOrder = transaccionOrder;
	}
}
