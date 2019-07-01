
// Receipt.java

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Receipt {
    private List<Item> _items;

    private Item parseLine(String line) {
        Scanner scanner = new Scanner(line);

        int quantity = scanner.nextInt();
        scanner.useDelimiter(" at ");
        String description = scanner.next().replaceFirst(" ", "");
        double price = scanner.nextDouble();
        scanner.close();

        return new Item(quantity, description, price);
    }

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