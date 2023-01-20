package br.com.ada.georg.bookstore;

import br.com.ada.georg.bookstore.controller.FlowController;
import br.com.ada.georg.bookstore.controller.distribuitor.ProductDistribuitor;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;

public class BookstoreApplication {
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();
        ProductDistribuitor distribuitor = new ProductDistribuitor();
        distribuitor.deliverProductShippment(bookstore);
        new FlowController(bookstore).run();

    }
}