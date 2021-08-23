package com.challenge.app.tienda;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.app.tienda.services.impl.OrdersServices;

@SpringBootTest
public class OrderServicesTest {
	@Autowired
	OrdersServices service;
    
    @Test
    public void crearTransaccion_success() throws Exception {
    	String str = service.crearTransaccion(50L);
    	assertThat(str.contains("https://dev.placetopay.com/redirection/session/"));
    }
	
}
