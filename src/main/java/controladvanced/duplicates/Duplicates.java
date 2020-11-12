package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicates {
    public List<Integer> find(List<Integer> numberList){
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
}
