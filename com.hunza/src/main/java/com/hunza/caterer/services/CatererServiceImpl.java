package com.hunza.caterer.services;

import com.mongodb.MongoException;
import com.hunza.caterer.documents.Caterer;
import com.hunza.caterer.dto.CatererCreateDTO;
import com.hunza.caterer.repositories.CatererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CatererServiceImpl implements CatererService {

    @Autowired
    private CatererRepository catererRepository;

    @Autowired
    private RabbitMQService rabbitMQService;

    @Override
    public Caterer getCatererByIdOrName(String id, String name) {
        Caterer caterer = catererRepository.findByIdOrName(id,name);
        if (caterer!=null)
            return caterer;
        else
            throw new MongoException("Record not Found");
    }

    @Override
    public Page<Caterer> getCatererByCity(String city,int pageNumber, int pageSize) {
        Page<Caterer> catererPage = catererRepository.findByLocationCity(city,PageRequest.of(pageNumber,pageSize));
        if (!catererPage.isEmpty())
            return catererPage;
        else
            throw new MongoException("Record not Found");
    }


    @Override
    public Caterer createCaterer(CatererCreateDTO catererCreateDTO) {
        Caterer caterer = catererRepository.save(Caterer.mapDTOtoEntity(catererCreateDTO));
        rabbitMQService.send("Successfully created a caterer");
        return caterer;
    }
}
