package org.example;

import java.util.Scanner;

public class OfferCreator {
    Scanner scanner = new Scanner(System.in);
    private VoucherCreator voucherCreator = new VoucherCreator();

    public void createOfferComponents() {
        Offer offer = createOffer();
        voucherCreator.createVouchers(offer.getId());
        offer.setVouchers(voucherCreator.getVouchers());
    }

    public Offer createOffer() {
        return new Offer(getId(), getName());
    }

    private String getId() {
        System.out.println("Podaj identyfikator oferty:");
        return scanner.nextLine();
    }

    private String getName() {
        System.out.println("Podaj nazwę oferty (SEO):");
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return "OfferCreator{" +
                "voucherCreator=" + voucherCreator +
                '}';
    }
}
