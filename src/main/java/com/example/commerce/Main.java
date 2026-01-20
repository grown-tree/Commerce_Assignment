package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int menu = 1;

        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        products.add(new Product("Galaxy S25", 1200000,"최신 안드로이드 스마트폰", 80));
        products.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 120));
        products.add(new Product("MacBook Pro", 2400000,  "M3 칩셋이 탑재된 노트북", 50));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 200));

        while (menu!=0) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (int i = 1; i < products.size()+1; i++) {
                System.out.println(i + ". " + products.get(i-1).getProdInfo());
            }
            System.out.println("0. 종료            | 프로그램 종료");
            menu = sc.nextInt();
        }

    }
}
