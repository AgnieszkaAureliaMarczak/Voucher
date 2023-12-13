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
        if (establishIfEditsNeeded()){
            System.out.println("Edits needed.");
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

    public boolean establishIfEditsNeeded(){
        System.out.println("\nCzy chcesz edytować vouchery?\n" +
                "1. Tak\n" +
                "2. Nie");
        String userAnswer = scanner.nextLine();
        return switch (userAnswer){
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
