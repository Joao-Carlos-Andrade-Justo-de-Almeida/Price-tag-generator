package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

// Class representing a used product, inherits from Product
public final class UsedProducted extends Product {
    // Attribute to store the manufacturing date of the used product
    private Date manufactureDate;

    // Define a SimpleDateFormat to format the date
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor initializes product attributes and the manufacture date
    public UsedProducted(String name, Double price, Date manufactureDate) {
        super(name, price); // Calls the constructor of the base class (Product)
        this.manufactureDate = manufactureDate;
    }

    // Getter for the manufacturing date
    public Date getManufactureDate() {
        return manufactureDate;
    }

    // Setter for the manufacturing date
    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    // Overridden priceTag method to include the manufacturing date
    @Override
    public String priceTag() {
        return getName()
            + " (used) $"
            + String.format("%.2f", getPrice())
            + " (Manufacture date: "
            + sdf.format(manufactureDate)
            + ")";
    }
}
