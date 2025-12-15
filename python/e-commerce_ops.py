# ecommerce_ops.py

def validate_cart(order_context):
    cart = order_context["cart"]
    if not cart:
        raise ValueError("Cart is empty")
    print("Cart validated")


def calculate_totals(order_context):
    total = 0
    for item in order_context["cart"]:
        total += item["price"] * item["quantity"]

    order_context["subtotal"] = total
    order_context["tax"] = total * 0.18  # 18% VAT
    order_context["total"] = total + order_context["tax"]

    print(f"Totals calculated: {order_context['total']:.2f}")


def reserve_inventory(order_context):
    for item in order_context["cart"]:
        print(f"Reserved {item['quantity']} units of {item['name']}")


def process_payment(order_context):
    print(f"Payment of {order_context['total']:.2f} processed")


def send_confirmation(order_context):
    email = order_context["customer"]["email"]
    print(f"Order confirmation sent to {email}")


def process_order(
    order_context,
    payment_mode,
    notify_customer,
    inventory_mode
):

validate_cart(order_context)
calculate_totals(order_context)

if inventory_mode == "RESERVE":
    reserve_inventory(order_context)

if payment_mode == "ONLINE":
    process_payment(order_context)
elif payment_mode == "COD":
    print("Cash on delivery selected")

if notify_customer:
    send_confirmation(order_context)
