package controladvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicates {
    public List<Integer> duplicates(List<Integer> numberList){
        List<Integer> duplicateList = new ArrayList<>();
        for (int j = 0; j < numberList.size(); j++)
            for (int i = 0; i < j; i++){
                if (numberList.get(j) == numberList.get(i)){
                    duplicateList.add(numberList.get(j));
                    break;
                }
            }
        return duplicateList;
    }

    public static void main(String[] args) {
        List<Integer> elemnts = Arrays.asList(1,2,2,3,4,5,2,66,77,66,32,23,1);

        Duplicates duplicates = new Duplicates();

        System.out.println(duplicates.duplicates(elemnts));
    }
}
