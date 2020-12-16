package com.pulkitvyascoder.models;

public class Products {
    private Integer id;
    private String productName;
    private String productDescription;
    private Integer Quantity;
    private Double Commission;
    private Double Cost;
    private Double Size;
    private Integer CategoryId;
    private String ageGroup;
    private String Gender;
    private String Color;
    private String Type;
    private Integer supplierId;
    private String Brand;
    private Double Discount;

    public Products() {
    }

    public Products(Integer id,
                    String productName,
                    String productDescription,
                    Integer Quantity,
                    Double Commission,
                    Double Cost,
                    Double Size,
                    Integer CategoryId,
                    String Age_Group,
                    String Gender,
                    String Color,
                    String Type,
                    Integer supplierId,
                    String Brand,
                    Double Discount) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.Quantity = Quantity;
        this.Commission = Commission;
        this.Cost = Cost;
        this.Size = Size;
        this.CategoryId = CategoryId;
        this.ageGroup = Age_Group;
        this.Gender = Gender;
        this.Color = Color;
        this.Type = Type;
        this.supplierId = supplierId;
        this.Brand = Brand;
        this.Discount = Discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getCommission() {
        return Commission;
    }

    public double getCost() {
        return Cost;
    }

    public double getSize() {
        return Size;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getGender() {
        return Gender;
    }

    public String getColor() {
        return Color;
    }

    public String getType() {
        return Type;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getBrand() {
        return Brand;
    }

    public double getDiscount() {
        return Discount;
    }
}
