package org.example;

public class ContentFileTXTGenerator implements ContentFileGenerator{
    public void createFile(String offersAsString) {
        System.out.println("Zapisuje plik txt z trescia " + offersAsString);
    }
}
