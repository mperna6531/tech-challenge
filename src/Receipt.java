
/**
 * Receipt.java - class to hold information for an individual receipt.
 * Maintains a List of Items internally.
 * 
 * @author Michael Perna
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Receipt {
    private List<Item> _items;

    /**
     * parseLine takes a String (line of input file) as input, parses the quantity,
     * description, and unitPrice of the product and uses these values to
     * instantiate and return a new Item object.
     */
    private Item parseLine(String line) {
        Scanner scanner = new Scanner(line);

        int quantity = scanner.nextInt();
        scanner.useDelimiter(" at ");
        String description = scanner.next().replaceFirst(" ", "");
        double price = scanner.nextDouble();
        scanner.close();

        return new Item(quantity, description, price);
    }

    /**
     * Constructor for receipt class - takes a string file input, converts to a File
     * obj and uses a Scanner obj to read the file line by line. Item objects
     * generated from parseLine method are appended to an ArrayList of items field.
     */
    public Receipt(String filePath) {
        _items = new ArrayList<Item>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Item newItem = parseLine(line);
                _items.add(newItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * print method calculates and displays formatted data for the order.
     */
    public void print() {
        double price = 0.0;
        double tax = 0.0;
        for (Item item : _items) {
            price += item.getPrice();
            tax += item.getTax();
            item.display();
        }
        double total = price + tax;

        System.out.println(String.format("Sales Taxes: %.2f", tax));
        System.out.println(String.format("Total: %.2f\n", total));
    }

}