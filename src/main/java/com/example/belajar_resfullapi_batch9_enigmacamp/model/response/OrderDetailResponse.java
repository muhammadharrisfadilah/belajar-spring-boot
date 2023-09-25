package com.example.belajar_resfullapi_batch9_enigmacamp.model.response;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Customer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDetailResponse {
    private String orderDetailId;
    private ProductResponse product;
    private Integer quantity;

}
