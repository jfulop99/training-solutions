package week14.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContractCreator {

    private Contract template;

    ContractCreator(String client, List<Integer> monthlyPrices) {

        template = new Contract(client, monthlyPrices);

    }

    public Contract create(String client) {

        return new Contract(client, new ArrayList<>(template.getMonthlyPrices()));

    }

    public static void main(String[] args) {
        ContractCreator contractCreator = new ContractCreator("Minta János", Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));

        Contract c1 = contractCreator.create("First");
        Contract c2 = contractCreator.create("Second");
        Contract c3 = contractCreator.create("Third");
        Contract c4 = contractCreator.create("Forth");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        c1.getMonthlyPrices().set(0, 20);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        System.out.println(contractCreator.create("Fifth"));

    }

}
