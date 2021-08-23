package com.challenge.app.tienda.repositorio.modelo.pay;

import java.io.Serializable;

/**
 * STUB de API-REST PlaceToPay
 * @author ombohorquez
 *
 */
public class Status  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String reason;
	private String message;
	private String date;
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
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Status [status=" + status + ", reason=" + reason + ", message=" + message + ", date=" + date + "]";
	}
	
	

}
