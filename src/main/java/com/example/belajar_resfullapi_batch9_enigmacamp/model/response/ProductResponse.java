package com.example.belajar_resfullapi_batch9_enigmacamp.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {
    private String productId;
    private String productName;
    private String description;
    private Long price;
    private Integer stock;
    private StoreResponse store;
}
