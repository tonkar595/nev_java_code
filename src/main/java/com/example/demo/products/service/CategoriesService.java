package com.example.demo.products.service;



import com.example.demo.products.dto.CategoryReq;
import com.example.demo.products.entity.CategoriesEntity;
import com.example.demo.products.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

//    ล้อกค่าเอาไว้
    private final CategoriesRepository categoriesRepository;

    //
    public CategoriesService(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    public void createCategories(CategoryReq categoryReq){
        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setName(categoryReq.getName());
        categoriesEntity.setDescription(categoryReq.getDescription());
        categoriesRepository.save(categoriesEntity);
    }

    public List<CategoryReq> fineAllCategories() {

        List<CategoryReq> categoryReq = new ArrayList<>();
        List<CategoriesEntity> categoryReqList = (List<CategoriesEntity>) categoriesRepository.findAll();
        for (int i = 0; i < categoryReqList.size(); i++) {
            CategoryReq categoryReq1 = new CategoryReq();
            categoryReq1.setId(categoryReqList.get(i).getId());
            categoryReq1.setName(categoryReqList.get(i).getName());
            categoryReq1.setDescription(categoryReqList.get(i).getDescription());
            categoryReq.add(categoryReq1);

        }
        return categoryReq;
    }
}
