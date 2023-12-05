package org.example;

public class Voucher {
    private String id;
    private int numberOfNights;
    private int numberOfPeople;
    private String validity;
    private String addOns;
    private String roomType;

    public Voucher(String offerId, int voucherCount, int numberOfNights){
        id = offerId + "/" + voucherCount;
        this.numberOfNights = numberOfNights;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id='" + id + '\'' +
                ", numberOfNights=" + numberOfNights +
                '}';
    }
}
