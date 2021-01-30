package week13.d05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillWriterTest {

    private List<BillItem> billItems;
    private BillWriter billWriter;
    private String test1;
    private String test2;
    private String test3;

    @BeforeEach
    void setUp() {
        billItems = List.of(new BillItem("kenyér", 1, 10),
                new BillItem("tej", 2, 20),
                new BillItem("kifli", 3, 30),
                new BillItem("vaj", 4, 40));

//        billItems = new ArrayList<>();

        billWriter = new BillWriter();

        test1 = """
                1 kenyér, darabja 10 Ft
                2 tej, darabja 20 Ft
                3 kifli, darabja 30 Ft
                4 vaj, darabja 40 Ft
                """;

        test2 = """
                kenyér 1 * 10 = 10
                tej 2 * 20 = 40
                kifli 3 * 30 = 90
                vaj 4 * 40 = 160
                """;

        test3 = """
                Megnevezés          Egységár (Ft) Darab Összeg
                kenyér                         10    1    10
                tej                            20    2    40
                kifli                          30    3    90
                vaj                            40    4   160
                """;
    }
    @Test
    void writeBills1() {

        assertEquals(test1, billWriter.writeBills(billItems, new RowWriterFirst()));

    }
    @Test
    void writeBills2() {

        assertEquals(test2, billWriter.writeBills(billItems, new RowWriterSecond()));

    }
    @Test
    void writeBills3() {

        assertEquals(test3, billWriter.writeBills(billItems, new RowWriterThird()));

    }



    @Test
    void writeBillsWithFunctionInterface1() {

        System.out.println(test1);

        assertEquals(test1, billWriter.writeBills(billItems, billItem -> {
            String result = "";
            if (billItem.isPresent()) {
                String name = billItem.get().getName();
                int unitPrice = billItem.get().getUnitPrice();
                int number = billItem.get().getNumber();
                return String.format("%d %s, darabja %d Ft\n", number, name, unitPrice);
            }
            return result;
        }));

    }

    @Test
    void writeBillsWithFunctionInterface2() {

        System.out.println(test2);

        assertEquals(test2, billWriter.writeBills(billItems, billItem -> {
            String result = "";
            if (billItem.isPresent()) {
                String name = billItem.get().getName();
                int unitPrice = billItem.get().getUnitPrice();
                int number = billItem.get().getNumber();
                result = String.format("%s %d * %d = %d\n", name, number, unitPrice, number * unitPrice);
            }
            return result;
        }));

    }

    @Test
    void writeBillsWithFunctionInterface3() {

        System.out.println(test3);

        Function<Optional<BillItem>, String> formatterFunction = billItem -> {
            String result = "Megnevezés          Egységár (Ft) Darab Összeg\n";
            if (billItem.isPresent()) {
                String name = billItem.get().getName();
                int unitPrice = billItem.get().getUnitPrice();
                int number = billItem.get().getNumber();
                result = String.format("%-20s%13d%5d%6d\n", name, unitPrice, number, unitPrice * number);
            }
            return result;

        };

        assertEquals(test3, billWriter.writeBillsFunction(billItems, formatterFunction));

    }

}