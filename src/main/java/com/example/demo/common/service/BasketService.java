package com.example.demo.common.service;


import com.example.demo.common.dto.BasketReq;
import com.example.demo.common.dto.BasketRes;
import com.example.demo.common.entity.BasketEntity;
import com.example.demo.common.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void saveBasket(BasketReq basketReq) {

        BasketEntity basketEntity = new BasketEntity();

        basketEntity.setId(basketReq.getId());
        basketEntity.setItemId(basketReq.getItemId());
        basketEntity.setCustomerName(basketReq.getCustomerName());
        basketEntity.setQtyStock(basketReq.getQtyStock());
        basketRepository.save(basketEntity);
    }

    public List<BasketRes> fineAllBasket() {

        List<BasketRes> basketRes = new ArrayList<>();
        List<BasketEntity> basketResList = (List<BasketEntity>) basketRepository.findAll();
        for (int i = 0; i < basketResList.size(); i++) {
            BasketRes basketRes1 = new BasketRes();
            basketRes1.setId(basketResList.get(i).getId());
            basketRes1.setItemId(basketResList.get(i).getItemId());
            basketRes1.setCustomerName(basketResList.get(i).getCustomerName());
            basketRes1.setQtyStock(basketResList.get(i).getQtyStock());


            basketRes.add(basketRes1);

        }
        return basketRes;
    }
}