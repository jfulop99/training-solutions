package week13.d05;

public class RowWriterSecond implements RowWriter {

    @Override
    public String createLine(BillItem billItem) {

        return String.format("%s %d * %d = %d\n", billItem.getName(), billItem.getNumber(), billItem.getUnitPrice(), billItem.getNumber() * billItem.getUnitPrice());

    }
}
