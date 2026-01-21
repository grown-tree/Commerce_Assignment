package com.example.commerce;

public class Product {

    //상품명, 가격, 설명, 재고수량, 카테고리
    private String productName;
    private int price;
    private String desc;
    private int stock;
    private String productCategory;


    public Product(String productName, int price, String desc, int stock, String productCategory) {
        this.productName = productName;
        this.price = price;
        this.desc = desc;
        this.stock = stock;
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {//음수예외처리
            System.out.println("가격은 0원 이상이어야 합니다.");
            return;
        }
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
        if (stock < 0) {//음수예외처리
            System.out.println("재고는 0개 이상이어야 합니다.");
            return;
        }
        this.stock = stock;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    // 상품 정보 출력 포맷
    public String getProdInfo() {
        return String.format("%-15s\t | %,10d원\t | %s", productName, price, desc);
    }
}
