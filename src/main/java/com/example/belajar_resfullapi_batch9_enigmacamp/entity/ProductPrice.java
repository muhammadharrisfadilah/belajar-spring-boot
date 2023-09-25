package com.example.belajar_resfullapi_batch9_enigmacamp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "m_product_price")
@Builder(toBuilder = true)
public class ProductPrice {
    @Id
    @GenericGenerator(strategy = "org.hibernate.id.UUIDGenerator",name = "uuid-hibernate-generator")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    private String id;
    @Column(columnDefinition = "int check (stock > 0)")
    private Integer stock;
    @Column
    private Boolean isActive;
    @Column(columnDefinition = "bigint check (price > 0)")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

}
