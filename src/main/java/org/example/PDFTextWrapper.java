package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;

public class PDFTextWrapper {
    private static final int DEFAULT_FONT_SIZE = 12;
    private PDFont font;
    private int fontSize;
    private float maxWidth; // Maksymalna szerokość tekstu
    private float startX; // Początkowa pozycja X
    private float startY; // Początkowa pozycja Y
    private float leading; // Interlinia
    private float lastLine;


    public PDFTextWrapper() {
        this(new PDType1Font(Standard14Fonts.FontName.HELVETICA));
    }

    public PDFTextWrapper(PDFont font) {
        this(
                font,
                DEFAULT_FONT_SIZE,
                550,
                25,
                811,
                30
        );
    }

    public PDFTextWrapper(PDFont font, int fontSize, float maxWidth, float startX, float startY, float lastLine) {
        this.font = font;
        this.fontSize = fontSize;
        this.maxWidth = maxWidth;
        this.startX = startX;
        this.startY = startY;
        this.leading = -1.5f * fontSize;
        this.lastLine = lastLine;
    }

    public void writeAndWrapString(String voucher, PDDocument document, PDPage page) {
        try (PDPageContentStream contentStream = new PDPageContentStream(document, page,
                PDPageContentStream.AppendMode.APPEND, true)) {
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
            startY = startY + (2 * leading);
        } catch (Exception e) {
            System.out.println("Exception found.");
            e.printStackTrace();
         /*   if (contentStream != null) {
                contentStream.close();
            }*/
        }
    }

    public PDFont getFont() {
        return font;
    }

    public int getFontSize() {
        return fontSize;
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }
}
