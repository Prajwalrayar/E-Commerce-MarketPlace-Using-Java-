package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.exceptions.DuplicateDataException;
import com.crimsonlogic.ecommerce.exceptions.SellerNotFoundException;
import com.crimsonlogic.ecommerce.model.Seller;
import com.crimsonlogic.ecommerce.util.ValidationUtil;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SellerOperations {

    private Map<Integer, Seller> sellers;
    private Scanner scanner;

    public SellerOperations() {
        sellers = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Register Seller
    public void addSeller() {

        try {

            int id;

            while (true) {
                System.out.print("Enter Seller ID : ");

                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    scanner.nextLine();

                    if (sellers.containsKey(id)) {
                        System.out.println("Seller ID already exists. Please enter another ID.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Invalid Seller ID! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            String name;

            while (true) {
                System.out.print("Enter Name : ");
                name = scanner.nextLine();

                if (ValidationUtil.isValidName(name)) {
                    break;
                }

                System.out.println("Invalid Name! Please enter a valid name.");
            }

            String email;

            while (true) {
                System.out.print("Enter Email : ");
                email = scanner.nextLine();

                if (ValidationUtil.isValidEmail(email)) {
                    break;
                }

                System.out.println("Invalid Email! Please enter a valid email.");
            }

            String phone;

            while (true) {
                System.out.print("Enter Phone Number : ");
                phone = scanner.nextLine();

                if (ValidationUtil.isValidPhoneNumber(phone)) {
                    break;
                }

                System.out.println("Invalid Phone Number! Please enter a valid phone number.");
            }

            System.out.print("Enter Address : ");
            String address = scanner.nextLine();

            String password;

            while (true) {
                System.out.print("Enter Password : ");
                password = scanner.nextLine();

                if (ValidationUtil.isValidPassword(password)) {
                    break;
                }

                System.out.println("Invalid Password! Please enter a valid password.");
            }

            System.out.print("Enter Company Name : ");
            String companyName = scanner.nextLine();

            Seller seller = new Seller(
                    id,
                    name,
                    email,
                    password,
                    phone,
                    address,
                    LocalDate.now(),
                    companyName
            );

            sellers.put(id, seller);

            System.out.println("Seller registered successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Search Seller
    public void getSellerById() {

        try {

            System.out.print("Enter Seller ID : ");
            int id = scanner.nextInt();

            Seller seller = sellers.get(id);

            if (seller == null) {
                throw new SellerNotFoundException("Seller not found.");
            }

            System.out.println("\n========== SELLER DETAILS ==========");
            System.out.println(seller);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Seller
    public void updateSeller() {

        try {

            System.out.print("Enter Seller ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (!sellers.containsKey(id)) {
                throw new SellerNotFoundException("Seller not found.");
            }

            System.out.print("Enter New Name : ");
            String name = scanner.nextLine();

            System.out.print("Enter New Email : ");
            String email = scanner.nextLine();

            System.out.print("Enter New Phone Number : ");
            String phone = scanner.nextLine();

            System.out.print("Enter New Address : ");
            String address = scanner.nextLine();

            System.out.print("Enter New Password : ");
            String password = scanner.nextLine();

            System.out.print("Enter New Company Name : ");
            String companyName = scanner.nextLine();

            Seller seller = new Seller(
                    id,
                    name,
                    email,
                    password,
                    phone,
                    address,
                    sellers.get(id).getRegistrationDate(),
                    companyName);

            sellers.put(id, seller);

            System.out.println("Seller updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Seller
    public void deleteSeller() {

        try {

            System.out.print("Enter Seller ID : ");
            int id = scanner.nextInt();

            if (!sellers.containsKey(id)) {
                throw new SellerNotFoundException("Seller not found.");
            }

            sellers.remove(id);

            System.out.println("Seller deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Display All Sellers
    public void displayAllSellers() {

        if (sellers.isEmpty()) {
            System.out.println("No sellers available.");
            return;
        }

        sellers.values().forEach(System.out::println);
    }

    public Seller findSellerById(int sellerId)
            throws SellerNotFoundException {

        Seller seller = sellers.get(sellerId);

        if (seller == null) {
            throw new SellerNotFoundException("Seller not found.");
        }

        return seller;
    }

    // Check Seller Exists
    public boolean sellerExists(int sellerId) {
        return sellers.containsKey(sellerId);
    }

    // Total Sellers
    public int getSellerCount() {
        return sellers.size();
    }

    // Return All Sellers
    public Collection<Seller> getAllSellers() {
        return sellers.values();
    }
}