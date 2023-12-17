package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class PDFTextWrapper {
    public void wrapWords(String voucher, PDDocument document, PDPage page) {
        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            int fontSize = 12;
            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            contentStream.setFont(font, fontSize);
            float maxWidth = 565; // Maksymalna szerokość tekstu
            float startX = 25; // Początkowa pozycja X
            float startY = 821; // Początkowa pozycja Y
            float leading = -1.5f * fontSize; // Interlinia
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
        } catch (Exception e) {
            System.out.println("Exception found.");
        }
    }
}
