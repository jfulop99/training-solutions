package week13.d05;

import java.util.Optional;

public class RowWriterThird implements RowWriter {

    @Override
    public String createLine(Optional<BillItem> billItem) {
        String result = "Megnevezés          Egységár (Ft) Darab Összeg\n";
        if (billItem.isPresent()) {
            result = String.format("%-20s%13d%5d%6d\n", billItem.get().getName(), billItem.get().getUnitPrice(),
                    billItem.get().getNumber(), billItem.get().getUnitPrice() * billItem.get().getNumber());
        }
        return result;
    }
}
