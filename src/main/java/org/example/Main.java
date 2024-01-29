package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator(new PDFDocumentConfiguration()));
        offerCreator.createOfferComponents();
    }
}
