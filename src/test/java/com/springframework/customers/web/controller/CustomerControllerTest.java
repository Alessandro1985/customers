package com.springframework.customers.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.customers.services.CustomerService;
import com.springframework.customers.web.model.CustomerDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerDto validCustomerDto;

    @BeforeEach
    void setUp() {
        validCustomerDto = CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .customerName("GB")
                .customerStyle("PW")
                .build();
    }

    @Test
    void getCustomer() {
        given(customerService.getCustomerById(any(UUID.class))).willReturn(validCustomerDto);

        mockMvc.perform(get("/api/vi/customer" + validCustomerDto.getUuid().toString())
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    void handlePost() {
    }

    @Test
    void handleUpdate() {
    }
}