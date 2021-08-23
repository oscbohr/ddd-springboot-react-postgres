package com.challenge.app.tienda.modelo;

import java.io.Serializable;

/**
 * DTO de TransaccionOrder
 * @author ombohorquez
 *
 */
public class TransaccionOrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long requestid;
	private String status;
	
	/**
	 * @return the requestid
	 */
	public Long getRequestid() {
		return requestid;
	}
	/**
	 * @param requestid the requestid to set
	 */
	public void setRequestid(Long requestid) {
		this.requestid = requestid;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransaccionOrder [requestid=" + requestid + ", status=" + status + "]";
	}
}
