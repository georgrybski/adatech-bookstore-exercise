package br.com.georg.bookstore.util.menu;

import br.com.georg.bookstore.products.ProductCategories;

public class MenuOptions {

    protected static final String[] PRODUCT_CATEGORY_MENU_OPTIONS =
            MenuTools.createCategoryGenreAndTypeMenuOptions(ProductCategories.getCategories());

    protected static final String[] LOGGED_OUT_MENU_OPTIONS = {
            "1 - Create an account", " 2 - Log in", "3 - Exit"
    };

    protected static final String[] CUSTOMER_MENU_OPTIONS = {
            "1 - Browse all products", "2 -  Add a product to shopping cart", "3 - Go to shopping cart",
            "4 - See my purchase history", "5 - Log out", "6 - Exit"
    };


    protected static final String[] ADMIN_MENU_OPTIONS = {
            "1 - See products list", "2 - Add new product", "3 - Modify an existing product",
            "4 - Remove a product", "5 - See sales dashboard", "6 - See sales history", "7 - Log out", "8 - Exit"
    };

    protected static String[] getLoggedOutMenuOptions() {
        return LOGGED_OUT_MENU_OPTIONS;
    }

    protected static String[] getCustomerMenuOptions() {
        return CUSTOMER_MENU_OPTIONS;
    }

    protected static String[] getAdminMenuOptions() {
        return ADMIN_MENU_OPTIONS;
    }

    protected static String[] getProductCategoryMenuOptions() {
        return PRODUCT_CATEGORY_MENU_OPTIONS;
    }

}
