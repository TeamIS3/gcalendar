import java.util.AbstractMap;
import java.util.Map;

/**
 * Class to represent a date.
 *
 * @author cmcl
 * @version 1.0
 */
public class Date implements Comparable<Date> {
    public static final Integer[] days = getDays();
    public static final Integer[] months = getMonths();
    public static final Integer[] years = getYears();
    //public static final Integer[] daysInMonth = getDaysInMonth();
    private int day, month, year;
    
    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }
    
    public Date() {
        this(1, 1, 1970);
    }
    
    public Date(Date d) {
        day = d.day;
        month = d.month;
        year = d.year;
    }
    
    public int getDay() { return day; }
    public void setDay(int d) { day = d; }
    
    public int getMonth() { return month; }
    public void setMonth(int m) { month = m; }
    
    public int getYear() { return year; }
    public void setYear(int y) { year = y; }
    
    public boolean isLeapYear() {
        return ((year % 4 == 0 && year % 100 != 0) ||
                (year % 100 == 0 && year % 400 == 0));
    }
    
    public boolean isValid() {
        Integer[] daysInMonth = getDaysInMonth(this);
        return day > 0 && day < 32 && month > 1 && month < 13 && year > 0;
    }
    
    public int compareTo(Date d) {
        if (year == d.year)
            if (month == d.month) return day - d.day;
            else return month - d.month;
        else return year - d.year;
    }
    
    public boolean equals(Object o) {
        return (o instanceof Date && ((Date)o).day == day &&
            ((Date)o).month == month && ((Date)o).year == year);
    }
            
    
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    
    
    /**
     * Test method with primitive test harness.
     */
    public static void main(String[] args) {
        Date d1 = new Date(12, 1, 2012);
        Date d2 = new Date(23, 4, 2012);
        Date d3 = new Date(9, 1, -1);
        Date d4 = new Date(2, 12, 2011);
        
        Pair[] tests = {
            new Pair("d1.compareTo(d2) < 0", d1.compareTo(d2) < 0),
            new Pair("!d3.isValid()", !d3.isValid()),
            new Pair("d1.compareTo(d4) > 0", d1.compareTo(d4) > 0),
            new Pair("d2.compareTo(d4) > 0", d2.compareTo(d4) > 0),
            new Pair("d2.equals(d2)", d2.equals(d2)),
            new Pair("!d2.equals(d1)", !d2.equals(d1)),
        };
        
        for (Pair p : tests) testDate(p.getKey(), p.getValue());
        
        System.out.println("Pass.");
    }
    
    /**
     * Helper method for checking the result of a test case
     * and providing diagnostics for failures.
     */
    private static void testDate(String s, boolean b) {
        if (!b) {
            System.out.println("Failed : " + s);
            System.exit(1);
        }
    }
    
    /**
     * Helper class for test case generation.
     */
    private static class Pair {
        private String key;
        private Boolean value;
        
        public Pair(String k, Boolean v) {
            key = k;
            value = v;
        }
        
        public String getKey() { return key; }
        
        public Boolean getValue() { return value; }
    }
    
    private static Integer[] getDays() {
        Integer[] days = new Integer[31];
        for (int i = 0; i < days.length; i++) days[i] = i+1;
        return days;
    }
    
    private static Integer[] getMonths() {
        Integer[] months = new Integer[12];
        for (int i = 0; i < months.length; i++) months[i] = i+1;
        return months;
    }
    
    private static Integer[] getYears() {
        Integer[] years = new Integer[2];
        years[0] = 2011;
        years[1] = 2012;
        return years;
   }
    
    private static Integer[] getDaysInMonth(Date d) {
        Integer[] daysInMonth = new Integer[months.length];
        
        for (int i = 0; i < daysInMonth.length; i++) {
            switch (i+1) {
                case 3:
                    break;
            }
        }
        return daysInMonth;
    }
}
