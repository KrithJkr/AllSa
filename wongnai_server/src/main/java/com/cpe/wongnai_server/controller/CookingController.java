package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.CookingRepository;
import com.cpe.wongnai_server.entity.Cooking;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class CookingController {
  @Autowired
    CookingRepository repository;
 


    @GetMapping("/Cooking")
    public List<Cooking> cookings() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
}
