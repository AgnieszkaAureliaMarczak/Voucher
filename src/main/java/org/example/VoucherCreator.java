package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VoucherCreator {
    private List<Voucher> vouchers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createVouchers(String offerId) {
        int numberOfVouchers = getNumberOfVouchers();
        for (int i = 1; i <= numberOfVouchers; i++) {
            int numberOfNights = getNumberOfNights();
            vouchers.add(new Voucher(offerId, vouchers.size() + 1, numberOfNights));
        }
    }

    private int getNumberOfVouchers() {
        System.out.println("Podaj liczbę voucherów do utworzenia:");
        return scanner.nextInt();
    }

    private int getNumberOfNights() {
        System.out.println("Podaj liczbę noclegów:");
        return scanner.nextInt();
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public String toString() {
        return "VoucherCreator{" +
                "vouchers=" + vouchers +
                '}';
    }
}
