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
@Table(name = "customer")
public class Customer {
    @Id
    @GenericGenerator(strategy = "org.hibernate.id.UUIDGenerator",name = "uuid-hibernate-generator")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "mobile_phone", nullable = false, unique = true)
    private Integer mobilePhone;
    @Column(name = "email", nullable = false,unique = true)
    private String email;
}
