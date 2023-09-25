package com.example.belajar_resfullapi_batch9_enigmacamp.service;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Customer;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Product;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.CustomerRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.ProductRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.CustomerResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.ProductResponse;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Customer getById(String id);
    List<Customer> getAll();
    Customer update(Customer customer);
    void deleteById(String id);
    CustomerResponse createCustomer(CustomerRequest request);
}
