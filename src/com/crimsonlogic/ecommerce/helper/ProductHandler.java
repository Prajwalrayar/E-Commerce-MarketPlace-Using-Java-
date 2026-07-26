package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.CategoryOperations;
import com.crimsonlogic.ecommerce.services.ProductOperations;
import com.crimsonlogic.ecommerce.services.SellerOperations;

import java.util.Scanner;

public class ProductHandler {

    Scanner scanner = new Scanner(System.in);

    private ProductOperations productOperations;

    public ProductHandler(ProductOperations productOperations) {
        this.productOperations = productOperations;
    }

    public void productHandlerMethod() {

        int choice;

        do {

            System.out.println("\n========== PRODUCT MENU ==========");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Display All Products");
            System.out.println("0. Back");
            System.out.print("Enter Your Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    productOperations.addProduct();
                    break;

                case 2:
                    productOperations.getProductById();
                    break;

                case 3:
                    productOperations.updateProduct();
                    break;

                case 4:
                    productOperations.deleteProduct();
                    break;

                case 5:
                    productOperations.displayAllProducts();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }
}