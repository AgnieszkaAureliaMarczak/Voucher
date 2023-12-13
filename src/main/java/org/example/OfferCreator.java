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
        if (establishIfEditsNeeded()) {
            voucherCreator.edit(offer);
        }
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

    private boolean establishIfEditsNeeded() {
        String textBlock = """
                Czy chcesz edytować vouchery?
                1. Tak
                2. Nie
                """;
        System.out.println(textBlock);
        String userAnswer = scanner.nextLine();
        return switch (userAnswer) {
            case "1" -> true;
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "OfferCreator{" +
                "voucherCreator=" + voucherCreator +
                '}';
    }
}
