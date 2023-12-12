package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContentFileTXTGenerator implements ContentFileGenerator {
    public void createFile(String vouchersAsString) {
        File txtFile = new File("C:/Projekty Java/Voucher/VoucherTXT.txt");
        FileWriter fileWriter;
        try {
            txtFile.createNewFile();
            PrintWriter printWriter = new PrintWriter("VoucherTXT.txt");
            fileWriter = new FileWriter("VoucherTXT.txt");
            fileWriter.write(vouchersAsString);
            printWriter.println(vouchersAsString);
            fileWriter.close();
            printWriter.close();
            System.out.println("Zapisuję plik txt z treścią...");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
