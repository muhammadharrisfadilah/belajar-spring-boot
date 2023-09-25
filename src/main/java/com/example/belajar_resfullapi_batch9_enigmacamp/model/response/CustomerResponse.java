package com.example.belajar_resfullapi_batch9_enigmacamp.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerResponse {

    private String Cid;
    private String Cname;
}
