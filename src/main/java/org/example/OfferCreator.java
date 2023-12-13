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
            Voucher voucherToEdit = getVoucherToEdit(offer);

        }

        ContentCreator contentCreator = new ContentCreator();
        String vouchersAsString = contentCreator.createAllVouchersAsOneString(offer);
        contentFileGenerator.createFile(vouchersAsString);
    }

    private Voucher getVoucherToEdit(Offer offer) {
        boolean correctVoucherId;
        Voucher voucherToEdit = null;
        do {
            correctVoucherId = true;
            String voucherId = readVoucherId();
            for (Voucher voucher : offer.getVouchers()) {
                if (voucher.getId().equals(voucherId)) {
                    voucherToEdit = voucher;
                    return voucherToEdit;
                } else {
                    System.out.println("Podano niepoprawny id vouchera");
                    correctVoucherId = false;
                }
            }
        } while (!correctVoucherId);
        return voucherToEdit;
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
        System.out.println("\nCzy chcesz edytować vouchery?\n" +
                "1. Tak\n" +
                "2. Nie");
        String userAnswer = scanner.nextLine();
        return switch (userAnswer) {
            case "1" -> true;
            default -> false;
        };
    }

    private String readVoucherId() {
        System.out.print("Podaj id vouchera, którego chcesz edytować: ");
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return "OfferCreator{" +
                "voucherCreator=" + voucherCreator +
                '}';
    }
}
