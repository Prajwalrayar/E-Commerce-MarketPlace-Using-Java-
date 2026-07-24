package com.crimsonlogic.ecommerce.model;

import com.crimsonlogic.ecommerce.enums.ShipmentStatus;

import java.time.LocalDate;

public class Shipment {

    private String shipmentId;
    private Order order;
    private String shippingAddress;
    private ShipmentStatus shipmentStatus;
    private LocalDate dispatchDate;
    private LocalDate deliveryDate;

    public Shipment() {
    }

    public Shipment(String shipmentId, Order order,
                    String shippingAddress,
                    ShipmentStatus shipmentStatus,
                    LocalDate dispatchDate,
                    LocalDate deliveryDate) {

        this.shipmentId = shipmentId;
        this.order = order;
        this.shippingAddress = shippingAddress;
        this.shipmentStatus = shipmentStatus;
        this.dispatchDate = dispatchDate;
        this.deliveryDate = deliveryDate;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
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

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId='" + shipmentId + '\'' +
                ", orderId='" + order.getOrderId() + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shipmentStatus=" + shipmentStatus +
                ", dispatchDate=" + dispatchDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
