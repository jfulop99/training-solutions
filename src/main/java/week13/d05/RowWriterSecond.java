package week13.d05;

import java.util.Optional;

public class RowWriterSecond implements RowWriter {

    @Override
    public String createLine(Optional<BillItem> billItem) {

        if (billItem.isEmpty()) {
            return "";
        }

        return String.format("%s %d * %d = %d\n", billItem.get().getName(), billItem.get().getNumber(),
                billItem.get().getUnitPrice(), billItem.get().getNumber() * billItem.get().getUnitPrice());

    }
}
