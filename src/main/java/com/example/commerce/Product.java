package com.example.commerce;

public class Product {

    //상품명, 가격, 설명, 재고수량
    private String name;
    private int price;
    private String desc;
    private int stock;

    public Product(String name, int price, String desc, int stock) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // 상품 정보 출력 포맷
    public String getProdInfo() {
        return String.format("%-15s | %,10d원 | %s", name, price, desc);
    }
}
