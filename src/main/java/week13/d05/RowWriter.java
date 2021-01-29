package week13.d05;

@FunctionalInterface
public interface RowWriter {

    String createLine(BillItem billItem);

}
