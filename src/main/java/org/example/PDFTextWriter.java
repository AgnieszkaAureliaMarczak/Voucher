package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.util.List;

public class PDFTextWriter extends ContentFilePDFGenerator { //todo odpowiedzialność - wstawienie całej treści do dokumentu - więc już nie tylko wrappowanie
    //todo to wrapper powinien przyjmować wymiary a nie ustalać w naszej aplikacji jaki jest domyślny font itd- przenieść do głównej klasy

    private PDFont font;

    public PDFTextWriter(PDFont font) {
        this.font = font;
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
                startY += leading;
            } catch (Exception e) {
                System.out.println("Exception found.");
                e.printStackTrace();
            }
        }
    }
}
