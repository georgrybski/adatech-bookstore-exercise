package br.com.ada.georg.bookstore.controller.bookstore;

import br.com.ada.georg.bookstore.models.Product;
import br.com.ada.georg.bookstore.models.ProductCategories;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dashboard {

    private final Bookstore bookstore;
    private final HashMap<String, Integer> productInventoryQuantityDashboard;

    private final HashMap<String, BigDecimal> productInventoryValueDashboard;
    private final HashMap<String, Integer> productSalesQuantityDashboard;

    private final HashMap<String, BigDecimal> productSalesValueDashboard;

    public Dashboard(Bookstore bookstore) {
        this.bookstore = bookstore;
        productInventoryQuantityDashboard = DashboardTools.initializeProductQuantityDashboard();
        productInventoryValueDashboard = DashboardTools.initializeProductValueDashboard();
        productSalesQuantityDashboard = DashboardTools.initializeProductQuantityDashboard();
        productSalesValueDashboard = DashboardTools.initializeProductValueDashboard();
    }

    public void recieveNewProductData(Product newProduct, String category) {
        productInventoryQuantityDashboard.put(category, productInventoryQuantityDashboard.get(category) + newProduct.getQuantity());
        productInventoryValueDashboard.put(category, productInventoryValueDashboard.get(category).add(newProduct.getValueOfItemStack()));
    }

    public void recieveSaleData(Order order) {
        List<Product> items = order.getItems();
        items.stream().forEach(product -> {

            productInventoryQuantityDashboard.put(
                    product.getCategory(),
                    productInventoryQuantityDashboard.get(product.getCategory()) - product.getQuantity()
            );

            productSalesQuantityDashboard.put(
                    product.getCategory(),
                    productSalesQuantityDashboard.get(product.getCategory()) + product.getQuantity()
            );

            productInventoryValueDashboard.put(
                    product.getCategory(),
                    productInventoryValueDashboard.get(product.getCategory()).subtract(product.getValueOfItemStack())
            );

            productSalesValueDashboard.put(
                    product.getCategory(),
                    productSalesValueDashboard.get(product.getCategory()).add(product.getValueOfItemStack())
            );

        });
    }
    public void recieveProductUpdateData(Product oldProduct, Product newProduct) {
        productInventoryQuantityDashboard.put(oldProduct.getCategory(), productInventoryQuantityDashboard.get(oldProduct.getCategory()) - oldProduct.getQuantity() + newProduct.getQuantity());
        productInventoryValueDashboard.put(oldProduct.getCategory(), productInventoryValueDashboard.get(oldProduct.getCategory()).subtract(oldProduct.getValueOfItemStack()).add(newProduct.getValueOfItemStack()));
    }

    public void recieveProductRemovalData(String ID) {
        Product product = bookstore.getDatabase().getProductByID(ID);
        productInventoryQuantityDashboard.put(product.getCategory(), productInventoryQuantityDashboard.get(product.getCategory()) - product.getQuantity());
        productInventoryValueDashboard.put(product.getCategory(), productInventoryValueDashboard.get(product.getCategory()).subtract(product.getValueOfItemStack()));
    }

    public BigDecimal getTotalProductInventoryValue() {
        return productInventoryValueDashboard.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getTotalProductInventoryQuantity() {
        return productInventoryQuantityDashboard.values().stream().mapToInt(Integer::intValue).sum();
    }

    public BigDecimal getTotalProductSalesValue() {
        return productSalesValueDashboard.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getTotalProductSalesQuantity() {
        return productSalesQuantityDashboard.values().stream().mapToInt(Integer::intValue).sum();
    }

    public HashMap<String, Integer> getProductInventoryQuantityDashboard() {
        return productInventoryQuantityDashboard;
    }

    public HashMap<String, BigDecimal> getProductInventoryValueDashboard() {
        return productInventoryValueDashboard;
    }

    public HashMap<String, Integer> getProductSalesQuantityDashboard() {
        return productSalesQuantityDashboard;
    }

    public HashMap<String, BigDecimal> getProductSalesValueDashboard() {
        return productSalesValueDashboard;
    }

    private static class DashboardTools {
        private static HashMap<String, Integer> initializeProductQuantityDashboard() {
            var productDashboard = new HashMap<String, Integer>();
            Arrays.stream(ProductCategories.getCategoriesArray()).forEach(category -> productDashboard.put(category, 0));
            return productDashboard;
        }

        private static HashMap<String, BigDecimal> initializeProductValueDashboard() {
            var productDashboard = new HashMap<String, BigDecimal>();
            Arrays.stream(ProductCategories.getCategoriesArray()).forEach(category -> productDashboard.put(category, BigDecimal.valueOf(0)));
            return productDashboard;
        }

    }

}
