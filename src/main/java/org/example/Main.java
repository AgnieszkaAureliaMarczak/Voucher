package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class Main {
    public static void main(String[] args) {
       /* OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator(new PDFTextWrapper()));
        offerCreator.createOfferComponents();*/
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        String longText = "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        new PDFTextWrapper().writeAndWrapString(longText,document,page);

    }
}