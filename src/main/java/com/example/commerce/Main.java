package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CommerceSystem commerceSystem = new CommerceSystem();

//        List<Product> productList = commerceSystem.getProducts();

//        productList.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 80));
//        productList.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 120));
//        productList.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
//        productList.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 200));

        commerceSystem.addProduct(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 80));
        commerceSystem.addProduct(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 120));
        commerceSystem.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        commerceSystem.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 200));


        commerceSystem.start();


    }
}
