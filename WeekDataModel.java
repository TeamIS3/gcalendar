import javax.swing.table.AbstractTableModel;

/**
 * Data Model for the Week table
 * 
 * @author gordon
 * 
 */
public class WeekDataModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public WeekDataModel() {
    }

    private String[] names = { "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday" };

    public String getColumnName(int col) {
        return names[col];
    }

    public int getColumnCount() {
        return 7;
    }

    public int getRowCount() {
        return 1;
    }

    public Object getValueAt(int row, int col) {
        return null;
    }

}
