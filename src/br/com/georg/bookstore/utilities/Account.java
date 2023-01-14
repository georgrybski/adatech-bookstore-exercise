package br.com.georg.bookstore.utilities;

public class Account {
    private String username;
    private String password;
    private Bookstore bookstore;
    private ShoppingCart shoppingCart;

    protected Account(String username, String password, Bookstore bookstore) {
        this.username = username;
        this.password = password;
        this.bookstore = bookstore;
        shoppingCart = new ShoppingCart(this, bookstore);
    }

    public void purchaseItemsInCart() {
        shoppingCart.checkout();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bookstore getBookstore() {
        return bookstore;
    }

    public void setBookstore(Bookstore bookstore) {
        this.bookstore = bookstore;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
