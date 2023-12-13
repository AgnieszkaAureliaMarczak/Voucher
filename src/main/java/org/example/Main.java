package org.example;

public class Main {
    public static void main(String[] args) {
        OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator());
        offerCreator.createOfferComponents();
        new ContentFilePDFGenerator().createFile("abc");
    }
}