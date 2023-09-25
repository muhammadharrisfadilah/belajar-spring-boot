package com.example.belajar_resfullapi_batch9_enigmacamp.controller;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Customer;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.CustomerRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.CommonResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.CustomerResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public Customer createNewCustomer(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerService.getById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){return customerService.getAll();}

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){return customerService.update(customer);}

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){customerService.deleteById(id);}

    @PostMapping("/all")
    public ResponseEntity<?> createCustomerAll(@RequestBody CustomerRequest request){
        CustomerResponse customerResponse = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<CustomerResponse>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Successfully Create New Project")
                .data(customerResponse)
                .build());
    }
}
