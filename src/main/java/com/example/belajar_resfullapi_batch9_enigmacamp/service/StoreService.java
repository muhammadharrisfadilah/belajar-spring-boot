package com.example.belajar_resfullapi_batch9_enigmacamp.service;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Store;

import java.util.List;

public interface StoreService {
    Store create(Store store);
    Store getById(String id);
    List<Store> getAll();
    Store update(Store store);
    void deleteById(String id);
}
