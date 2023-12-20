package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ContentFilePDFGenerator implements ContentFileGenerator {

//tu dac sciezke jako pole final

    public void createFile(List<String> vouchersAsString) {

        //LETTER 611 X 792, A4 595 X 841

        try (PDDocument document = new PDDocument()){
            PDFont myFont = PDType0Font.load(document, new File("src/main/resources/RethinkSans-VariableFont_wght.ttf"));
            PDFTextWrapper pdfTextWrapper = new PDFTextWrapper(myFont);
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            Random random = new Random();
            int number = random.nextInt();
            System.out.println(number);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(pdfTextWrapper.getFont(), pdfTextWrapper.getFontSize());
            // contentStream.setFont(myFont,12);
            float yOffset = pdfTextWrapper.getStartY();
            contentStream.beginText();
            contentStream.newLineAtOffset(pdfTextWrapper.getStartX(), yOffset);
            for (String voucher : vouchersAsString) {
                pdfTextWrapper.writeAndWrapString(voucher, document, page);
                contentStream.newLineAtOffset(pdfTextWrapper.getStartX(), pdfTextWrapper.getStartY());
            }
            contentStream.endText();
            contentStream.close();
            document.save("VoucherPDF" + number + ".pdf");
            System.out.println("Creating a pdf file...");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
