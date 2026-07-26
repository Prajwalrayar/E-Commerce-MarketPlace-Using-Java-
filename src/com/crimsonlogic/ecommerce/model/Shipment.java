package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.enums.ShipmentStatus;

import java.time.LocalDate;
import java.util.Objects;

public class Shipment {

    private int shipmentId;
    private Order order;
    private String shippingAddress;
    private String courierPartner;
    private String trackingNumber;
    private ShipmentStatus shipmentStatus;
    private LocalDate dispatchDate;
    private LocalDate expectedDeliveryDate;
    private LocalDate deliveredDate;

    public Shipment() {
        this.shipmentStatus = ShipmentStatus.PENDING;
    }

    public Shipment(int shipmentId,
                    Order order,
                    String shippingAddress,
                    String courierPartner,
                    String trackingNumber,
                    LocalDate dispatchDate,
                    LocalDate expectedDeliveryDate) {

        this.shipmentId = shipmentId;
        this.order = order;
        this.shippingAddress = shippingAddress;
        this.courierPartner = courierPartner;
        this.trackingNumber = trackingNumber;
        this.dispatchDate = dispatchDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.shipmentStatus = ShipmentStatus.PENDING;;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getCourierPartner() {
        return courierPartner;
    }

    public void setCourierPartner(String courierPartner) {
        this.courierPartner = courierPartner;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public LocalDate getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public void dispatchShipment() {
        shipmentStatus = ShipmentStatus.DISPATCHED;
        dispatchDate = LocalDate.now();
    }

    public void markInTransit() {
        shipmentStatus = ShipmentStatus.IN_TRANSIT;
    }

    public void deliverShipment() {
        shipmentStatus = ShipmentStatus.DELIVERED;
        deliveredDate = LocalDate.now();
    }

    public boolean isDelivered() {
        return shipmentStatus == ShipmentStatus.DELIVERED;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Shipment))
            return false;

        Shipment shipment = (Shipment) obj;

        return shipmentId == shipment.shipmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipmentId);
    }

    @Override
    public String toString() {

        return "\n========== SHIPMENT ==========" +
                "\nShipment ID          : " + shipmentId +
                "\nOrder ID             : " +
                (order != null ? order.getOrderId() : "N/A") +
                "\nCourier Partner      : " + courierPartner +
                "\nTracking Number      : " + trackingNumber +
                "\nShipping Address     : " + shippingAddress +
                "\nShipment Status      : " + shipmentStatus +
                "\nDispatch Date        : " + dispatchDate +
                "\nExpected Delivery    : " + expectedDeliveryDate +
                "\nDelivered Date       : " +
                (deliveredDate != null ? deliveredDate : "Not Delivered") +
                "\n==============================";
    }
}
