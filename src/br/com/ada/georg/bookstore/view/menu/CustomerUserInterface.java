package br.com.ada.georg.bookstore.view.menu;

import br.com.ada.georg.bookstore.controller.FlowController;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;
import br.com.ada.georg.bookstore.util.Printer;
import br.com.ada.georg.bookstore.view.input.ProductInput;

public class CustomerUserInterface {

    private final FlowController controller;
    private final Bookstore bookstore;

    public CustomerUserInterface(FlowController controller) {
        this.controller = controller;
        this.bookstore = controller.getBookstore();
    }

    public void run() {

        if (controller.noAccountLoggedIn()) return;

        if (controller.customerLoggedIn()) {
            switch (Menu.getCustomerInput()) {
                // Browse all products
                case (1) -> Menu.seeProductList(bookstore);
                // Add a product to shopping cart
                case (2) -> ProductInput.addProductToCartUsingID(bookstore, controller.getLoggedAccount());
                // Go to shopping cart
                case (3) ->  Menu.goToCart(bookstore, controller.getLoggedAccount());
                // See my purchase history
                case (4) -> controller.getLoggedAccount().viewOrders();
                // Log out
                case (5) -> controller.setLoggedAccount(null);
                // Exit
                case (6) -> {
                    controller.closeApplication();
                    Printer.printFormattedMessage("Thanks for visiting my Bookstore!");
                }
            }
        }
    }
}
