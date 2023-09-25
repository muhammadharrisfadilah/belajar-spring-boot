package com.example.belajar_resfullapi_batch9_enigmacamp.service.impl;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Customer;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Order;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.OrderDetail;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.ProductPrice;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.OrderRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.*;
import com.example.belajar_resfullapi_batch9_enigmacamp.repository.OrderDetailRepository;
import com.example.belajar_resfullapi_batch9_enigmacamp.repository.OrderRepository;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.CustomerService;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.OrderService;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductPriceService productPriceService;
//    @Override
//    public OrderResponse createNewTransaction(OrderRequest orderRequest) {
//        //todo 1 : validate customer
//        //todo 2 : validate product price
//        //todo 3 : craete new order
//        //todo 4 : change the stock fro the purchase quantity
//        return null;
//    }

    @Override
    public OrderResponse getOrderById(String id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAllTransaction() {
        return null;
    }


    @Override
    public OrderResponse createNewTransaction(OrderRequest orderRequest) {
        // TODO 1 : Validate customer
        Customer customer = customerService.getById(orderRequest.getCustomerId());
        // TODO 2 : Convert orderDetailRequest to orderDetail
        List<OrderDetail> orderDetails = orderRequest.getOrderDetail().stream().map(orderDetailRequest -> {
            //TODO 3 : Validate Product Price
            ProductPrice productPrice = productPriceService.getById(orderDetailRequest.getProductPriceId());
            return OrderDetail.builder()
                    .productPrice(productPrice)
                    .quantity(orderDetailRequest.getQuantity())
                    .build();
        }).collect(Collectors.toList());
        // TODO 4 : Crete New Order
        Order order = Order.builder()
                .customer(customer)
                .transDate(LocalDateTime.now())
                .orderDetails(orderDetails)
                .build();
        orderRepository.saveAndFlush(order);

        List<OrderDetailResponse> orderDetailResponses = order.getOrderDetails().stream().map(orderDetail -> {
            //TODO 5 : Set order fro orderDetail after creating new order
            orderDetail.setOrder(order);
            // TODO 6 : Change the stock from the purchase quantity
            ProductPrice currentProductPrice = orderDetail.getProductPrice();
            currentProductPrice.setStock(currentProductPrice.getStock() - orderDetail.getQuantity());
            orderDetailRepository.save(orderDetail);
            return OrderDetailResponse.builder()
                    .orderDetailId(orderDetail.getId())
                    .quantity(orderDetail.getQuantity())
                    //TODO 7 : Convert product to productResponse(from productPrice)
                    .product(ProductResponse.builder()
                            .productId(currentProductPrice.getProduct().getId())
                            .productName(currentProductPrice.getProduct().getName())
                            .description(currentProductPrice.getProduct().getDescription())
                            .price(currentProductPrice.getPrice())
                            .stock(currentProductPrice.getStock())
                            //TODO 8 : Convert store to storeResponse (from productPrice)
                            .store(StoreResponse.builder()
                                    .id(currentProductPrice.getStore().getId())
                                    .name(currentProductPrice.getStore().getName())
                                    .address(currentProductPrice.getStore().getAddress())
                                    .build())
                            .build())
                    .build();
        }).collect(Collectors.toList());

        //TODO 9 : Convert customer to customerResponse\
        CustomerResponse customerResponse = CustomerResponse.builder()
                .Cid(customer.getId())
                .Cname(customer.getName())
                .build();

        return OrderResponse.builder()
                .orderId(order.getId())
                .customerResponse(customerResponse)
                .transDate(order.getTransDate())
                .orderDetail(orderDetailResponses)
                .build();
    }


}
