package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.CommentRepository;
import com.cpe.wongnai_server.entity.Comment;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> showAllComment() {
        return commentRepository.findAll().stream().collect(Collectors.toList());
    }
}

