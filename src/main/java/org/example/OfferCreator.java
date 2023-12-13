package org.example;

import java.util.List;
import java.util.Scanner;

public class OfferCreator {
    private Scanner scanner = new Scanner(System.in);
    private VoucherCreator voucherCreator = new VoucherCreator();
    private ContentFileGenerator contentFileGenerator;

    public OfferCreator(ContentFileGenerator contentFileGenerator) {
        this.contentFileGenerator = contentFileGenerator;
    }

    public void createOfferComponents() {
        Offer offer = createOffer();
        voucherCreator.fillWithVouchers(offer);
        displayVouchers(offer.getVouchers());
        editVouchersIfRequired(offer);
        ContentCreator contentCreator = new ContentCreator();
        String vouchersAsString = contentCreator.createAllVouchersAsOneString(offer);
        contentFileGenerator.createFile(vouchersAsString);
    }


    public Offer createOffer() {
        return new Offer(readId(), readName());
    }

    private String readId() {
        System.out.print("Podaj identyfikator oferty: ");
        return scanner.nextLine();
    }

    private String readName() {
        System.out.print("Podaj nazwę oferty (SEO): ");
        return scanner.nextLine();
    }

    public void displayVouchers(List<Voucher> vouchers) {
        System.out.println();
        System.out.println("Utworzone vouchery:");
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
        }
    }

    private void editVouchersIfRequired(Offer offer) {
       // boolean editsRequired;
       // editsRequired = establishIfEditsNeeded();
        while (establishIfEditsNeeded()) {
            voucherCreator.edit(offer);
           // editsRequired = establishIfEditsNeeded();
        }
    }

    private boolean establishIfEditsNeeded() {
        System.out.println();
        String textBlock = """
                Czy chcesz edytować vouchery?
                Tak - wpisz "1"
                Nie - wpisz "2"
                """;
        System.out.println(textBlock);
        String userAnswer = scanner.nextLine();
        return userAnswer.equals("1");
    }

    @Override
    public String toString() {
        return "OfferCreator{" +
                "voucherCreator=" + voucherCreator +
                '}';
    }
}
