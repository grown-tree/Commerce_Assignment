package com.example.commerce;

public class Cart {
    private Product product; // 기존 상품 정보 포함 (Composition)
    private int count;

    public Cart() {
    }

    public Cart(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    //총가격 계산
    public int getTotalPrice() {
        return product.getPrice() * count;
    }

}
