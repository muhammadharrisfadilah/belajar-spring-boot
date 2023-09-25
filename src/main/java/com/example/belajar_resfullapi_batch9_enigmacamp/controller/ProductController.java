package com.example.belajar_resfullapi_batch9_enigmacamp.controller;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Product;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.ProductRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.CommonResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.PagingResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.ProductResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createNewProduct(@RequestBody Product product){
        return productService.create(product);
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") String id){
        return productService.getById(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(
            @RequestParam (name = "name", required = false) String name,
            @RequestParam (name = "maxPrice", required = false) Long maxPrice,
            @RequestParam (name = "page", required = false,defaultValue = "1")Integer page,
            @RequestParam (name = "size", required = false,defaultValue = "5")Integer size
    ) {
        Page<ProductResponse> productResponses = productService
                .getAllByNameOrPrice(name, maxPrice, page, size);
        PagingResponse pagingResponse = PagingResponse.builder()
                .currentPage(page)
                .totalPage(productResponses.getTotalPages())
                .size(size)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("succesfully get all customer")
                        .paging(pagingResponse)
                        .build());
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        return productService.update(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
    }

    @PostMapping(value = "all")
    public ResponseEntity<?> createProductAll(@RequestBody ProductRequest request){
         ProductResponse productResponse = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully Create New Project")
                        .data(productResponse)
                        .build());

    }


    }
