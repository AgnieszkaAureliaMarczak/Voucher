package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PDFTextWriter extends ContentFilePDFGenerator { //todo odpowiedzialność - wstawienie całej treści do dokumentu - więc już nie tylko wrappowanie
    //todo to wrapper powinien przyjmować wymiary a nie ustalać w naszej aplikacji jaki jest domyślny font itd- przenieść do głównej klasy

    private PDFont font;

    public PDFTextWriter(PDFont font) {
        this.font = font;
    }

    public void writeContent(List<String> stringLines, PDDocument document) {

        do{
            writeOnePage(stringLines, document);
        }while (!stringLines.isEmpty());

    }

    private void writeOnePage(List<String> stringLines, PDDocument document) {
        PDPage currentPage = new PDPage(pageSize);
        document.addPage(currentPage);

        float lineStartY = startY;
        List<String> linesCopy = new ArrayList<>(stringLines);

        for (String stringLine : linesCopy) {
            try ( PDPageContentStream  contentStream = new PDPageContentStream(document, currentPage,
                    PDPageContentStream.AppendMode.APPEND, true))  {
                contentStream.setFont(font, fontSize);

                String[] words = stringLine.split("\\s+");
                StringBuilder line = new StringBuilder();

                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    line.append(word).append(" ");
                    float width = font.getStringWidth(line + word) / 1000 * fontSize;
                    if (width > maxWidth || i == words.length - 1) {
                        if (lineStartY >= lastLine) {
                            contentStream.beginText();
                            contentStream.newLineAtOffset(startX, lineStartY);
                            contentStream.showText(line.toString());
                            contentStream.endText();
                            line.setLength(0);
                            lineStartY += leading;

                        } else {
                            System.out.println("Nowa strona");
                          return;
                        }
                    }
                }
                lineStartY += leading;
                stringLines.remove(stringLine);
            } catch (IOException e) {
                System.out.println("Exception found.");
                e.printStackTrace();
            }
        }
    }
}
