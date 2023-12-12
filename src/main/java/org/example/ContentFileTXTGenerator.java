package org.example;

public class ContentFileTXTGenerator implements ContentFileGenerator{
    public void createFile(String vouchersAsString) {
        System.out.println("Zapisuje plik txt z trescia " + vouchersAsString);
    }
}
