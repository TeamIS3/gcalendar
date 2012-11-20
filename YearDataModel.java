import javax.swing.table.AbstractTableModel;

public class YearDataModel extends AbstractTableModel {

    private String[] names = new String[1];

    public YearDataModel(String name){
        names[0] = name;
    }

    public String getColumnName(int col) {
        return names[col];
    }

    public int getColumnCount() {
		return 1;
	}

    public int getRowCount() {
		return 1;
	}

    public Object getValueAt(int row, int col) {
        return null;
    }

}
