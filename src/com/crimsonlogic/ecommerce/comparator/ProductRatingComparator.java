package com.crimsonlogic.ecommerce.comparator;

import com.crimsonlogic.ecommerce.model.Product;

import java.util.Comparator;

public class ProductRatingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p2.getRating(), p1.getRating());
    }
}
