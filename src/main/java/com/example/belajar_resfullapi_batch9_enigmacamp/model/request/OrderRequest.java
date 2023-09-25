package com.example.belajar_resfullapi_batch9_enigmacamp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderRequest {
    private String customerId;
    private List<OrderDetailRequest> orderDetail;
}
