import java.util.SortedSet;
import javax.swing.table.AbstractTableModel;

/**
 * Data Model for the Month table
 * 
 * @author gordon
 * 
 */
public class MonthDataModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private int offset;
    private int days;
    private SortedSet<Event> data;

    private String[] names = { "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday" };

    public MonthDataModel(int off, int d) {
        offset = off;
        days = d;
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

    public Object getValueAt(int row, int col) {
        // Eventless days will just show the date number
        // Days with events will show the date number
        // and a string representation of the relevant
        // event.
        // Other cells will be blank.
        int i = ((7 * row) + (col + 1) - offset);
        if (data != null)
            return data.first();
        else
            return (i <= days && i > 0) ? i : null;
    }

}
