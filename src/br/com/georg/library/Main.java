package br.com.georg.library;

import br.com.georg.library.utilities.Bookstore;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        var hashMap = Bookstore.getInventory();

        System.out.println();
        System.out.println();

        for (Map.Entry<String, HashMap<String, HashMap<String, InventoryItem>>> outerEntry : hashMap.entrySet()) {
            System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
            System.out.println();
            for (Map.Entry<String, HashMap<String, InventoryItem>> innerEntry : outerEntry.getValue().entrySet()) {
                System.out.println("    Inner key: " + innerEntry.getKey() + " | Inner value: " + innerEntry.getValue());
            }
            System.out.println();
        }

    }
}
