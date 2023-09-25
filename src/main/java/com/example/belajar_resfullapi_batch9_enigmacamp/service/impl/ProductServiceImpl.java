package com.example.belajar_resfullapi_batch9_enigmacamp.service.impl;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Product;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.ProductPrice;
import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Store;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.request.ProductRequest;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.ProductResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.model.response.StoreResponse;
import com.example.belajar_resfullapi_batch9_enigmacamp.repository.ProductRepository;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.ProductPriceService;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.ProductService;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final StoreService storeService;
    private final ProductPriceService productPriceService;
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        Product currentProduct =getById(product.getId());
        if (currentProduct != null){
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);

    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ProductResponse createProduct(ProductRequest request){
        Store store = storeService.getById(request.getStore_id());

        Product product= Product.builder()
                .name(request.getProductName())
                .description(request.getDescription())
                .build();
        productRepository.saveAndFlush(product);

        ProductPrice productPrice = ProductPrice.builder()
                .price(request.getPrice())
                .stock(request.getStock())
                .store(store)
                .product(product)
                .isActive(true)
                .build();

        productPriceService.create(productPrice);
        return toProductResponse(store, product, productPrice);

    }

    private static ProductResponse toProductResponse(Store store, Product product, ProductPrice productPrice) {
        return ProductResponse.builder()
                .productId(product.getId())
                .productName(product.getName())
                .description(product.getDescription())
                .price(productPrice.getPrice())
                .stock(productPrice.getStock())
                .store(StoreResponse.builder()
                        .id(store.getId())
                        .name(store.getName())
                        .address(store.getAddress())
                        .build())
                .build();
    }

    @Override
    public Page<ProductResponse> getAllByNameOrPrice(String name, Long maxPrice, Integer page, Integer size) {
        Specification<Product> specification = (root, query, criteriaBuilder) -> {
            Join<Product, ProductPrice> productPrices = root.join("productPrices");
            List<Predicate> predicates = new ArrayList<>();
            if (name != null){
                predicates.add((Predicate) criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+ name.toLowerCase()+"%"));
            }
            if (maxPrice != null){
                predicates.add((Predicate) criteriaBuilder.lessThanOrEqualTo(productPrices.get("price"),maxPrice));
            }
            return query.where(predicates.toArray(new javax.persistence.criteria.Predicate[]{})).getRestriction();

        } ;

        Pageable pageable = PageRequest.of(page,size);
        Page<Product> products = productRepository.findAll(specification, pageable);
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products.getContent()){
            Optional<ProductPrice> productPrice = product.getProductPrices()
                    .stream()
                    .filter(ProductPrice::getIsActive).findFirst();
            if (productPrice.isEmpty()) continue;
            Store store = productPrice.get().getStore();
            productResponses.add(toProductResponse(store, product,productPrice.get()));
        }
        return new PageImpl<>(productResponses,pageable,products.getTotalElements());
    }


}
