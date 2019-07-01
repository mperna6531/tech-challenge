// Main.java - simple driver class to generate a recceipt from
// given input files of items.

public class Main {
    public static void main(String[] args) {
        Receipt order1 = new Receipt("Input1.txt");
        Receipt order2 = new Receipt("Input2.txt");
        Receipt order3 = new Receipt("Input3.txt");

        order1.print();
        order2.print();
        order3.print();
    }
}