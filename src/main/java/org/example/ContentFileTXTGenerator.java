package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ContentFileTXTGenerator implements ContentFileGenerator {
    public void createFile(List<String> vouchersAsString) {
        String fileName = "VoucherTXT.txt";
        File txtFile = new File(fileName);
        FileWriter fileWriter;
        try {
            txtFile.createNewFile();
            PrintWriter printWriter = new PrintWriter(fileName);
            fileWriter = new FileWriter(fileName);
            for (String voucher : vouchersAsString) {
                fileWriter.write(voucher);
                System.out.println();
                printWriter.println(voucher);
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
