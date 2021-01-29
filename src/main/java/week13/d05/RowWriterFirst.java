package week13.d05;

public class RowWriterFirst implements RowWriter{

    @Override
    public String createLine(BillItem billItem) {
        return String.format("%d %s, darabja %d Ft\n", billItem.getNumber(), billItem.getName(), billItem.getUnitPrice());
    }
}
