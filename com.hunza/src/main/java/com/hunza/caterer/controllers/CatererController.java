package com.hunza.caterer.controllers;

import com.hunza.caterer.documents.Caterer;
import com.hunza.caterer.dto.CatererCreateDTO;
import com.hunza.caterer.services.CatererService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
@Validated
public class CatererController {

    @Autowired
    private CatererService catererService;

    private Logger logger = Logger.getLogger(CatererController.class.toGenericString());

    @GetMapping(value = "/caterers")
    public ResponseEntity<Caterer> getCatererByIdOrName(@RequestParam(value = "id",required = false) String id,@RequestParam(value = "name",required = false) String name){
        logger.log(Level.INFO,"Executing method getCatererByIdOrName");
        return new ResponseEntity<>(catererService.getCatererByIdOrName(id,name), HttpStatus.OK);
    }

    @GetMapping(value = "/caterers/{city}")
    public ResponseEntity<List<Caterer>> getCaterersByCity(@PathVariable(value = "city") @NotBlank @NotNull String city, @RequestParam(value = "page") @NotNull int page, @RequestParam(value = "size") @NotNull int size){
        logger.log(Level.INFO,"Executing method getCaterersByCity");
        return new ResponseEntity<>(catererService.getCatererByCity(city,page,size).getContent(), HttpStatus.OK);
    }

    @PostMapping(value = "/caterers")
    public ResponseEntity<Caterer> createCaterer(@RequestBody @Valid CatererCreateDTO catererCreateDTO){
        logger.log(Level.INFO,"Executing method createCaterer");
        return new ResponseEntity<>(catererService.createCaterer(catererCreateDTO),HttpStatus.CREATED);
    }

}
