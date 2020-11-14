package formatlocaleprintf;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.MissingFormatArgumentException;

public class PrintFormat {

    public String formatMessageWithIntegerParameters(String formatString, Integer i, Integer j){
//      "Less objects then expected in format String!"
        try {
            return String.format(formatString, i, j);
        }catch (MissingFormatArgumentException e){
            throw new IllegalArgumentException("Less objects then expected in format String!", e);
        }
    }
    public String printFormattedText(Double number){
//      "Total is: 561 123,20 Ft"

        return String.format("Total is: %,8.2f Ft", number);
    }
    public String printFormattedText(int count, String fruit){
//      "We counted 6 APPLES in the basket"
        return String.format("We counted %d %s in the basket", count, fruit);
    }
    public String printFormattedText(int number){
//      "Right edge of numbers set at 4 spaces from text:" 6 hossz
        return String.format("Right edge of numbers set at 4 spaces from text:%4d",number);
    }
    public String printFormattedText(Integer i, Integer j, Integer k){
//      "Multiple objects containing text:" + i + "\t" + j + "\t" + k
        return String.format("Multiple objects containing text:%d\t%d\t%d", i, j, k);
    }
}
