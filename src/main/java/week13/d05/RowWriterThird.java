package week13.d05;

public class RowWriterThird implements RowWriter {

    @Override
    public String createLine(BillItem billItem) {
        return String.format("%-20s%13d%5d%6d\n", billItem.getName(), billItem.getUnitPrice(), billItem.getNumber(), billItem.getUnitPrice() * billItem.getNumber());
    }
}
