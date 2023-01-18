package br.com.georg.bookstore.utilities.printer;

import br.com.georg.bookstore.service.Order;

import java.util.ArrayList;

import static br.com.georg.bookstore.utilities.printer.Printer.printFrameLine;
import static br.com.georg.bookstore.utilities.printer.Printer.printIndentedFormattedLine;

public class OrderPrinter {

    public static void printAllOrdersFromList(ArrayList<Order> orders) {
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



}
