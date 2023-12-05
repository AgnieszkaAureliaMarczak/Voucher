package org.example;

import java.util.ArrayList;
import java.util.List;

public class Offer {
    private String id;
    private String name;
    private List<Voucher> vouchers = new ArrayList<>();

    public Offer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
