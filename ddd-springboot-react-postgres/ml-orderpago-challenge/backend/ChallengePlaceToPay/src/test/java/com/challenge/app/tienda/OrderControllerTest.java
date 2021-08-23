package com.challenge.app.tienda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.challenge.app.tienda.controller.OrdersController;
import com.challenge.app.tienda.modelo.OrderDTO;
import com.challenge.app.tienda.repositorio.ArticuloRepositorio;
import com.challenge.app.tienda.repositorio.OrdersRepositorio;
import com.challenge.app.tienda.repositorio.TransaccionOrderRepositorio;
import com.challenge.app.tienda.repositorio.modelo.persistencia.OrdersJPA;
import com.challenge.app.tienda.repositorio.modelo.persistencia.TransaccionOrderJPA;
import com.challenge.app.tienda.util.EnumStatus;
import com.challenge.app.tienda.util.UtilidadesSistema;
import com.fasterxml.jackson.databind.ObjectMapper;


//@SpringBootTest
@WebMvcTest(OrdersController.class)
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    OrdersRepositorio repoOrder;
    @MockBean
    TransaccionOrderRepositorio repoTrans;
    @MockBean
    ArticuloRepositorio repoArticulo;
    
    
    
    /**
     * Variables
     */
    OrdersJPA RECORD1 = new OrdersJPA(new Timestamp(System.currentTimeMillis()), "mail@mail1.com", "3003210000", "nombreCliente1",
    		EnumStatus.CREATED.toString(), new Timestamp(System.currentTimeMillis()),null);
    OrdersJPA RECORD2 = new OrdersJPA(new Timestamp(System.currentTimeMillis()), "mail2@mail2.com", "2003210000", "nombreCliente2",
    		EnumStatus.CREATED.toString(), new Timestamp(System.currentTimeMillis()),null);
    
    
    
    /**
     * Test para consultar todas las Ordenes
     * @throws Exception
     */
    @Test
    public void getAllOrders_success() throws Exception {
    	RECORD1.setIdOrder(1l);
    	List<OrdersJPA> records = new ArrayList<>(Arrays.asList(RECORD1, RECORD2));
    	Mockito.when(repoOrder.findAll()).thenReturn(records);
    	
    	mockMvc.perform(MockMvcRequestBuilders
                .get("/orders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(1)));
    }
    
    /**
     * Test para consultar una Orden
     * @throws Exception
     */
    @Test
    public void getOrderById_success() throws Exception {
    	//Preparacion Data
    	TransaccionOrderJPA transJPA1 = new TransaccionOrderJPA(1L, EnumStatus.CREATED.toString(), RECORD1);
    	RECORD1.setTransaccionOrder(transJPA1);
    	//Se coloca el idOrder de un registro de la BD
    	RECORD1.setIdOrder(47L);
    	
    	
    	Mockito.when(repoOrder.findById(RECORD1.getIdOrder())).thenReturn(java.util.Optional.of(RECORD1));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/orders/47")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombreCliente", is("nombreCliente1")));
    }
    
    /**
     * Test para crear una Ordern
     * @throws Exception
     */
    @Test
    public void createOrders_success() throws Exception {
    	OrderDTO dto = new OrderDTO(1l, "PABLO", "MARMOL", "pablo@gmail.com", "34223455", 
    			EnumStatus.CREATED.toString(), new Timestamp(System.currentTimeMillis()), 
    			new Timestamp(System.currentTimeMillis()), null);
    	OrdersJPA record = UtilidadesSistema.setearValoresOrderDTOaJPA(dto);
    	
    	Mockito.when(repoOrder.save(record)).thenReturn(record);
    	
    	MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(dto));
    	
    	mockMvc.perform(mockRequest).andExpect(status().isOk());
   }
}
