package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContentFilePDFGenerator implements ContentFileGenerator {
    private TextWrapper textWrapper;
    private PDFDocumentConfiguration configuration;

    public ContentFilePDFGenerator(PDFDocumentConfiguration configuration) {
        this.configuration = configuration;
        textWrapper = new TextWrapper(new LineWidthCheckerPDF(configuration.getMaxWidth(), font, configuration.getFontSize()));
    }

    public void createFile(List<String> vouchersAsString) {
        //LETTER 611 X 792, A4 595 X 841
        try (PDDocument document = new PDDocument()) {
            PDFont myFont = createFont(document);
            writeContent(vouchersAsString, document, myFont);
            int number = drawRandomNumber();
            document.save("VoucherPDF" + number + ".pdf");
            System.out.println("Creating a pdf file...");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    private int drawRandomNumber(){
        Random random = new Random();
        int number = random.nextInt(100);
        System.out.println(number);
        return number;
    }

    private PDFont createFont(PDDocument document){
        PDFont myFont = null;
        try {
             myFont = PDType0Font.load(document, new File(configuration.getFILE_PATH_NAME()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not there.");
        }
        return myFont;
    }

    private void writeContent(List<String> contentList, PDDocument document, PDFont font) {
        PDPage currentPage = new PDPage(configuration.getPageSize());
        document.addPage(currentPage);
        float lineStartY = configuration.getStartY();
        List<String> contentListCopy = new ArrayList<>(contentList);
        for (String content : contentListCopy) {
            List<String> lines = textWrapper.wrapText(content);
            for (String line : lines) {
                if (lineStartY < configuration.getLastLine()) {
                    PDPage newPage = new PDPage(configuration.getPageSize());
                    document.addPage(newPage);
                    currentPage = newPage;
                    lineStartY = configuration.getStartY();
                }
                lineStartY = writeOneLine(document, currentPage, lineStartY, line, font);
            }
            lineStartY += configuration.getLeading();
            contentList.remove(content);
        }
    }

    private float writeOneLine(PDDocument document, PDPage currentPage, float lineStartY, String stringLine, PDFont font) {
        try (PDPageContentStream contentStream = new PDPageContentStream(document, currentPage,
                PDPageContentStream.AppendMode.APPEND, true)) {
            contentStream.setFont(font, configuration.getFontSize());
            contentStream.beginText();
            contentStream.newLineAtOffset(configuration.getStartX(), lineStartY);
            contentStream.showText(stringLine);
            contentStream.endText();
            lineStartY += configuration.getLeading();
        } catch (IOException e) {
            System.out.println("Exception found.");
            e.printStackTrace();
        }
        return lineStartY;
    }
}
