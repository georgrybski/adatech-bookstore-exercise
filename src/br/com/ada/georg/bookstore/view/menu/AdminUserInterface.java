package br.com.ada.georg.bookstore.view.menu;

import br.com.ada.georg.bookstore.controller.FlowController;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;
import br.com.ada.georg.bookstore.util.DashboardPrinter;
import br.com.ada.georg.bookstore.util.OrderPrinter;
import br.com.ada.georg.bookstore.util.Printer;
import br.com.ada.georg.bookstore.view.input.ProductInput;

public class AdminUserInterface {

    private final FlowController controller;
    private final Bookstore bookstore;

    public AdminUserInterface(FlowController controller) {
        this.controller = controller;
        this.bookstore = controller.getBookstore();
    }

    public void run() {

        if (controller.noAccountLoggedIn()) return;
        if (controller.adminLoggedIn()) {
            switch (Menu.getAdminInput()) {
                // See products list
                case (1) -> Menu.seeProductList(bookstore);
                // Add new product
                case (2) -> Menu.addProduct(bookstore);
                // Modify an existing product
                case (3) -> ProductInput.modifyExistingProduct(bookstore);
                // Remove a product
                case (4) -> ProductInput.removeProductUsingID(bookstore);
                // See Dashboard
                case (5) -> DashboardPrinter.printDashboard(bookstore);
                // See sales history
                case (6) -> OrderPrinter.printAllOrders(bookstore);
                // Log out
                case (7) -> controller.setLoggedAccount(null);
                // Exit
                case (8) -> {
                    controller.closeApplication();
                    Printer.printFormattedMessage("Thanks for visiting my Bookstore!");
                }
            }
        }
    }
}
