package org.example;

public class Voucher {
    private String id;
    private int numberOfNights;
    private Offer offer;
    private int numberOfPeople;
    private String validity;
    private String addOns;
    private String roomType;

    public Voucher(Offer offer, int voucherCount, int numberOfNights){
        this.offer = offer;
        id = offer.getId() + "/" + voucherCount;
        this.numberOfNights = numberOfNights;
    }

    @Override
    public String toString() {
        return "Nr vouchera: " + id + ", " + offer.getName() + ", ilość nocy: " + numberOfNights;
    }
}
