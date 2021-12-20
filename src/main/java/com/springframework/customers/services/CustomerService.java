package com.springframework.customers.services;

import com.springframework.customers.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
