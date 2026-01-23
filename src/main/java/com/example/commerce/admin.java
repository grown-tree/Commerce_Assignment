package com.example.commerce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class admin {

    private Scanner sc = new Scanner(System.in);
    private int adminMenu = -1;


    public void admin() {}

    public void accessAdmin(){
        int failCount = 0;//
        while (failCount < 3) {
            System.out.print("관리자 비밀번호를 입력해주세요: ");
            String adminPw = sc.next();

            if ("admin123".equals(adminPw)) {// 비밀번호 일치 시 메뉴 출력
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
                    switch (adminMenu) {
                        case 1: // 상품 추가
                             break;
                        case 2: // 상품 수정
                            break;
                        case 3: // 상품 삭제
                            break;
                        case 4: // 전체 상품 현황
                            break;
                        case 0:
                            System.out.println("메인으로 돌아갑니다.");
                            break;
                        default:
                            // 메뉴 외의 숫자를 입력했을 때의 예외 처리
                            System.out.println("잘못된 메뉴 번호입니다. 다시 확인해주세요.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력 가능합니다.");
                    sc.nextLine(); // 입력 비우기
                }
                return; // 관리자 업무 종료 후 메인으로 복귀

            } else {
                failCount++;
                System.out.println("비밀번호가 틀렸습니다. (실패 횟수: " + failCount + "/3)");

                if (failCount == 3) {
                    System.out.println("비밀번호 3회 오류로 인해 메인 메뉴로 돌아갑니다.");
                }
            }
        }
    }

    public int getAdminMenu() {
        return adminMenu;
    }

    public void setAdminMenu(int adminMenu) {
        this.adminMenu = adminMenu;
    }
}
