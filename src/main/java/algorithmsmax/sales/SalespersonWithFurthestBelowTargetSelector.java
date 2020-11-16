package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {
    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersonList) {
        Salesperson salesperson = null;
        for (Salesperson salespersonItem:salespersonList) {
            if (salesperson == null || salesperson.getDifferenceFromTarget() > salespersonItem.getDifferenceFromTarget()) {
                salesperson = salespersonItem;
            }
        }
        return salesperson;
    }
}
