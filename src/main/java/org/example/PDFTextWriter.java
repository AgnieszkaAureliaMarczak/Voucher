package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.util.List;

public class PDFTextWriter { //todo odpowiedzialność - wstawienie całej treści do dokumentu - więc już nie tylko wrappowanie
    private static final int DEFAULT_FONT_SIZE = 12;
    private PDFont font;
    private int fontSize;
    private float maxWidth; // Maksymalna szerokość tekstu
    private float startX; // Początkowa pozycja X
    private float startY; // Początkowa pozycja Y
    private float leading; // Interlinia
    private float lastLine;
    private PDRectangle pageSize;


    //todo to wrapper powinien przyjmować wymiary a nie ustalać w naszej aplikacji jaki jest domyślny font itd- przenieść do głównej klasy

    public PDFTextWriter() {
        this(new PDType1Font(Standard14Fonts.FontName.HELVETICA));
    }

    public PDFTextWriter(PDFont font) {
        this(
                font,
                DEFAULT_FONT_SIZE,
                550,
                25,
                811,
                30,
                PDRectangle.A4);
    }

    public PDFTextWriter(PDFont font, int fontSize, float maxWidth, float startX, float startY, float lastLine, PDRectangle pageSize) {
        this.font = font;
        this.fontSize = fontSize;
        this.maxWidth = maxWidth;
        this.startX = startX;
        this.startY = startY;
        this.leading = -1.5f * fontSize;
        this.lastLine = lastLine;
        this.pageSize = pageSize;
    }

    public void writeContent(List<String> stringLines, PDDocument document) {
        PDPage page = new PDPage(pageSize);
        document.addPage(page);

        for (String stringLine : stringLines) {
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page,
                    PDPageContentStream.AppendMode.APPEND, true)) {
                contentStream.setFont(font, fontSize);

                String[] words = stringLine.split("\\s+");
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];

                    float width = font.getStringWidth(line + word) / 1000 * fontSize;
                    if (width > maxWidth || i == words.length - 1) {

                        contentStream.beginText();
                        contentStream.newLineAtOffset(startX, startY);
                        contentStream.showText(line.toString());
                        contentStream.endText();

                        line.setLength(0);
                        startY += leading; // Przejście do nowej linii
                    }
                    line.append(word).append(" ");

                }

//                contentStream.beginText();
//                contentStream.newLineAtOffset(startX, startY);
//                contentStream.showText(line.toString());
//                contentStream.endText();


                startY += leading;
            } catch (Exception e) {
                System.out.println("Exception found.");
                e.printStackTrace();
            }
        }
    }
}
