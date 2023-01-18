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

    public void recalculateInventoryValueRemovingItem(String ID) {
        BigDecimal removedItemValue = bookstore.getDatabase().getProductByID(ID).getValueOfItemStack();
    }

    public BigDecimal getCapital() {
        return capital;
    }
}
