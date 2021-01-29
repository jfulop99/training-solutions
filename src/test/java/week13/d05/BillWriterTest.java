package week13.d05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillWriterTest {

    @Test
    void writeBills() {

        List<BillItem> billItems = List.of(new BillItem("kenyér", 1, 10),
                new BillItem("tej", 2, 20),
                new BillItem("kifli", 3, 30),
                new BillItem("vaj", 4, 40));

        BillWriter billWriter = new BillWriter();

        String test1 = "1 kenyér, darabja 10 Ft\n" +
                "2 tej, darabja 20 Ft\n" +
                "3 kifli, darabja 30 Ft\n" +
                "4 vaj, darabja 40 Ft\n";

        assertEquals(test1, billWriter.writeBills(billItems, new RowWriterFirst()));

        String test2 = "kenyér 1 * 10 = 10\n" +
                "tej 2 * 20 = 40\n" +
                "kifli 3 * 30 = 90\n" +
                "vaj 4 * 40 = 160\n";

        assertEquals(test2, billWriter.writeBills(billItems, new RowWriterSecond()));


        String test3 = "kenyér                         10    1    10\n" +
                "tej                            20    2    40\n" +
                "kifli                          30    3    90\n" +
                "vaj                            40    4   160\n";

        assertEquals(test3, billWriter.writeBills(billItems, new RowWriterThird()));

        System.out.println(billWriter.writeBillsFunction(billItems, billItem -> String.format("%d %s, darabja %d Ft\n", billItem.getNumber(), billItem.getName(), billItem.getUnitPrice())));
    }
}