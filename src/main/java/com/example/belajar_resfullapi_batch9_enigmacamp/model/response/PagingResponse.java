package com.example.belajar_resfullapi_batch9_enigmacamp.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PagingResponse {
    private Integer currentPage;
    private Integer totalPage;
    private Integer size;
}
