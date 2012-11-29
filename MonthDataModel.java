import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

/**
 * Data Model for the Month table
 * 
 * @author gordon
 * @author cmcl
 *
 */
public class MonthDataModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private int offset;
    private int days;
    private SortedSet<Event> data;
    private Map<Date, SortedSet<Event>> dateMap;
    
    private String[] names = { "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday" };

    public MonthDataModel(int off, int d,
                          Map<Date, SortedSet<Event>> dateMap) {
        offset = off;
        days = d;
        this.dateMap = dateMap;
    }

    public int getOffset() {
        return offset;
    }

    public int getDays() {
        return days;
    }

    public void setData(SortedSet<Event> e) {
        data = e;
    }

    public void setOffset(int i) {
        offset = i;
    }

    public void setDays(int i) {
        days = i;
    }

    public String getColumnName(int col) {
        return names[col];
    }

    public int getColumnCount() {
        return names.length;
    }

    public int getRowCount() {
        // The number of rows is the number of full weeks
        // plus the number of part weeks which make up a
        // month. Expected output will either be 4, 5, or 6
        int result = (days + offset) / names.length;
        if ((days + offset) % names.length != 0)
            result++;
        return result;
    }
    
    public Class getColumnClass(int c) {
        Object obj = getValueAt(1, c);
        return obj != null ? obj.getClass() : Object.class;
    }

    public Object getValueAt(int row, int col) {
        // Eventless days will just show the date number
        // Days with events will show the date number
        // and a string representation of the relevant
        // event.
        // Other cells will be blank.
        int i = ((7 * row) + (col + 1) - offset);
        Integer day = (i <= days && i > 0) ? i : null;
        if (day != null) {
            Date date = new Date(day, BaseView.currentDate.getMonth(),
                                 BaseView.currentDate.getYear());
            SortedSet<Event> set = dateMap.get(date);
            if (set == null) {
                set = new TreeSet<Event>();
            }
            Event e = new Event();
            e.setName(day.toString());
            set.add(e);
            return set;
        } else return day;
    }
}
