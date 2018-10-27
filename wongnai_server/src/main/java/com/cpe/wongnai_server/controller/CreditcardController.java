package com.cpe.wongnai_server.controller;
import com.cpe.wongnai_server.entity.Creditcard;
import com.cpe.wongnai_server.Repository.CreditcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CreditcardController {
    @Autowired
    private CreditcardRepository creditcardRepository;

    @GetMapping("/creditcard")
    public List<Creditcard> showAllCreditcard() {
        return creditcardRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/creditcard/create/{number}/{bank}")
    public Creditcard createCreditcard(@PathVariable Long number,@PathVariable String bank){
        Creditcard creditcard = new Creditcard();
        creditcard.setNumber(number);
        creditcard.setBank(bank);
        return creditcardRepository.save(creditcard);
    }
    @GetMapping("/creditcardbyid/{id}")
    public Optional<Creditcard> showCreditcardById(@PathVariable Long id) {
        return creditcardRepository.findById(id);
    }
}