package com.hunza.caterer.services;

import com.hunza.caterer.documents.Caterer;
import com.hunza.caterer.dto.CatererCreateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CatererService {
    Page<Caterer> getCatererByCity(String city,int pageNumber, int pageSize);
    Caterer getCatererByIdOrName(String id, String name);
    Caterer createCaterer(CatererCreateDTO catererCreateDTO);
}
