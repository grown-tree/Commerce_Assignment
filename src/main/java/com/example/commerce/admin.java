package com.example.commerce;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class admin {

    private Scanner sc = new Scanner(System.in);
    private List<Product> productList;
    private Category ct;
    private List<String> categoryList;
    private int adminMenu = -1;

    public void admin() {}

    public admin(Category ct) {
        this.ct = ct;
        this.productList = ct.getProducts(); // Category가 가진 상품 리스트 넣어주기
        this.categoryList = ct.getCategoryName();
    }

    public void accessAdmin(){
        int failCount = 0;
        while (failCount < 3) {
            System.out.print("관리자 비밀번호를 입력해주세요: ");
            String adminPw = sc.next();

            if ("admin123".equals(adminPw)) {// 비밀번호 일치 시 메뉴 출력
                while (true) {
                    System.out.println("\n[ ☆ 관리자 모드 ☆ ]");
                    System.out.println("1. 상품 추가");
                    System.out.println("2. 상품 수정");
                    System.out.println("3. 상품 삭제");
                    System.out.println("4. 전체 상품 현황");
                    System.out.println("0. 메인으로 돌아가기");
                    System.out.print("메뉴 선택: ");

                    //메뉴 선택에 문자입력시 예외처리
                    try {
                        adminMenu = sc.nextInt();
                        sc.nextLine();//입력 버퍼 지우기
                        switch (adminMenu) {
                            case 1 -> addProduct();
                            case 2 -> updateProduct();
                            case 3 -> deleteProduct();
                            case 4 -> allProducts();
                            case 0 -> {
                                System.out.println("메인으로 돌아갑니다.");
                                return;//메인메뉴로
                            }
                            default ->
                                // 메뉴 외의 숫자를 입력했을 때의 예외 처리
                                    System.out.println("잘못된 메뉴 번호입니다. 다시 확인해주세요.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("숫자만 입력 가능합니다.");
                        sc.nextLine(); // 입력 비우기
                    }
                }


            } else {
                failCount++;
                System.out.println("비밀번호가 틀렸습니다. (실패 횟수: " + failCount + "/3)");

                if (failCount == 3) {
                    System.out.println("비밀번호 3회 오류로 인해 메인 메뉴로 돌아갑니다.");
                }
            }
        }
    }

    // 상품 추가
    private void addProduct() {
        System.out.println("\n어느 카테고리에 상품을 추가하시겠습니까?");
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.println((i + 1) + ". " + categoryList.get(i));
            }
        int ctChoice = sc.nextInt();
        sc.nextLine();
        String selectedCategory = categoryList.get(ctChoice - 1);

        System.out.println("\n[" + selectedCategory + " 카테고리에 상품 추가]");
        System.out.print("상품명을 입력해주세요: ");
            String name = sc.nextLine();
        System.out.print("가격을 입력해주세요: ");
            int price = sc.nextInt();
            sc.nextLine();//오류방지 입력버퍼 지우기
        System.out.print("상품 설명을 입력해주세요: ");
            String desc = sc.nextLine();
        System.out.print("재고수량을 입력해주세요: ");
            int stock = sc.nextInt();
            sc.nextLine();

        System.out.printf("\n%s | %,d원 | %s | 재고: %d개\n", name, price, desc, stock);
        System.out.println("위 정보로 상품을 추가하시겠습니까?\n1. 확인    2. 취소");
        if (sc.nextInt() == 1) {
            productList.add(new Product(name, price, desc, stock, selectedCategory));
            System.out.println("상품이 성공적으로 추가되었습니다!");
        } else {
            System.out.println("추가가 취소되었습니다.");
        }
    }

    // 상품 수정
    private void updateProduct() {

        Product target = null;

        System.out.print("수정할 상품명을 입력해주세요: ");
        String searchName = sc.nextLine();

        //상품리스트에서 상품찾기
        for (Product p : productList) {
            if (p.getProductName().equals(searchName)) {
                target = p;
                break;
            }
        }

        //예외처리
        if (target == null) {
            System.out.println("해당 상품을 찾을 수 없습니다.");
            return;
        }

        System.out.printf("현재 상품 정보: %s | %,d원 | %s | 재고: %d개\n", target.getProductName(), target.getPrice(), target.getDesc(), target.getStock());

        System.out.println("\n수정할 항목을 선택해주세요:\n1. 가격  2. 설명  3. 재고수량");
        int detailMenu = sc.nextInt(); sc.nextLine();

        //java 14이상 사용가능
        switch (detailMenu) {
            case 1 -> {
                System.out.println("현재 가격: " + target.getPrice());
                System.out.print("새로운 가격: ");
                int newPrice = sc.nextInt();
                System.out.printf("%s의 가격이 %,d원 → %,d원으로 수정되었습니다.\n", target.getProductName(), target.getPrice(), newPrice);
                target.setPrice(newPrice);
            }
            case 2 -> {
                System.out.print("새로운 설명: ");
                target.setDesc(sc.nextLine());
                System.out.println("설명이 수정되었습니다.");
            }
            case 3 -> {
                System.out.print("새로운 재고수량: ");
                target.setStock(sc.nextInt());
                System.out.println("재고가 수정되었습니다.");
            }
        }
    }

    // 상품 삭제
    private void deleteProduct() {
        allProducts();
        if (productList.size()==0) return;
        System.out.print("삭제할 상품 번호: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < productList.size()) {
            System.out.println(productList.remove(index).getProductName() + " 삭제 완료.");
        }
    }

    // 전체 상품 현황
    private void allProducts() {
        System.out.println("\n[ 전체 상품 현황 ]");
        if (productList.size()==0) System.out.println("등록된 상품이 없습니다.");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i).getProdInfo() + " | 재고: " + productList.get(i).getStock());
        }
    }

    public int getAdminMenu() {
        return adminMenu;
    }

    public void setAdminMenu(int adminMenu) {
        this.adminMenu = adminMenu;
    }
}
