package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {
    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersonList) {
        Salesperson salesperson = null;
        for (Salesperson salespersonItem:salespersonList) {
            if (salesperson == null || salesperson.getDifferenceFromTarget() < salespersonItem.getDifferenceFromTarget()) {
                salesperson = salespersonItem;
            }
        }
        return salesperson;
    }

}
