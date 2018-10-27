package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.CategoriesRepository;
import com.cpe.wongnai_server.entity.Categories;
import java.util.Collection;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class CatagoriesController {
  @Autowired
  private CategoriesRepository repository;



    @GetMapping("/Categories")
    public Collection<Categories> Categories() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}

