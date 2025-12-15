package ecommerce;

import java.util.List;
import java.util.Map;

public class OrderContext {

    private Map<String, String> customer;
    private List<CartItem> cart;

    private double subtotal;
    private double tax;
    private double total;

    public OrderContext(Map<String, String> customer, List<CartItem> cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public Map<String, String> getCustomer() {
        return customer;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
