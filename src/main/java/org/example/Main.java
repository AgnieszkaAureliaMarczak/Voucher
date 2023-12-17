package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*new PDFTextWrapper(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12, 565,
        25, 821)*/

public class Main {
    public static void main(String[] args) {
       /* OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator(new PDFTextWrapper
                (new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12, 565,
                25, 821)));
        offerCreator.createOfferComponents();*/
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        String longText = "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        new PDFTextWrapper(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12, 565,
                25, 821).wrapWords(longText,document,page);



    }
}