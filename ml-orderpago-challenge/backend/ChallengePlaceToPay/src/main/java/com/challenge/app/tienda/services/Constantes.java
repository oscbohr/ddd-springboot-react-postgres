package com.challenge.app.tienda.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Componente para obtener las variables de ambiente de la app
 * localizadas en "application.yml"
 * @author ombohorquez
 *
 */
@Component
public class Constantes {
	
	@Value("${placetopay.login}")
	private String login;
	@Value("${placetopay.trankey}")
	private String trankey;
	@Value("${placetopay.endpoint}")
	private String endpoint;
	@Value("${placetopay.agente}")
	private String agente;
	@Value("${placetopay.ipcliente}")
	private String ipcliente;
	@Value("${placetopay.urlretorno}")
	private String urlretorno;
	@Value("${placetopay.documenttype}")
	private String documenttype;
	@Value("${placetopay.document}")
	private String document;
	@Value("${placetopay.currency}")
	private String currency;
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @return the trankey
	 */
	public String getTrankey() {
		return trankey;
	}
	/**
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}
	/**
	 * @return the agente
	 */
	public String getAgente() {
		return agente;
	}
	/**
	 * @return the ipcliente
	 */
	public String getIpcliente() {
		return ipcliente;
	}
	/**
	 * @return the urlretorno
	 */
	public String getUrlretorno() {
		return urlretorno;
	}
	/**
	 * @return the documenttype
	 */
	public String getDocumenttype() {
		return documenttype;
	}
	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
}
