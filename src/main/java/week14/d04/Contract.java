package week14.d04;

import java.util.List;

public class Contract {

    private String client;

    private List<Integer> monthlyPrices;

    public Contract(String name, List<Integer> monthlyPrices) {
        this.client = name;
        this.monthlyPrices = monthlyPrices;
    }

    public String getClient() {
        return client;
    }

    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "name='" + client + '\'' +
                ", monthlyPrices=" + monthlyPrices +
                '}';
    }
}
