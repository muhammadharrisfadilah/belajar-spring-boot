package com.example.belajar_resfullapi_batch9_enigmacamp.service.impl;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Customer;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.CustomerRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.CustomerResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.repository.CustomerRepository;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(String id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        Customer currentCustomer = getById(customer.getId());
        if (currentCustomer == null){
            return customerRepository.save(customer);
        }

        return null;
    }

    @Override
    public void deleteById(String id) {

        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer =Customer.builder()
                .id(request.getCId())
                .name(request.getCname())
                .build();
        customerRepository.saveAndFlush(customer);

        return CustomerResponse.builder()
                .Cid(customer.getId())
                .Cname(customer.getName())
                .build();
    }
}
