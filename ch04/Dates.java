package ch04;

import static util.Util.print;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
public class Dates {
    
    public static void main(String[] args) {
        //YYYY-mm-dd
        print(LocalDate.now().minusYears(420));
        print(LocalTime.now().plusHours(1));
        print(LocalDateTime.now().plusWeeks(1));
        print(ZonedDateTime.now());
        print();

        print("--- Period ---");
        //Format: P#Years#Months#Days, e.g., P1337Y128M (params can be negative!)
        print(Period.of(1337,128, 0));
        print(Period.of(42, 6, 21)); //P42Y6M21D
        print(Period.ofDays(32)); // P32D
        print(Period.ofWeeks(8));  //P14D

        var date = LocalDateTime.of(2024, 3, 9, 20, 5, 0); // y, mo, d, h, min, s, exeception on illegal dates like 32.12.2024
        print(date.plus(Period.ofDays(2))); //2024 3 11

        try {print(LocalTime.of(13, 37, 0).plus(Period.ofDays(2)));}
        catch (UnsupportedTemporalTypeException e) {
            print("Adding days to something to only knows hours, minuts, ... is not allowed");
        }
        print();
        
        print("--- Duration ---");
        //Period is for year - day, duration handles the smaller parts
        //As Period always starts with P, duration always starts with PT
        //Format: PT#Hours#Minutes#Seconds
        // Seconds can be 0.001 for millis or 0.8-zer0s for nanos
        //writing nanos is tricky, so Duration has NO .of(..) method but of(1, ChronoUnit.DAYS)
        print(Duration.of(2, ChronoUnit.DAYS)); //PT48H
        print(Duration.of(2, ChronoUnit.NANOS)); //PT0.0000000002S
        var t1 = LocalTime.of(20, 30);
        var t2 = LocalTime.of(20, 40);
        var tx = LocalDate.of(2024, 12, 31);
        //negative years are allowed, month and days need to be in range [1,12] or [1,31] otherwise exception!
        var txx = LocalDate.of(-1, 12, 31);
        print("Date with negative year", txx);
        print("Hours between 20:30-20:40", ChronoUnit.HOURS.between(t1, t2)); // 0
        print("Minutes between 20:30-20:40", ChronoUnit.MINUTES.between(t1, t2)); // 10
        //print(ChronoUnit.DAYS.between(t1, t2)); execption: locale time does not know days
        //print(ChronoUnit.MINUTES.between(t1, null)); NPE
        try { print(ChronoUnit.MINUTES.between(t1, tx));}
        catch (DateTimeException e) {
            print("not time in a date only -> can not compare");
        }
        print(t1.truncatedTo(ChronoUnit.HOURS)); //20:00 -> cuts of everthing until Hours

        //tricky
        var t3 = LocalDate.of(2024,3,9);
        var p1 = Period.ofDays(1);
        var d1 = Duration.ofDays(1);
        print(t3.plus(p1)); //works
        //print(t3.plus(d1)); //exception




    }
}
