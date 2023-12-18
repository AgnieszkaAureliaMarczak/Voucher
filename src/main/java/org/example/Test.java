package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Test {
    public static void writeListToPDF(List<String> stringList, String outputPath) {

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Początkowa pozycja tekstu na stronie PDF
            float yPosition = 700;

            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
            contentStream.newLineAtOffset(50, yPosition);

            for (String line : stringList) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -15); // Przesunięcie do kolejnego wiersza

                // Sprawdzanie, czy wystarczy miejsca na kolejny wiersz na stronie PDF
                if (yPosition < 50) {
                    contentStream.endText();
                    contentStream.close();
                    PDPage newPage = new PDPage();
                    document.addPage(newPage);
                    contentStream = new PDPageContentStream(document, newPage);
                    contentStream.beginText();
                    contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                    contentStream.newLineAtOffset(50, 700);
                    yPosition = 700;
                } else {
                    yPosition -= 15;
                }
            }

            contentStream.endText();
            contentStream.close();

            document.save(outputPath);
            System.out.println("Plik PDF został pomyślnie utworzony.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt();
        System.out.println(number);
        // Przykładowa lista stringów do wpisania do pliku PDF
        List<String> stringList = List.of("Pierwszy wiersz", "Drugi wiersz", "Trzeci wiersz");

        // Wywołanie funkcji zapisującej listę stringów do pliku PDF
        writeListToPDF(stringList, "Plik PDF " + number + ".pdf");
    }
}

