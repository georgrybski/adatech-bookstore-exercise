package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;

import java.util.Arrays;
import java.util.HashMap;

public class Dashboard {

    private Bookstore bookstore;
    private HashMap<String, Integer> productDashboard;

    public Dashboard(Bookstore bookstore) {
        this.bookstore = bookstore;
        productDashboard = DashboardTools.initializeProductDashboard();
    }

    private static class DashboardTools {
        private static HashMap<String, Integer> initializeProductDashboard() {
            var productDashboard = new HashMap<String, Integer>();
            Arrays.stream(Product.getCategoriesArray()).forEach(category -> productDashboard.put(category, 0));
            return productDashboard;
        }
    }

}
