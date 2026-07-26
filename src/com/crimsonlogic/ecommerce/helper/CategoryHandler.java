package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.CategoryOperations;

import java.util.Scanner;

public class CategoryHandler {

    private Scanner scanner;
    private CategoryOperations categoryOperations;

    public CategoryHandler(CategoryOperations categoryOperations) {
        this.categoryOperations = categoryOperations;
        this.scanner = new Scanner(System.in);
    }

    public void categoryMenu() {

        int choice;

        do {

            System.out.println("\n========== CATEGORY MENU ==========");
            System.out.println("1. Add Category");
            System.out.println("2. Search Category");
            System.out.println("3. Update Category");
            System.out.println("4. Delete Category");
            System.out.println("5. Display All Categories");
            System.out.println("0. Back");
            System.out.print("Enter Your Choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    categoryOperations.addCategory();
                    break;

                case 2:
                    categoryOperations.getCategoryById();
                    break;

                case 3:
                    categoryOperations.updateCategory();
                    break;

                case 4:
                    categoryOperations.deleteCategory();
                    break;

                case 5:
                    categoryOperations.displayAllCategories();
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