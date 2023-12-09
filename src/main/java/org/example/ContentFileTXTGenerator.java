package org.example;

public class ContentFileTXTGenerator implements ContentFileGenerator{
    public void createFile(String offerAsString) {
        System.out.println("Zapisuje plik txt z trescia " + offerAsString);
    }
}
