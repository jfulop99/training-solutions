package controlselection.greetings;

import java.time.LocalTime;

public class Greetings {
    public String greetings(int hour, int min){
        LocalTime inputtime = LocalTime.of(hour, min);
        String greeting;
        if (inputtime.isAfter(LocalTime.of(20,0))){
            greeting = "Jó éjt!";
        }
        else if (inputtime.isAfter(LocalTime.of(18,30))){
            greeting = "Jó estét!";
        }
        else if (inputtime.isAfter(LocalTime.of(9, 0))){
            greeting = "Jó napot!";
        }
        else if (inputtime.isAfter(LocalTime.of(5,0))){
            greeting = "Jó reggelt!";
        }
        else{
            greeting = "Jó éjt!";
        }
        System.out.println(greeting);
        return greeting;
    }

}
