package com.example.demo.common.service;


import com.example.demo.common.dto.ProductReq;
import com.example.demo.common.dto.ProductRes;

import com.example.demo.common.entity.ProductEntity;
import com.example.demo.common.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductReq productReq){

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductCode(productReq.getProductCode());
        productEntity.setProductName(productReq.getProductName());
        productEntity.setPrice(productReq.getPrice());
        productEntity.setStock(productReq.getStock());
        productEntity.setStatus(productReq.getStatus());

        productRepository.save(productEntity);

    }

    public List<ProductRes> fineAllProduct(){


        List<ProductRes> productRes = new ArrayList<>();
        List<ProductEntity> productResList = (List<ProductEntity>) productRepository.findAll();
        for (int i = 0; i < productResList.size(); i++){
            ProductRes productRes1 = new ProductRes();
            productRes1.setId(productResList.get(i).getId());
            productRes1.setProductCode(productResList.get(i).getProductCode());
            productRes1.setProductName(productResList.get(i).getProductName());
            productRes1.setPrice(productResList.get(i).getPrice());
            productRes1.setStock(productResList.get(i).getStock());
            productRes1.setStatus(productResList.get(i).getStatus());

            productRes.add(productRes1);

        }
        return productRes;
    }

    public ProductRes fineProductById(Long id){

        ProductEntity productEntity = productRepository.findById(id).get();
        ProductRes productRes = new ProductRes();
        productRes.setId(productEntity.getId());
        productRes.setProductCode(productEntity.getProductCode());
        productRes.setProductName(productEntity.getProductName());
        productRes.setPrice(productEntity.getPrice());
        productRes.setStock(productEntity.getStock());
        productRes.setStatus(productEntity.getStatus());
        return productRes;
    }

    public void updateProduct(ProductReq productReq){
        ProductEntity productEntity = productRepository.findById(productReq.getId()).get();
        productEntity.setProductCode(productReq.getProductCode());
        productEntity.setProductName(productReq.getProductName());
        productEntity.setPrice(productReq.getPrice());
        productEntity.setStock(productReq.getStock());
        productEntity.setStatus(productReq.getStatus());
        productRepository.save(productEntity);
    }




}
