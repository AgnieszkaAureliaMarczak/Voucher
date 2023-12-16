package org.example;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        String longText = "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc.";

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        Random random = new Random();
        int number = random.nextInt();
        System.out.println(number);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            int fontSize = 12;
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), fontSize);
            float maxWidth = 200; // Maksymalna szerokość tekstu
            float startX = 25; // Początkowa pozycja X
            float startY = 821; // Początkowa pozycja Y
            float leading = -1.5f * 12; // Interlinia

            String[] words = longText.split("\\s+");
            StringBuilder line = new StringBuilder();

            for (String word : words) {
                contentStream.beginText();
                float width = new PDType1Font(Standard14Fonts.FontName.HELVETICA).getStringWidth(line + word) / 1000 * fontSize;
                if (width > maxWidth) {
                    contentStream.newLineAtOffset(startX, startY);
                    contentStream.showText(line.toString());
                    line.setLength(0);
                    startY += leading; // Przejście do nowej linii
                }

                line.append(word).append(" ");
                contentStream.endText();
            }
            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText(line.toString());
            contentStream.endText();
            contentStream.close();
            document.save("ZawijanieTekstu" + number +".pdf");
            document.close();
        } catch (Exception e) {
            System.out.println("Exception found.");
        }
    }
}
