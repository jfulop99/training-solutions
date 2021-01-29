package week13.d05;

import java.util.Optional;

public class RowWriterFirst implements RowWriter{

    @Override
    public String createLine(Optional<BillItem> billItem) {
        if (billItem.isEmpty()) {
            return "";
        }
        return String.format("%d %s, darabja %d Ft\n", billItem.get().getNumber(),
                billItem.get().getName(), billItem.get().getUnitPrice());
    }
}
