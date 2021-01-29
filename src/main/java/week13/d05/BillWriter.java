package week13.d05;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BillWriter {

    public String writeBills(List<BillItem> billItems, RowWriter line) {
        StringBuilder result = new StringBuilder();

        result.append(line.createLine(Optional.empty()));

        for (BillItem item:billItems) {

            result.append(line.createLine(Optional.of(item)));

        }

        return result.toString();
    }

    public String writeBillsFunction(List<BillItem> billItems, Function<Optional<BillItem>, String> lineWriter) {
        StringBuilder result = new StringBuilder();

        result.append(lineWriter.apply(Optional.empty()));

        for (BillItem item:billItems) {

            result.append(lineWriter.apply(Optional.of(item)));

        }

        return result.toString();
    }

}
