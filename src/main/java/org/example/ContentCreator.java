package org.example;

import java.util.ArrayList;
import java.util.List;


public class ContentCreator {

    public List<String> createAllVouchersAsString(List<Voucher> vouchers) {
        List<String> vouchersAsStrings = new ArrayList<>();
        for (Voucher voucher : vouchers) {
            vouchersAsStrings.add(voucher.toString());
        }
        return vouchersAsStrings;
    }
}
