package com.example.demo.products.dto;

import java.math.BigDecimal;

public class SellProductsReq {

    private Long productId;

    private String productName;

    private BigDecimal buyPrice;

    private Integer reqStock;

    private BigDecimal price;

    private Integer stock;

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getReqStock() {
        return reqStock;
    }

    public void setReqStock(Integer reqStock) {
        this.reqStock = reqStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
