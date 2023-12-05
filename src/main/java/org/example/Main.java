package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VoucherCreator voucherCreator = new VoucherCreator();
        Voucher voucher = voucherCreator.createVoucher();
        System.out.println(voucher);
    }
}