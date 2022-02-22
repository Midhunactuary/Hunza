package com.hunza.caterer.repositories;

import com.hunza.caterer.documents.Caterer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CatererRepository extends MongoRepository<Caterer, UUID> {
    Page<Caterer> findByLocationCity(String city, Pageable pageable);
    Page<Caterer> findByName(String city, Pageable pageable);
    Caterer findByIdOrName(String id, String name);
}
