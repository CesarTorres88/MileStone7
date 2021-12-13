package app;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	// Stock list that receives any input from the user
	List<Product<?>> StockList = new ArrayList<>();
	// Cart list that receives any input from the user
	List<Product<?>> CartList = new ArrayList<>();
	// String data
	Product<String> name = new Product<>();
	// Integer Data
	Product<String> description = new Product<>();
	// Integer Data
	Product<Double> quantity = new Product<>();
	// Double Data
	Product<Double> price = new Product<>();

	// Method that displays the description of the data types
	public Inventory() {
		System.out.println("Input Product Information: ");
		// Prints
		System.out.println("Name");
		// sort(name);
		System.out.println("Description ");
		// Short Data
		// sort(description);
		System.out.println("Quantity ");
		// Byte Data

		System.out.println("Price: $");
		// Long Data

		System.out.println();
		//Collections.sort(null);

	}
//****Sorting method******// 
	// private void sort(Product<String> name2) {
	// for (int i = 0; i != name2.getName().length() ; ++i) {
	// String itemToInsert = name2.name;

	// }

//	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param quantity
	 * @param price
	 */
	public Inventory(Product<String> name, Product<String> description, Product<Double> quantity,
			Product<Double> price) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;

	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String item = "Name: " + name + " Description: " + description + " Qty: " + quantity + " Price: $" + price;
		return item;
	}
	

/**
 * Check out method used to add the double values in the stock list or cart 
 * and display their total amount due or assets.
 * @return
 */
	public double Checkout() {
		double totalCost = 0;

		for (Product<?> c : StockList) {
			totalCost = totalCost + c.price;
		}
		StockList.clear();
		return totalCost;

	}

}
