package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFTextWriter extends ContentFilePDFGenerator {
    private PDFont font;
    private TextWrapper textWrapper;

    public PDFTextWriter(PDFont font) {
        this.font = font;
        textWrapper = new TextWrapper(new LineWidthCheckerPDF(maxWidth, font, fontSize));
    }

    public void writeContent(List<String> contentList, PDDocument document) {
        PDPage currentPage = new PDPage(pageSize);
        document.addPage(currentPage);
        float lineStartY = startY;
        List<String> contentListCopy = new ArrayList<>(contentList);
        for (String content : contentListCopy) {
            List<String> stringLines = textWrapper.wrapText(content);
            int stringLinesLength = stringLines.size();
            for (int stringLine = 0; stringLine < stringLinesLength; stringLine++) {
                if (lineStartY < lastLine) {
                    PDPage newPage = new PDPage(pageSize);
                    document.addPage(newPage);
                    currentPage = newPage;
                    lineStartY = startY;
                }
                lineStartY = writeOneLine(document, currentPage, lineStartY, stringLines);
                /*try (PDPageContentStream contentStream = new PDPageContentStream(document, currentPage,
                        PDPageContentStream.AppendMode.APPEND, true)) {
                    contentStream.setFont(font, fontSize);
                    contentStream.beginText();
                    contentStream.newLineAtOffset(startX, lineStartY);
                    contentStream.showText(stringLines.remove(0));
                    contentStream.endText();
                    lineStartY += leading;
                } catch (IOException e) {
                    System.out.println("Exception found.");
                    e.printStackTrace();
                }*/
            }
            lineStartY += leading;
            contentList.remove(content);
        }
    }

    private float writeOneLine(PDDocument document, PDPage currentPage, float lineStartY, List<String> stringLines) {
        try (PDPageContentStream contentStream = new PDPageContentStream(document, currentPage,
                PDPageContentStream.AppendMode.APPEND, true)) {
            contentStream.setFont(font, fontSize);
            contentStream.beginText();
            contentStream.newLineAtOffset(startX, lineStartY);
            contentStream.showText(stringLines.remove(0));
            contentStream.endText();
            lineStartY += leading;
        } catch (IOException e) {
            System.out.println("Exception found.");
            e.printStackTrace();
        }
        return lineStartY;
    }
}
