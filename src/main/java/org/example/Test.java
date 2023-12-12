package org.example;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        File newFile = new File("C:/Projekty Java/Voucher/VoucherTXT.txt");
        try{
            newFile.createNewFile();
        } catch (IOException e){
            System.out.println("Nie znaleziono pliku");
        }
    }
}
