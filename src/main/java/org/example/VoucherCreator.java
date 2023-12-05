package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VoucherCreator {
    private List<Voucher> vouchers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createVouchers() {
        int voucherCount;
        String offerId = getOfferId();
        int numberOfVouchers = getNumberOfVouchers();
        for (int i = 1; i <= numberOfVouchers; i++) {
            int numberOfNights = getNumberOfNights();
            voucherCount = vouchers.size() + 1;
            vouchers.add(new Voucher(offerId, voucherCount, numberOfNights));
        }
    }

    private String getOfferId() {
        System.out.println("Podaj identyfikator oferty:");
        return scanner.nextLine();
    }

    private int getNumberOfVouchers() {
        System.out.println("Podaj liczbę voucherów do utworzenia:");
        return scanner.nextInt();
    }

    private int getNumberOfNights() {
        System.out.println("Podaj liczbę noclegów:");
        return scanner.nextInt();
    }
}
