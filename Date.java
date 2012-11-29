/**
 * Class to represent a date.
 *
 * @author cmcl
 * @version 1.0
 */
public class Date implements Comparable<Date> {
    public static final int JAN = 1, FEB = 2, MAR = 3, APR = 4, MAY = 5,
                             JUN = 6, JUL = 7, AUG = 8, SEP = 9, OCT = 10,
                             NOV = 11, DEC = 12;
    public static final Integer[] days = getDays();
    public static final Integer[] months = getMonths();
    public static final Integer[] years = getYears();
    public static final String[] monthNames = {"January", "February", 
                            "March", "April", "May", "June", "July",
                            "August", "September", "October",
                            "November", "December"};
    public static final String[] dayNames = { "Monday", "Tuesday", 
        "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    
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
        return year > 0 && month > 0 && month < 13 && day > 0 &&
            day <= getDaysInMonth(year)[month-1];
    }
    
    /**
     * Increment the date by one day.
     * 
     * @returns this date incremented by one day.
     */
    public Date increment() {
        Integer[] daysInMonth = getDaysInMonth(year);
        Date d = new Date(this);
        if (d.day == daysInMonth[month-1]) {
            if (d.month == DEC) {
                d.month = JAN;
                d.year++;
            } else d.month++;
            d.day = 1;
        } else d.day++;
        return d;
    }
    
    /**
     * Increment the date by one day.
     * 
     * @returns this date incremented by one day.
     */
    public Date incrementMonth() {
        Integer[] daysInMonth = getDaysInMonth(year);
        Date d = new Date(this);
        if (d.month == DEC) {
            d.month = JAN;
            d.year++;
        } else d.month++;
        if (d.day > daysInMonth[d.month - 1])
            d.day = daysInMonth[d.month - 1];
        return d;
    }
    
    /**
     * Decrement the date by one day.
     * 
     * @returns this date decremented by one day.
     */
    public Date decrement() {
        Integer[] daysInMonth = getDaysInMonth(year);
        Date d = new Date(this);
        
        if (d.day == 1) {
            if (d.month == JAN) {
                d.month = DEC;
                d.year--;
            } else
                d.month--;
            d.day = daysInMonth[d.month - 1];
        } else d.day--;
        return d;
    }
    
