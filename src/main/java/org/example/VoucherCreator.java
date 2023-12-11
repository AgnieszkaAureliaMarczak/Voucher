package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VoucherCreator {

    Scanner scanner = new Scanner(System.in);

    public void fillWithVouchers(Offer offer) {
        List<Voucher> vouchers = new ArrayList<>();
        int numberOfVouchers = readNumberOfVouchers();
        for (int i = 1; i <= numberOfVouchers; i++) {
            int numberOfNights = readNumberOfNights(i);
            int numberOfPeople = readNumberOfPeople(i);
            vouchers.add(new Voucher(offer, vouchers.size() + 1, numberOfNights, numberOfPeople));
        }
        offer.setVouchers(vouchers);
    }

    private int readNumberOfVouchers() {
        System.out.print("Podaj liczbę voucherów do utworzenia: ");
        return scanner.nextInt();
    }
    private int readNumberOfNights(int voucherCount) {
        System.out.print("Voucher nr " + voucherCount + ": podaj liczbę nocy ");
        return scanner.nextInt();
    }
    private int readNumberOfPeople(int voucherCount){
        System.out.print("Voucher nr " + voucherCount + ": podaj liczbę osób ");
        return scanner.nextInt();
    }



}
