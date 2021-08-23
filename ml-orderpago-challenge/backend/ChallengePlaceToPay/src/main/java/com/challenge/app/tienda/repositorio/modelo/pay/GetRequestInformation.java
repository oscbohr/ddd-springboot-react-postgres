package com.challenge.app.tienda.repositorio.modelo.pay;

import java.io.Serializable;

/**
 * STUB de API-REST PlaceToPay
 * @author ombohorquez
 *
 */
public class GetRequestInformation implements Serializable {
	private static final long serialVersionUID = 1L;
	private WSAuthentication auth;
	/**
	 * @return the auth
	 */
	public WSAuthentication getAuth() {
		return auth;
	}
	/**
	 * @param auth the auth to set
	 */
	public void setAuth(WSAuthentication auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "GetRequestInformation [auth=" + auth + "]";
	}
}
