package br.com.georg.bookstore.service;

import java.math.BigDecimal;

public class Treasury {
    private final Bookstore bookstore;

    private BigDecimal inventoryValue;
    private BigDecimal capital;

    public Treasury(Bookstore bookstore) {
        this.bookstore = bookstore;
        inventoryValue = BigDecimal.valueOf(0);
        capital = BigDecimal.valueOf(0);
    }

    public void addToCapital(BigDecimal moneyToBeAdded) {
        capital.add(moneyToBeAdded);
    }

    public void addToValueOfAllProductsInStock(BigDecimal addedValue) {
        inventoryValue.add(addedValue);
    }

    public void recieveMoneyFromSale(BigDecimal moneyRecieved) {
        capital.add(moneyRecieved);
        inventoryValue.subtract(moneyRecieved);
    }

    public void recalculateInventoryValueRemovingItem(String ID) {
        BigDecimal removedItemValue = bookstore.getDatabase().getProductByID(ID).getValueOfItemStack();
        inventoryValue.subtract(removedItemValue);
    }

    public void recalculateInventoryValueChangingItemPrice(BigDecimal oldValue, BigDecimal newValue) {
        inventoryValue.subtract(oldValue);
        inventoryValue.add(newValue);
    }

    public BigDecimal getInventoryValue() {
        return inventoryValue;
    }

    public BigDecimal getCapital() {
        return capital;
    }
}
