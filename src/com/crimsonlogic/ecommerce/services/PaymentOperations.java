package com.crimsonlogic.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crimsonlogic.ecommerce.enums.PaymentMethod;
import com.crimsonlogic.ecommerce.enums.PaymentStatus;
import com.crimsonlogic.ecommerce.exceptions.OrderNotFoundException;
import com.crimsonlogic.ecommerce.exceptions.PaymentFailedException;
import com.crimsonlogic.ecommerce.exceptions.PaymentNotFoundException;
import com.crimsonlogic.ecommerce.model.Order;
import com.crimsonlogic.ecommerce.model.Payment;
import com.crimsonlogic.ecommerce.model.interfaces.PaymentGateway;

public class PaymentOperations {

    private List<Payment> payments;

    private OrderOperations orderOperations;
    private PaymentGateway paymentGateway;

    private Scanner scanner;

    public PaymentOperations(OrderOperations orderOperations,
                             PaymentGateway paymentGateway) {

        this.payments = new ArrayList<>();

        this.orderOperations = orderOperations;
        this.paymentGateway = paymentGateway;

        this.scanner = new Scanner(System.in);
    }

    // Generate Payment ID
    private int generatePaymentId() {

        int maxId = 0;

        for (Payment payment : payments) {

            if (payment.getPaymentId() > maxId) {
                maxId = payment.getPaymentId();
            }
        }

        return maxId + 1;
    }

    // Process Payment
    public void processPayment() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = orderOperations.findOrderById(orderId);

            if (order.isPaid()) {

                System.out.println("Payment already completed.");
                return;
            }

            System.out.println("Order Amount : $" + order.getTotalAmount());

            System.out.println("\nPayment Methods");
            System.out.println("1. UPI");
            System.out.println("2. CREDIT_CARD");
            System.out.println("3. DEBIT_CARD");
            System.out.println("4. NET_BANKING");
            System.out.println("5. CASH_ON_DELIVERY");

            System.out.print("Choose Payment Method : ");
            int choice = scanner.nextInt();

            PaymentMethod paymentMethod;

            switch (choice) {

                case 1:
                    paymentMethod = PaymentMethod.UPI;
                    break;

                case 2:
                    paymentMethod = PaymentMethod.CREDIT_CARD;
                    break;

                case 3:
                    paymentMethod = PaymentMethod.DEBIT_CARD;
                    break;

                case 4:
                    paymentMethod = PaymentMethod.NET_BANKING;
                    break;

                case 5:
                    paymentMethod = PaymentMethod.CASH_ON_DELIVERY;
                    break;

                default:
                    System.out.println("Invalid Payment Method.");
                    return;
            }

            System.out.print("Enter Transaction ID : ");
            String transactionId = scanner.next();

            Payment payment = new Payment(
                    generatePaymentId(),
                    order,
                    order.getTotalAmount(),
                    paymentMethod,
                    transactionId
            );

            boolean success =
                    paymentGateway.processPayment(payment.getAmount());

            if (!success) {

                payment.setPaymentStatus(PaymentStatus.FAILED);

                throw new PaymentFailedException("Payment Failed.");
            }

            payment.setPaymentStatus(PaymentStatus.SUCCESS);

            payments.add(payment);

            order.setPayment(payment);

            System.out.println("Payment Successful.");

        } catch (OrderNotFoundException |
                 PaymentFailedException |
                 IllegalArgumentException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid Input.");
        }
    }

    // Search Payment
    public void getPaymentById() {

        try {

            int paymentId;

            while (true) {

                System.out.print("Enter Payment ID : ");

                if (scanner.hasNextInt()) {
                    paymentId = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid Payment ID! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            Payment payment = findPaymentById(paymentId);

            System.out.println(payment);

        } catch (PaymentNotFoundException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Something went wrong.");
        }
    }

    // Search Payment by Order
    public void getPaymentByOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int orderId = scanner.nextInt();

            Order order = orderOperations.findOrderById(orderId);

            for (Payment payment : payments) {

                if (payment.getOrder().getOrderId() == order.getOrderId()) {

                    System.out.println(payment);
                    return;
                }
            }

            throw new PaymentNotFoundException("Payment not found.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Display All Payments
    public void displayAllPayments() {

        if (payments.isEmpty()) {

            System.out.println("No Payments Available.");
            return;
        }

        for (Payment payment : payments) {

            System.out.println(payment);
        }
    }

    // Find Payment
    public Payment findPaymentById(int paymentId)
            throws PaymentNotFoundException {

        for (Payment payment : payments) {

            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }

        throw new PaymentNotFoundException("Payment not found.");
    }

    // Total Payments
    public void getPaymentCount() {

        System.out.println("Total Payments : " + payments.size());
    }
}