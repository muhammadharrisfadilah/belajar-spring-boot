package com.example.belajar_resfullapi_batch9_enigmacamp.service;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Product;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.ProductPrice;

public interface ProductPriceService {
    ProductPrice create(ProductPrice productPrice);
    ProductPrice getById(String id);

    ProductPrice findProductPriceActive(String product, boolean active);

}
