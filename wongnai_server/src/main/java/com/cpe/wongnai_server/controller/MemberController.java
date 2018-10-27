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
    private MemberRepository memberrepository;
    @GetMapping("/members")
    public List<Member> members() {
        return memberrepository.findAll().stream() .collect(Collectors.toList());
    }

  @GetMapping("/member/{mid}")
  public Member getMemberById(@PathVariable Long mid) {
    Optional<Member> member = memberrepository.findById(mid);
    return member.get();
  }
  @PostMapping("/member/create/{username}/{password}/{email}/{memberOf}")
    public Member createMember(@PathVariable String username,@PathVariable String password,@PathVariable String email,@PathVariable String memberOf){
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        member.setMemberOf(memberOf);
        return memberrepository.save(member);
    }
    @GetMapping("/memberbyemail/{email}")
    public Member getMemberByUser(@PathVariable String email) {
      Optional<Member> member = memberrepository.findByEmail(email);
      return member.get();
    }
}
