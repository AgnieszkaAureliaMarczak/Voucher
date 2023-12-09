package org.example;

public class ContentFilePDFGenerator implements ContentFileGenerator{
    public void createFile(String offersAsString) {
        System.out.println("Zapisuje plik pdf z trescia " + offersAsString);
    }
}
