package coworking_space.coworks;

import java.time.LocalDate;

public class slotsMain {
    public static void main (String args[])
    {
        Slot slot1 =  new Slot("8","10", 100.00);
        LocalDate thirty = slot1.getDate30DaysFromNow();
        LocalDate now = slot1.currentDate;
        System.out.println("Current Date + 30 --> " + thirty);
        System.out.println("Current Date --> " + now);
        System.out.println("Current Date < Current Date + 30: " + now.isBefore(thirty));
    }
}
