package org.example;

public class Voucher {
    private Offer offer;
    private String id;
    private int numberOfNights;
    private int numberOfPeople;
    private String roomType;
    private String validity;
    private String addOns;


    public Voucher(Offer offer, int voucherCount, int numberOfNights, int numberOfPeople){
        this.offer = offer;
        id = offer.getId() + "/" + voucherCount;
        this.numberOfNights = numberOfNights;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Nr vouchera: " + id + ", " + offer.getName() + ", liczba nocy: " + numberOfNights +
                ", liczba osób: " + numberOfPeople;
    }
}
