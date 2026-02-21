package com.example.demo.products.repository;

import com.example.demo.products.entity.CategoriesEntity;
import org.springframework.data.repository.CrudRepository;

public interface  CategoriesRepository extends CrudRepository<CategoriesEntity, Long> {
}
