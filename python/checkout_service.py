from ecommerce_ops import process_order


def checkout():
    order_context = {
        "customer": {
            "id": 42,
            "name": "Ali Hasanov",
            "email": "ali@example.com"
        },
        "cart": [
            {"name": "Laptop", "price": 1500.0, "quantity": 1},
            {"name": "Mouse", "price": 25.0, "quantity": 2}
        ]
    }

    payment_mode = "ONLINE"      # ONLINE | COD
    notify_customer = True       # True | False
    inventory_mode = "RESERVE"   # RESERVE | SKIP

    process_order(
        order_context=order_context,
        payment_mode=payment_mode,
        notify_customer=notify_customer,
        inventory_mode=inventory_mode
    )


if __name__ == "__main__":
    checkout()
