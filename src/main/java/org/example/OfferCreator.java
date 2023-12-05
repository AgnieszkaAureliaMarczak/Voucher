package org.example;

import java.util.Scanner;

public class OfferCreator {
    public Offer createOffer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj identyfikator oferty:");
        String offerId = scanner.nextLine();
        System.out.println("Podaj unikatową nazwę oferty (SEO):");
        String name = scanner.nextLine();
        return new Offer(offerId,name);
    }
}
