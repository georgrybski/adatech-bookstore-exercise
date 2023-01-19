package br.com.georg.bookstore.service;

import java.math.BigDecimal;

public class Treasury {
    private final Bookstore bookstore;

    private BigDecimal capital;

    public Treasury(Bookstore bookstore) {
        this.bookstore = bookstore;;
        capital = BigDecimal.valueOf(0);
    }

    public void recieveMoneyFromSale(BigDecimal moneyRecieved) {
        capital.add(moneyRecieved);
    }

}
