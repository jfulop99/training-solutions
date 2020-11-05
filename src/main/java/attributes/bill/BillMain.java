package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill = new Bill();
        Item item1 = new Item("Remote", 5, 5400.0);
        Item item2 = new Item("Philips 55HFL6014", 1, 89654.0);
        Item item3 = new Item("Cable", 2, 220.0);

        bill.addItem(item1);
        bill.addItem(item2);
        bill.addItem(item3);
        System.out.println(bill.calculateToPrice());

        }
}
