package org.example;

import java.util.Scanner;

public class VoucherCreator {

    public Voucher createVoucher() {
        Scanner scanner = new Scanner(System.in);
        int voucherCount = 0;
        voucherCount++;
        System.out.println("Podaj identyfikator oferty:");
        String offerId = scanner.nextLine();
        System.out.println("Podaj liczbę noclegów:");
        int numberOfNights = scanner.nextInt();
        return new Voucher(offerId,voucherCount,2);
    }
}
