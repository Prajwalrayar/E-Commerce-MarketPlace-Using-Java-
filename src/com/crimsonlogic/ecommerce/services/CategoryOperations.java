package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.exceptions.CategoryNotFoundException;
import com.crimsonlogic.ecommerce.exceptions.DuplicateDataException;
import com.crimsonlogic.ecommerce.model.Category;
import com.crimsonlogic.ecommerce.util.ValidationUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CategoryOperations {

    private Map<Integer, Category> categories;

    Scanner scanner = new Scanner(System.in);

    public CategoryOperations() {
        categories = new HashMap<>();
    }

    // Add Category
    public void addCategory() {

        try {

            int id;

            while (true) {

                System.out.print("Enter Category ID : ");

                if (scanner.hasNextInt()) {

                    id = scanner.nextInt();
                    scanner.nextLine();

                    if (categories.containsKey(id)) {
                        System.out.println("Category ID already exists. Please enter another ID.");
                    } else {
                        break;
                    }

                } else {
                    System.out.println("Invalid Category ID! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            String categoryName;

            while (true) {

                System.out.print("Enter Category Name : ");
                categoryName = scanner.nextLine();

                if (ValidationUtil.isValidName(categoryName)) {
                    break;
                }

                System.out.println("Invalid Category Name! Please enter a valid category name.");
            }

            System.out.print("Enter Description : ");
            String description = scanner.nextLine();

            Category category = new Category(
                    id,
                    categoryName,
                    description
            );

            categories.put(id, category);

            System.out.println("Category added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Search Category
    public void getCategoryById() {

        try {

            System.out.print("Enter Category ID : ");
            int id = scanner.nextInt();

            Category category = categories.get(id);

            if (category == null) {
                throw new CategoryNotFoundException("Category not found.");
            }

            System.out.println("\n========== CATEGORY DETAILS ==========");
            System.out.println(category);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Category
    public void updateCategory() {

        try {

            System.out.print("Enter Category ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (!categories.containsKey(id)) {
                throw new CategoryNotFoundException("Category not found.");
            }

            System.out.print("Enter New Category Name : ");
            String categoryName = scanner.nextLine();

            System.out.print("Enter New Description : ");
            String description = scanner.nextLine();

            if (!ValidationUtil.isValidName(categoryName)) {
                throw new IllegalArgumentException("Invalid Category Name.");
            }

            Category category = new Category(
                    id,
                    categoryName,
                    description
            );

            categories.put(id, category);

            System.out.println("Category updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Category
    public void deleteCategory() {

        try {

            System.out.print("Enter Category ID : ");
            int id = scanner.nextInt();

            if (!categories.containsKey(id)) {
                throw new CategoryNotFoundException("Category not found.");
            }

            categories.remove(id);

            System.out.println("Category deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Category findCategoryById(int categoryId) throws CategoryNotFoundException {

        Category category = categories.get(categoryId);

        if (category == null) {
            throw new CategoryNotFoundException("Category not found.");
        }

        return category;
    }

    // Display All Categories
    public void displayAllCategories() {

        if (categories.isEmpty()) {
            System.out.println("No categories available.");
            return;
        }

        System.out.println("\n========== CATEGORY LIST ==========");

        categories.values().forEach(System.out::println);
    }

    // Check Category Exists
    public boolean categoryExists(int categoryId) {
        return categories.containsKey(categoryId);
    }

    // Total Categories
    public int getCategoryCount() {
        return categories.size();
    }

    // Return All Categories
    public Collection<Category> getAllCategories() {
        return categories.values();
    }
}