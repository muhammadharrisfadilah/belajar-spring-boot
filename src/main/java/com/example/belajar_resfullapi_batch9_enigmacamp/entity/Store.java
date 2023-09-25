package com.example.belajar_resfullapi_batch9_enigmacamp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "m_store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GenericGenerator(strategy = "org.hibernate.id.UUIDGenerator",name = "uuid-hibernate-generator")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    private String id;
    @Column(name = "no_siup", nullable = false, unique = true)
    private String noSiup;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "mobile_phone", nullable = false, unique = true)
    private String mobilePhone;
}
