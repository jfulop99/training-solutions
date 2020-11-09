package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {
    List<DayType> dayTypes = new ArrayList<>();
    public List<DayType> dayTypes(Day firstDay, int numberOfDays){
        dayTypes.add(firstDay.getDayType());
        int indexOfDay = firstDay.ordinal();
        for (int i = 0; i < numberOfDays; i++){
            dayTypes.add(nextday(Day.values()[indexOfDay]).getDayType());
            indexOfDay = (indexOfDay < 6 ? indexOfDay+1 : 0);
        }
        return dayTypes;
    }
    private Day nextday(Day day){
        if (day.ordinal() < 6){
            return Day.values()[day.ordinal()+1];
            }
        else
            return Day.values()[0];
    }
}
