package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ContentFileTXTGenerator implements ContentFileGenerator {
    public void createFile(List<String> vouchersAsString) {
        String fileName = "VoucherTXT.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileName);
            for (String voucher : vouchersAsString) {
                fileWriter.write(voucher + "\n");
                printWriter.println(voucher + "\n");
            }
            fileWriter.close();
            printWriter.close();
            System.out.println("Creating a txt file...");
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
