/**
 * Class to represent a time.
 *
 * @author Victor Pantazi
 * @version 1.0
 */
public class Time implements Comparable<Time> {   
    
    private int hour, minute;
    
    public Time(int h, int m) {
        hour = h;
        minute = m;
    }
    
    public Time() {
        this(0,0);
    }
    
    public Time(Time t) {
        hour = t.hour;
        minute = t.minute;
    }
    
    public int getHour() { return hour; }
    public void setHour(int h) { hour = h; }
    
    public int getMinute() { return minute; }
    public void setMinute(int m) { minute = m; }
    
    public boolean isValid() {
        return (minute >= 0 && minute <= 59 && hour <= 23 && hour >= 0);
    }
    
    /**
     * Increment the time by one minute.
     */
    public void increment() {
	minute++;
	if(minute==60){
		minute=0;
		hour++;
	}
	if(hour==24){
		hour=0;
		//increment day ???
	}       
    }
    
    /**
     * Decrement the time by one minute.
     */
    public void decrement() {
	minute--;
	if(minute==-1){
		minute=59;
		hour--;
	}
	if(hour==-1){
		hour=23;
		//decrement day ???
	}              
    }
    
    public int compareTo(Time t) {
        if (hour == t.hour) return minute - t.minute;
        return hour - t.hour;
    }
    
    public boolean equals(Object o) {
        return (o instanceof Time && ((Time)o).hour == hour &&
            ((Time)o).minute == minute);
    }            
    
    public String toString() {
	String th = "";
	String tm = "";
	if(hour<10) th = "0";
	if(minute<10) tm = "0";
        return th + hour + ":" + tm + minute;
    }
    
    
    /**
     * Test method with primitive test harness.
     */
    public static void main(String[] args) {

	// I suck as test methods, okay ? 
	Time t1 = new Time(23,58);
	Time t2 = new Time(0,2);
	Time t3 = new Time(24,23);
	Time t4 = new Time(12,60);
	Time t5 = new Time();
	System.out.println(t1);
	System.out.println(t1+" "+t1.isValid());
	System.out.println(t2+" "+t2.isValid());
	System.out.println(t3+" "+t3.isValid());
	System.out.println(t4+" "+t4.isValid());
	t1.increment();
	System.out.println(t1);
	t1.increment();
	System.out.println(t1);
	t1.increment();
	System.out.println(t1);
	t1.increment();
	System.out.println(t1+" "+t2+" "+t1.compareTo(t2)+" "+t1.equals(t2));
	t1.increment();
	System.out.println(t1+" "+t2+" "+t1.compareTo(t2)+" "+t1.equals(t2));
	t2.decrement();
	System.out.println(t2);
	t2.decrement();
	System.out.println(t1+" "+t2+" "+t1.compareTo(t2)+" "+t1.equals(t2));
	t2.decrement();
	System.out.println(t2);
	t2.decrement();
	System.out.println(t2);
	t2.decrement();
	System.out.println(t2);
	t2.decrement();
	System.out.println(t2);
	System.out.println(t5);

       	
	}
}
