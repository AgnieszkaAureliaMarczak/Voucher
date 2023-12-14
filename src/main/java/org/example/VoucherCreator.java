package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VoucherCreator {

    Scanner scanner = new Scanner(System.in);

    public void fillWithVouchers(Offer offer) {
        List<Voucher> vouchers = new ArrayList<>();
        int numberOfVouchers = readNumberOfVouchers();
        for (int i = 1; i <= numberOfVouchers; i++) {
            int numberOfNights = readNumberOfNights(Integer.toString(i));
            int numberOfPeople = readNumberOfPeople(Integer.toString(i));
            String roomType = readRoomType(Integer.toString(i));
            String addOns = readAddOns(Integer.toString(i));
            String validity = readRestrictions(Integer.toString(i));
            vouchers.add(new Voucher(offer, vouchers.size() + 1, numberOfNights, numberOfPeople,
                    roomType, addOns, validity));
        }
        offer.setVouchers(vouchers);
    }

    private int readNumberOfVouchers() {
        System.out.print("Podaj liczbę voucherów do utworzenia: ");
        int numberOfVouchers = scanner.nextInt();
        scanner.nextLine();
        return numberOfVouchers;
    }

    private int readNumberOfNights(String voucherNumber) {
        System.out.print("Voucher nr " + voucherNumber + ": podaj liczbę nocy: ");
        int numberOfNights = scanner.nextInt();
        scanner.nextLine();
        return numberOfNights;
    }

    private int readNumberOfPeople(String voucherNumber) {
        System.out.print("Voucher nr " + voucherNumber + ": podaj liczbę osób: ");
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine();
        return numberOfPeople;
    }

    private String readRoomType(String voucherNumber) {
        System.out.print("Voucher nr " + voucherNumber + ": podaj rodzaj pokoju: ");
        return scanner.nextLine();
    }

    private String readAddOns(String voucherNumber) {
        System.out.print("Voucher nr " + voucherNumber + ": podaj wliczone dodatki np. śniadanie: ");
        return scanner.nextLine();
    }

    private String readRestrictions(String voucherNumber) {
        System.out.print("Voucher nr " + voucherNumber + ": podaj ograniczenia w wykorzystaniu vouchera: ");
        return scanner.nextLine();
    }

    public void edit(Offer offer) {
        Voucher voucherToEdit = readVoucherToEdit(offer);
        editFields(voucherToEdit);
        displayEditedVoucher(voucherToEdit);
    }

    private Voucher readVoucherToEdit(Offer offer) {
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
                    System.out.println("Podano niepoprawny nr vouchera");
                    correctVoucherId = false;
                }
            }
        } while (!correctVoucherId);
        return voucherToEdit;
    }

    private String readVoucherId() {
        System.out.print("Podaj nr vouchera, którego chcesz edytować: ");
        return scanner.nextLine();
    }

    private void editFields(Voucher voucherToEdit){
        boolean editsRequired;
        do {
            displayFieldsToEdit();
            editsRequired = readAndSetFieldsToEdit(voucherToEdit);
        } while (editsRequired);
    }

    private void displayFieldsToEdit() {
        String textBlock = """
                Które pole chcesz edytować?
                1. Liczba nocy
                2. Liczba osób
                3. Rodzaj pokoju
                4. Wliczone dodatki
                5. Restrykcje
                6. Żadne (wyjście)
                """;
        System.out.println(textBlock);
    }

    private boolean readAndSetFieldsToEdit(Voucher voucherToEdit) {
        boolean editsRequired = true;
        int userInput = scanner.nextInt();
        scanner.nextLine();
        switch (userInput) {
            case 1 -> voucherToEdit.setNumberOfNights(readNumberOfNights(voucherToEdit.getId()));
            case 2 -> voucherToEdit.setNumberOfPeople(readNumberOfPeople(voucherToEdit.getId()));
            case 3 -> voucherToEdit.setRoomType(readRoomType(voucherToEdit.getId()));
            case 4 -> voucherToEdit.setAddOns(readAddOns(voucherToEdit.getId()));
            case 5 -> voucherToEdit.setRestrictions(readRestrictions(voucherToEdit.getId()));
            default -> editsRequired = false;
        }
        return editsRequired;
    }

    private void displayEditedVoucher(Voucher voucherToEdit){
        System.out.println("Wyedytowany voucher:");
        System.out.println(voucherToEdit);
    }
}
