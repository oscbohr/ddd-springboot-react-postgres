package com.challenge.app.tienda.repositorio.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.challenge.app.tienda.modelo.OrderDTO;
import com.challenge.app.tienda.repositorio.ISrvPlaceToPay;
import com.challenge.app.tienda.repositorio.modelo.pay.Amount;
import com.challenge.app.tienda.repositorio.modelo.pay.GetRequestInformation;
import com.challenge.app.tienda.repositorio.modelo.pay.PaymentRequest;
import com.challenge.app.tienda.repositorio.modelo.pay.Person;
import com.challenge.app.tienda.repositorio.modelo.pay.RedirectInformation;
import com.challenge.app.tienda.repositorio.modelo.pay.RedirectRequest;
import com.challenge.app.tienda.repositorio.modelo.pay.RedirectResponse;
import com.challenge.app.tienda.repositorio.modelo.pay.WSAuthentication;
import com.challenge.app.tienda.services.Constantes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementación de ISrvPlaceToPay
 * @author ombohorquez
 *
 */
@Component
public class AdaptadorServicios implements ISrvPlaceToPay {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private Constantes constantes;

	@Override
	public RedirectResponse createRequestPay(OrderDTO order) {
		RedirectRequest request = new RedirectRequest();
		request.setAuth(new WSAuthentication(constantes.getLogin(), constantes.getTrankey()));
		request.setBuyer(getBuyer(order));
		request.setPayment(getPayment(order));
		request.setExpiration("2021-08-30T00:00:00-00:00");
		request.setIpAddress(constantes.getIpcliente());
		request.setUserAgent(constantes.getAgente());
		request.setReturnUrl(constantes.getUrlretorno() + "/" + order.getId());

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RedirectRequest> entity = new HttpEntity<RedirectRequest>(request, headers);
		RedirectResponse response = restTemplate.exchange(constantes.getEndpoint(),
				HttpMethod.POST, entity, RedirectResponse.class).getBody();
		
		printJson(request, response);
		return (response);
	}
	
	@Override
	public RedirectInformation getRequestInformationPay(Integer requestId) {
		GetRequestInformation request = new GetRequestInformation();
		request.setAuth(new WSAuthentication(constantes.getLogin(), constantes.getTrankey()));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<GetRequestInformation> entity = new HttpEntity<GetRequestInformation>(request, headers);
		RedirectInformation response = restTemplate.exchange(constantes.getEndpoint() + "/" + requestId,
				HttpMethod.POST, entity, RedirectInformation.class).getBody();
		
		printJson(request, response);
		return response;
	}

	/**
	 * Metodo para crear el objeto pagador
	 * @param order order
	 * @return Person
	 */
	private Person getBuyer(OrderDTO order) {
		Person person = new Person();
		person.setDocument(constantes.getDocument());
		person.setDocumentType(constantes.getDocumenttype());
		person.setEmail(order.getEmailCliente());
		person.setMobile(order.getMovilCliente());
		person.setName(order.getNombreCliente());
		person.setSurname(order.getApellidoCliente());
		return (person);
	}

	/**
	 * Metodo para crear el objeto payment
	 * @param order order
	 * @return payment
	 */
	private PaymentRequest getPayment(OrderDTO order) {
		PaymentRequest payment = new PaymentRequest();
		Amount amount = new Amount();
		amount.setCurrency(constantes.getCurrency());
		amount.setTotal(500000d);
		
		payment.setAllowPartial(false);
		payment.setReference("TEST_" + System.currentTimeMillis());
		payment.setAmount(amount);

		return (payment);
	}
	
	/**
	 * Metodo privado para imprimir en formato JSON el request/response
	 * @param request request
	 * @param response response
	 */
	private void printJson(Object request, Object response) {
		try {
			ObjectMapper obj = new ObjectMapper();
			String strReq = obj.writeValueAsString(request);
			String strRes = obj.writeValueAsString(response);
			System.err.println("REQUEST ==" + strReq);
			System.err.println("RESPONSE==" + strRes);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
