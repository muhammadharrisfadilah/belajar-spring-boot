package com.example.belajar_resfullapi_batch9_enigmacamp.controller;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Store;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public Store createNewStore(@RequestBody Store store){
        return storeService.create(store);
    }
    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable("id") String id){
        return storeService.getById(id);
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAll();
    }

    @PutMapping("/{id}")
    public Store updateStore(@RequestBody Store updatedStore) {
        return storeService.update(updatedStore);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable String id) {
        storeService.deleteById(id);
    }
}
