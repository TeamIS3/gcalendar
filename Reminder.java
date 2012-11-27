/**
 * Class to represent a reminder.
 *
 * @author Victor Pantazi
 * @version 1.0
 */
public class Reminder implements Comparable<Reminder> {

    private Date d;
    private Time t;
    
    public Reminder(Date d, Time t) {
        this.d = d;
        this.t = t;
    }
    
    public Reminder() {
        this.d = new Date();
        this.t = new Time();
    }
    
    public Reminder(Reminder r) {
        this.d = r.d;
        this.t = r.t;
    }
    
    public Date getDate() { return d; }
    public void setDate(Date d) { this.d = d; }

    public Time getTime() { return t; }
    public void setTime(Time t) { this.t = t; }

    public int compareTo(Reminder r) {
        if (this.d.compareTo(r.getDate()) == 0)
            return this.t.compareTo(r.getTime());
        return this.d.compareTo(r.getDate());
    }
    
    public boolean equals(Object o) {
        return (o instanceof Reminder && ((Reminder)o).d.equals(d) &&
            ((Reminder)o).t.equals(t));
    }

    public String toString() {
        return d + "|" + t;
    }

    public static void main(String[] args) {
        Reminder r1 = new Reminder();
        Reminder r2 = new Reminder(new Date(23,2,2012),new Time(15,50));
        System.out.println(r1+"\n"+r2);
    }

}
