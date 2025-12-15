import java.util.List;
import java.util.Map;

public class OrderProcessing {

    public static void validateCart(OrderContext context) {
        if (context.getCart().isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        System.out.println("Cart validated");
    }

    public static void calculateTotals(OrderContext context) {
        double subtotal = 0.0;

        for (CartItem item : context.getCart()) {
            subtotal += item.getPrice() * item.getQuantity();
        }

        double tax = subtotal * 0.18;
        double total = subtotal + tax;

        context.setSubtotal(subtotal);
        context.setTax(tax);
        context.setTotal(total);

        System.out.println("Totals calculated: " + total);
    }

    public static void reserveInventory(OrderContext context) {
        for (CartItem item : context.getCart()) {
            System.out.println(
                "Reserved " + item.getQuantity() + " units of " + item.getName()
            );
        }
    }

    public static void processPayment(OrderContext context) {
        System.out.println(
            "Payment processed: " + context.getTotal()
        );
    }

    public static void sendConfirmation(OrderContext context) {
        System.out.println(
            "Confirmation email sent to " +
            context.getCustomer().get("email")
        );
    }

    public static void processOrder(
            OrderContext context,
            String paymentMode,
            boolean notifyCustomer,
            String inventoryMode
    ) {

        validateCart(context);
        calculateTotals(context);

        if ("RESERVE".equals(inventoryMode)) {
            reserveInventory(context);
        }

        if ("ONLINE".equals(paymentMode)) {
            processPayment(context);
        } else if ("COD".equals(paymentMode)) {
            System.out.println("Cash on delivery selected");
        }

        if (notifyCustomer) {
            sendConfirmation(context);
        }
    }
}
