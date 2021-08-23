package com.challenge.app.tienda.repositorio.modelo.pay;

import java.io.Serializable;

/**
 * STUB de API-REST PlaceToPay
 * @author ombohorquez
 *
 */
public class RedirectInformation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Status status;
	private RedirectRequest request;
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the request
	 */
	public RedirectRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(RedirectRequest request) {
		this.request = request;
	}
	@Override
	public String toString() {
		return "RedirectInformation [status=" + status + ", request=" + request + "]";
	}
}
