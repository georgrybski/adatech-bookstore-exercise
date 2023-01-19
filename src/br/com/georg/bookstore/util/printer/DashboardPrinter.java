package br.com.georg.bookstore.util.printer;

import br.com.georg.bookstore.products.ProductCategories;
import br.com.georg.bookstore.service.Bookstore;
import br.com.georg.bookstore.service.Dashboard;

public class DashboardPrinter {

    public static void printDashboard(Bookstore bookstore) {
        Dashboard dashboard = bookstore.getDashboard();

        Printer.printFrameLine();
        Printer.printIndentedFormattedLine("Product Dashboard");
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(" ");
        Printer.printIndentedFormattedLine(" ");
        Printer.printIndentedFormattedLine("Current Inventory Data");
        Printer.printIndentedFormattedLine(" ");
        for (String category : ProductCategories.getCategoriesArray()) {
            Printer.printIndentedFormattedLine(" ");
            Printer.printIndentedFormattedLine(
                    category + ": " + dashboard.getProductInventoryQuantityDashboard().get(category) +
                    " items valued at " + dashboard.getProductInventoryValueDashboard().get(category) + " USD");
        }
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine("Total: " + dashboard.getTotalProductInventoryQuantity() + " items valued at " + dashboard.getTotalProductInventoryValue() + " USD");
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(" ");
        Printer.printIndentedFormattedLine(" ");

        Printer.printIndentedFormattedLine("Current Sales Data");
        Printer.printIndentedFormattedLine(" ");
        for (String category : ProductCategories.getCategoriesArray()) {
            Printer.printIndentedFormattedLine(" ");
            Printer.printIndentedFormattedLine(
                    category + ": " + dashboard.getProductSalesQuantityDashboard().get(category) +
                    " items sold, resulting in a total of " + dashboard.getProductSalesValueDashboard().get(category) + " USD");
        }
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(dashboard.getTotalProductSalesQuantity() + " items sold, resulting in a total of " + dashboard.getTotalProductSalesValue() + " USD");
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(" ");
        Printer.printFrameLine();
    }
}
