package com.springframework.customers.services;

import com.springframework.customers.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Slf4j
public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .customerName("GiuliaB")
                .customerStyle("Pretty woman")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //todo: implement method
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting a customer");
    }
}
