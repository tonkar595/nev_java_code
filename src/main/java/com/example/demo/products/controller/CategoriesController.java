package com.example.demo.products.controller;


import com.example.demo.common.dto.BasketRes;
import com.example.demo.products.dto.CategoryReq;
import com.example.demo.products.entity.CategoriesEntity;
import com.example.demo.products.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoriesController {
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryReq categoryReq){
        categoriesService.createCategories(categoryReq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<CategoryReq>> showCategory(){
        List<CategoryReq> categoryReqList = categoriesService.fineAllCategories();
        return ResponseEntity.ok(categoryReqList);
    }



}
