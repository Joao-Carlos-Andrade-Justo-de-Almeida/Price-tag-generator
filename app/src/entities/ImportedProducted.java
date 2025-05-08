package entities;

// Class representing an imported product, inherits from Product
public final class ImportedProducted extends Product {
    // Attribute to store the import fee of the product
    private Double customsFee;

    // Constructor initializes the product with the name, price, and customs fee
    public ImportedProducted(String name, Double price, Double customsFee) {
        super(name, price); // Calls the constructor of the base class (Product)
        this.customsFee = customsFee;
    }

    // Getter for the import fee
    public Double getCustomsFee() {
        return customsFee;
    }

    // Setter for the import fee
    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    // Method that returns the total price (price + customs fee)
    public double totalPrice() {
        return getPrice() + customsFee;
    }

    // Overridden priceTag method to include the import fee and the total price
    @Override
    public String priceTag() {
        return getName()
            + " $"
            + String.format("%.2f", totalPrice()) // Displays the total price (price + customs fee)
            + " (Customs fee: $"
            + String.format("%.2f", getCustomsFee()) // Displays only the customs fee
            + ")";
    }
}

