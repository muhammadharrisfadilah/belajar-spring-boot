package com.example.belajar_resfullapi_batch9_enigmacamp.repository;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {

    Optional<ProductPrice> findByProduct_IdAndIsActive(String productId, Boolean active);
}
