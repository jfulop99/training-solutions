package controlselection.week;

public class DayOfWeeks {
    public String dayOfWeeks(String nameOfDay){
        String dayOfWeeks;
        switch (nameOfDay.trim().toUpperCase()){
            case "HÉTFŐ":
                dayOfWeeks = "hét eleje";
                break;
            case "KEDD":
            case "SZERDA":
            case "CSÜTÖRTÖK":
                dayOfWeeks = "hét közepe";
                break;
            case "PÉNTEK":
                dayOfWeeks = "majdnem hétvége";
                break;
            case "SZOMBAT":
            case "VASÁRNAP":
                dayOfWeeks = "hét vége";
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + nameOfDay);
        }
        return dayOfWeeks;
    }
}
