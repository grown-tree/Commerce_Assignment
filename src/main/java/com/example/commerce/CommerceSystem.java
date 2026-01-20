package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private int menu = 1;

    private List<Product> products = new ArrayList<>();

    public CommerceSystem() {
    }

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }
    // List<Product>에 값 할당해주는 생성자
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void start (){

        Scanner sc = new Scanner(System.in);

        System.out.println("start 함수 시작");

        while (menu!=0) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (int i = 1; i < products.size()+1; i++) {
                System.out.println(i + ". " + products.get(i-1).getProdInfo());
            }
            System.out.println("0. 종료            | 프로그램 종료");
            menu = sc.nextInt();
        }
    }


    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
