package lambdaprimitives;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = new ArrayList<>(products);
    }


    public int getNumberOfProducts() { //: összesen hány termék van a boltban,

        return products.stream().mapToInt(Product::getAmount).sum();

    }

    public double getAveragePrice() { //: átlagosan mennyibe kerül egy termék. Ha nincs termék, 0-t adjon vissza.

        return products.stream().mapToDouble(Product::getPrice).summaryStatistics().getAverage();

    }

    public String getExpensiveProductStatistics(double minPrice) { //: adott árnál drágább termékek

        String answer = "Nincs ilyen termék.";

        IntSummaryStatistics result = products.stream().filter(x -> x.getPrice() > minPrice).mapToInt(Product::getAmount).summaryStatistics();

        if (result.getCount() != 0) {

            answer = String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van."
                    , result.getCount(), result.getMin(), result.getMax(), result.getSum());
        }

        return answer;
    }

}
