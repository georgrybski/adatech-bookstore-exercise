package br.com.georg.bookstore.utilities.printer;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.service.Order;

import java.util.ArrayList;

import static br.com.georg.bookstore.utilities.printer.Printer.printFrameLine;
import static br.com.georg.bookstore.utilities.printer.Printer.printIndentedFormattedLine;

public class OrderPrinter {

    public static void printAllOrdersFromList(ArrayList<Order> orders) {
        orders.stream().forEach(OrderPrinter::printOrder);
    }

    // TODO
    public static void printOrder(Order order) {
        printFrameLine();
        printIndentedFormattedLine("User: " + order.getUsername() + " | Date: " + order.getDate());
        printIndentedFormattedLine("Total: " + order.getTotal() + " USD");
        printIndentedFormattedLine(" ");
        for (Product product: order.getItems()) {
            printIndentedFormattedLine(product.toString());
        }
        printFrameLine();
    }

}
