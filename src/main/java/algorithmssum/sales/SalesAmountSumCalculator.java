package algorithmssum.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesAmountSumCalculator {

    public int sumSalesAmount(List<Salesperson> salespersonList) {
        int sum =0;
        for (Salesperson salesPerson:salespersonList) {
            sum += salesPerson.getAmount();
        }
        return sum;
    }
}
