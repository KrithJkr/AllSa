package com.cpe.wongnai_server.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.cpe.wongnai_server.entity.Creditcard;
import com.cpe.wongnai_server.entity.Profile;
import com.cpe.wongnai_server.Repository.AddressRepository;
import com.cpe.wongnai_server.Repository.CreditcardRepository;
import com.cpe.wongnai_server.Repository.MemberRepository;
import com.cpe.wongnai_server.Repository.ProfileRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class MemberProfilesController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CreditcardRepository creditcardRepository;
    @Autowired
    private MemberRepository memberRepository;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @GetMapping("/profile")
    public List<Profile> showAllProfile() {
        return profileRepository.findAll().stream().collect(Collectors.toList());
    } 
    @PostMapping("/profile/create/{username}/{firstname}/{lastname}/{age}/{address}/{number}/{bank}")
    public Profile createProfile(@PathVariable String firstname,@PathVariable String lastname,@PathVariable Long age,@PathVariable Long address,
                                 @PathVariable String bank,@PathVariable Long number,@PathVariable Long username){
        
        Profile profile = new Profile();
        Creditcard creditcard = new Creditcard();
        creditcard.setBank(bank);
        creditcard.setNumber(number);
        creditcardRepository.save(creditcard);
        profile.setMember(memberRepository.getOne(username));
        profile.setFirstname(firstname);
        profile.setLastname(lastname);
        profile.setAge(age);
        profile.setAddress(addressRepository.getOne(address));
        profile.setCreditcard(creditcardRepository.findByNumber(number));
        return profileRepository.save(profile);
    }

    @GetMapping("/profile/{id}")
    public Optional<Profile> showProfileById(@PathVariable Long id) {
        return profileRepository.findById(id);
    } 
}


