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
            System.out.println("6. List Available Products");
            System.out.println("7. Filter Products By Category");
            System.out.println("8. Filter Products By Seller");
            System.out.println("9. Sort Products By Price");
            System.out.println("10. Sort Products By Rating");
            System.out.println("11. Most Expensive Product");
            System.out.println("12. Cheapest Product");
            System.out.println("13. Average Product Price");
            System.out.println("14. Total count of available Products");
            System.out.println("15. Display Products Above Price");
            System.out.println("16. Display Products By Category");
            System.out.println("17. Display Products Below Price");
            System.out.println("18. Display Products Within Price Range");
            System.out.println("19. Sort Products By Name");
            System.out.println("20. Sort Products By Price (Descending)");
            System.out.println("21. Total Product Value");
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

                case 6:
                    productOperations.listAvailableProducts();
                    break;

                case 7:
                    productOperations.filterProductsByCategory();
                    break;

                case 8:
                    productOperations.filterProductsBySeller();
                    break;

                case 9:
                    productOperations.sortProductsByPrice();
                    break;

                case 10:
                    productOperations.sortProductsByRating();
                    break;

                case 11:
                    productOperations.mostExpensiveProduct();
                    break;

                case 12:
                    productOperations.cheapestProduct();
                    break;

                case 13:
                    productOperations.averageProductPrice();
                    break;

                case 14:
                    productOperations.availableProductsCount();
                    break;

                case 15:
                    productOperations.displayProductsAbovePrice();
                    break;

                case 16:
                    productOperations.displayProductsByCategory();
                    break;

                case 17:
                    productOperations.displayProductsBelowPrice();
                    break;

                case 18:
                    productOperations.displayProductsWithinPriceRange();
                    break;

                case 19:
                    productOperations.sortProductsByName();
                    break;

                case 20:
                    productOperations.sortProductsByPriceDescending();
                    break;

                case 21:
                    productOperations.totalProductValue();
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