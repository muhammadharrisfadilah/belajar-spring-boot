package com.example.belajar_resfullapi_batch9_enigmacamp.model.request;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class ProductRequest {
    private String productId;

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Price is required")
    @Min(value = 0,message = "Product price must be greater than equal 0")
    private Long price;

    @Min(value = 0,message = "Stock must be greater than equal 0")
    @NotBlank(message = "Stock is required")
    private Integer stock ;

    @NotBlank(message = "store ID is required")
    private String store_id ;

}
