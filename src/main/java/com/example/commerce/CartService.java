package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    private List<Cart> cartList = new ArrayList<>();
    private int total = 0; //총 금액

    //카트에 상품 추가
    public void addCart(Product product, int count) {

        //없는 재고가 담기지 않도록 체크
        if (product.getStock() < count) {
            System.out.println("재고가 부족합니다. (현재 재고: " + product.getStock() + "개)");
            return;
        }

        //같은 상품인지 이름으로 확인
        Cart chSame = checkSameProduct(product.getProductName());

        //if(product.getProductName() == getCart()){}
        if (chSame != null) {
            //장바구니안에 있는 상품수량과 해당상품 재고합이 원래재고를 넘지 않도록 체크
            if (product.getStock() < (chSame.getCount() + count)) {
                System.out.println("오류: 장바구니 합계가 재고를 초과합니다.");
                return;
            }
            // 이미 있는 상품은 수량만 증가
            chSame.setCount(chSame.getCount() + count);
        } else {
            // 없는 상품은 새로객체 생성후 추가
            Cart newItem = new Cart(product, count);
            this.cartList.add(newItem);
        }

    }

    //상품이 카트에 있는것과 같은건지 확인해주는 메서드
    public Cart checkSameProduct(String productName){
        for (Cart item : cartList) {
            if (item.getProduct().getProductName().equals(productName)) {
                return item;
            }
        }
        return null;
    }


    //카트 상품 조회
    public void checkCart(){
        this.total = 0;//총 금액 계산시 total값에 값이 들어가니 조회할때 0으로 초기화
        if (cartList.size() == 0){
            System.out.println("장바구니가 비었습니다.");
        }else {
            System.out.println("----------------------------------------------------");
            System.out.println("■ 장바구니 현황 ■");
            for (Cart item : cartList) {
                Product p = item.getProduct();
                System.out.println(p.getProductName()+" | "
                + p.getPrice()+" | "
                + p.getDesc()+" | "
                + "수량: "+item.getCount()+"개");
                total += (p.getPrice() * item.getCount());
            }
            setTotal(total);
            System.out.println("[ 총 주문 금액 ]\n" +
                    this.total+"원");
            System.out.println("----------------------------------------------------");
        }
    }

    //주문 확정 메서드
    public void confirmOrder(){
        System.out.println("주문이 완료되었습니다! 총 금액: "+ this.total+ "원");
        for (Cart item : cartList) {
            Product p = item.getProduct();
            int updatedStock = p.getStock()- item.getCount();

            System.out.println(p.getProductName()+" 재고가 "+
                   p.getStock() +"→"+updatedStock+"개로 업데이트되었습니다.");

            p.setStock(updatedStock);//재고 업데이트처리 부분
        }
        //주문 확정 이후 장바구니 초기화
        cartList.clear();
        this.total = 0;
        System.out.println("장바구니가 초기화되었습니다.");

    }

    public List<Cart> getCart() {
        return cartList;
    }

    public void setCart(List<Cart> cart) {
        this.cartList = cart;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
