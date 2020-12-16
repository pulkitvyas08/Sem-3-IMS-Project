package com.pulkitvyascoder.models;

import jdk.nashorn.internal.objects.NativeDate;

import java.sql.ResultSet;
import java.util.Date;

public class Quotes {

    private Integer id;
    private Integer customerId;
    private Integer paymentId;
    private Date orderDate;
    private Double salesTax;
    private String Freight;
    private Integer shippingId;
    private Date shipDate;
    private Integer productId;
    private Double Price;
    private Integer Quantity;
    private Double Discount;
    private Double totalAmount;
    private Double Size;
    private String Color;

    public Quotes() {
    }
    
    public Quotes(Integer id,
                  Integer customerId,
                  Integer paymentId,
                  Date orderDate,
                  Double salesTax,
                  String Freight,
                  Integer shippingId,
                  Date shipDate,
                  Integer productId,
                  Double Price,
                  Integer Quantity,
                  Double Discount,
                  Double totalAmount,
                  Double Size,
                  String Color) {
        this.id = id;
        this.customerId = customerId;
        this.paymentId = paymentId;
        this.orderDate = orderDate;
        this.salesTax = salesTax;
        this.Freight = Freight;
        this.shippingId = shippingId;
        this.shipDate = shipDate;
        this.productId = productId;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Discount = Discount;
        this.totalAmount = totalAmount;
        this.Size = Size;
        this.Color = Color;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        this.Price = price;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public double getPayId() {
        return paymentId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public String getFreight() {
        return Freight;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getDiscount() {
        return Discount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getSize() {
        return Size;
    }

    public String getColor() {
        return Color;
    }

    public int getShippingId() {
        return shippingId;
    }
}
