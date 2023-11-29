package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj identyfikator oferty");
        String id = scanner.nextLine();
        System.out.println("Podaj ilosc nocy");
        int numberOfNights = scanner.nextInt();

    }
}