package com.crimsonlogic.ecommerce.helper;

import com.crimsonlogic.ecommerce.services.InventoryOperations;

import java.util.Scanner;

public class InventoryHandler {
    private InventoryOperations inventoryOperations;
    private Scanner scanner = new Scanner(System.in);

    public InventoryHandler(InventoryOperations inventoryOperations) {
        this.inventoryOperations = inventoryOperations;
    }

    public void inventoryMenu() {

        int choice;

        do {

            System.out.println("\n========== INVENTORY MENU ==========");
            System.out.println("1. Add Inventory");
            System.out.println("2. Search Inventory");
            System.out.println("3. Update Inventory");
            System.out.println("4. Delete Inventory");
            System.out.println("5. Display All Inventories");
            System.out.println("6. Increase Stock");
            System.out.println("7. Reduce Stock");
            System.out.println("8. Display Low Stock Inventories");
            System.out.println("9. Display Out of Stock Inventories");
            System.out.println("10. Total Inventory Count");
            System.out.println("11. Total Inventory Value");
            System.out.println("12. Low Stock Inventory Count");
            System.out.println("13. Out Of Stock Inventory Count");
            System.out.println("14. Display Inventories Updated Today");
            System.out.println("15. Total Available Quantity");
            System.out.println("0. Back");
            System.out.print("Enter your choice : ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    inventoryOperations.addInventory();
                    break;

                case 2:
                    inventoryOperations.getInventoryById();
                    break;

                case 3:
                    inventoryOperations.updateInventory();
                    break;

                case 4:
                    inventoryOperations.deleteInventory();
                    break;

                case 5:
                    inventoryOperations.displayAllInventories();
                    break;

                case 6:
                    inventoryOperations.increaseStock();
                    break;

                case 7:
                    inventoryOperations.reduceStock();
                    break;

                case 8:
                    inventoryOperations.displayLowStockInventories();
                    break;

                case 9:
                    inventoryOperations.displayOutOfStockInventories();
                    break;

                case 10:
                    System.out.println("Total Inventories : " + inventoryOperations.getInventoryCount());
                    break;

                case 11:
                    inventoryOperations.totalInventoryValue();
                    break;

                case 12:
                    inventoryOperations.lowStockInventoryCount();
                    break;

                case 13:
                    inventoryOperations.outOfStockInventoryCount();
                    break;

                case 14:
                    inventoryOperations.displayInventoriesUpdatedToday();
                    break;

                case 15:
                    inventoryOperations.totalAvailableQuantity();
                    break;

                case 0:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 0);
    }
}
