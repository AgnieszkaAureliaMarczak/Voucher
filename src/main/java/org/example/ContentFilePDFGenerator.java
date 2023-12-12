package org.example;

public class ContentFilePDFGenerator implements ContentFileGenerator{
    public void createFile(String vouchersAsString) {
        System.out.println("Zapisuje plik pdf z trescia " + vouchersAsString);
    }
}
