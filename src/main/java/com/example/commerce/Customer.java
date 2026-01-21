package com.example.commerce;

public class Customer {

    //고객명, 이메일, 등급, 누적 주문 금액
    private String customerName;
    private String email;
    private String rate;
    private int totalOrderAmount;

    // 등급 계산 메서드
    public String calculateGrade(int currentOrderAmount) {
        // 이번 주문 금액을 누적 금액에 누적
        this.totalOrderAmount += currentOrderAmount;

        // 등급 판별 로직
        if (this.totalOrderAmount < 500000) {
            return "브론즈";
        } else if (this.totalOrderAmount < 1000000) {
            return "실버";
        } else if (this.totalOrderAmount < 2000000) {
            return "골드";
        } else {
            return "플레티넘";
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(int totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }
}
