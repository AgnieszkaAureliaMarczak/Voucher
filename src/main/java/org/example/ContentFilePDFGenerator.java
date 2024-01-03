package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ContentFilePDFGenerator implements ContentFileGenerator {

    private final String FILE_PATH_NAME = "src/main/resources/RethinkSans-VariableFont_wght.ttf";
    protected static final int DEFAULT_FONT_SIZE = 12;
    protected int fontSize;
    protected float maxWidth; // Maksymalna szerokość tekstu
    protected float startX; // Początkowa pozycja X
    protected float startY; // Początkowa pozycja Y
    protected float leading; // Interlinia
    protected float lastLine;
    protected PDRectangle pageSize;

    public ContentFilePDFGenerator() {
        this(
                DEFAULT_FONT_SIZE,
                530,
                25,
                811,
                30,
                PDRectangle.A4);
    }

    public ContentFilePDFGenerator(int fontSize, float maxWidth, float startX, float startY,
                                   float lastLine, PDRectangle pageSize) {
        this.fontSize = fontSize;
        this.maxWidth = maxWidth;
        this.startX = startX;
        this.startY = startY;
        this.leading = -1.5f * fontSize;
        this.lastLine = lastLine;
        this.pageSize = pageSize;
    }

    public void createFile(List<String> vouchersAsString) {

        //LETTER 611 X 792, A4 595 X 841

        try (PDDocument document = new PDDocument()) {
            PDFont myFont = PDType0Font.load(document, new File(FILE_PATH_NAME));
            PDFTextWriter pdfTextWriter = new PDFTextWriter(myFont);
            Random random = new Random();
            int number = random.nextInt(100);
            System.out.println(number);
            pdfTextWriter.writeContent(vouchersAsString, document);
            document.save("VoucherPDF" + number + ".pdf");
            System.out.println("Creating a pdf file...");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
}
