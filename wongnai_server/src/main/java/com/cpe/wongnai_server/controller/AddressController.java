package com.cpe.wongnai_server.controller;
import com.cpe.wongnai_server.entity.Address;
import com.cpe.wongnai_server.Repository.AddressRepository;
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
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/address")
    public List<Address> showAllAddress() {
        return addressRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @PostMapping("/address/create/{provincename}")
    public Address createCreditcard(@PathVariable String provincename){
        Address address = new Address();
        address.setProvincename(provincename);
        return addressRepository.save(address);
    }
    @GetMapping("/address/{id}")
    public Optional<Address> showAddressById(@PathVariable Long id) {
        return addressRepository.findById(id);
    }
}