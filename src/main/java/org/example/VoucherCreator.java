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
            int numberOfNights = readNumberOfNights(i);
            int numberOfPeople = readNumberOfPeople(i);
            scanner.nextLine();
            String roomType = readRoomType(i);
            String addOns = readAddOns(i);
            String validity = readRestrictions(i);
            vouchers.add(new Voucher(offer, vouchers.size() + 1, numberOfNights, numberOfPeople,
                    roomType, addOns, validity));
        }
        offer.setVouchers(vouchers);
    }

    private int readNumberOfVouchers() {
        System.out.print("Podaj liczbę voucherów do utworzenia: ");
        return scanner.nextInt();
    }

    private int readNumberOfNights(int voucherCount) {
        System.out.print("Voucher nr " + voucherCount + ": podaj liczbę nocy: ");
        return scanner.nextInt();
    }

    private int readNumberOfPeople(int voucherCount) {
        System.out.print("Voucher nr " + voucherCount + ": podaj liczbę osób: ");
        return scanner.nextInt();
    }

    private String readRoomType(int voucherCount) {
        System.out.print("Voucher nr " + voucherCount + ": podaj rodzaj pokoju: ");
        return scanner.nextLine();
    }

    private String readAddOns(int voucherCount) {
        System.out.print("Voucher nr " + voucherCount + ": podaj wliczone dodatki np. śniadanie: ");
        return scanner.nextLine();
    }

    private String readRestrictions(int voucherCount) {
        System.out.print("Voucher nr " + voucherCount + ": podaj ograniczenia w wykorzystaniu vouchera: ");
        return scanner.nextLine();
    }

    public void edit(Offer offer) {
        Voucher voucherToEdit = getVoucherToEdit(offer);
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
        switch (scanner.nextInt()) {
            case 1 -> readNumberOfNights(Integer.parseInt(voucherToEdit.getId()));
            case 2 -> readNumberOfPeople(Integer.parseInt(voucherToEdit.getId()));
            case 3 -> readRoomType(Integer.parseInt(voucherToEdit.getId()));
            case 4 -> readRestrictions(Integer.parseInt(voucherToEdit.getId()));
            case 5 -> readAddOns(Integer.parseInt(voucherToEdit.getId()));
            default -> {
            }
        }
        scanner.nextLine();
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

    private String readVoucherId() {
        System.out.print("Podaj id vouchera, którego chcesz edytować: ");
        return scanner.nextLine();
    }
}
