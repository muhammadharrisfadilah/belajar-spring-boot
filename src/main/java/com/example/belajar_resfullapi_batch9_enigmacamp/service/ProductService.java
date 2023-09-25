package com.example.belajar_resfullapi_batch9_enigmacamp.service;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Product;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.ProductRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product getById(String id);
    List<Product> getAll();
    Product update(Product product);
    void deleteById(String id);
    ProductResponse createProduct(ProductRequest request);
    Page<ProductResponse> getAllByNameOrPrice(String name, Long maxPrice, Integer page,Integer size);
}
