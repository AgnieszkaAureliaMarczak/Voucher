package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dlugiTekst = "To jest długi tekst, który chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst1 = "dlugiTekst1: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst2 = "dlugiTekst2: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst3 = "dlugiTekst3: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst4 = "dlugiTekst4: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst5 = "dlugiTekst5: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst6 = "dlugiTekst6: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst7 = "dlugiTekst7: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst8 = "dlugiTekst8: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst9 = dlugiTekst1;
        String dlugiTekst10 = dlugiTekst2;
        String dlugiTekst11 = dlugiTekst3;

        List<String> testoweVouchery = new ArrayList<>();
        testoweVouchery.add(dlugiTekst);
        testoweVouchery.add(dlugiTekst1);
        testoweVouchery.add(dlugiTekst2);
        testoweVouchery.add(dlugiTekst3);
        testoweVouchery.add(dlugiTekst4);
        testoweVouchery.add(dlugiTekst5);
        testoweVouchery.add(dlugiTekst6);
        testoweVouchery.add(dlugiTekst7);
        testoweVouchery.add(dlugiTekst8);
        testoweVouchery.add(dlugiTekst9);
        testoweVouchery.add(dlugiTekst10);
        testoweVouchery.add(dlugiTekst11);

        new ContentFilePDFGenerator().createFile(testoweVouchery);

        System.exit(0);
        OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator());
        offerCreator.createOfferComponents();
    }
}
