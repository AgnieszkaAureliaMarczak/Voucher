package org.example;

public class ContentFilePDFGenerator implements ContentFileGenerator{
    public void createFile(String offerAsString) {
        System.out.println("Zapisuje plik pdf z trescia " + offerAsString);
    }
}
