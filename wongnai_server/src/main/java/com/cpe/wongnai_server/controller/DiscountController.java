package com.cpe.wongnai_server.controller;
import org.springframework.web.bind.annotation.*;
import com.cpe.wongnai_server.Repository.*;
import com.cpe.wongnai_server.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.stream.Collectors;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
class DiscountController{
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private PeriodRepository periodRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private DisCategoryRepository discategoryRepository;
    
    @GetMapping("/Discount")
    public List<Discount> showAllDiscount(){
        return discountRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Discountbyid/{id}")
    public Discount ShowDiscountdetail(@PathVariable Long id) {
        Optional<Discount> discount = discountRepository.findById(id);
        return discount.get();
    }

    @GetMapping("/Timebyid/{Pid}")
    public Period ShowTime(@PathVariable Long Pid) {
        Optional<Period> period = periodRepository.findById(Pid);
        return period.get();
    }

    @PostMapping("/discount(coupon)/create/{Name}/{Title}/{Tid}/{Sdate}/{Edate}/{Duration}/{code}")
    public Discount createDiscount(@PathVariable String Name,@PathVariable String Title,@PathVariable long Tid,
                                    @PathVariable Date Sdate,@PathVariable Date Edate,@PathVariable String Duration
                                    ,@PathVariable String code){

       
        Period period = new Period();
        period.setEdate(Edate);
        period.setSdate(Sdate);
        period.setDuration(Duration);
        periodRepository.save(period);

        Discount discount = new Discount();
        discount.setName(Name);
        discount.setTitle(Title);
        discount.setDiscountCategory(discategoryRepository.getOne(Tid));
        discount.setDiscountCoupon(couponRepository.findByCode(code));
        discount.setDiscountPeriod(periodRepository.findBySdate(Sdate));
        return discountRepository.save(discount);
        

    }
    @PostMapping("/discount/create/{Name}/{Title}/{Tid}/{Sdate}/{Edate}/{Duration}")
    public Discount createDiscount(@PathVariable String Name,@PathVariable String Title,@PathVariable long Tid,
                                    @PathVariable Date Sdate,@PathVariable Date Edate,@PathVariable String Duration){

       
        Period period = new Period();
        period.setEdate(Edate);
        period.setSdate(Sdate);
        period.setDuration(Duration);
        periodRepository.save(period);

        Discount discount = new Discount();
        discount.setName(Name);
        discount.setTitle(Title);
        discount.setDiscountCategory(discategoryRepository.getOne(Tid));
        discount.setDiscountPeriod(periodRepository.findBySdate(Sdate));
        return discountRepository.save(discount);

    }
    
}