package week13.d05;

import java.util.List;
import java.util.function.Function;

public class BillWriter {

    public String writeBills(List<BillItem> billItems, RowWriter line) {
        StringBuilder result = new StringBuilder();

        for (BillItem item:billItems) {

            result.append(line.createLine(item));

        }

        return result.toString();
    }
    public String writeBillsFunction(List<BillItem> billItems, Function<BillItem, String> lineWriter) {
        StringBuilder result = new StringBuilder();

        for (BillItem item:billItems) {

            result.append(lineWriter.apply(item));

        }

        return result.toString();
    }

}
