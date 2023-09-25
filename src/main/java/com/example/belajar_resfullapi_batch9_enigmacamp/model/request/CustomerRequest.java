package com.example.belajar_resfullapi_batch9_enigmacamp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerRequest {
    private String cId;
    @NotBlank(message = "Customer name is required")
    private String Cname;
}
