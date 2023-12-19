package com.example.layeredarchitecture.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomDTO {
    private String id;
    private String name;
    private String oid;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;
    private String date;

    public CustomDTO(String id, String name, String oid, String itemCode, int qty, BigDecimal unitPrice, String date) {
        this.id = id;
        this.name = name;
        this.oid = oid;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.date = date;
    }

    public CustomDTO(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return oid;
    }

    public void setOrderId(String oid) {
        this.oid = oid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getOrderDate() {
        return date;
    }

    public void setOrderDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", orderId='" + oid + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", orderDate=" + date +
                '}';
    }
}
