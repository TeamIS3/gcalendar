import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Stores the data for the calendar.
 * This is accessed by the views and manipulated by the dialogs.
 *
 * @author cmcl
 * @version 1.0
 */
public class CalendarModel implements Iterable<Event> {
    private Deque<Event> events;
    
    public CalendarModel() {
        events = new LinkedList<Event>();
    }
    
    public void push(Event e) { events.push(e); }
    
    public Event peek() { return events.peek(); }
    
    public Event pop() { return events.pop(); }
    
    public boolean isEmpty() { return events.isEmpty(); }

    public Iterator<Event> iterator() { return events.iterator(); }
}
