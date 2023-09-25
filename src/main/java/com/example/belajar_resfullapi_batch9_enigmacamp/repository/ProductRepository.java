package com.example.belajar_resfullapi_batch9_enigmacamp.repository;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> , JpaSpecificationExecutor<Product> {
}
