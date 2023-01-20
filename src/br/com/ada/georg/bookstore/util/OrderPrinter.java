package br.com.ada.georg.bookstore.util;

import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;
import br.com.ada.georg.bookstore.controller.bookstore.Order;

import java.util.ArrayList;

public class OrderPrinter {

    public static void printOrdersFromList(ArrayList<Order> orders) {
        orders.stream().forEach(OrderPrinter::printOrder);
    }


    public static void printOrder(Order order) {
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine("User: " + order.getUsername() + " | Date: " + order.getDate());
        Printer.printIndentedFormattedLine("Total: " + order.getTotal() + " USD");
        Printer.printIndentedFormattedLine(" ");
        Printer.printIndentedFormattedLine("Items:");
        Printer.printIndentedFormattedLine(" ");

                order.getItems().forEach(product -> {
                    Printer.printFormattedMultiLineString("ID: " + product.getID() + " | Name: " + product.getName());
                    Printer.printFormattedMultiLineString( " Quantity: " + product.getQuantity() + " | " + product.getPrice() + " USD/Unit");
                    Printer.printFormattedMultiLineString("");
                });

        Printer.printFrameLine();
    }

    public static void printAllOrders(Bookstore bookstore) {
        bookstore.getDatabase().getOrdersHashMap().values().forEach(OrderPrinter::printOrdersFromList);
    }

}
