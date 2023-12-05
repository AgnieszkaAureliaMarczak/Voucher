package org.example;

import java.util.Scanner;

public class VoucherCreator {

    public void createVoucher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj identyfikator oferty:");
        String offerId = scanner.nextLine();
        System.out.println("Podaj liczbę noclegów:");
        int numberOfNights = scanner.nextInt();

    }
}
