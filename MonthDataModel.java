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

    private String[] names = { "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday" };

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
        int result = (days + offset) / names.length;
        if ((days + offset) % names.length != 0)
            result++;
        return result;
    }

    public Object getValueAt(int row, int col) {
        int i = ((7 * row) + (col + 1) - offset);
        return (i <= days && i > 0) ? i : null;
    }

}
