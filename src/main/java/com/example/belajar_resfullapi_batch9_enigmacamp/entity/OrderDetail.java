package com.example.belajar_resfullapi_batch9_enigmacamp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "t_order_detail")
public class OrderDetail {
    @Id
    @GenericGenerator(strategy = "org.hibernate.id.UUIDGenerator",name = "uuid-hibernate-generator")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    private String id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_price_id")
    private ProductPrice productPrice;
    private Integer quantity;
}
