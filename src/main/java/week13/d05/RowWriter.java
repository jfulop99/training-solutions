package week13.d05;

import java.util.Optional;

@FunctionalInterface
public interface RowWriter {

    String createLine(Optional<BillItem> billItem);

}
