package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.comparator.ProductPriceComparator;
import com.crimsonlogic.ecommerce.comparator.ProductNameComparator;
import com.crimsonlogic.ecommerce.comparator.ProductRatingComparator;
import com.crimsonlogic.ecommerce.exceptions.DuplicateDataException;
import com.crimsonlogic.ecommerce.exceptions.ProductNotFoundException;
import com.crimsonlogic.ecommerce.model.Category;
import com.crimsonlogic.ecommerce.model.Product;
import com.crimsonlogic.ecommerce.model.Seller;
import com.crimsonlogic.ecommerce.util.ValidationUtil;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ProductOperations {

    private Map<Integer, Product> products;
    private CategoryOperations categoryOperations;
    private SellerOperations sellerOperations;
    private Scanner scanner = new Scanner(System.in);

    public ProductOperations(CategoryOperations categoryOperations,
                             SellerOperations sellerOperations) {

        this.products = new HashMap<>();
        this.categoryOperations = categoryOperations;
        this.sellerOperations = sellerOperations;
    }

    // Add Product
    public void addProduct() {

        try {

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            if (products.containsKey(productId)) {
                throw new DuplicateDataException("Product ID already exists.");
            }

            System.out.print("Enter Product Name : ");
            String productName = scanner.nextLine();

            if (!ValidationUtil.isValidName(productName)) {
                throw new IllegalArgumentException("Invalid Product Name.");
            }

            System.out.print("Enter Brand : ");
            String brand = scanner.nextLine();

            System.out.print("Enter Description : ");
            String description = scanner.nextLine();

            System.out.print("Enter Price : ");
            double price = scanner.nextDouble();

            if (!ValidationUtil.isValidPrice(price)) {
                throw new IllegalArgumentException("Invalid Product Price.");
            }

            System.out.print("Enter Quantity : ");
            int quantity = scanner.nextInt();

            if (!ValidationUtil.isValidQuantity(quantity)) {
                throw new IllegalArgumentException("Invalid Product Quantity.");
            }

            System.out.print("Enter Rating : ");
            double rating = scanner.nextDouble();

            System.out.print("Enter Category ID : ");
            int categoryId = scanner.nextInt();

            System.out.print("Enter Seller ID : ");
            int sellerId = scanner.nextInt();

            Category category = categoryOperations.findCategoryById(categoryId);
            Seller seller = sellerOperations.findSellerById(sellerId);

            Product product = new Product(
                    productId,
                    productName,
                    brand,
                    description,
                    price,
                    quantity,
                    rating,
                    category,
                    seller,
                    LocalDate.now()
            );

            products.put(productId, product);

            System.out.println("Product added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Search Product
    public void getProductById() {

        try {

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();

            Product product = products.get(productId);

            if (product == null) {
                throw new ProductNotFoundException("Product not found.");
            }

            System.out.println("\n========== PRODUCT DETAILS ==========");
            System.out.println(product);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getProductByName() {

        try {

            scanner.nextLine();

            System.out.print("Enter Product Name : ");
            String productName = scanner.nextLine();

            Optional<Product> product = products.values()
                    .stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                    .findFirst();

            if (product.isEmpty()) {
                throw new ProductNotFoundException("Product not found.");
            }

            System.out.println("\n========== PRODUCT DETAILS ==========");
            System.out.println(product.get());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Product
    public void updateProduct() {

        try {

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            if (!products.containsKey(productId)) {
                throw new ProductNotFoundException("Product not found.");
            }

            System.out.print("Enter New Product Name : ");
            String productName = scanner.nextLine();

            if (!ValidationUtil.isValidName(productName)) {
                throw new IllegalArgumentException("Invalid Product Name.");
            }

            System.out.print("Enter New Brand : ");
            String brand = scanner.nextLine();

            System.out.print("Enter New Description : ");
            String description = scanner.nextLine();

            System.out.print("Enter New Price : ");
            double price = scanner.nextDouble();

            if (!ValidationUtil.isValidPrice(price)) {
                throw new IllegalArgumentException("Invalid Product Price.");
            }

            System.out.print("Enter New Quantity : ");
            int quantity = scanner.nextInt();

            if (!ValidationUtil.isValidQuantity(quantity)) {
                throw new IllegalArgumentException("Invalid Product Quantity.");
            }

            System.out.print("Enter New Rating : ");
            double rating = scanner.nextDouble();

            System.out.print("Enter Category ID : ");
            int categoryId = scanner.nextInt();

            System.out.print("Enter Seller ID : ");
            int sellerId = scanner.nextInt();

            Category category = categoryOperations.findCategoryById(categoryId);
            Seller seller = sellerOperations.findSellerById(sellerId);

            Product product = new Product(productId, productName, brand, description, price,
                    quantity, rating, category, seller, products.get(productId).getDateAdded()
            );

            products.put(productId, product);

            System.out.println("Product updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Product
    public void deleteProduct() {

        try {

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();

            if (!products.containsKey(productId)) {
                throw new ProductNotFoundException("Product not found.");
            }

            products.remove(productId);

            System.out.println("Product deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Display All Products
    public void displayAllProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n========== PRODUCT LIST ==========");

        products.values().forEach(System.out::println);
    }

    public void displayProductsByCategory() {

        try {

            scanner.nextLine();

            System.out.print("Enter Category Name : ");
            String categoryName = scanner.nextLine();

            List<Product> productList = products.values()
                    .stream()
                    .filter(product -> product.getCategory()
                            .getCategoryName()
                            .equalsIgnoreCase(categoryName))
                    .toList();

            if (productList.isEmpty()) {
                System.out.println("No products found.");
                return;
            }

            productList.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayProductsBySeller() {

        try {

            System.out.print("Enter Seller ID : ");
            int sellerId = scanner.nextInt();

            List<Product> productList = products.values()
                    .stream()
                    .filter(product ->
                            product.getSeller().getUserId() == sellerId)
                    .toList();

            if (productList.isEmpty()) {
                System.out.println("No products found.");
                return;
            }

            productList.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Sort Products By Price
//    public void sortProductsByPrice() {
//
//        products.values()
//                .stream()
//                .sorted(Comparator.comparing(Product::getPrice))
//                .forEach(System.out::println);
//    }

    public void sortProductsByPrice() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        products.values()
                .stream()
                .sorted(new ProductPriceComparator())
                .forEach(System.out::println);
    }

    // Sort Products By Name
    public void sortProductsByName() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        products.values()
                .stream()
                .sorted(new ProductNameComparator())
                .forEach(System.out::println);
    }

    // Sort Products By Rating
    public void sortProductsByRating() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        products.values()
                .stream()
                .sorted(new ProductRatingComparator())
                .forEach(System.out::println);
    }
    // Display Available Products
    public void displayAvailableProducts() {

        List<Product> productList = products.values()
                .stream()
                .filter(Product::isAvailable)
                .toList();

        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        productList.forEach(System.out::println);
    }
    public Product findProductById(int productId)
            throws ProductNotFoundException {

        Product product = products.get(productId);

        if (product == null) {
            throw new ProductNotFoundException("Product not found.");
        }

        return product;
    }
    // Product Exists
    public boolean productExists(int productId) {
        return products.containsKey(productId);
    }

    // Total Products
    public int getProductCount() {
        return products.size();
    }

    // Return All Products
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

}
