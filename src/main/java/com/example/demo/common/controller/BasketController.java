package com.example.demo.common.controller;


import com.example.demo.common.dto.BasketReq;
import com.example.demo.common.dto.BasketRes;
import com.example.demo.common.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baskets/")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService){
        this.basketService = basketService;

    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody BasketReq basketReq){
        basketService.saveBasket(basketReq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<BasketRes>> showAll(){
        List<BasketRes> basketResList = basketService.fineAllBasket();
        return ResponseEntity.ok(basketResList);

    }




}
