package com.example.belajar_resfullapi_batch9_enigmacamp.service;

import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.OrderRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createNewTransaction(OrderRequest orderRequest);
    OrderResponse getOrderById(String id);
    List<OrderResponse> getAllTransaction();
}
