package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.apache.pdfbox.pdmodel.common.PDRectangle.LETTER;


public class ContentFilePDFGenerator implements ContentFileGenerator {
    public void createFile(List<String> vouchersAsString) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
       // PDRectangle rectangle = PDRectangle.A4;
        document.addPage(page);
        Random random = new Random();
        int number = random.nextInt();
        System.out.println(number);
        try{
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
            contentStream.newLineAtOffset(25, 821);
            for (String voucher : vouchersAsString) {
                contentStream.showText(voucher);
            }
            contentStream.endText();
            contentStream.close();
            document.save("VoucherPDF" + number + ".pdf");
            document.close();
        } catch(IOException e) {
            System.out.println("File not found.");
        }
    }
}
