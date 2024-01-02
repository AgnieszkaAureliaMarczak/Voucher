package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ContentFilePDFGenerator implements ContentFileGenerator {
    private final String FILE_PATH_NAME = "src/main/resources/RethinkSans-VariableFont_wght.ttf";

    public void createFile(List<String> vouchersAsString) {

        //LETTER 611 X 792, A4 595 X 841

        try (PDDocument document = new PDDocument()) {
            PDFont myFont = PDType0Font.load(document, new File(FILE_PATH_NAME));
            PDFTextWriter pdfTextWriter = new PDFTextWriter(myFont);
            Random random = new Random();
            int number = random.nextInt();
            System.out.println(number);
            pdfTextWriter.writeContent(vouchersAsString, document);
            document.save("VoucherPDF" + number + ".pdf");
            System.out.println("Creating a pdf file...");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
