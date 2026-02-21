package com.example.demo.common.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "basket",schema = "public")


public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "customer")
    private String customerName;

    @Column(name = "qty")
    private int qtyStock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQtyStock() {
        return qtyStock;
    }

    public void setQtyStock(int qtyStock) {
        this.qtyStock = qtyStock;
    }
}
