package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator());
        offerCreator.createOfferComponents();*/
        List<String> teksty = new ArrayList<>();
        teksty.add("bdf");
        teksty.add("abc");
        teksty.add("asf");
        new ContentFilePDFGenerator().createFile(teksty);
    }
}