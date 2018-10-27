package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.CommentRepository;
import com.cpe.wongnai_server.Repository.MemberRepository;
import com.cpe.wongnai_server.Repository.RatingRepository;
import com.cpe.wongnai_server.Repository.RestaurantRepository;
import com.cpe.wongnai_server.entity.Comment;
import com.cpe.wongnai_server.entity.Rating;
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
class CommentController {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RatingRepository ratingRepository;


    @PostMapping("/comment/create/{rid}/{username}")
    public Comment createComment(@PathVariable Long rid,@PathVariable String username,
                                 @RequestBody String dataComment)throws JsonParseException,IOException {

        final String decoded = URLDecoder.decode(dataComment, "UTF-8");
        dataComment = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataComment);

        JsonNode jsonText = actualObj.get("textSelect");
        JsonNode jsonImg = actualObj.get("imgSelect");
        JsonNode jsonRating = actualObj.get("ratingSelect");

        long ratinglevel = jsonRating.asLong();

        Comment comment = new Comment();

        comment.setRestaurants(restaurantRepository.getOne(rid));
        comment.setMembers(memberRepository.findByUsername(username));
        comment.setText(jsonText.textValue());
        comment.setRating(ratingRepository.getOne(ratinglevel));
        comment.setImg(jsonImg.textValue());
        return commentRepository.save(comment);

    }


    @GetMapping("commentbyrid/{rid}")
    public List<Comment> showCommentByRid(@PathVariable Long rid) {
        return commentRepository.findByRestaurants_Rid(rid);
    }


    @GetMapping("/ratings")

    public List<Rating> showAllRating() {

        return ratingRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/comments")

    public List<Comment> showAllComment() {

        return commentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/restaurants/{rid}")
    public Restaurant ShowRestaurantInfo(@PathVariable Long rid) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(rid);
        return restaurant.get();
    }

    @DeleteMapping("/comment/delete/{cmid}")
    public void deleteComment(@PathVariable long cmid) {
        commentRepository.deleteById(cmid);
    }

    @GetMapping("restaurant/rating/{rid}")
    public List<Comment> RestaurantRating(@PathVariable Long rid){
        return commentRepository.findAllRating(rid);

    }

}

