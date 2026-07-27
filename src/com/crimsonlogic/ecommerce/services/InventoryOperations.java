package com.crimsonlogic.ecommerce.services;

import com.crimsonlogic.ecommerce.exceptions.InvalidQuantityException;
import com.crimsonlogic.ecommerce.exceptions.InventoryNotFoundException;
import com.crimsonlogic.ecommerce.model.Inventory;
import com.crimsonlogic.ecommerce.model.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryOperations {
    Map<Integer, Inventory> inventories;
    private ProductOperations productOperations;
    private Scanner scanner = new Scanner(System.in);
    public InventoryOperations(ProductOperations productOperations) {

        this.inventories = new HashMap<>();
        this.productOperations = productOperations;
    }

    public void addInventory() {

        try {

            int inventoryId;

            while (true) {

                System.out.print("Enter Inventory ID : ");

                if (scanner.hasNextInt()) {

                    inventoryId = scanner.nextInt();

                    if (inventories.containsKey(inventoryId)) {
                        System.out.println("Inventory ID already exists. Please enter another ID.");
                    } else {
                        break;
                    }

                } else {
                    System.out.println("Invalid Inventory ID! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            Product product;

            while (true) {

                System.out.print("Enter Product ID : ");

                if (scanner.hasNextInt()) {

                    int productId = scanner.nextInt();

                    try {
                        product = productOperations.findProductById(productId);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Product ID! Please enter a valid Product ID.");
                    }

                } else {
                    System.out.println("Invalid Product ID! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            int availableQuantity;

            while (true) {

                System.out.print("Enter Available Quantity : ");

                if (scanner.hasNextInt()) {

                    availableQuantity = scanner.nextInt();

                    if (availableQuantity >= 0) {
                        break;
                    }

                    System.out.println("Available Quantity cannot be negative.");

                } else {
                    System.out.println("Invalid Quantity! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            int reorderLevel;

            while (true) {

                System.out.print("Enter Reorder Level : ");

                if (scanner.hasNextInt()) {

                    reorderLevel = scanner.nextInt();

                    if (reorderLevel >= 0) {
                        break;
                    }

                    System.out.println("Reorder Level cannot be negative.");

                } else {
                    System.out.println("Invalid Reorder Level! Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            Inventory inventory = new Inventory(
                    inventoryId,
                    product,
                    availableQuantity,
                    reorderLevel,
                    LocalDate.now()
            );

            inventories.put(inventoryId, inventory);

            System.out.println("Inventory added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Inventory findInventoryById(int inventoryId)
            throws InventoryNotFoundException {

        Inventory inventory = inventories.get(inventoryId);

        if (inventory == null) {
            throw new InventoryNotFoundException("Inventory not found.");
        }

        return inventory;
    }
    public void getInventoryById() {

        try {

            System.out.print("Enter Inventory ID : ");
            int inventoryId = scanner.nextInt();

            Inventory inventory = findInventoryById(inventoryId);

            System.out.println(inventory);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateInventory() {

        try {

            System.out.print("Enter Inventory ID : ");
            int inventoryId = scanner.nextInt();

            Inventory existingInventory = findInventoryById(inventoryId);

            System.out.print("Enter Product ID : ");
            int productId = scanner.nextInt();

            Product product = productOperations.findProductById(productId);

            System.out.print("Enter Available Quantity : ");
            int availableQuantity = scanner.nextInt();

            if (availableQuantity < 0) {
                throw new InvalidQuantityException("Available quantity cannot be negative.");
            }

            System.out.print("Enter Reorder Level : ");
            int reorderLevel = scanner.nextInt();

            if (reorderLevel < 0) {
                throw new InvalidQuantityException("Reorder level cannot be negative.");
            }

            existingInventory.setProduct(product);
            existingInventory.setAvailableQuantity(availableQuantity);
            existingInventory.setReorderLevel(reorderLevel);
            existingInventory.setLastUpdated(LocalDate.now());

            System.out.println("Inventory updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Inventory
    public void deleteInventory() {

        try {

            System.out.print("Enter Inventory ID : ");
            int inventoryId = scanner.nextInt();

            findInventoryById(inventoryId);

            inventories.remove(inventoryId);

            System.out.println("Inventory deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllInventories() {

        if (inventories.isEmpty()) {
            System.out.println("No inventories available.");
            return;
        }

        System.out.println("\n========== INVENTORY LIST ==========");

        for (Inventory inventory : inventories.values()) {
            System.out.println(inventory);
        }
    }

    // Increase Stock
    public void increaseStock() {

        try {

            System.out.print("Enter Inventory ID : ");
            int inventoryId = scanner.nextInt();

            Inventory inventory = findInventoryById(inventoryId);

            System.out.print("Enter Quantity to Add : ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                throw new InvalidQuantityException("Quantity must be greater than zero.");
            }

            inventory.restock(quantity);

            System.out.println("Stock increased successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Reduce Stock
    public void reduceStock() {

        try {

            System.out.print("Enter Inventory ID : ");
            int inventoryId = scanner.nextInt();

            Inventory inventory = findInventoryById(inventoryId);

            System.out.print("Enter Quantity to Reduce : ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                throw new InvalidQuantityException("Quantity must be greater than zero.");
            }

            if (!inventory.reduceStock(quantity)) {
                throw new InvalidQuantityException("Insufficient stock available.");
            }

            System.out.println("Stock reduced successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Low Stock Products
    public void displayLowStockInventories() {

        List<Inventory> lowStockInventories = inventories.values()
                .stream()
                .filter(Inventory::isLowStock)
                .toList();

        if (lowStockInventories.isEmpty()) {
            System.out.println("No low stock inventories found.");
            return;
        }

        System.out.println("\n========== LOW STOCK INVENTORIES ==========");

        lowStockInventories.forEach(System.out::println);
    }

    public void lowStockInventoryCount() {

        long count = inventories.values()
                .stream()
                .filter(Inventory::isLowStock)
                .count();

        System.out.println("Low Stock Inventories : " + count);
    }


    // Out of Stock Products
    public void displayOutOfStockInventories() {

        List<Inventory> outOfStockInventories = inventories.values()
                .stream()
                .filter(Inventory::isOutOfStock)
                .collect(Collectors.toList());

        if (outOfStockInventories.isEmpty()) {
            System.out.println("No out of stock inventories found.");
            return;
        }

        System.out.println("\n========== OUT OF STOCK INVENTORIES ==========");

        outOfStockInventories.forEach(System.out::println);
    }

    public void outOfStockInventoryCount() {

        long count = inventories.values()
                .stream()
                .filter(Inventory::isOutOfStock)
                .count();

        System.out.println("Out Of Stock Inventories : " + count);
    }

    public void displayInventoriesUpdatedToday() {

        List<Inventory> inventoryList = inventories.values()
                .stream()
                .filter(inventory ->
                        inventory.getLastUpdated().equals(LocalDate.now()))
                .toList();

        if (inventoryList.isEmpty()) {
            System.out.println("No inventories updated today.");
            return;
        }

        System.out.println("\n========== INVENTORIES UPDATED TODAY ==========");

        inventoryList.forEach(System.out::println);
    }

    // Find Inventory By Product ID
    public Inventory findInventoryByProductId(int productId) throws InventoryNotFoundException {

        for (Inventory inventory : inventories.values()) {

            if (inventory.getProduct().getProductId() == productId) {
                return inventory;
            }
        }

        throw new InventoryNotFoundException("Inventory not found for Product ID : " + productId);
    }

    // Reduce Stock (Used by OrderOperations)
    public void reduceStock(int productId, int quantity)
            throws InventoryNotFoundException, InvalidQuantityException {

        Inventory inventory = findInventoryByProductId(productId);

        if (!inventory.reduceStock(quantity)) {
            throw new InvalidQuantityException("Insufficient stock available.");
        }
    }

    // Increase Stock (Used while cancelling orders)
    public void increaseStock(int productId, int quantity)
            throws InventoryNotFoundException {

        Inventory inventory = findInventoryByProductId(productId);

        inventory.restock(quantity);
    }


    public void totalAvailableQuantity() {

        int totalQuantity = inventories.values()
                .stream()
                .mapToInt(Inventory::getAvailableQuantity)
                .sum();

        System.out.println("Total Available Quantity : " + totalQuantity);
    }

    public void totalInventoryValue() {

        double totalValue = inventories.values()
                .stream()
                .mapToDouble(inventory ->
                        inventory.getProduct().getPrice()
                                * inventory.getAvailableQuantity())
                .sum();

        System.out.println("Total Inventory Value : $" + totalValue);
    }
    // Inventory Exists
    public boolean inventoryExists(int inventoryId) {
        return inventories.containsKey(inventoryId);
    }

    // Total Inventories
    public int getInventoryCount() {
        return inventories.size();
    }

    // Return All Inventories
    public List<Inventory> getAllInventories() {

        return new ArrayList<>(inventories.values());
    }

}
