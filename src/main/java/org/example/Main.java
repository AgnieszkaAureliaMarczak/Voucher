package org.example;

public class Main {
    public static void main(String[] args) {
        OfferCreator offerCreator = new OfferCreator(new ContentFileTXTGenerator());
        offerCreator.createOfferComponents();
    }
}