package com.springframework.customers.services.v2;

import com.springframework.customers.web.model.v2.CustomerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerServiceV2 {
    Object getCustomerById(UUID customerId);

    CustomerDtoV2 saveNewCustomer(CustomerDtoV2 customerDto);

    void updateCustomer(UUID customerId, CustomerDtoV2 customerDto);

    void deleteCustomerById(UUID customerId);
}
