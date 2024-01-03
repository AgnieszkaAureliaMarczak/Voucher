package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dlugiTekst = "To jest długi tekst, który chcemy zawinąć do nowej linii. " +
                "Powinien być odpowiednio zawinięty, jeśli jego szerokość przekroczy określoną wartość. " +
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
        String dlugiTekst9 = "dlugiTekst9: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst10 = "dlugiTekst10: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";
        String dlugiTekst11 = "dlugiTekst11: >>>> To jest dlugi tekst, ktory chcemy zawinac do nowej linii. " +
                "Powinien byc odpowiednio zawiniety, jesli jego szerokosc przekroczy okreslona wartosc. " +
                "To jest dlugi tekst, ktory chcemy zawinac do nowej linii. Powinien byc odpowiednio zawiniety, " +
                "jesli jego szerokosc przekroczy okreslona wartosc.";

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
        testoweVouchery.add(dlugiTekst9.toUpperCase());
        testoweVouchery.add(dlugiTekst10.toUpperCase());
        testoweVouchery.add(dlugiTekst11.toUpperCase());

        new ContentFilePDFGenerator().createFile(testoweVouchery);

        System.exit(0);
        OfferCreator offerCreator = new OfferCreator(new ContentFilePDFGenerator());
        offerCreator.createOfferComponents();
    }
}
