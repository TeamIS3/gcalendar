import javax.swing.table.AbstractTableModel;

/**
 * This class represents each table's data model. This class 
 * represents months of any length, starting on any day of the
 * week.
 * 
 * @author gordon
 * 
 */
public class YearDataModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private String[] names = new String[1];
    // Which day (0 based) does this month start on
    private int offset;
    private int days;

    public YearDataModel(String name, int off, int d) {
        offset = off;
        days = d;
        names[0] = name;
    }

    public String getColumnName(int col) {
        // Only display column name in first row.
        return col == 0 ? names[0] : null;
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

    public int getColumnCount() {
        return 7;
    }

    public int getRowCount() {
        // Work out how many weeks + part weeks a month has. The valid
        // values are between 4 and 6.
        int result = (days + offset) / 7;
        if ((days + offset) % 7 != 0)
            result++;
        return result;
    }

    public Object getValueAt(int row, int col) {
        // Cells values are the ith day of the week. Cells before
        // first day in month are blank. Cells after last day in month
        // are blank.
        int i = ((7 * row) + (col + 1) - offset);
        return (i <= days && i > 0) ? i : null;
    }

}
