package com.example.belajar_resfullapi_batch9_enigmacamp.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StoreResponse {
    private String id;
    private String name;
    private String address;
}
