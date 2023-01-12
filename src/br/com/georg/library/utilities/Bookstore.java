package br.com.georg.library.utilities;

import java.math.BigDecimal;

public class Bookstore {

    private static BigDecimal money = BigDecimal.valueOf(0);

    private Bookstore(){}

    public static void recieveMoney(BigDecimal total) {
        money.add(total);
    }


}
