package org.example;

import java.util.Scanner;

public class VoucherCreator {

    public void createVoucher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj identyfikator oferty");
        String id = scanner.nextLine();
        System.out.println("Podaj ilosc nocy");
        int numberOfNights = scanner.nextInt();
    }
}
