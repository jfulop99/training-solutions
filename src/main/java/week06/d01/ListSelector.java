package week06.d01;

import java.util.ArrayList;
import java.util.List;

public class ListSelector {

    public String evenSelector(List<String> inputList) {
        if (inputList == null) {
            throw new IllegalArgumentException("Input list is null");
        }
        int i = 0;
        List<String> outputList = new ArrayList<>();
        for (String item: inputList) {
            if (i % 2 == 0) {
                outputList.add(item);
            }
            i++;
        }
        return outputList.toString();
    }
}
