package com.example.belajar_resfullapi_batch9_enigmacamp.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse <T>{
    private Integer statusCode;
    private String message;
    private T data;
    private PagingResponse paging;

}
