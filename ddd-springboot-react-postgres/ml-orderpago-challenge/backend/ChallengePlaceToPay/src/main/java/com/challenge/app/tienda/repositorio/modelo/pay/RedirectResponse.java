package com.challenge.app.tienda.repositorio.modelo.pay;

import java.io.Serializable;

/**
 * STUB de API-REST PlaceToPay
 * @author ombohorquez
 *
 */
public class RedirectResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Status status;
	private Integer requestId;
	private String processUrl;
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
	 * @return the requestId
	 */
	public Integer getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	/**
	 * @return the processUrl
	 */
	public String getProcessUrl() {
		return processUrl;
	}
	/**
	 * @param processUrl the processUrl to set
	 */
	public void setProcessUrl(String processUrl) {
		this.processUrl = processUrl;
	}
	@Override
	public String toString() {
		return "RedirectResponse [status=" + status + ", requestId=" + requestId + ", processUrl=" + processUrl + "]";
	}
}
