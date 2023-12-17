package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator());
        offerCreator.createOfferComponents();*/
        List<String> teksty = new ArrayList<>();
        teksty.add("bdf".repeat(50));
        teksty.add("abc".repeat(50));
        teksty.add("asf".repeat(50));
        new ContentFilePDFGenerator().createFile(teksty);
    }
}