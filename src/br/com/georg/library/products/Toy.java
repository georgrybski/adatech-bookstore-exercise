package br.com.georg.library.products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Toy extends Product {
    private String type;
    private static Map<Integer,String> types = new HashMap(Map.of());
//    private static Stream<Map.Entry<Integer,String>> typesStream = types.entrySet().stream();
    private static String[] typeMenuOptions =
        types.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);

    public Toy(String name, BigDecimal price, Integer quantity, Integer type){
        super(name, price, quantity);
        this.type = types.get(type);
    }

    public String getType() {
        return type;
    }

    public static Map<Integer, String> getTypes() {
        return types;
    }

    public static String[] getTypeMenuOptions() {
        return typeMenuOptions;
    }
}
