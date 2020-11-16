package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersonList) {
        Salesperson salesperson = null;
        for (Salesperson salespersonItem:salespersonList) {
            if (salesperson == null || salesperson.getAmount() < salespersonItem.getAmount()) {
                salesperson = salespersonItem;
            }
        }
        return salesperson;
    }



}
