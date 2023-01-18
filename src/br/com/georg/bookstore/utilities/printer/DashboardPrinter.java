package br.com.georg.bookstore.utilities.printer;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.service.Bookstore;
import br.com.georg.bookstore.service.Dashboard;

public class DashboardPrinter {

    public static void printDashboard(Bookstore bookstore) {
        Dashboard dashboard = bookstore.getDashboard();

        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(" ");
        Printer.printIndentedFormattedLine(bookstore.getName() + "'s Product Info");
        Printer.printIndentedFormattedLine(" ");
        Printer.printIndentedFormattedLine("Current Inventory");
        for (String category : Product.getCategoriesArray()) {
            Printer.printIndentedFormattedLine(" ");
            Printer.printIndentedFormattedLine(
                    category + ": " + dashboard.getProductQuantityDashboard().get(category) +
                    " items valued at " + dashboard.getProductValueDashboard().get(category) + " USD");
        }
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine("Total: " + dashboard.getTotalProductQuantity() + " items valued at " + dashboard.getTotalProductValue() + " USD");
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(" ");
        Printer.printFrameLine();
    }
}
