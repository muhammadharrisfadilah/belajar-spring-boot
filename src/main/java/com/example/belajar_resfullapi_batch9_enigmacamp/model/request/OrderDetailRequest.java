package com.example.belajar_resfullapi_batch9_enigmacamp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDetailRequest {
    private String productPriceId;
    private Integer quantity;

}
