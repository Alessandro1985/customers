package com.springframework.customers.services.v2;

import com.springframework.customers.services.CustomerService;
import com.springframework.customers.web.model.CustomerDto;
import com.springframework.customers.web.model.v2.CustomerDtoV2;
import com.springframework.customers.web.model.v2.CustomerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceV2Impl implements CustomerServiceV2 {
    @Override
    public CustomerDtoV2 getCustomerById(UUID customerId) {
        return CustomerDtoV2.builder()
                .uuid(UUID.randomUUID())
                .customerName("GiuliaB")
                .customerStyle(CustomerStyleEnum.FASHION)
                .build();

    }

    @Override
    public CustomerDtoV2 saveNewCustomer(CustomerDtoV2 customerDto) {
        return CustomerDtoV2.builder()
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDtoV2 customerDto) {
        //todo
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting a customer");
    }
}
