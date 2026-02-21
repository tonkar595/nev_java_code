package com.example.demo.products.service;

import com.example.demo.common.entity.StudentEntity;
import com.example.demo.products.dto.Products2Req;
import com.example.demo.products.entity.CategoriesEntity;
import com.example.demo.products.entity.Products2Entity;
import com.example.demo.products.repository.CategoriesRepository;
import com.example.demo.products.repository.Products2Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Products2Service {


    private final Products2Repository products2Repository;

    private  final CategoriesRepository categoriesRepository;

    public Products2Service(Products2Repository products2Repository, CategoriesRepository categoriesRepository) {
        this.products2Repository = products2Repository;
        this.categoriesRepository = categoriesRepository;
    }

    public void createProducts2(Products2Req products2Req){
        Products2Entity products2Entity = new Products2Entity();
        products2Entity.setCategoryId(products2Req.getCategoryId());
        products2Entity.setName(products2Req.getName());
        products2Entity.setDescription(products2Req.getDescription());
        products2Entity.setPrice(products2Req.getPrice());
        products2Entity.setStock(products2Req.getStock());
        products2Repository.save(products2Entity);
    }

    public List<Products2Req> fineAllProducts2() {


        List<Products2Req> products2Req = new ArrayList<>();
        List<Products2Entity> products2ReqList = (List<Products2Entity>) products2Repository.findAll();
        CategoriesEntity c = categoriesRepository.findById(id).get();
        for (int i = 0; i < products2ReqList.size(); i++) {
            Products2Req products2Req1 = new Products2Req();
            products2Req1.setId(products2ReqList.get(i).getId());
            products2Req1.setName(products2ReqList.get(i).getName());
            products2Req1.setDescription(products2ReqList.get(i).getDescription());
            products2Req1.setPrice(products2ReqList.get(i).getPrice());
            products2Req1.setStock(products2ReqList.get(i).getStock());
            products2Req.add(products2Req1);

        }
        return products2Req;
    }

}
