import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * This class represents a given year by a grid of tables, each table
 * represents a single month.
 * 
 * @author gordon
 * 
 */
public class YearView extends BaseView {

    private static final long serialVersionUID = 1L;
    private GridLayout grid;
    // 1 Jan 2011 is a Saturday
    private int offset = 5;
    // Local copy of array of month names
    private String[] names = { "Jan", "Feb", "Mar", "Apr", "May",
            "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    // Local copy of an array of ints.
    private int[] days = { 31, 29, 31, 30, 31, 30, 31,
                           31, 30, 31, 30, 31 };

    public YearView(CalendarModel model, JLabel viewLabel) {
        super(model, viewLabel);
    }

    public void setupCalendar() {
        // Create a four column grid layout
        grid = new GridLayout(0, 4);
        panel.setLayout(grid);
        // Check to see if we need to represent February as 29 days
        days[1] = currentDate.isLeapYear() ? 29 : 28;
        /*
         * Represent each month of the year as a table. Each "cell"
         * of the grid layout plays host to a month.
         */
        for (int i = 0; i < 12; i++)
            addTable(i);
        this.add(panel);
    }

    private void addTable(int i) {
        TableModel temp = new YearDataModel(names[i], offset, days[i]);
        // Work out where in the week this month starts
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
