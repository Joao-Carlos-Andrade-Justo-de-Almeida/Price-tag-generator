package entities;

// Base class representing a generic product
public class Product {
    // Attributes to store the name and price of the product
    private String name;
    private Double price;

    // Constructor initializes the attributes with the provided values
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for the product's name
    public String getName() {
        return name;
    }

    // Setter for the product's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the product's price
    public Double getPrice() {
        return price;
    }

    // Setter for the product's price
    public void setPrice(Double price) {
        this.price = price;
    }

    // Method that returns a formatted price tag
    public String priceTag() {
        return getName() + " $ " + String.format("%.2f", getPrice());
    }
}
