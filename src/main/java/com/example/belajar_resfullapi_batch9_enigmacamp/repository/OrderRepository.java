package com.example.belajar_resfullapi_batch9_enigmacamp.repository;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> , JpaSpecificationExecutor<Order> {

}
