import javax.swing.table.AbstractTableModel;

/**
 * Data Model for the Day table
 * 

 * 
 */
public class DayDataModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private String[] hours = { "00:00", "01:00", "02:00", "03:00",
            "04:00", "05:00", "06:00", "07:00", "08:00", "09:00",
            "10:00", "11:00", "12:00", "13:00", "14:00", "15:00",
            "16:00", "17:00", "18:00", "19:00", "20:00", "21:00",
            "22:00", "23:00" };

	

	//public String  d = Date.getDay();

    private String[] names = { "today" };

    public DayDataModel() {
    }

    public String getColumnName(int col) {
        return "";
    }

    public int getColumnCount() {
        return 1;
    }

    public int getRowCount() {
        return hours.length;
    }

    public Object getValueAt(int row, int col) {
        return (col == 0) ? hours[row] : null;
    }
}
