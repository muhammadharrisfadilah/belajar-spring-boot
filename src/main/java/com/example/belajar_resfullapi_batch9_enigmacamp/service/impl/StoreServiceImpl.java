package com.example.belajar_resfullapi_batch9_enigmacamp.service.impl;

import com.example.belajar_resfullapi_batch9_enigmacamp.entity.Store;
import com.example.belajar_resfullapi_batch9_enigmacamp.repository.StoreRepository;
import com.example.belajar_resfullapi_batch9_enigmacamp.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    public Store create(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getById(String id) {
        return storeRepository.findById(id).get();
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store update(Store store) {
        Store currentStore =getById(store.getId());
        if (currentStore != null){
            return storeRepository.save(store);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        storeRepository.deleteById(id);
    }
}
