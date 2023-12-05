package org.example;

public class Main {
    public static void main(String[] args) {
        OfferCreator offerCreator = new OfferCreator();
        Offer offer = offerCreator.createOffer();
        System.out.println(offer);
        System.exit(0);
        VoucherCreator voucherCreator = new VoucherCreator();
        voucherCreator.createVouchers();
    }
}