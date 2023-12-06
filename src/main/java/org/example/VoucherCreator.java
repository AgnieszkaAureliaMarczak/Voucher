package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VoucherCreator {

    Scanner scanner = new Scanner(System.in);

    public void fillWithVouchers(Offer offer) {
        int numberOfVouchers = readNumberOfVouchers();
        List<Voucher> vouchers = new ArrayList<>();
        for (int i = 1; i <= numberOfVouchers; i++) {
            int numberOfNights = readNumberOfNights();
            vouchers.add(new Voucher(offer, vouchers.size() + 1, numberOfNights));
        }
        offer.setVouchers(vouchers);
    }

    private int readNumberOfVouchers() {
        System.out.print("Podaj liczbę voucherów do utworzenia:");
        return scanner.nextInt();
    }

    private int readNumberOfNights() {
        System.out.print("Podaj liczbę nocy:");
        return scanner.nextInt();
    }



}
