package ru.jbasics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * It is advised not to use date, it is considered to be deprecated. Use
 * Calendar instead.
 */
/**
 *
 * @author Влад
 */
public class Dates {

    // Gets a current date and current time in milliseconds.
    Date date = new Date();
    // The same as a previous one, gets current date
    Date date2 = new Date(System.currentTimeMillis());
    Calendar calendar = new GregorianCalendar();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Dates() {
        demoDate(date);
        System.out.println("");
        demoCalendar(calendar);
    }

    void demoDate(Date date) {

        // Default date printing.
        System.out.println("Default date look: " + date.toString());

        // Printing a date and time to console in milliseconds.
        System.out.println("Date is milliseconds: " + date.getTime());

        // Printing date in a nicer looking manner.
        
        String strDate = dateFormat.format(date);
        System.out.println(strDate);
    }

    void demoCalendar(Calendar calendar) {
        
        System.out.println(calendar.getTime());
        System.out.println(dateFormat.format(calendar.getTime()));
        
        calendar.set(Calendar.YEAR, 2002);
        calendar.set(Calendar.MONTH, Calendar.AUGUST);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        
        System.out.println(calendar.getTime());
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
