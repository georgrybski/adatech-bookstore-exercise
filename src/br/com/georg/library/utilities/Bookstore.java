package br.com.georg.library.utilities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Bookstore {

    private static BigDecimal money = BigDecimal.valueOf(0);

    private static HashMap<Integer, String> categories =
            new HashMap(Map.of(
                    1, "Albums", 2, "Books",
                    3, "Films", 4, "Games",
                    5, "Toys"
            ));
    private static HashMap<String, HashMap<String, InventoryItem>> inventory = new HashMap<>();

    private Bookstore(){}

    public static void recieveMoney(BigDecimal total) {
        money.add(total);
    }

    private void initializeInventory() {
        var inventory = new HashMap<String, HashMap<String, InventoryItem>>();

        categories.values().stream()
                .forEach(category -> inventory.put(category, new HashMap<>()));


    }

}
