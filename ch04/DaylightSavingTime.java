package ch04;

import static util.Util.print;
import java.time.*;

public class DaylightSavingTime {
    public static void main(String[] args) {
        var currentDate = LocalDate.of(2022, Month.MARCH, 13);
        var currentTime = LocalTime.of(1,30);
        var curentZone = ZoneId.of("US/Eastern");
        var springSwitch = ZonedDateTime.of(currentDate, currentTime, curentZone);
        //March aka Spring -> "Spring forward" an hour
        print("before spring switch", springSwitch); // 1:30 am, offeset -5 
        print("after spring switch", springSwitch.plusHours(1)); // 3:30 am, offset -4 

        var fallSwitch = ZonedDateTime.of(LocalDate.of(2022, 11, 6), currentTime, curentZone);
        print("before fall swtich", fallSwitch); // 1:30 am, offset -4
        print("after fall swtich", fallSwitch.plusHours(1)); // 1:30 am offset -5

        //Calc GMT Time: currentTime + -1*offset -> 1:30 + (-1)*(-5) = 6:30 am GMT
    }
}
