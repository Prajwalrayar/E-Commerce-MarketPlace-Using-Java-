package com.crimsonlogic.ecommerce.exceptions;

public class InventoryNotFoundException extends Exception{

    public InventoryNotFoundException(String message){
        super(message);
    }
}
