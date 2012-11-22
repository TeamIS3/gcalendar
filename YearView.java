import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

public class YearView extends BaseView {

    private static final long serialVersionUID = 1L;
    private GridLayout grid;
    private int offset = 0;
    private String[] names = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
            "Aug", "Sep", "Oct", "Nov", "Dec" };
    private int[] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public YearView(CalendarModel model, JLabel viewLabel) {
        super(model, viewLabel);
    }

    public void setupCalendar() {
        grid = new GridLayout(0, 4);
        panel.setLayout(grid);
        for (int i = 0; i < 12; i++) {
            addTable(i);
        }
        this.add(panel);
    }

    private void addTable(int i) {
        days[1] = currentDate.isLeapYear() ? 29 : 28;
        TableModel temp = new YearDataModel(names[i], offset, days[i]);
        offset = (offset + days[i]) % 7;
        JTable month = new JTable(temp);
        month.getTableHeader().setReorderingAllowed(false);
        month.setRowSelectionAllowed(false);
        month.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(month);
        this.add(scrollPane, BorderLayout.CENTER);
        panel.add(scrollPane);
    }
    
    public String toString() {
        return currentDate.getYear() + "";
    }
}
