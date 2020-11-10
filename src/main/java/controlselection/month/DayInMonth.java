package controlselection.month;

public class DayInMonth {
    public int dayInMonth(int year, String month){
        int day;
        switch (month.trim().toUpperCase()){
            case "JANUÁR":
            case "MÁRCIUS":
            case "MÁJUS":
            case "JÚLIUS":
            case "AUGUSZTUS":
            case "OKTÓBER":
            case "DECEMBER":
                day = 31;
                break;
            case "ÁPRILIS":
            case "JÚNIUS":
            case "SZEPTEMBER":
            case "NOVEMBER":
                day = 30;
                break;
            case "FEBRUÁR":
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                    day = 29;
                }
                else {
                    day = 28;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return day;
    }
}
