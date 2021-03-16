package xtest.streamtest;

import java.util.Map;

public class PeekPrint {


    public static void main(String[] args) {


        Map<Integer, String> vacTypes = Map.of(1, "Astra", 2, "Sinopharm", 3, "Pfizer");

        vacTypes.entrySet()
                .stream()
                .peek(e -> System.out.println(e.getKey().toString() + "\t" + e.getValue()))
                .count();

//        for (Map.Entry<Integer, String> entry : vacTypes.entrySet()) {
//            System.out.println(entry.getKey().toString() + "\t" + entry.getValue());
//        }


    }


}
