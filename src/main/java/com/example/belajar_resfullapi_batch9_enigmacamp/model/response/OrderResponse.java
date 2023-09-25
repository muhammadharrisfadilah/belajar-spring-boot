package com.example.belajar_resfullapi_batch9_enigmacamp.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderResponse {
    private String orderId;
    private LocalDateTime transDate;
    private CustomerResponse customerResponse;
    private List<OrderDetailResponse> orderDetail;
}
