package com.cpe.wongnai_server.controller;


import com.cpe.wongnai_server.Repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cpe.wongnai_server.entity.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;
import org.springframework.boot.json.JsonParseException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InfoMenuController {
    @Autowired
    private InfoMenuRepository InfoMenurepository;
    @Autowired
    private IngredientRepository Ingredientrepository;
    @Autowired
    private StoryRepository Storyrepository;
    @Autowired
    private NutritionRepository Nutritionrepository;
    @Autowired
    private MenuRepository menuRepository;

    @PostMapping("/menu/create/{stext}/{text}/{protein}/{carbohydrate}/{vitamin}/{fruit}/{fat}/{mid}")
    public InfoMenu createMenu(@PathVariable String stext,@PathVariable String text,
    @PathVariable String protein,@PathVariable String carbohydrate,
    @PathVariable String vitamin,@PathVariable String fruit,
    @PathVariable String fat,@PathVariable Long mid,@RequestBody String dataMenu
    )throws JsonParseException,IOException
        {
            final String decoded = URLDecoder.decode(dataMenu, "UTF-8");
        dataMenu = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataMenu);
        JsonNode jsoncal = actualObj.get("cal");
        //JsonNode jsonMid = actualObj.get("menuId");

        //long mid =jsonMid.asLong();
        Nutrition nutrition = new Nutrition();
            nutrition.setProtein(protein);
            nutrition.setCarbohydrate(carbohydrate);
            nutrition.setVitamin(vitamin);
            nutrition.setFruit(fruit);
            nutrition.setFat(fat);
            Nutritionrepository.save(nutrition);

        Story story = new Story();
            story.setStext(stext);
            Storyrepository.save(story);

        InfoMenu infomenu = new InfoMenu();
            infomenu.setCal(jsoncal.asDouble());

            infomenu.setStext(Storyrepository.findByStext(stext));
            infomenu.setText(Ingredientrepository.findByText(text));
            infomenu.setNutrition(Nutritionrepository.findByProtein(protein));
            infomenu.setNutrition(Nutritionrepository.findByCarbohydrate(carbohydrate));
            infomenu.setNutrition(Nutritionrepository.findByVitamin(vitamin));
            infomenu.setNutrition(Nutritionrepository.findByFruit(fruit));
            infomenu.setNutrition(Nutritionrepository.findByFat(fat));
            infomenu.setMenus(menuRepository.getOne(mid));
            return InfoMenurepository.save(infomenu);
    }

    @GetMapping("/InfoMenu")
    public List<InfoMenu> showAllMenu() {
        return InfoMenurepository.findAll().stream().collect(Collectors.toList());
        }

   @GetMapping("/InfoMenu/{Mid}")
    public InfoMenu ShowMenu(@PathVariable Long Mid) {
        Optional<InfoMenu> InfoMenu = InfoMenurepository.findById(Mid);
        return InfoMenu.get();
    }
    @GetMapping("/story")
    public List<Story> showAllStory() {
        return Storyrepository.findAll().stream().collect(Collectors.toList());
        }

    @GetMapping("/story/{Sid}")
        public Story ShowStoryId(@PathVariable Long Sid) {
            Optional<Story> story = Storyrepository.findById(Sid);
            return story.get();
        }
    @GetMapping("/ingredient")
    public List<Ingredient> ShowIngredient() {
            return Ingredientrepository.findAll().stream().collect(Collectors.toList());
        }
    @GetMapping("/nutrition")
        public List<Nutrition> showNutrition() {
                return Nutritionrepository.findAll().stream().collect(Collectors.toList());
            }
    }
