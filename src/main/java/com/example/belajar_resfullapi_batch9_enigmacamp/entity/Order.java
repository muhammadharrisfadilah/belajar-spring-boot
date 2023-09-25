package com.example.belajar_resfullapi_batch9_enigmacamp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "t_order")
public class Order {
    @Id
    @GenericGenerator(strategy = "org.hibernate.id.UUIDGenerator",name = "uuid-hibernate-generator")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    private String id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime transDate;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    private List<OrderDetail> orderDetails;

}
