package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.RestaurantRepository;
import com.cpe.wongnai_server.entity.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class RestaurantController {
    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping("/restaurant")
    public List<Restaurant> showAllRestaurant() {
        return restaurantRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/restaurant/{rid}")
    public Restaurant ShowRestaurantInfo(@PathVariable Long rid) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(rid);
        return restaurant.get();
    }
}