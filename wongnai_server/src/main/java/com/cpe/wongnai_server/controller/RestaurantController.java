package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cpe.wongnai_server.Repository.*;
import com.cpe.wongnai_server.Repository.RestaurantRepository;
import com.cpe.wongnai_server.entity.Restaurant;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class RestaurantController {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    ResCategoryRepository resCategoryRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MenuRepository menuRepository;
    @GetMapping("/restaurant")
    public List<Restaurant> showAllRestaurant() {
        return restaurantRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/restaurant/{rid}")
    public Restaurant ShowRestaurantInfo(@PathVariable Long rid) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(rid);
        return restaurant.get();
    }
    @PostMapping("/restaurant/create/{rname}/{catego}/{menus}/{owa}/{rtel}")
    public Restaurant createRestaurant(@PathVariable Long menus,
                                       @PathVariable Long owa,
                                       @PathVariable String rname,
                                       @PathVariable Long catego,
                                       @PathVariable String rtel,
                                       @RequestBody String packAddress)
    throws IOException,JsonParseException {
        final String decoded = URLDecoder.decode(packAddress, "UTF-8");
        packAddress = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(packAddress);
        JsonNode jsonTextad = actualObj.get("addressSelect");
        JsonNode jsonTexturl = actualObj.get("picurl");
        Restaurant restaurant = new Restaurant();
        restaurant.setRtel(rtel);
        restaurant.setRestaurantName(rname);
        restaurant.setMenus(menuRepository.getOne(menus));
        restaurant.setMemberowner(memberRepository.getOne(owa));
        restaurant.setCategories(resCategoryRepository.getOne(catego));
        restaurant.setAddress(jsonTextad.textValue());
        restaurant.setRestaurantImg(jsonTexturl.textValue());
            return restaurantRepository.save(restaurant);
    }
}
