import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

public class MonthView extends BaseView {
    
    public MonthView() {
        super();
    }
    
    protected void setupCalendar() {
		TableModel monthView = new MonthDataModel(3);
		JTable month = new JTable(monthView);
        month.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(month);
		month.setRowHeight(100);
		this.add(scrollPane, BorderLayout.CENTER);
	}
}