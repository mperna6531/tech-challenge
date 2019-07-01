
// Item.java

import java.lang.Math;

public class Item {
    private static final double SALES_TAX = 0.10;
    private static final double IMPORT_TAX = 0.05;
    // list of words denoting tax exempt status
    private static final String[] EXEMPTIONS = { "chocolate", "pills", "book", "chips", "medicine", "cough",
            "headache" };

    private int _quantity;
    private String _description;
    private double _unitPrice;
    private boolean _imported;
    private boolean _taxExempt;

    public Item(int quantity, String description, double price) {
        _description = description;
        _quantity = quantity;
        _unitPrice = price;
        _imported = _description.contains("imported");

        _taxExempt = false;
        for (String word : EXEMPTIONS) {
            if (_description.contains(word)) {
                _taxExempt = true;
                break;
            }
        }
    }

    public double getPrice() {
        return _quantity * _unitPrice;
    }

    public void display() {
        double totalPrice = getPrice() + getTax();
        String formatted = String.format("%d %s: %.2f", _quantity, _description, totalPrice);
        System.out.println(formatted);
    }

    public double getTax() {
        double baseRate = _taxExempt ? 0.0 : SALES_TAX;
        double taxRate = baseRate + (_imported ? IMPORT_TAX : 0.0);
        double tax = getPrice() * taxRate;

        // round up to nearest 0.05
        tax = Math.round(Math.ceil(tax * 20.0)) / 20.0;
        return tax;
    }

}