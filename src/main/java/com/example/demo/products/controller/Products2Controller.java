package com.example.demo.products.controller;


import com.example.demo.products.dto.Products2Req;
import com.example.demo.products.service.Products2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products2")
public class Products2Controller {

    private final Products2Service products2Service;

    public Products2Controller(Products2Service products2Service){
        this.products2Service = products2Service;
    }

    @RequestMapping("/create")
    public ResponseEntity<Void> createProducts2(@RequestBody Products2Req products2Req){
        products2Service.createProducts2(products2Req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<Products2Req>> showProducts2(){
        List<Products2Req> products2ReqList = products2Service.fineAllProducts2();
        return ResponseEntity.ok(products2ReqList);
    }
}
