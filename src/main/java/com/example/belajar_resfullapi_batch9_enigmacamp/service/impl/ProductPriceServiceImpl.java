package com.example.belajar_resfullapi_batch9_enigmacamp.service.impl;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.ProductPrice;
import com.example.belajar_resfullapi_batch9_enigmacamp.repository.ProductPriceRepository;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService  {
    private final ProductPriceRepository productPriceRepository;
    @Override
    public ProductPrice create(ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice getById(String id) {
        return productPriceRepository.findById(id).get();
    }

    @Override
    public ProductPrice findProductPriceActive(String productId, boolean active) {
        return productPriceRepository.findByProduct_IdAndIsActive(productId,active).orElseThrow(()-> new
                ResponseStatusException(HttpStatus.NOT_FOUND,"product not found"));
    }
}
