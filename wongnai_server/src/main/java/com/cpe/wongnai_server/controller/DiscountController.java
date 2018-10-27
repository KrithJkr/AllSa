package com.cpe.wongnai_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpe.wongnai_server.Repository.*;
import com.cpe.wongnai_server.entity.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class DiscountController {
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private CouponRepository couponRepository;

    @GetMapping("/Coupon")
    public List<Coupon> showAllCoupon() {
        return couponRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Discount")
    public List<Discount> showAllDiscount(){
        return discountRepository.findAll().stream().collect(Collectors.toList());
    }
}