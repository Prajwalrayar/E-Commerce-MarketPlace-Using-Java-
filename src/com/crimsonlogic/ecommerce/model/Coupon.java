
package com.crimsonlogic.ecommerce.model;
import java.time.LocalDate;
import java.util.Objects;

public class Coupon {

    private String couponCode;
    private double discountPercentage;
    private double minimumPurchase;
    private LocalDate expiryDate;

    public Coupon() {
    }

    public Coupon(String couponCode,
                  double discountPercentage,
                  double minimumPurchase,
                  LocalDate expiryDate) {

        this.couponCode = couponCode;
        this.discountPercentage = discountPercentage;
        this.minimumPurchase = minimumPurchase;
        this.expiryDate = expiryDate;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getMinimumPurchase() {
        return minimumPurchase;
    }

    public void setMinimumPurchase(double minimumPurchase) {
        this.minimumPurchase = minimumPurchase;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isValid() {

        return LocalDate.now().isBefore(expiryDate)
                || LocalDate.now().isEqual(expiryDate);
    }

    public double calculateDiscount(double amount) {

        if(amount>=minimumPurchase && isValid()) {

            return amount*discountPercentage/100;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {

        if(this==obj)
            return true;

        if(!(obj instanceof Coupon))
            return false;

        Coupon coupon=(Coupon)obj;

        return Objects.equals(couponCode,coupon.couponCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponCode);
    }

    @Override
    public String toString() {

        return "\nCoupon Code : "+couponCode+
                "\nDiscount : "+discountPercentage+"%"+
                "\nMinimum Purchase : $"+minimumPurchase+
                "\nExpiry Date : "+expiryDate;
    }

}