    /**
     * Decrement the date by one day.
     * 
     * @returns this date decremented by one day.
     */
    public Date decrementMonth() {
        Integer[] daysInMonth = getDaysInMonth(year);
        Date d = new Date(this);
        if (d.month == JAN) {
            d.month = DEC;
            d.year--;
        } else d.month--;
        if (d.day > daysInMonth[d.month - 1])
            d.day = daysInMonth[d.month - 1];
        return d;
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
    
    public int hashCode() {
        return (day << 5) ^ (month >> 2) ^ ((year << 6) ^ (year >> 8));
    } 

    public String dayName() {
        return dayNames[getDayFromDate(this)];
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
        Date nonLeapYear = new Date(29, 2, 2011);
        Date validDate = new Date(1, 1, 2011);
        
        Date endOfYear = new Date(31, 12, 2012);
        endOfYear.increment();
        Date notEndOfFeb = new Date(28, 2, 2012);
        notEndOfFeb.increment();
        int passes = 0, fails = 0;
        
        Pair[] tests = {
            new Pair("d1.compareTo(d2) < 0", d1.compareTo(d2) < 0),
            new Pair("!d3.isValid()", !d3.isValid()),
            new Pair("d1.compareTo(d4) > 0", d1.compareTo(d4) > 0),
            new Pair("d2.compareTo(d4) > 0", d2.compareTo(d4) > 0),
            new Pair("d2.equals(d2)", d2.equals(d2)),
            new Pair("!d2.equals(d1)", !d2.equals(d1)),
            new Pair("!nonLeapYear.isValid()", !nonLeapYear.isValid()),
            new Pair("validDate.isValid()", validDate.isValid()),
            new Pair("endOfYear.increment().equals(newYear)",
                     endOfYear.equals(new Date(1, 1, 2013))),
            new Pair("!notEndOfFeb.increment().equals(march)",
                     !notEndOfFeb.equals(new Date(1, 3, 2012))),
            new Pair("23/11/2012 == Friday",
                     getDayFromDate(new Date(23, 11, 2012)) == 4),
            new Pair("3/09/1992 == Thursday",
                     getDayFromDate(new Date(3, 9, 1992)) == 3),
        };
        
        for (Pair p : tests) {
            testDate(p.getKey(), p.getValue());
            if (p.getValue()) passes++;
            else fails++;
        }
        
        System.out.println("Passes : " + passes);
        System.out.println("Failures : " + fails);
    }
    
    /**
     * Helper method for checking the result of a test case
     * and providing diagnostics for failures.
     */
    private static void testDate(String s, boolean b) {
        if (!b) System.out.println("Failed : " + s);
        else System.out.println("Passed : " + s);
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
    
    /**
     * Obtain the days in every month of the year passed as a argument.
     *
     * @returns a list of month lengths indexed by month (starting
     * from zero).
     */
    public static Integer[] getDaysInMonth(int year) {
        if (year < 0) return null;
        
        Integer[] daysInMonth = new Integer[months.length];
        
        Date d = new Date(1, 1, year);
        
        for (int i = 0; i < daysInMonth.length; i++) {
            switch (i+1) {
                case FEB:
                    if (d.isLeapYear()) daysInMonth[i] = 29;
                    else daysInMonth[i] = 28;
                    break;
                case JAN:
                case MAR:
                case MAY:
                case JUL:
                case AUG:
                case OCT:
                case DEC:
                    daysInMonth[i] = 31;
                    break;
                case APR:
                case JUN:
                case SEP:
                case NOV:
                    daysInMonth[i] = 30;
                    break;
            }
        }
        return daysInMonth;
    }
    
    /**
     * This method returns a number indicating the day that the date
     * falls on.
     *
     * 0 = Monday, 1 = Tuesday etc.
     *
     * Disclaimer: The code in this method is not to indicative of the
     * software engineering profession. Do not try this at home.
     */
    public static int getDayFromDate(Date d){
        String[][] YEARS = {
                { "00", "06", "17", "23", "28", "34", "45", "51",
                    "56", "62", "73", "79", "84", "90" },
                { "01", "07", "12", "18", "29", "35", "40", "46",
                   "57", "63", "68", "74", "85", "91", "96" },
                { "02", "13", "19", "24", "30", "47", "52", "58",
                   "69", "75","80", "86", "97" },
                { "03", "08", "14", "25", "31", "36", "42", "53",
                  "59", "64", "70", "81", "87", "92", "98" },
                { "09", "15", "20", "26", "37", "43", "48", "54",
                  "65", "71", "76", "82", "93", "99" },
                { "04", "10", "21", "27", "32", "38", "49", "55", 
                  "60", "66", "77", "83", "88", "94" },
                { "05", "11", "16", "22", "33", "39", "44", "50",
                  "61", "67", "72", "78", "89", "95" } };
        int[] MONTH_INDEX = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
        int lpYear = 0;
        if (d.isLeapYear() && d.month <= FEB) lpYear = -1;
        
		int num = d.day + MONTH_INDEX[d.month-1] + lpYear;
        
        // Obtain year data as a string
        String y = new Integer(d.getYear()).toString();
        
		// Add century data
        Integer century = new Integer(y.substring(0, 2));
		switch(century){
		case 18:
			num += 2;
			break;
		case 19:
			break;
		case 20:
			num += 6;
			break;
		}
        // Finally, calculate the year index
        int yearIndex = 0;
        // Get  the last two digits from the year
        String lastTwo = y.substring(2);
        for (int i = 0; i < YEARS.length; i++) {
            String[] indices = YEARS[i];
            for (String year : indices) {
                if (lastTwo.equals(year)) {
                    yearIndex = i;
                    break;
                }
            }
        }
		num += yearIndex; // Add year number code on.
		return (num + 5) % 7;
	}
}
