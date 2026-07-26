package com.crimsonlogic.ecommerce.comparator;

import com.crimsonlogic.ecommerce.model.Product;

import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getProductName().compareToIgnoreCase(p2.getProductName());
    }
}
