package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.MemberRepository;
import com.cpe.wongnai_server.entity.Member;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class MemberController {

    @Autowired
    private MemberRepository repository;
    @GetMapping("/Member")
    public List<Member> members() {
        return repository.findAll().stream() .collect(Collectors.toList());
    }

  @GetMapping("/member/{mid}")
  public Member getMemberById(@PathVariable Long mid) {
    Optional<Member> member = repository.findById(mid);
    return member.get();
  }
}
