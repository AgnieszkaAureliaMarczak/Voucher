package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFTextWriter extends ContentFilePDFGenerator {
    private PDFont font;
    private TextWrapper textWrapper;

    public PDFTextWriter(PDFont font) {
        this.font = font;
        textWrapper = new TextWrapper(new LineWidthCheckerPDF(maxWidth,font, fontSize));
    }

    public void writeContent(List<String> stringLines, PDDocument document) {
        do {
            writeOnePage(stringLines, document);
        } while (!stringLines.isEmpty());
    }

    private void writeOnePage(List<String> contentList, PDDocument document) {
        PDPage currentPage = new PDPage(pageSize);
        document.addPage(currentPage);
        float lineStartY = startY;
        List<String> contentListCopy = new ArrayList<>(contentList);
        for (String content : contentListCopy) {
            List<String> lines = textWrapper.wrapText(content);
            //upewniamy sie czy sie zmiesci na stronie, jesli nie to wypad
            try (PDPageContentStream contentStream = new PDPageContentStream(document, currentPage,
                    PDPageContentStream.AppendMode.APPEND, true)) {
                contentStream.setFont(font, fontSize);
                for (String line : lines) {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(startX, lineStartY);
                    contentStream.showText(line);
                    contentStream.endText();
                    lineStartY += leading;
                }

                  //  float width = font.getStringWidth(line + word) / 1000 * fontSize;
                    /*line.append(word).append(" ");
                    if (width > maxWidth || i == words.length - 1) {//wersja z dodaniem ostatniego slowa w linijce
                        if (lineStartY < lastLine) {
                            System.out.println("Nowa strona");
                            return;
                        }
                        contentStream.beginText();
                        contentStream.newLineAtOffset(startX, lineStartY);
                        contentStream.showText(line.toString());
                        contentStream.endText();
                        line.setLength(0);
                        lineStartY += leading;
                    }*/
                lineStartY += leading;
                contentList.remove(content);
            } catch (IOException e) {
                System.out.println("Exception found.");
                e.printStackTrace();
            }
        }
    }
}
