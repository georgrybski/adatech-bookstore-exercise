package br.com.georg.library.utilities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Bookstore {

    private static BigDecimal money = BigDecimal.valueOf(0);

    private static HashMap<Integer, String> categories =
            new HashMap(Map.of(
                    1, "albums", 2, "books",
                    3, "films", 4, "games",
                    5, "toys"
            ));
    private static HashMap<String, HashMap<String, InventoryItem>> inventory = new HashMap<>();

    private Bookstore(){}

    public static void recieveMoney(BigDecimal total) {
        money.add(total);
    }

    private HashMap<String, HashMap<String, InventoryItem>> initializeInventory() {
        var inventory = new HashMap<String, HashMap<String, InventoryItem>>();

        categories.values().stream()
                .forEach(category -> inventory.put(category, new HashMap<>()));

        return inventory;
    }

}
