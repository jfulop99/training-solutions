package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    public static List<Type> whichType(String s){
        List<Type> fitType = new ArrayList<>();
        long value = Long.parseLong(s);
        for (Type type: Type.values()){
            if (value > type.getMinValue() && value < type.getMaxValue()){
                fitType.add(type);
            }
        }
        return fitType;
    }
}
