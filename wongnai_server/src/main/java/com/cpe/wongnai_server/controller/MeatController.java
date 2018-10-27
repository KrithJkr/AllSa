package com.cpe.wongnai_server.controller;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.MeatRepository;
import com.cpe.wongnai_server.entity.Meat;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class MainController {
    private MeatRepository repository;

    public MainController(MeatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/Meat")
    public List<Meat> meats() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
}
