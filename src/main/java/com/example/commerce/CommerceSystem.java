package com.example.commerce;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private int menu = -1;

    private Category category = new Category();
    private List<String> categories = category.getCategoryName();
    private Scanner sc = new Scanner(System.in);
    private CartService cartService = new CartService();
    private admin admin = new admin(category);//카테고리객체를 넘겨줘서 생성된 상품들전달하기

    public CommerceSystem() {}

    public void start (){

        while (menu!=0) {
            try {
                System.out.println("[ 실시간 커머스 플랫폼 메인 ]");

                //List.of로 선언된 카테고리 출력
                for (int i = 0; i < categories.size(); i++) {
                    System.out.println((i + 1) + ". " + categories.get(i));
                }
                List<Cart> carts = cartService.getCart();

                if (carts.size() != 0) {
                    System.out.println("[ 주문 관리 ]");
                    System.out.println("4. 장바구니 확인    | 장바구니를 확인 후 주문합니다.");
                    System.out.println("5. 주문 취소       | 진행중인 주문을 취소합니다.");
                }

                System.out.println("6. ☆ 관리자 모드 ☆");
                System.out.println("0. 종료            | 프로그램 종료");
                System.out.print("입력: ");
                menu = sc.nextInt();

                //관리자모드
                if (menu == 6) {
                    admin.accessAdmin();
                }

                if (menu == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                }

                if (menu > 0 && menu <= categories.size()) {
                    showCategoryDetail(categories.get(menu - 1));
                } else {
                    if (carts.size() != 0 && menu == 4) {
                        System.out.println("아래와 같이 주문 하시겠습니까?");
                        cartService.checkCart();
                        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");

                        int confirmMenu = sc.nextInt();

                        if (confirmMenu == 1) {
                            cartService.confirmOrder();
                        } else {
                            System.out.println("메인메뉴로 돌아가기");
                        }
                    } else if (menu == 5) {
                        System.out.println("5번 주문 취소를 선택하셨습니다.");
                    } else {
                        System.out.println("유효하지 않은 상품 번호 입력입니다.");
                    }
                }
            }catch (InputMismatchException e) { //예외 처리
                System.out.println("오류: 숫자만 입력할 수 있습니다. 다시 시도해주세요.");
                sc.nextLine();
                menu = -1;
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
                        + selected.getDesc() + " | 재고: " + selected.getStock() + "개\n");
                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2. 취소");

                if(sc.nextInt() ==1){
                    System.out.println("담을 수량을 입력해주세요");
                    //수량입력받기
                    int count = sc.nextInt();
                    if(count > selected.getStock()){
                        System.out.println("재고가 부족합니다.(현재 재고: " + selected.getStock() + "개)");
                    }else if (count <= 0) {
                        System.out.println("1개 이상의 수량을 입력해주세요.");
                    } else{
                        System.out.println(selected.getProductName()+" (이)가 "+ count+"개 장바구니에 추가되었습니다.");
                        //카트에 담기
                        cartService.addCart(selected,count);
                    }
                } else{
                    System.out.println("취소되었습니다.");
                }

                break;
            } else{
                System.out.println("유효한 번호 입력이 아닙니다.");
            }
        }
    }

}
