package br.com.ada.georg.bookstore.util.printer;

import br.com.ada.georg.bookstore.service.Bookstore;
import br.com.ada.georg.bookstore.service.Order;

import java.util.ArrayList;

import static br.com.ada.georg.bookstore.util.printer.Printer.printFrameLine;
import static br.com.ada.georg.bookstore.util.printer.Printer.printIndentedFormattedLine;

public class OrderPrinter {

    public static void printOrdersFromList(ArrayList<Order> orders) {
        orders.stream().forEach(OrderPrinter::printOrder);
    }


    public static void printOrder(Order order) {
        printFrameLine();
        printIndentedFormattedLine("User: " + order.getUsername() + " | Date: " + order.getDate());
        printIndentedFormattedLine("Total: " + order.getTotal() + " USD");
        printIndentedFormattedLine(" ");
        printIndentedFormattedLine("Items:");
        printIndentedFormattedLine(" ");

                order.getItems().forEach(product -> {
                    Printer.printFormattedMultiLineString("ID: " + product.getID() + " | Name: " + product.getName());
                    Printer.printFormattedMultiLineString( " Quantity: " + product.getQuantity() + " | " + product.getPrice() + " USD/Unit");
                    Printer.printFormattedMultiLineString("");
                });

        printFrameLine();
    }

    public static void printAllOrders(Bookstore bookstore) {
        bookstore.getDatabase().getOrdersHashMap().values().forEach(OrderPrinter::printOrdersFromList);
    }

}
