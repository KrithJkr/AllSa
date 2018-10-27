package com.cpe.wongnai_server.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.CategoriesRepository;
import com.cpe.wongnai_server.Repository.CookingRepository;
import com.cpe.wongnai_server.Repository.MeatRepository;
import com.cpe.wongnai_server.Repository.MemberRepository;
import com.cpe.wongnai_server.Repository.MenuRepository;
import com.cpe.wongnai_server.entity.Cooking;
import com.cpe.wongnai_server.entity.Member;
import com.cpe.wongnai_server.entity.Menu;
import org.springframework.boot.json.JsonParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
class MenuController {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    MeatRepository meatRepository;
    @Autowired
    CookingRepository cookingRepository;
    @Autowired
    MemberRepository memberRepository;


    @PostMapping("/menu/create/")
    public Menu createComment(
                              @RequestBody String MenuDatas)throws JsonParseException,IOException {


        final String decoded = URLDecoder.decode(MenuDatas, "UTF-8");
        MenuDatas = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(MenuDatas);


        JsonNode jsonMenuName = actualObj.get("MenuNameSelect");
        JsonNode jsonMeatId = actualObj.get("MeatIdSelect");
        JsonNode jsonCatId = actualObj.get("CatIdSelect");
        JsonNode jsonCooking = actualObj.get("CookingSelect");
        JsonNode jsonPicUrl = actualObj.get("PicUrlSelect");
        JsonNode jsonMemberId = actualObj.get("MemberIdSelect");


        Cooking cooking = new Cooking();
        cooking.setCookingName(jsonCooking.textValue());
        cookingRepository.save(cooking);


        Long catid = jsonCatId.asLong();
        Long meatId =jsonMeatId.asLong();
        Long memberId=jsonMemberId.asLong();
        String cookingName =jsonCooking.textValue();

        Menu menu = new Menu();
        menu.setMenuName(jsonMenuName.textValue());
        menu.setCookingId(cookingRepository.findByCookingName(cookingName));
        menu.setMeatId(meatRepository.getOne(meatId));
        menu.setCatId(categoriesRepository.getOne(catid));
        menu.setMemberId(memberRepository.getOne(memberId));
        menu.setPicUrl(jsonPicUrl.textValue());

        return menuRepository.save(menu);
    }







    @GetMapping("/Menus")
    public List<Menu> menus() {
        return menuRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/Menu/{menuId}")
    public Menu ShowMenu(@PathVariable Long menuId) {
        Optional<Menu> menu = menuRepository.findById(menuId);
        return menu.get();
    }
    @GetMapping("/Member/{memberId}")
    public Member ShowMember(@PathVariable Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.get();
    }

}
