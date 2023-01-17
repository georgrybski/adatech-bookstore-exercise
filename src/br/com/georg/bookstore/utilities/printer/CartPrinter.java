package br.com.georg.bookstore.utilities.printer;

import br.com.georg.bookstore.service.Account;
import br.com.georg.bookstore.service.ShoppingCart;

public class CartPrinter {

    public static void printShoppingCart(Account account) {
        ShoppingCart cart = account.getShoppingCart();

        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(account.getUsername() + "'s Shopping cart");

        Printer.printFormattedMultiLineString("");
        Printer.printFormattedMultiLineString("Items");

        cart.getItems().stream()
                .map(product -> "ID: " + product.getID() + " | Name: " + product.getName() + " | Quantity: " + product.getQuantity() + " | " + product.getPrice() + " USD/Unit")
                .forEach(Printer::printFormattedMultiLineString);




        Printer.printIndentedFormattedLine("Total: " + cart.getTotal() + " USD");
        Printer.printFrameLine();
    }

}
