package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.exceptions.CustomerNotFoundException;
import com.crimsonlogic.ecommerce.exceptions.DuplicateDataException;
import com.crimsonlogic.ecommerce.model.Customer;
import com.crimsonlogic.ecommerce.util.ValidationUtil;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerOperations {

    Map<Integer, Customer> customers;
    Scanner sc = new Scanner(System.in);

    public CustomerOperations() {
        customers = new HashMap<>();
    }

    // Add Customer
    public void addCustomer() {

        try {

            int id;

            while (true) {

                System.out.print("Enter Customer ID : ");

                if (sc.hasNextInt()) {

                    id = sc.nextInt();
                    sc.nextLine();

                    if (customers.containsKey(id)) {
                        System.out.println("Customer ID already exists. Please enter another ID.");
                    } else {
                        break;
                    }

                } else {

                    System.out.println("Invalid Customer ID! Please enter numbers only.");
                    sc.nextLine();
                }
            }

            String name;

            while (true) {

                System.out.print("Enter Name : ");
                name = sc.nextLine();

                if (ValidationUtil.isValidName(name)) {
                    break;
                }

                System.out.println("Invalid Name! Name should contain only letters and spaces (3-30 characters).");
            }

            String email;

            while (true) {

                System.out.print("Enter Email : ");
                email = sc.nextLine();

                if (ValidationUtil.isValidEmail(email)) {
                    break;
                }

                System.out.println("Invalid Email! Please enter a valid email.");
            }

            String phone;

            while (true) {

                System.out.print("Enter Phone Number : ");
                phone = sc.nextLine();

                if (ValidationUtil.isValidPhoneNumber(phone)) {
                    break;
                }

                System.out.println("Invalid Phone Number! Enter a 10-digit mobile number.");
            }

            System.out.print("Enter Address : ");
            String address = sc.nextLine();

            String password;

            while (true) {

                System.out.print("Enter Password : ");
                password = sc.nextLine();

                if (ValidationUtil.isValidPassword(password)) {
                    break;
                }

                System.out.println("Invalid Password!");
                System.out.println("Password must contain:");
                System.out.println("- 8 to 20 characters");
                System.out.println("- One uppercase letter");
                System.out.println("- One lowercase letter");
                System.out.println("- One digit");
                System.out.println("- One special character");
            }

            Customer customer = new Customer(
                    id,
                    name,
                    email,
                    password,
                    phone,
                    address,
                    LocalDate.now()
            );

            customers.put(id, customer);

            System.out.println("Customer registered successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Search Customer
    public void getCustomerById() {

        try {

            System.out.print("Enter Customer ID : ");
            int id = sc.nextInt();

            Customer customer = customers.get(id);

            if (customer == null) {
                throw new CustomerNotFoundException("Customer not found.");
            }

            System.out.println("\n========== CUSTOMER DETAILS ==========");
            System.out.println(customer);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Customer
    public void updateCustomer() {

        try {

            System.out.print("Enter Customer ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            if (!customers.containsKey(id)) {
                throw new CustomerNotFoundException("Customer not found.");
            }

            System.out.print("Enter New Name : ");
            String name = sc.nextLine();

            System.out.print("Enter New Email : ");
            String email = sc.nextLine();

            System.out.print("Enter New Phone Number : ");
            String phone = sc.nextLine();

            System.out.print("Enter New Address : ");
            String address = sc.nextLine();

            System.out.print("Enter New Password : ");
            String password = sc.nextLine();

            if (!ValidationUtil.isValidName(name)) {
                throw new IllegalArgumentException("Invalid Customer Name.");
            }

            if (!ValidationUtil.isValidEmail(email)) {
                throw new IllegalArgumentException("Invalid Email.");
            }

            if (!ValidationUtil.isValidPhoneNumber(phone)) {
                throw new IllegalArgumentException("Invalid Phone Number.");
            }

            Customer customer = new Customer(id, name, email, password, phone, address, customers.get(id).getRegistrationDate());

            customers.put(id, customer);

            System.out.println("Customer updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // Delete Customer
    public void deleteCustomer() {

        try {

            System.out.print("Enter Customer ID : ");
            int id = sc.nextInt();

            if (!customers.containsKey(id)) {
                throw new CustomerNotFoundException("Customer not found.");
            }

            customers.remove(id);

            System.out.println("Customer deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Display All Customers
    public void displayAllCustomers() {

        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }

        customers.values().forEach(System.out::println);
    }

    public Customer findCustomerById(int customerId)
            throws CustomerNotFoundException {

        Customer customer = customers.get(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found.");
        }

        return customer;
    }
    // Check Customer Exists
    public boolean customerExists(int customerId) {
        return customers.containsKey(customerId);
    }

    // Total Customers
    public int getCustomerCount() {
        return customers.size();
    }

    // Return All Customers
    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }



}
