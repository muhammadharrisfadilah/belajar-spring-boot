package com.example.belajar_resfullapi_batch9_enigmacamp.repository;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
