package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.enums.OrderStatus;
import com.crimsonlogic.ecommerce.exceptions.OrderNotFoundException;
import com.crimsonlogic.ecommerce.model.*;
import java.util.*;
import java.util.stream.Collectors;

public class OrderOperations {

    private List<Order> orders;

    private CustomerOperations customerOperations;
    private CartOperations cartOperations;
    private ProductOperations productOperations;
    private InventoryOperations inventoryOperations;
    private CouponOperations couponOperations;

    private Scanner scanner;

    public OrderOperations(CustomerOperations customerOperations,
                           CartOperations cartOperations,
                           ProductOperations productOperations,
                           InventoryOperations inventoryOperations,
                           CouponOperations couponOperations) {

        this.orders = new ArrayList<>();

        this.customerOperations = customerOperations;
        this.cartOperations = cartOperations;
        this.productOperations = productOperations;
        this.inventoryOperations = inventoryOperations;
        this.couponOperations = couponOperations;

        this.scanner = new Scanner(System.in);
    }

    // Generate Order ID
    private int generateOrderId() {

        int maxId = 0;

        for (Order order : orders) {

            if (order.getOrderId() > maxId) {
                maxId = order.getOrderId();
            }
        }

        return maxId + 1;
    }

    // Place Order
    public void placeOrder() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer = customerOperations.findCustomerById(customerId);

            Cart cart = customer.getCart();

            if (cart.isEmpty()) {

                System.out.println("Cart is empty.");
                return;
            }

            Order order = new Order(generateOrderId(), customer);
            order.setOrderStatus(OrderStatus.PENDING);

            for (CartItem cartItem : cart.getCartItems()) {

                Product product = cartItem.getProduct();
                int quantity = cartItem.getQuantity();

                Inventory inventory =
                        inventoryOperations.findInventoryByProductId(product.getProductId());

                if (inventory == null) {

                    System.out.println("Inventory not found.");
                    return;
                }

                if (inventory.getAvailableQuantity() < quantity) {

                    System.out.println(product.getProductName() + " is out of stock.");
                    return;
                }

                inventoryOperations.reduceStock(product.getProductId(), quantity);

                OrderItem orderItem = new OrderItem(product, quantity);

                order.addOrderItem(orderItem);
            }

            double totalAmount = order.getTotalAmount();

            System.out.println("Total Amount : $" + totalAmount);

            System.out.print("Apply Coupon (Y/N) : ");
            char choice = scanner.next().toUpperCase().charAt(0);

            if (choice == 'Y') {

                System.out.print("Enter Coupon Code : ");
                String code = scanner.next();

                try {

                    Coupon coupon = couponOperations.findCouponByCode(code);

                    double discount = coupon.calculateDiscount(totalAmount);

                    totalAmount -= discount;

                    System.out.println("Discount : $" + discount);
                    System.out.println("Final Amount : $" + totalAmount);

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }
            }

            orders.add(order);

            customer.addOrder(order);

            cart.clearCart();

            System.out.println("Order placed successfully.");
            System.out.println("Order ID : " + order.getOrderId());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Search Order
    public void getOrderById() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = findOrderById(orderId);

            System.out.println(order);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Update Order Status
    public void confirmOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = findOrderById(orderId);

            if (order.getOrderStatus() != OrderStatus.PENDING) {
                System.out.println("Only pending orders can be confirmed.");
                return;
            }

            order.setOrderStatus(OrderStatus.CONFIRMED);

            System.out.println("Order confirmed successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void packOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = findOrderById(orderId);

            if (order.getOrderStatus() != OrderStatus.CONFIRMED) {
                System.out.println("Order must be confirmed first.");
                return;
            }

            order.setOrderStatus(OrderStatus.PACKED);

            System.out.println("Order packed successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void shipOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = findOrderById(orderId);

            if (order.getOrderStatus() != OrderStatus.PACKED) {
                System.out.println("Order must be packed first.");
                return;
            }

            order.setOrderStatus(OrderStatus.SHIPPED);

            System.out.println("Order shipped successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void markOutForDelivery() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = findOrderById(orderId);

            if (order.getOrderStatus() != OrderStatus.SHIPPED) {
                System.out.println("Order must be shipped first.");
                return;
            }

            order.setOrderStatus(OrderStatus.OUT_FOR_DELIVERY);

            System.out.println("Order is now Out For Delivery.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void deliverOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = findOrderById(orderId);

            if (order.getOrderStatus() != OrderStatus.OUT_FOR_DELIVERY) {
                System.out.println("Order must be Out For Delivery first.");
                return;
            }

            order.setOrderStatus(OrderStatus.DELIVERED);

            System.out.println("Order delivered successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void cancelOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = findOrderById(orderId);

            if (order.getOrderStatus() == OrderStatus.SHIPPED
                    || order.getOrderStatus() == OrderStatus.OUT_FOR_DELIVERY
                    || order.getOrderStatus() == OrderStatus.DELIVERED) {

                System.out.println("Order cannot be cancelled.");
                return;
            }

            order.setOrderStatus(OrderStatus.CANCELLED);

            System.out.println("Order cancelled successfully.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Display Customer Orders
    public void displayCustomerOrders() {

        try {

            System.out.print("Enter Customer ID : ");
            int customerId = scanner.nextInt();

            Customer customer =
                    customerOperations.findCustomerById(customerId);

            List<Order> customerOrders =
                    customer.getOrderHistory();

            if (customerOrders.isEmpty()) {

                System.out.println("No Orders Found.");
                return;
            }

            for (Order order : customerOrders) {

                System.out.println(order);
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Display All Orders
    public void displayAllOrders() {

        if (orders.isEmpty()) {

            System.out.println("No Orders Available.");
            return;
        }

        for (Order order : orders) {

            System.out.println(order);
        }
    }

    public Order findOrderById(int orderId)
            throws OrderNotFoundException {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        throw new OrderNotFoundException("Order not found.");
    }
    // Total Orders
    public void getOrderCount() {

        System.out.println("Total Orders : " + orders.size());
    }
}
