package org.example;

import java.util.List;

public class ContentCreator {

    public String createStringOffer(Offer offer) {
        List<Voucher> vouchers = offer.getVouchers();
        String offerAsString = "";
        for (Voucher voucher : vouchers) {
            offerAsString = offerAsString + voucher + ". ";
        }
       return offerAsString.substring(0,offerAsString.length() - 3);
    }
}
