package org.example;

import java.util.List;

public class ContentCreator {

    public String createAllVouchersAsOneString(Offer offer) {
        List<Voucher> vouchers = offer.getVouchers();
        String vouchersAsString = "";
        for (Voucher voucher : vouchers) {
            vouchersAsString = vouchersAsString + voucher + ". ";
        }
       return vouchersAsString.substring(0,vouchersAsString.length() - 1);
    }
}
