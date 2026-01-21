package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private List<String> categoryName = new ArrayList<>(List.of("전자제품","의류","식품"));
    private List<Product> products = new ArrayList<>();

    public Category() {
        //전자제품
        addProduct(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 80, "전자제품"));
        addProduct(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 120, "전자제품"));
        addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50, "전자제품"));
        addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 200, "전자제품"));
        //의류
        addProduct(new Product("노스페이스 패딩", 400000, "차가운 바람을 막아주는 패딩", 98, "의류"));
        addProduct(new Product("갈색 니트", 57000, "푸근한 니트", 800, "의류"));
        addProduct(new Product("데님 팬츠", 90000, "트렌디한 데님팬츠", 110, "의류"));
        addProduct(new Product("범고래 신발", 89000, "범고래가 떠오르는 신발", 60, "의류"));
        //식품
        addProduct(new Product("삼겹살", 30000, "기름좔좔 삼겹살", 20, "식품"));
        addProduct(new Product("시금치", 6000, "뽀빠이 시금치", 30, "식품"));
        addProduct(new Product("고추장", 9800, "맛있게 매운 고추장", 50, "식품"));
        addProduct(new Product("귤", 10000, "달콤새콤한 제주귤", 2000, "식품"));
    }

    // List<Product>에 값 할당해주는 생성자
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<String> getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(List<String> categoryName) {
        this.categoryName = categoryName;
    }

}
