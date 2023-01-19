package br.com.georg.bookstore.util.printer;

import br.com.georg.bookstore.service.Account;
import br.com.georg.bookstore.service.ShoppingCart;

public class CartPrinter {

    public static void printShoppingCart(Account account) {
        ShoppingCart cart = account.getShoppingCart();

        Printer.printFrameLine();
        Printer.printIndentedFormattedLine("Shopping cart");

        Printer.printFormattedMultiLineString("");
        Printer.printFormattedMultiLineString("Items");
        Printer.printFormattedMultiLineString(" ");

        cart.getItems().stream()
                .forEach(product -> {
                    Printer.printFormattedMultiLineString("ID: " + product.getProduct().getID() + " | Name: " + product.getProduct().getName());
                    Printer.printFormattedMultiLineString( " Quantity: " + product.getQuantity() + " | " + product.getProduct().getPrice() + " USD/Unit");
                    Printer.printFormattedMultiLineString("");
                });

        Printer.printIndentedFormattedLine("Total: " + cart.getTotal() + " USD");
        Printer.printFrameLine();
    }

}
