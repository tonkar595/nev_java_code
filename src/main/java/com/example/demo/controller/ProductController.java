package com.example.demo.controller;


import com.example.demo.dto.ProductReq;
import com.example.demo.dto.ProductRes;
import com.example.demo.dto.UserReq;
import com.example.demo.dto.UserRes;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    private final ProductService productService;

    //eject
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody ProductReq productReq){
        productService.saveProduct(productReq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<ProductRes>> showAll(){
        List<ProductRes> productResList = productService.fineAllProduct();
        return ResponseEntity.ok(productResList);

    }

    @GetMapping("/show-by-id/{id}")
    public ResponseEntity<ProductRes> showById(@PathVariable long id){
        ProductRes productRes = productService.fineProductById(id);
        return ResponseEntity.ok(productRes);

    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody ProductReq productReq){
        productService.updateProduct(productReq);
        return ResponseEntity.ok().build();
    }


}
