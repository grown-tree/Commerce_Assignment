package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private int menu = -1;

    private Category category = new Category();
    private List<String> categories = category.getCategoryName();
    private Scanner sc = new Scanner(System.in);

    public CommerceSystem() {}

    public void start (){

        System.out.println("start 함수 시작");

        while (menu!=0) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");

            //List.of로 선언된 카테고리 출력
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i));
            }

            System.out.println("0. 종료            | 프로그램 종료");
            System.out.print("입력: ");
            menu = sc.nextInt();

            if (menu == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }

            if (menu > 0 && menu <= categories.size()) {
                showCategoryDetail(categories.get(menu - 1));
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        sc.close();
    }

    //카테고리 선택시 해당 카테고리 상품보여주는 메소드
    private void showCategoryDetail(String categoryName) {
        while (true) {
            System.out.println("\n[ " + categoryName + " 카테고리 ]");

            // 선택한 카테고리 상품들 담을 리스트
            List<Product> filteredProducts = new ArrayList<>();

            //전체 상품중에 선택한 카테고리로 필터링하여 리스트에 추가
            for (Product p : category.getProducts()) {
                if (p.getProductCategory().equals(categoryName)) {
                    filteredProducts.add(p);
                }
            }

            // 필터링된 상품 출력
            for (int i = 0; i < filteredProducts.size(); i++) {
                System.out.println((i + 1) + ". " + filteredProducts.get(i).getProdInfo());
            }
            System.out.println("0. 뒤로가기");

            System.out.print("입력: ");
            int itemChoice = sc.nextInt();

            if (itemChoice == 0) break; // 뒤로가기 (상위 루프인 메인 메뉴로 이동)

            //상품을 정상적으로 선택햇는지 확인 후 해당 상품 정보 출력
            if (itemChoice > 0 && itemChoice <= filteredProducts.size()) {
                Product selected = filteredProducts.get(itemChoice - 1);
                // 선택한 상품 상세 정보 출력 (재고 포함)
                System.out.println("\n선택한 상품: " + selected.getProductName() + " | "
                        + String.format("%,d원", selected.getPrice()) + " | "
                        + selected.getDesc() + " | 재고: " + selected.getStock() + "개");
                break;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }

}
