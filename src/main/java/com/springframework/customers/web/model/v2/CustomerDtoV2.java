package com.springframework.customers.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDtoV2 {

    private UUID uuid;
    private String customerName;
    private CustomerStyleEnum customerStyle;
    private Long upc;


}
