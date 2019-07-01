
/**
 * Main.java Simple Main class used as a driver to generate receipts from input
 * files
 * 
 * @author Michael Perna
 */
public class Main {
    /**
     * main method - entry point for program.
     */
    public static void main(String[] args) {
        Receipt order1 = new Receipt("../resources/Input1.txt");
        Receipt order2 = new Receipt("../resources/Input2.txt");
        Receipt order3 = new Receipt("../resources/Input3.txt");

        order1.print();
        order2.print();
        order3.print();
    }
}