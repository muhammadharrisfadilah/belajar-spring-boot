package com.example.belajar_resfullapi_batch9_enigmacamp.controller;

import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.OrderRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.CommonResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.OrderResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.createNewTransaction(orderRequest);

        if (orderResponse != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CommonResponse.<OrderResponse>builder()
                    .statusCode(HttpStatus.CREATED.value())
                    .message("Successfully Create New Transaction")
                    .data(orderResponse)
                    .build().getData());
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
