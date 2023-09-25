package com.example.belajar_resfullapi_batch9_enigmacamp.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "m_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Product {
    @Id
    @GenericGenerator(strategy = "org.hibernate.id.UUIDGenerator",name = "uuid-hibernate-generator")
    @GeneratedValue(generator = "uuid-hibernate-generator")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<ProductPrice> productPrices;
}
