package com.springframework.customers.web.controller.v2;

import com.springframework.customers.web.model.v2.CustomerDtoV2;
import com.springframework.customers.services.v2.CustomerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/customer")
@RestController
public class CustomerControllerV2 {

    private final CustomerServiceV2 customerServiceV2;

    public CustomerControllerV2(CustomerServiceV2 customerServiceV2) {
        this.customerServiceV2 = customerServiceV2;
    }

    @GetMapping({"customerId"})
    public ResponseEntity<CustomerDtoV2> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>((CustomerDtoV2) customerServiceV2.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(CustomerDtoV2 customerDto){
        CustomerDtoV2 savedDto = customerServiceV2.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        // todo: add hostname to url
        httpHeaders.add("Location", "/api/vi/customer" + savedDto.getUuid().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, CustomerDtoV2 customerDto) {
        customerServiceV2.updateCustomer(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public void deleteCustomer(@PathVariable("/{customerId}") UUID customerId) {
        customerServiceV2.deleteCustomerById(customerId);
    }
}
