package finalmodifier;

public class TaxCalculator {
    final static double VAT = 27.0;

    public double tax(double price){
        return price * VAT / 100.0;
    }

    public double priceWithTax(double price){
        return price * (1.0 + VAT / 100.0);
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println("Az ÁFA értéke: \t" + taxCalculator.tax(150.0));
        System.out.println("A bruttó ár:   \t" + taxCalculator.priceWithTax(150.0));
    }
}
