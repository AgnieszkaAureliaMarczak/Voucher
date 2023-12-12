package org.example;

import java.io.File;
import java.io.IOException;

public class ContentFileTXTGenerator implements ContentFileGenerator {
    public void createFile(String vouchersAsString) {
        File txtFile = new File("C:/Projekty Java/Voucher/VoucherTXT.txt");
        try {
            txtFile.createNewFile();
            System.out.println("Tworzę plik");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
