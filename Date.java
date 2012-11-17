import java.util.AbstractMap;
import java.util.Map;

/**
 * Class to represent a date.
 *
 * @author cmcl
 * @version 1.0
 */
public class Date implements Comparable<Date> {
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

    public boolean isValid() {
        return day > 0 && day < 32 && month > 1 && month < 13 && year > 0;
    }
    
    public int compareTo(Date d) {
        if (year == d.year)
            if (month == d.month) return day - d.day;
            else return month - d.month;
        else return year - d.year;
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
}
