import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProducted;
import entities.Product;
import entities.UsedProducted;

public class App {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> productList = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		char resp;

		// Start of the main method
		for (int i = 0; i < n; i++) {

			// Prints the number of the current product (starting from 1)
			System.out.println("Product #" + (i + 1));

			// Prompts the user to choose the type of product: common (c), used (u), or
			// imported (i)
			System.out.print("Common, used, or imported (c/u/i)?: ");
			resp = sc.next().charAt(0); // Reads the user's response (character 'c', 'u', or 'i')

			// Prompts for the name of the product
			System.out.print("Name: ");
			sc.nextLine(); // Consumes the leftover newline character from the previous input
			String name = sc.nextLine(); // Reads the product name
			System.out.print("Price: ");
			double price = sc.nextDouble(); // Reads the price of the product

			// If the product is imported ('i')
			if (resp == 'i') {
				// Prompts the user to enter the customs fee for the imported product
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();

				// Creates a new ImportedProducted object and adds it to the product list
				productList.add(new ImportedProducted(name, price, customsFee));

				// If the product is used ('u')
			} else if (resp == 'u') {
				// Prompts the user to enter the manufacturing date of the used product
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = null;
				manufactureDate = sdf.parse(sc.next()); // Parses the date string into a Date object

				// Creates a new UsedProducted object and adds it to the product list
				productList.add(new UsedProducted(name, price, manufactureDate));

				// If the product is a common product ('c')
			} else {
				// Creates a new Product object and adds it to the product list
				productList.add(new Product(name, price));
			}
		}

		// Prints a blank line before the price tag section
		System.out.println();

		// Prints the header for the price tags
		System.out.println("PRICE TAGS: ");

		// Iterates through each product in the product list
		for (Product prod : productList) {
			// Prints the price tag for each product using the priceTag() method
			System.out.println(prod.priceTag());
		}

		// Closes the scanner to release resources
		sc.close();
	}
}