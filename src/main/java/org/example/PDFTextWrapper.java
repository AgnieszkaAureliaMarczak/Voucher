package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.util.Random;

public class PDFTextWrapper {
    private PDType1Font font;
    private int fontSize;
    private float maxWidth; // Maksymalna szerokość tekstu
    private float startX; // Początkowa pozycja X
    private float startY; // Początkowa pozycja Y
    private float leading; // Interlinia

    public PDFTextWrapper(PDType1Font font, int fontSize, float maxWidth, float startX, float startY) {
        this.font = font;
        this.fontSize = fontSize;
        this.maxWidth = maxWidth;
        this.startX = startX;
        this.startY = startY;
        this.leading = -1.5f * fontSize;
    }

    public void wrapWords(String voucher, PDDocument document, PDPage page) {
        Random random = new Random();
        int number = random.nextInt();
        System.out.println(number);
        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(font, fontSize);
            String[] words = voucher.split("\\s+");
            StringBuilder line = new StringBuilder();
            for (String word : words) {
                contentStream.beginText();
                float width = font.getStringWidth(line + word) / 1000 * fontSize;
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
            contentStream.close();
            document.save("ZawijanieTekstu" + number +".pdf");
            document.close();
        } catch (Exception e) {
            System.out.println("Exception found.");
        }
    }
}
