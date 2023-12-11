package org.example;

public class Voucher {
    private Offer offer;
    private String id;
    private int numberOfNights;
    private int numberOfPeople;
    private String roomType;
    private String addOns;
    private String validity;



    public Voucher(Offer offer, int voucherCount, int numberOfNights, int numberOfPeople, String roomType,
                   String addOns) {
        this.offer = offer;
        id = offer.getId() + "/" + voucherCount;
        this.numberOfNights = numberOfNights;
        this.numberOfPeople = numberOfPeople;
        this.roomType = roomType;
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "Nr vouchera: " + id + ", " + offer.getName() + ", liczba nocy: " + numberOfNights +
                ", liczba osób: " + numberOfPeople + ", rodzaj pokoju: " + roomType +
                ", wliczone dodatki: " + addOns;
    }
}
