package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
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
       // PDRectangle rectangle = PDRectangle.A4; //LETTER 611 X 792, A4 595 X 841
        document.addPage(page);
        Random random = new Random();
        int number = random.nextInt();
        System.out.println(number);
        try{
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
           // PDType0Font myFont = PDType0Font.load(document, new File("C:/Projekty Java/Voucher/Rethink_Sans/RethinkSans-VariableFont_wght.ttf"));
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
           // contentStream.setFont(myFont,12);

            int yOffset = 821;
            for (String voucher : vouchersAsString) {
                contentStream.beginText();
                contentStream.newLineAtOffset(25, yOffset);
                contentStream.showText(voucher);
                yOffset -= 20;
                contentStream.endText();
            }

            contentStream.close();
            document.save("VoucherPDF" + number + ".pdf");
            document.close();
            System.out.println("Creating a pdf file...");
        } catch(IOException e) {
            System.out.println("File not found.");
        }
    }

    private void moveTexttoNewLine(){
    }
}
