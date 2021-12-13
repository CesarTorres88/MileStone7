package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AdminApplication {
	/**
	 * Main class used to initiate the server thread invoking the store front
	 * application and the client application.
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		StoreThread storeThread = new StoreThread();
		storeThread.start();
		Runnable runnable = new Client();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		/**
		 * For loop that reiterates the program only one time during its execution.
		 */
		for (int x = 0; x < 1; ++x) {
			System.out.println("Welcome to CESAR'S STORE!!!!!");
			// Instance of a the inventory class
			Inventory item = new Inventory();
			// Creates a scanner objects to receive input from the user

			@SuppressWarnings("resource")
			Scanner myItem = new Scanner(System.in);
			// Initialize the choose action methods with a value as action
			String action = chooseAction();
			/**
			 * While loop that will receive input from the user
			 */
			while (action != "E") {
				System.out.println("You chose option " + action);
				// Switch and case to prompt the user for input and allow the program to respond
				// to the input
				switch (action) {
				case "U":
					try {
						System.out.println("You chose to add an item to your Inventory");
						String name = " ";
						String description = " ";
						int quantity = 0;
						double price = 0;

						System.out.println("Name: ");
						name = myItem.next();

						System.out.println("Description: ");
						description = myItem.next();

						System.out.println("Qty: ");
						quantity = myItem.nextInt();

						System.out.println("Price: $");
						price = myItem.nextDouble();

						Product<Object> newItem = new Product<Object>(name, description, quantity, price);

						// JSON File application
						for (int x1 = 0; x1 < item.StockList.size(); ++x1)
							;
						{
							saveToFile("out.json", newItem, true);
						}
						@SuppressWarnings("rawtypes")
						List<Product> inventoryList = readFromFile1("out.json");

						for (@SuppressWarnings("rawtypes")
						Product item1 : inventoryList) {
							String text = (item1.name + "" + item1.description + "" + item1.quantity + ""
									+ item1.price);
							System.out.println(text);
						}

					} catch (Exception e) {
						System.out.println("Invalid Character input");
					}
					break;

				case "R":
					try {
						System.out.println("You chose to view your JSON list");

						readFromFile1("out.json");

					} catch (Exception e) {
						System.out.println("Invalid Character input");
					}
					break;
				case "E":
					try {

						storeThread.interrupt();

						 thread2.interrupt();
						System.out.println("Connection has been interrupted");
					} catch (Exception e) {
						System.out.println("Invalid Character input");
					}
					break;
				}
				action = chooseAction();

			}
		}
	}

	/**
	 * Read from file should return the items in the JSON file.
	 * 
	 * @param filename
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static ArrayList<Product> readFromFile1(String filename) {
		ArrayList<Product> items = new ArrayList<>();
		{
			try {
				File file = new File(filename);
				Scanner s = new Scanner(file);

				while (s.hasNext()) {
					String json = s.nextLine();
					ObjectMapper objectMapper = new ObjectMapper();
					Product item1 = objectMapper.readValue(json, Product.class);
					items.add(item1);
				}
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Items not added.");
			}
			return items;
		}
	}

	/**
	 * Save file method that return the following objects
	 * 
	 * @param filename
	 * @param newItem
	 * @param append
	 */
	private static void saveToFile(String filename, Product<Object> newItem, boolean append) {
		PrintWriter pw;
		try {
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);

			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(newItem);
			pw.println(json);

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Items not appended.");
		}
	}

	/*
	 * Choose action method that allows the while loop to receive string input from
	 * the user and within specific parameters.
	 * 
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String chooseAction() {

		Scanner num = new Scanner(System.in);
		String choice = "0";
		try {
			System.out.println(
					"Choose action (E) to --QUIT-- (U) Add new item to the Inventory List (R) Remove Item(s) to the cart and return to the Invenory List ");
			choice = num.next();

		} catch (Exception e) {
			System.out.println("Invalid Character entry");
		}
		return choice;
	}

	public Object equals(String string, String string2) {
		// TODO Auto-generated method stub
		return equals(string, string);
	}

}
